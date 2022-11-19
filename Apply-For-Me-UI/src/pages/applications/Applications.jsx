import styles from "./Applications.module.css";
import Table from "./components/Table";
import TopNav from "./components/TopNav";

const Applications = () => {
    return (
        <div className={styles.applications_container}>
            <TopNav />
            <section className={styles.application_main}>
                <Table />
            </section>
        </div>
    );
};

export default Applications;
