import React from "react";
import styles from "../Applications.module.css";
import { HiOutlineBellAlert } from "react-icons/hi2";
import avatar from "../assets/avatar.png";

const TopNav = () => {
    return (
        <div className={styles.applications_top_nav}>
            <h2>Applications</h2>
            <div className={styles.application_user_menu}>
                <HiOutlineBellAlert />
                <img src={avatar} className={styles.application_nav_avatar} />
            </div>
        </div>
    );
};

export default TopNav;
