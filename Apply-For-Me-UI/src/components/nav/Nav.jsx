import React, { useState } from "react";
import { Link } from "react-router-dom";
import { FiMenu } from "react-icons/fi";
import classes from "./Nav.module.css";
import Logo from "../../assets/images/nav_logo.svg";
import BlueButton from "../buttons/blue_background/BlueButton";
import LightButton from "../buttons/light_button/LightButton";
import DropdownMenu from "./DropdownMenu";

const Nav = () => {
    const [menuopen, setMenuopen] = useState(false);

    const toggleMenu = () => {
        setMenuopen(!menuopen);
    };
    return (
        <section className={classes.nav_container}>
            <nav className={classes.nav_container__wrapper}>
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
                    <LightButton text="Sign in" width="127" />
                    <BlueButton text="Get started" width="156" />
                </div>

                <FiMenu onClick={toggleMenu} className={classes.menu} />
                {menuopen ? <DropdownMenu /> : <></>}
            </nav>
        </section>
    );
};

export default Nav;
