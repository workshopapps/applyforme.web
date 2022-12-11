import React from "react";
import { IoChevronDownOutline } from "react-icons/io5";
import { IoFilterOutline } from "react-icons/io5";

import styles from "../Applications.module.css";

const Dropdown = () => {
    const [isOpen, setIsOpen] = React.useState(false);
    const [active, setActive] = React.useState("Oldest to Newest");
    const toggleOpen = () => setIsOpen(!isOpen);

    return (
        <div className={styles.dropdown}>
            <IoFilterOutline />
            <button onClick={toggleOpen} className={styles.dropbtn}>
                <span>{active}</span>{" "}
                <IoChevronDownOutline aria-hidden="true" />
            </button>
            <div
                id="myDropdown"
                className={`${styles.dropdown_content} ${
                    isOpen ? styles.show : ""
                }`}
            >
                <span
                    className={styles.dropdown_item}
                    onClick={() => {
                        toggleOpen();
                        setActive("Oldest to Newest");
                    }}
                >
                    Oldest to Newest
                </span>
                <span
                    className={styles.dropdown_item}
                    onClick={() => {
                        toggleOpen();
                        setActive("Newest to Oldest");
                    }}
                >
                    Newest to Oldest
                </span>
            </div>
        </div>
    );
};

export default Dropdown;
