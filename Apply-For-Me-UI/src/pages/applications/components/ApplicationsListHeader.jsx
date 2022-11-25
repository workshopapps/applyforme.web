import styles from "../Applications.module.css";
import Dropdown from "./Dropdown";
import Search from "./search/Search";

const ApplicationsListHeader = ({
    setSearch,
    searchQuery,
    sortApplications,
    setSortApplications
}) => {
    return (
        <div className={styles.applications_table_header}>
            <Search onChange={setSearch} value={searchQuery} />
            <Dropdown
                sortApplications={sortApplications}
                setSortApplications={setSortApplications}
            />
        </div>
    );
};

export default ApplicationsListHeader;
