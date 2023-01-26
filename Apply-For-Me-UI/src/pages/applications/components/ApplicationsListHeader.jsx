import styles from "../Applications.module.css";
import Dropdown from "./Dropdown";
import Search from "./search/Search";

const ApplicationsListHeader = ({sortOldestToNewest,sortNewestToOldest,setSearchValue}) => {
    return (
        <div className={styles.applications_table_header}>
            <Search setSearchValue={setSearchValue}/>
            <div>
                <Dropdown sortOldestToNewest={sortOldestToNewest} sortNewestToOldest={sortNewestToOldest}/>
            </div>
        </div>
    );
};

export default ApplicationsListHeader;
