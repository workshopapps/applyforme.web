import React from "react";
import Navbar from "./Navbar";
import "./Welcome1.css";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";
import Inputbox from "./components/Elements/Inputbox";
import Button from "./components/Elements/Button";
import "./components/Elements/Button.css";
import Footer from "./Footer";
import { Link } from "react-router-dom";

const Welcome1 = () => {
    const Submit = () => {
        alert("clicked");
    };
    return (
        <div className="Welcome1">
            <Navbar />
            <div className="w1bdy">
                <Text child="Welcome to ApplyForMe!!" />
                <Text2 child="Create your ApplyForMe account here" />
                <form className="form">
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
                </form>
                <Link to="/reg" className="lg">
                    <Button child="Sign Up" onClick={Submit} />
                </Link>
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
