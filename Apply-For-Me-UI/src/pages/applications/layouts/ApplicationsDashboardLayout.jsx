// import { Outlet } from "react-router-dom";
// import Sidebar from "../components/Sidebar";
import styles from "./ApplicationDashboard.module.css";
// import BottomNav from "../components/BottomNav";

const ApplicationsDashboardLayout = () => {
    return (
        <main className={styles.layout_container}>
            {/* <Sidebar /> */}
            {/* <DashboardSidebar /> */}
            <div className={styles.layout_main}>{/* <Outlet /> */}</div>
            {/* <BottomNav /> */}
        </main>
    );
};

export default ApplicationsDashboardLayout;
