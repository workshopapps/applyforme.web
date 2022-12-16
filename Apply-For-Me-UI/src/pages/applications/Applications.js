import styles from "./Applications.module.css";
import ApplicationsListCard from "./components/ApplicationsListCard";
import Table from "./components/Table";
import TopNav from "./components/topNav/TopNav";
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
