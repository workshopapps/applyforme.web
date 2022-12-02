/* eslint-disable no-unused-vars */
import React, { useEffect } from "react";
import Navbar from "./Navbar";
import "./Welcome1.css";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";
import Inputbox from "./components/Elements/Inputbox";
import Button from "./components/Elements/Button";
import "./components/Elements/Button.css";
import Footer from "./Footer";
import { Link } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import jwt_decode from "jwt-decode";
// Toaster
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
const BaseUrl = "https://official-volunux.uc.r.appspot.com/api/v1/auth/sign-up";

const Welcome1 = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();
    const { user } = useSelector(state => state.user);

    useEffect(() => {
        if (user) {
            setTimeout(() => {
                if (
                    user?.roles[0] === "Professional" ||
                    user?.roles[0] === "Recruiter"
                ) {
                    navigate("/dashboard");
                } else if (user?.roles[0] === "SuperAdministrator") {
                    navigate("/user-page");
                }
            }, 3000);
        }
    }, [user]);

    const handleSignup = async event => {
        event.preventDefault();
        const formData = {
            "first_name": event.target.fname.value,
            "last_name": event.target.lname.value,
            "email_address": event.target.email.value,
            "phone_number": event.target.num.value,
            "password": event.target.pass.value
        };
        console.log(formData);
        let result = await axios
            .post(`${BaseUrl}`, formData)
            .then(res => res.data)
            .catch(err => {
                console.log(err);
            });

        if (result?.token) {
            let decoded = jwt_decode(result.token);
            let tokenKey = "tokenHngKey";
            localStorage.setItem(tokenKey, result.token);
            dispatch(userInfo(decoded));
            toast("Signup Successfully");
            setTimeout(() => {
                if (
                    user.roles[0] === "Professional" ||
                    user.roles[0] === "Recruiter"
                ) {
                    navigate("/dashboard");
                } else if (user.roles[0] === "SuperAdministrator") {
                    navigate("/user-page");
                }
            }, 3000);
        } else {
            toast("Error signin up, try again");
        }
    };

    return (
        <div className="Welcome1">
            <Navbar />
            <ToastContainer />
            <div className="w1bdy">
                <Text child="Welcome to ApplyForMe!!" />
                <Text2 child="Create your ApplyForMe account here" />
                <form className="form" onSubmit={e => handleSignup(e)}>
                    <Inputbox
                        type="text"
                        name="fname"
                        place="First Name"
                        id="fnm"
                    />
                    <Inputbox
                        type="text"
                        name="lname"
                        place="Last Name"
                        id="lnm"
                    />
                    <Inputbox
                        type="email"
                        name="email"
                        place="Email Address"
                        id="eml"
                    />
                    <Inputbox
                        type="tel"
                        name="num"
                        place="Phone Number"
                        id="nmbr"
                    />
                    <Inputbox
                        type="password"
                        name="pass"
                        place="Password"
                        id="pswrd"
                    />
                    <label className="checkl">
                        <input type="checkbox" className="check" />
                        <span className="checkmark"></span>
                        <span className="chktxt">
                            I agree to the{" "}
                            <span className="special">
                                {" "}
                                Terms and Conditions
                            </span>{" "}
                            and{" "}
                            <span className="special">Privacy Policies</span>
                        </span>
                    </label>
                    <div className="lg">
                        <Button child="Sign Up" type="submit" />
                    </div>
                </form>
                <span className="ques">
                    Already have an account?{" "}
                    <Link to="/wel2" className="special">
                        {" "}
                        Sign In
                    </Link>
                </span>
                <Footer />
            </div>
        </div>
    );
};

export default Welcome1;
