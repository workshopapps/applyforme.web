import { HiOutlineChevronLeft, HiOutlineChevronRight } from "react-icons/hi2";
import styles from "../Applications.module.css";
import Dropdown from "./Dropdown";
import Search from "./search/Search";

const ApplicationsListHeader = () => {
    return (
        <div className={styles.applications_table_header}>
            <Search />
            <div>
                <Dropdown />
            </div>
            <div className={styles.applications_footer}>
                {/* <span>1-10/60</span> */}
                <span>
                    <HiOutlineChevronLeft />
                    <HiOutlineChevronRight />
                </span>
            </div>
        </div>
    );
};

export default ApplicationsListHeader;
