import React from "react";
import styles from "../layouts/ApplicationDashboard.module.css";
import { navigations } from "../navigation";
import { Link } from "react-router-dom";

const BottomNav = () => {
    const [active, setActive] = React.useState("");
    return (
        <div className={styles.bottom_nav}>
            <nav className={styles.layout_bottom_navigation}>
                {navigations.map((navLink, index) => (
                    <Link
                        key={`${navLink.name}-${index}`}
                        to={navLink.link}
                        onClick={() => setActive(navLink.name)}
                        className={
                            active === navLink.name ? styles.__active : ""
                        }
                    >
                        {navLink.icon}
                        <p>{navLink.name}</p>
                    </Link>
                ))}
            </nav>
        </div>
    );
};

export default BottomNav;
