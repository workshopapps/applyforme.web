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
        </div>
    );
};

export default ApplicationsListHeader;
