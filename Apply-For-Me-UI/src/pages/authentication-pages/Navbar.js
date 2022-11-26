import React from "react";
import { useNavigate } from "react-router-dom";
import logo from "./images/logo.svg";
import "./Navbar.css";

const Navbar = () => {
    const navigate = useNavigate();
    return (
        <div className="Navbar" onClick={() => navigate("/")}>
            <img src={logo} className="logo" alt="logo" />
        </div>
    );
};

export default Navbar;
