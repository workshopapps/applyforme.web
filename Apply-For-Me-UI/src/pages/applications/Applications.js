import styles from "./Applications.module.css";
import ApplicationsListCard from "./components/ApplicationsListCard";
import Table from "./components/Table";
import TopNav from "./components/topNav/TopNav";
import { applications } from "./applicationsMock";
const Applications = () => {
    return (
        <div className={styles.applications_container}>
            <TopNav title={"Applications"} />
            <section className={styles.application_main}>
                <Table applications={applications} />
                <ApplicationsListCard applications={applications} />
            </section>
        </div>
    );
};

export default Applications;
