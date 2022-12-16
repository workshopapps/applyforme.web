import React, { useEffect, useState } from "react";
import "./Verification.css";
import Navbar from "./Navbar";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";
import BlueButton from "components/buttons/blue_background/BlueButton";
import "./components/Elements/Button.css";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Spinner from "components/spinner/Spinner";

const Verification = () => {
    const navigate = useNavigate();
    const [password, setPassword] = useState("password");
    const [loading, setLoading] = useState(false);
    const handletoggle = () => {
        password === "password" ? setPassword("text") : setPassword("password");
    };
    const [otpForm, setOtpForm] = useState({
        val1: "",
        val2: "",
        val3: "",
        val4: "",
        val5: "",
        val6: ""
    });

    const [pass, setPass] = useState("");

    useEffect(() => {
        setOtpForm({
            val1: "",
            val2: "",
            val3: "",
            val4: "",
            val5: "",
            val6: ""
        });
    }, []);
    const handleSubmit = event => {
        event.preventDefault();
        let otp = [];
        let result = true;

        Object.values(otpForm).forEach(val => {
            if (val === "") {
                result = false;
            } else otp.push(val);
        });

        const data = {
            "otp": `${otp.join("")}`,
            "email_address": `${localStorage.getItem("emailKey")}`,
            "new_password": `${pass}`
        };

        console.log(data);

        if (result) {
            setLoading(true);
            axios
                .post(
                    "https://api.applyforme.hng.tech/api/v1/auth/reset-password",
                    data
                )
                .then(res => {
                    setLoading(false);
                    toast.success("Password Rest Successfully");
                    localStorage.removeItem("emailKey");

                    setTimeout(() => {
                        navigate("/wel2");
                    }, 2000);
                })
                .catch(err => {
                    toast.error(err.data.message);
                });
        } else {
            setLoading(false);
            toast.error("otp can not be empty");
        }
    };

    const resendOtp = () => {
        const email = localStorage.getItem("emailKey");
        setLoading(true);
        axios
            .post(
                `https://api.applyforme.hng.tech/api/v1/auth/send-otp-for-reset-password?email=${email}`
            )
            .then(res => {
                toast.success("New otp Sent Check your email for otp");
                setLoading(false);
            })
            .catch(err => {
                setLoading(false);
                toast.error(err);
            });
    };

    return (
        <div className="Verification">
            <Navbar />
            <ToastContainer />
            {loading && <Spinner />}
            <div className="vbdy">
                <Text child="Verification Code" />
                <Text2 child="Enter the verification code sent to your email address" />
                <form onSubmit={e => handleSubmit(e)}>
                    <div className="verify">
                        <input
                            type="number"
                            className="vrfy"
                            value={otpForm.val1}
                            onChange={e =>
                                setOtpForm({ ...otpForm, val1: e.target.value })
                            }
                            autoComplete="off"
                            maxLength="0"
                        />
                        <input
                            type="number"
                            className="vrfy"
                            value={otpForm.val2}
                            onChange={e =>
                                setOtpForm({ ...otpForm, val2: e.target.value })
                            }
                            autoComplete="off"
                        />
                        <input
                            type="text"
                            className="vrfy"
                            value={otpForm.val3}
                            onChange={e =>
                                setOtpForm({ ...otpForm, val3: e.target.value })
                            }
                            autoComplete="off"
                        />
                        <input
                            type="number"
                            className="vrfy"
                            value={otpForm.val4}
                            onChange={e =>
                                setOtpForm({ ...otpForm, val4: e.target.value })
                            }
                            autoComplete="off"
                        />
                        <input
                            type="number"
                            className="vrfy"
                            value={otpForm.val5}
                            onChange={e =>
                                setOtpForm({ ...otpForm, val5: e.target.value })
                            }
                            autoComplete="off"
                        />
                        <input
                            type="number"
                            className="vrfy"
                            value={otpForm.val6}
                            onChange={e =>
                                setOtpForm({ ...otpForm, val6: e.target.value })
                            }
                            autoComplete="off"
                        />
                    </div>

                    <div className="resend" onClick={() => resendOtp()}>
                        Resend verification code
                    </div>
                    <div className="pass_input_container">
                        <label htmlFor="pass" className="passowrd-label">
                            <input
                                type={password}
                                className="password_input"
                                value={pass}
                                onChange={e => setPass(e.target.value)}
                            />

                            <img
                                src="https://res.cloudinary.com/hamskid/image/upload/v1670631906/Vector_1_qntpu2.svg"
                                alt="object not found"
                                onClick={handletoggle}
                            />
                        </label>
                    </div>
                    <BlueButton text="continue" width="240" type="submit" />
                </form>
            </div>
        </div>
    );
};

export default Verification;
