import styles from "./rr_all_applications.module.css";
import Table from "./components/rr_table";
import { applications } from "./applicationsMock";
import GoBack from "pages/dashboard_noting/GoBack";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";

const RRApplications = () => {
    return (
        <div className={styles.applications_container}>
            <RRD_Nav />
            <section className={styles.application_main}>
                <Table applications={applications} className={styles.table} />
            </section>
            <GoBack />
        </div>
    );
};

export default RRApplications;
