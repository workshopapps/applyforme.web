import styles from "./rr_all_applications.module.css";
import ApplicationsListCard from "./components/RR_ApplicationsListCard";
import Table from "./components/rr_table";
import TopNav from "./components/topNav/RR_TopNav";
import { applications } from "./applicationsMock";
import GoBack from "pages/dashboard_noting/GoBack";

const Applications = () => {
    return (
        <div className={styles.applications_container}>
            <TopNav title={"Applications"} />
            <section className={styles.application_main}>
                <Table applications={applications} />
                <ApplicationsListCard applications={applications} />
            </section>
            <GoBack />
        </div>
    );
};

export default Applications;
