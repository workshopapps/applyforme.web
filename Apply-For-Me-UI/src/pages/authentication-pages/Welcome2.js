/* eslint-disable no-unused-vars */
import React, { useState } from "react";
import "./Welcome2.css";
import Navbar from "./Navbar";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";
import Inputbox from "./components/Elements/Inputbox";
import Button from "./components/Elements/Button";
import "./components/Elements/Button.css";
import Footer from "./Footer";
import { Link, Navigate, useNavigate } from "react-router-dom";
import axios from "axios";
import jwt_decode from "jwt-decode";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";
import { SpinnerCircular } from "spinners-react";

const BaseUrl = "https://official-volunux.uc.r.appspot.com/api/v1/auth/sign-in";

const Welcome2 = () => {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleSubmit = async event => {
        event.preventDefault();
        const formData = {
            email_address: event.target.email.value,
            password: event.target.pass.value
        };

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
            navigate("/dashboard");
        } else {
            console.log("eer");
        }
    };

    return (
        <div className="Welcome2">
            <Navbar />

            <div className="w2bdy">
                <Text child="Welcome Back !!" />
                <Text2 child="Login to ApplyForMe " />
                <form className="form" onSubmit={e => handleSubmit(e)}>
                    <Inputbox
                        type="email"
                        name="email"
                        id="eml"
                        place="Email Address"
                    />
                    <Inputbox
                        type="password"
                        name="pass"
                        id="pass"
                        place="Password"
                    />
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
                    <Link to="/wel1" className="special">
                        {" "}
                        Sign Up
                    </Link>
                </span>
                <Footer />
            </div>
        </div>
    );
};

export default Welcome2;
