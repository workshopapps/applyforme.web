/* eslint-disable no-unused-vars */
import React, { useState } from "react";
import { Link, NavLink, Navigate, useNavigate } from "react-router-dom";
import { FiMenu, FiX } from "react-icons/fi";
import classes from "./Nav.module.css";
import Logo from "../../assets/images/nav_logo.svg";
import BlueButton from "../buttons/blue_background/BlueButton";
import LightButton from "../buttons/light_button/LightButton";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";

const Nav = () => {
    const initState = {
        "about": false,
        "price": false,
        "blog": false,
        "contact": false
    };
    const [dropDown, setDropDown] = useState(false);
    const { user } = useSelector(state => state.user);
    const [active, setActiveLink] = useState({ ...initState });

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const handleLogout = () => {
        localStorage.removeItem("tokenHngKey");
        localStorage.removeItem("refreshTokenHngKey");
        dispatch(userInfo(""));
        navigate("/");
    };

    const handleActiveLink = ({ isActive }) => {
        return {
            color: isActive ? "#2E3192" : "",
            fontWeight: isActive ? "500" : ""
        };
    };

    return (
        <section className={classes.nav_container}>
            <nav
                className={[
                    classes.nav_container__wrapper,
                    classes.hide_mobile
                ].join(" ")}
            >
                <div className={classes.logo}>
                    <Link to="/">
                        <img
                            src="https://res.cloudinary.com/hamskid/image/upload/v1669935090/Frame_1_nfoiiz.png"
                            alt="Apply for me Logo"
                            className={classes.logo__img}
                        />
                    </Link>
                </div>

                <ul className={classes.nav_links}>
                    {/* <li className="active">
                        <NavLink to="/" style={handleActiveLink}>
                            Home
                        </NavLink>
                    </li> */}
                    <li>
                        <NavLink to="/about" style={handleActiveLink}>
                            About us
                        </NavLink>
                    </li>

                    <li>
                        <NavLink to="/pricing" style={handleActiveLink}>
                            Pricing plan
                        </NavLink>
                    </li>
                    <li>
                        <NavLink to="/faqs" style={handleActiveLink}>
                            FAQs
                        </NavLink>
                    </li>
                </ul>

                <div className={classes.btn_container}>
                    {!user ? (
                        <>
                            <Link to="/wel2" className={classes.sign_in}>
                                Sign in
                            </Link>
                            <Link to="/wel1">
                                <BlueButton text="Get started" width="156" />
                            </Link>
                        </>
                    ) : (
                        <div className={classes.auth__user_btn}>
                            <p
                                onClick={() =>
                                    navigate(
                                        user.roles[0] === "SuperAdministrator"
                                            ? "/user-page"
                                            : user.roles[0] === "Recruiter"
                                            ? "/rr_admin"
                                            : "/dashboard/"
                                    )
                                }
                                style={{color:"#2e3192", fontWeight:"bold"}}
                                >Dashboard
                            </p>
                            <BlueButton
                                text="Logout"
                                width="156"
                                func={handleLogout}
                            />
                        </div>
                    )}
                </div>
            </nav>

            {/*
            Mobile
            */}
            <div className="hide__desktop">
                <nav
                    className={classes.nav_container__wrapper__mobile}
                    style={{ height: dropDown ? "100vh" : "" }}
                >
                    <div className={classes.logo__mobile}>
                        <Link to="/">
                            <img
                                src={Logo}
                                alt="Apply for me Logo"
                                className={classes.logo__img__mobile}
                            />
                        </Link>

                        <FiMenu
                            className={classes.menu__mobile}
                            onClick={() => setDropDown(true)}
                            style={{ display: dropDown ? "none" : "block",
                            padding: "0.2rem",
                            borderRadius: "5px" }}
                            size="2.5rem"
                        />

                        <FiX
                            className={classes.menu__mobile}
                            onClick={() => setDropDown(false)}
                            style={{ display: dropDown ? "block" : "none" }}
                        />
                    </div>

                    <ul
                        className={classes.nav_links__mobile}
                        style={{ display: dropDown ? "flex" : "none" }}
                    >
                        <li onClick={() => setDropDown(false)}>
                            <Link to="/">Home</Link>
                        </li>
                        <li onClick={() => setDropDown(false)}>
                            <Link to="/about">About us</Link>
                        </li>

                        <li onClick={() => setDropDown(false)}>
                            <Link to="/pricing">Pricing plan</Link>
                        </li>
                        <li>
                            <Link to="/faqs">FAQs</Link>
                        </li>
                    </ul>

                    <div
                        className={classes.btn_container__mobile}
                        style={{ display: dropDown ? "flex" : "none" }}
                    >
                        {!user ? (
                            <>
                                <Link to="/wel2">
                                    <LightButton
                                        text="Sign in"
                                        width="127"
                                        func={() => setDropDown(false)}
                                    />
                                </Link>
                                <Link to="/wel1">
                                    <BlueButton
                                        text="Get started"
                                        width="156"
                                        func={() => setDropDown(false)}
                                    />
                                </Link>
                            </>
                        ) : (
                            <div className={classes.auth__user_btn}>
                                <BlueButton
                                    text="Dashboard"
                                    width="156"
                                    func={() =>
                                        navigate(
                                            user.roles[0] ===
                                                "SuperAdministrator"
                                                ? "/user-page"
                                                : user.roles[0] === "Recruiter"
                                                ? "/rr_admin"
                                                : "/dashboard/"
                                        )
                                    }
                                />
                                <BlueButton
                                    text="Logout"
                                    width="156"
                                    func={handleLogout}
                                />
                            </div>
                        )}
                    </div>
                </nav>
            </div>
        </section>
    );
};

export default Nav;
