import React from "react";
import styles from "./TopNav.module.css";
import { BsArrowLeft } from "react-icons/bs";
import avatar from "../../assets/avatar.png";
import notification from "../../assets/notification.png";
import { Link } from "react-router-dom";

const TopNav = ({ title }) => {
    return (
        <div className={styles.applications_top_nav}>
            <div className={styles.applications_page_title}>
                <BsArrowLeft/>
                <h2 onClick={()=>window.history.back()}>{title}</h2>
            </div>
            <div className={styles.application_user_menu}>
                <img
                    src={notification}
                    className={styles.application_nav_notif}
                />
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
