import React, { useState } from "react";
import "./Password.css";
import Navbar from "./Navbar";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";

import "./components/Elements/Button.css";
import "./Welcome1.css";
import { ToastContainer, toast } from "react-toastify";
import BlueButton from "components/buttons/blue_background/BlueButton";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Spinner from "components/spinner/Spinner";
const Password = () => {
    const navigate = useNavigate();
    const [email, setEmail] = useState();
    const [loading, setLoading] = useState(false);

    const handlePassChange = event => {
        event.preventDefault();
        setLoading(true);

        axios
            .post(
                `https://api.applyforme.hng.tech/api/v1/auth/send-otp-for-reset-password?email=${email}`
            )
            .then(res => {
                toast.success("Check your email for otp");
                let emailKey = "emailKey";
                localStorage.setItem(emailKey, `${email}`);
                setLoading(false);
                setTimeout(() => {
                    navigate("/veri");
                }, 2000);
            })
            .catch(err => {
                setLoading(false);
                toast.error(err);
            });
    };

    return (
        <div className="Password">
            <Navbar />
            <ToastContainer />
            <div className="pbdy">
                {loading && <Spinner />}
                <Text child="Forgot Password ?" />
                <Text2 child="Please enter your email address" />
                <form
                    className="form pass_form"
                    onSubmit={e => handlePassChange(e)}
                >
                    <input
                        type="email"
                        name="e-ml"
                        placeholder="Email Address"
                        className="input"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                    />
                    <span className="liltxt">
                        A code will be sent to this email address
                    </span>
                    <BlueButton text="continue" width="240" type="submit" />
                </form>
            </div>
        </div>
    );
};

export default Password;
