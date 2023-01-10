/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from "react";
import "./Welcome2.css";
import Navbar from "./Navbar";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";
import Inputbox from "./components/Elements/Inputbox";
import Button from "./components/Elements/Button";
import "./components/Elements/Button.css";
import Footer from "./Footer";
import { Link, useLocation, useNavigate } from "react-router-dom";
import axios from "axios";
import jwt_decode from "jwt-decode";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";
// Toaster
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Spinner from "components/spinner/Spinner";

const BaseUrl = "https://api.applyforme.hng.tech/api/v1/auth/sign-in";

const Welcome2 = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { user } = useSelector(state => state.user);
    const [loading, setLoading] = useState(false);
    const location = useLocation();
    const from = location.state?.from?.pathname || "/";
    const [error, setError] = useState("");
    const [errState, setErrState] = useState({
        password: false,
        email_address: false
    });
    const [password, setPassword] = useState("password");
    const handletoggle = () => {
        password === "password" ? setPassword("text") : setPassword("password");
    };
    useEffect(() => {
        if (user && from === "/pricing") {
            navigate(from);
        } else {
            if (user) {
                setTimeout(() => {
                    if (user?.roles[0] === "Recruiter") {
                        navigate("/rr_admin");
                    } else if (user?.roles[0] === "SuperAdministrator") {
                        navigate("/user-page");
                    } else if (
                        user.roles.length === 1 &&
                        user?.roles[0] === "Professional"
                    ) {
                        navigate("/dashboard/");
                    }
                }, 2000);
            }
        }
    }, [user, navigate, from]);

    const handleSubmit = async event => {
        event.preventDefault();
        setLoading(true);
        const formData = {
            email_address: event.target.email.value,
            password: event.target.pass.value
        };

        await axios
            .post(`${BaseUrl}`, formData)
            .then(res => {
                let result = res.data;
                let decoded = jwt_decode(result.token);
                let tokenKey = "tokenHngKey";
                let refreshKey = "refreshTokenHngKey";
                localStorage.setItem(refreshKey, result.refresh_token);
                localStorage.setItem(tokenKey, result.token);
                dispatch(userInfo(decoded));
                setError("");
                setLoading(false);
                console.log(decoded);
                toast.success("Login Successfully");
            })
            .catch(err => {
                let message =
                    typeof err.response.data.message === "object"
                        ? err.response.data.message[
                              Object.keys(err.response.data.message)[0]
                          ]
                        : err.response.data.message;
                setError(message);
                setLoading(false);
                toast.error(message);
            });
    };

    return (
        <div className="Welcome2">
            <Navbar />
            <ToastContainer />
            <div className="w2bdy">
                {loading && <Spinner />}
                <Text child="Welcome Back !!" />
                <Text2 child="Login to ApplyForMe " />
                <form className="form" onSubmit={e => handleSubmit(e)}>
                    <Inputbox
                        type="email"
                        name="email"
                        id="eml"
                        place="Email Address"
                    />
                    <label htmlFor="pass" className="passowrd-label">
                        <input
                            type={password}
                            className="passowrd-label-input"
                            name="pass"
                            id="pass"
                            placeholder="Password"
                            required
                        />
                        <img
                            src="https://res.cloudinary.com/hamskid/image/upload/v1670631906/Vector_1_qntpu2.svg"
                            alt="object not found"
                            onClick={handletoggle}
                        />
                    </label>

                    {error && <p style={{ color: "red" }}>{error}</p>}

                    <Link to="/pass" className="forgot">
                        Forgot Password
                    </Link>

                    <Button
                        child="Sign In"
                        className="submit_btn"
                        type="submit"
                    />
                </form>
                <span className="ques">
                    Don&#39;t have an account?{" "}
                    {from !== "/pricing" ? (
                        <Link to="/wel1" className="special">
                            {" "}
                            Sign Up
                        </Link>
                    ) : (
                        <p
                            onClick={() =>
                                navigate("/wel1", {
                                    state: { from: "/pricing" }
                                })
                            }
                            className="special"
                        >
                            {" "}
                            Sign Up
                        </p>
                    )}
                </span>
                <Footer />
            </div>
        </div>
    );
};

export default Welcome2;
