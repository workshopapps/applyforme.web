import React from "react";
import { IoChevronDownOutline } from "react-icons/io5";
import { IoFilterOutline } from "react-icons/io5";
import styles from "../Applications.module.css";

const Dropdown = ({ sortApplications, setSortApplications }) => {
    const [isOpen, setIsOpen] = React.useState(false);
    const toggleOpen = () => setIsOpen(!isOpen);

    return (
        <div className={styles.dropdown_container}>
            <IoFilterOutline />

            <div className={styles.dropdown}>
                <button onClick={toggleOpen} className={styles.dropbtn}>
                    <span>{sortApplications}</span>{" "}
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
                            setSortApplications("Oldest to Newest");
                        }}
                    >
                        Oldest to Newest
                    </span>
                    <span
                        className={styles.dropdown_item}
                        onClick={() => {
                            toggleOpen();
                            setSortApplications("Newest to Oldest");
                        }}
                    >
                        Newest to Oldest
                    </span>
                </div>
            </div>
        </div>
    );
};

export default Dropdown;
