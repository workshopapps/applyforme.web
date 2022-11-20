import React from "react";
import styles from "./TopNav.module.css";
import { TbBellRinging } from "react-icons/tb";
import { BsArrowLeft } from "react-icons/bs";
import avatar from "../../assets/avatar.png";

const TopNav = ({ title }) => {
    return (
        <div className={styles.applications_top_nav}>
            <div className={styles.applications_page_title}>
                <BsArrowLeft />
                <h2>{title}</h2>
            </div>
            <div className={styles.application_user_menu}>
                <TbBellRinging />
                <img src={avatar} className={styles.application_nav_avatar} />
            </div>
        </div>
    );
};

export default TopNav;
