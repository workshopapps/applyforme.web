import React from "react";
import styles from "./TopNav.module.css";
import { TbBellRinging } from "react-icons/tb";
import { BsArrowLeft } from "react-icons/bs";
import avatar from "../../assets/avatar.png";
import { Link } from "react-router-dom";

const TopNav = ({ title }) => {
    return (
        <div className={styles.applications_top_nav}>
            <div className={styles.applications_page_title}>
                <BsArrowLeft />
                <h2>{title}</h2>
            </div>
            <div className={styles.application_user_menu}>
                <TbBellRinging />
                <Link to="/dashboard/settings">
                    <img
                        src={avatar}
                        className={styles.application_nav_avatar}
                    />
                </Link>
            </div>
        </div>
    );
};

export default TopNav;
