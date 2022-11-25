import React from "react";
import { BsPlusLg } from "react-icons/bs";
import styles from "../layouts/ApplicationDashboard.module.css";

const NewButton = () => {
    return (
        <button className={styles.applications_new}>
            <BsPlusLg />
        </button>
    );
};

export default NewButton;
