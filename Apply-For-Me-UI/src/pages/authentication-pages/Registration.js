import React, { useRef } from "react";
import Navbar from "./Navbar";
import "./Registration.css";
import Text from "./components/Text/Text";
import Text2 from "./components/Text/Text2";
import Button from "./components/Elements/Button";
import "./components/Elements/Button.css";
import { Link } from "react-router-dom";

const Registration = () => {
    const ref = useRef();
    return (
        <div className="Registration">
            <div className="reg">
                <Navbar />
                <div className="rbdy">
                    <Text
                        className="reg"
                        child="Please fill in this necessary information"
                    />
                    <Text2 child="Complete your registration" />
                    <div className="form">
                        <div className="select-wrapper">
                            <select
                                className="registration_select"
                                name="cars"
                                id="cars"
                            >
                                <option value="" disabled selected hidden>
                                    Nationality
                                </option>
                                <option value="volvo">Option1</option>
                                <option value="saab">Option2</option>
                                <option value="opel">Option3</option>
                                <option value="audi">Option4</option>
                            </select>
                        </div>
                        <div className="select-wrapper">
                            <select
                                className="registration_select"
                                name="cars"
                                id="cars"
                            >
                                <option value="" disabled selected hidden>
                                    Country of residence
                                </option>
                                <option value="volvo">Option1</option>
                                <option value="saab">Option2</option>
                                <option value="opel">Option3</option>
                                <option value="audi">Option4</option>
                            </select>
                        </div>
                        <label>
                            <input
                                type="text"
                                name="date"
                                id="dob"
                                placeholder="Date of birth"
                                className="input select-wrapper"
                                ref={ref}
                                onChange={e => console.log(e.target.value)}
                                onFocus={() => (ref.current.type = "date")}
                                onBlur={() => (ref.current.type = "date")}
                            />
                        </label>
                        <div className="select-wrapper">
                            <select
                                className="registration_select"
                                name="cars"
                                id="cars"
                            >
                                <option value="" disabled selected hidden>
                                    Job title
                                </option>
                                <option value="volvo">Option1</option>
                                <option value="saab">Option2</option>
                                <option value="opel">Option3</option>
                                <option value="audi">Option4</option>
                            </select>
                        </div>
                    </div>
                    <Link to="/wel2" className="lg">
                        <Button child="Continue" />
                    </Link>
                </div>
            </div>
        </div>
    );
};

export default Registration;
