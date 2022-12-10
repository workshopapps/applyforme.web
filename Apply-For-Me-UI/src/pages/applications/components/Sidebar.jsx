import React from "react";
import styles from "../layouts/ApplicationDashboard.module.css";
import { Link } from "react-router-dom";
import afmLogo from "../assets/afm_logo.svg";
import { navigations } from "../navigation";

const Sidebar = () => {
    const [active, setActive] = React.useState("");
    return (
        <div className={styles.layout_sidebar}>
            <Link to="/" className={styles.brand_logo}>
                <img src={afmLogo} alt="Brand Logo" width={60} height={27} />
            </Link>
            <nav className={styles.layout_navigation}>
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

export default Sidebar;
