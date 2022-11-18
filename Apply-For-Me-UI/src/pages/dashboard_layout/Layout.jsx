import React from "react";
import { Outlet } from "react-router-dom";
import DashboardSidebar from "../../components/dashboard_sidebar/DashboardSidebar";
import classes from "./Layout.module.css";

const Layout = () => {
    return (
        <section className={classes.dashboard_container}>
            <DashboardSidebar />
            <Outlet />
        </section>
    );
};

export default Layout;
