import React from "react";
// import DashboardSidebar from "../../components/dashboard_sidebar/DashboardSidebar";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";
import { Outlet } from "react-router-dom";
import classes from "./UserDashboardLayout.module.css";
const UserDashboardLayout = () => {
    return (
        <section className={classes.dashboard_container}>
            {/* <DashboardSidebar /> */}
            <RRD_Nav />
            <Outlet />
        </section>
    );
};

export default UserDashboardLayout;
