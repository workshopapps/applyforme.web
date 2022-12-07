import React from "react";
import DashboardSidebar from "../../components/dashboard_sidebar/DashboardSidebar";
import { Outlet } from "react-router-dom";
import classes from "./UserDashboardLayout.module.css";
import { useSelector } from "react-redux";
const UserDashboardLayout = () => {

    return (
        <section className={classes.dashboard_container}>
            <DashboardSidebar />
            <Outlet />
        </section>
    );
};

export default UserDashboardLayout;