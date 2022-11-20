import { Outlet } from "react-router-dom";
import Sidebar from "../components/Sidebar";
import styles from "./ApplicationDashboard.module.css";
import TopNav from "../components/TopNav";
import BottomNav from "../components/BottomNav";

const ApplicationsDashboardLayout = () => {
    return (
        <main className={styles.layout_container}>
            <Sidebar />
            <div className={styles.layout_main}>
                <TopNav />
                <Outlet />
            </div>
            <BottomNav />
        </main>
    );
};

export default ApplicationsDashboardLayout;
