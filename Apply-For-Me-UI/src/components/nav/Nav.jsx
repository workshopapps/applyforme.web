/* eslint-disable no-unused-vars */
import React, { useState } from "react";
import { Link, Navigate, useNavigate } from "react-router-dom";
import { FiMenu, FiX } from "react-icons/fi";
import classes from "./Nav.module.css";
import Logo from "../../assets/images/nav_logo.svg";
import BlueButton from "../buttons/blue_background/BlueButton";
import LightButton from "../buttons/light_button/LightButton";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";

const Nav = () => {
    const [dropDown, setDropDown] = useState(false);
    const { user } = useSelector(state => state.user);

    const dispatch = useDispatch();
    const navigate = useNavigate();
    const handleLogout = () => {
        localStorage.removeItem("tokenHngKey");
        dispatch(userInfo(""));
        navigate("/");
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
                            src={Logo}
                            alt="Apply for me Logo"
                            className={classes.logo__img}
                        />
                    </Link>
                </div>

                <ul className={classes.nav_links}>
                    <li>
                        <Link to="/about">About us</Link>
                    </li>

                    <li>
                        <Link to="/pricing">Pricing plan</Link>
                    </li>

                    <li>
                        <Link to="/blog">Blog</Link>
                    </li>
                    <li>
                        <Link to="/faqs">FAQs</Link>
                    </li>
                    <li>
                        <Link to="/contact">Contact us</Link>
                    </li>
                </ul>

                <div className={classes.btn_container}>
                    {!user ? (
                        <>
                            <Link to="/wel2">
                                <LightButton text="Sign in" width="127" />
                            </Link>
                            <Link to="/wel1">
                                <BlueButton text="Get started" width="156" />
                            </Link>
                        </>
                    ) : (
                        <BlueButton
                            text="Logout"
                            width="156"
                            func={handleLogout}
                        />
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
                            style={{ display: dropDown ? "none" : "block" }}
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
                            <Link to="/about">About us</Link>
                        </li>

                        <li onClick={() => setDropDown(false)}>
                            <Link to="/pricing">Pricing plan</Link>
                        </li>

                        <li onClick={() => setDropDown(false)}>
                            <Link to="/blog">Blog</Link>
                        </li>
                        <li>
                            <Link to="/faqs">FAQs</Link>
                        </li>
                        <li onClick={() => setDropDown(false)}>
                            <Link to="/contact">Contact us</Link>
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
                            <BlueButton
                                text="Logout"
                                width="156"
                                func={handleLogout}
                            />
                        )}
                    </div>
                </nav>
            </div>
        </section>
    );
};

export default Nav;
