import React from "react";
import { NavLink } from "react-router-dom";
import styles from "./NoProfile.module.css";
import add from "../assets/add.png";
import blueadd from "../assets/blue-add.png";
import TopBar from "../components/TopBar/TopBar";

const NoProfile = () => {
    return (
        <div className={styles.noprofile}>
            <TopBar />
            <span className={styles.noprofile_body} id={styles.desktop_view}>
                <p className={styles.noprofile_body_text}>
                    Nothing to see here
                </p>
                <NavLink
                    to="/dashboard/user/create-profile"
                    style={{ textDecoration: "none" }}
                >
                    <button className={styles.createjob_button}>
                        <p>Create a job profile</p>
                        <img src={add} alt="add" />
                    </button>
                </NavLink>
                <p className={styles.noprofile_body_text}>to get started</p>
            </span>
            <span className={styles.mobile_view} id={styles.mobile_view}>
                <p>Welcome, you have no job profile yet!</p>
                <div className={styles.create_box}>
                    <p>Tap</p>
                    <NavLink
                        to="/dashboard/user/create-profile"
                        style={{ textDecoration: "none" }}
                    >
                        <div className={styles.btn_plus}>
                            <img src={blueadd} alt="add" />
                        </div>
                    </NavLink>
                    <p className={styles.noprofile_body_text}>to create</p>
                </div>
                <NavLink
                    to="/dashboard/user/create-profile"
                    style={{ textDecoration: "none" }}
                >
                    <div className={styles.btn_plus_fixed}>
                        <img src={blueadd} alt="add" />
                    </div>
                </NavLink>
            </span>
        </div>
    );
};

export default NoProfile;
