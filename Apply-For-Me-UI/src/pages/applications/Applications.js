import styles from "./Applications.module.css";
import ApplicationsListCard from "./components/ApplicationsListCard";
import Table from "./components/Table";
// import TopNav from "./components/topNav/TopNav";
import { applications } from "./applicationsMock";
import GoBack from "pages/dashboard_noting/GoBack";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";
const Applications = () => {
    return (
        <div className={styles.applications_container}>
            <TopBar
                title={"Applications"}
                style={{
                    marginTop: "auto",
                    color: "#2e3192",
                    fontWeight: "500",
                    marginLeft: "2.5rem"
                }}
            />
            <section className={styles.application_main}>
                <Table applications={applications} />
                <ApplicationsListCard applications={applications} />
            </section>
            <GoBack />
        </div>
    );
};

export default Applications;
