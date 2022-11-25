import React from "react";
import { Link, useLocation } from "react-router-dom";
import styles from "../layouts/ApplicationDashboard.module.css";

const Nav = ({ navigations }) => {
    const location = useLocation();
    return (
        <nav className={styles.layout_navigation} aria-label="navigation menu">
            {navigations.map((navLink, index) => (
                <Link
                    key={`${navLink.name}-${index}`}
                    to={navLink.link}
                    className={
                        location.pathname.split("/")[2] ===
                        navLink.name.toLowerCase()
                            ? styles.__active
                            : location.pathname.split("/")[2] === undefined &&
                              navLink.name.toLowerCase() === "dashboard"
                            ? styles.__active
                            : ""
                    }
                >
                    {navLink.icon}
                    <p>{navLink.name}</p>
                </Link>
            ))}
        </nav>
    );
};

export default Nav;
