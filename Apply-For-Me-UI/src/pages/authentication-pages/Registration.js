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
    const handleNation = event => {
        event.preventDefault();
    };
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
                    <form className="form" onSubmit={e => handleNation(e)}>
                        <div className="select-wrapper">
                            <select
                                className="registration_select"
                                name="cars"
                                id="cars"
                            >
                                <option value="" disabled selected hidden>
                                    Nationality
                                </option>
                                <option value="ng">Nigeria</option>
                                <option value="tg">Togo</option>
                                <option value="cd">Chad</option>
                                <option value="br">Brazil</option>
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
                                <option value="ng">Nigeria</option>
                                <option value="tg">Togo</option>
                                <option value="cd">Chad</option>
                                <option value="br">Brazil</option>
                            </select>
                        </div>
                        <label className="label">
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
                                <option value="volvo">
                                    FrontEnd Software Engineer
                                </option>
                                <option value="saab">Audict Analyst</option>
                                <option value="opel">Data Scienctist</option>
                                <option value="audi">Ui/Ux Design</option>
                            </select>
                        </div>
                        <Link to="/wel2" className="lg">
                            <Button child="Continue" />
                        </Link>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Registration;
