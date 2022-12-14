import styles from "../Applications.module.css";
import Dropdown from "./RR_DropDown";

const ApplicationsListHeader = () => {
    return (
        <div className={styles.applications_table_header}>
            <p><img src="https://res.cloudinary.com/hamskid/image/upload/v1671057706/Frame_51489_r5jnzo.svg" alt="object not found" onClick={()=> window.history.back()}/></p>
            <div>
                <Dropdown />
            </div>
        </div>
    );
};

export default ApplicationsListHeader;