import React, { useState } from "react";
import "./NewPass.css";
import Navbar from "./Navbar";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";
import BlueButton from "components/buttons/blue_background/BlueButton";
import "./components/Elements/Button.css";
import "./Welcome1.css";
import { useSearchParams } from "react-router-dom";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

const NewPass = () => {
    const [search] = useSearchParams();
    const [formData, setFormData] = useState({
        "email_address": "",
        "password": ""
    });

    const handleSubmit = event => {
        let errvalues;
        event.preventDefault();
        const data = {
            "token": `${search.get("token")}`,
            "email_address": `${formData.email_address}`,
            "password": `${formData.password}`
        };

        // handle Empty Fields
        Object.keys(data).forEach(val => {
            if (data[`${val}`] === "") {
                errvalues += `${val}`;
                toast.error(`Please Enter ${val}`);
            }
        });

        if (!errvalues?.split(" ").length) {
            axios
                .post(
                    "https://api.applyforme.hng.tech/api/v1/auth/reset-password",
                    data
                )
                .then(res => {
                    toast.success(res.data.message);
                })
                .catch(err => {
                    console.log(err);
                    toast.error(err.response.data.message);
                });
        }
    };

    return (
        <div className="NewPass">
            <Navbar />
            <ToastContainer />
            <div className="nbdy">
                <Text child="Create New Password" />
                <Text2 child="Enter your new password" />
                <form
                    className="form newpass_form"
                    onSubmit={e => handleSubmit(e)}
                >
                    <input
                        type="email"
                        name="pwrd"
                        value={formData.email_address}
                        placeholder="Enter New Password"
                        className="input"
                        onChange={e =>
                            setFormData({
                                ...formData,
                                email_address: e.target.value
                            })
                        }
                    />
                    <input
                        type="password"
                        name="npwrd"
                        id="npwrd"
                        value={formData.password}
                        placeholder="enter New Password"
                        className="input"
                        onChange={e =>
                            setFormData({
                                ...formData,
                                password: e.target.value
                            })
                        }
                    />

                    <BlueButton text="continue" width="240" type="submit" />
                </form>
            </div>
        </div>
    );
};

export default NewPass;
