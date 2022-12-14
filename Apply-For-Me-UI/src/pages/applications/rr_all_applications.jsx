import styles from "./rr_all_applications.module.css";
import Table from "./components/rr_table";
import { applications } from "./applicationsMock";
import GoBack from "pages/dashboard_noting/GoBack";
import RRDNav from "pages/RR_Dashboard/components/RRD_Nav";

const RRApplications = () => {
    return (
        <div className={styles.applications_container}>
            <RRDNav />
            <section className={styles.application_main}>
                <Table applications={applications} className={styles.table} />
            </section>
            <div className={styles.go_back_cover}>
                <GoBack />
            </div>
           
        </div>
    );
};

export default RRApplications;
