import styles from "../Applications.module.css";
import Dropdown from "./RR_DropDown";
import Search from "./search/RR_search.module.css";

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