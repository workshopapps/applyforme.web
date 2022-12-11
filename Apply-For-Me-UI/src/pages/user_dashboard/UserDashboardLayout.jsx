/* eslint-disable no-unused-vars */
import React from "react";
import DashboardSidebar from "../../components/dashboard_sidebar/DashboardSidebar";
import { Outlet } from "react-router-dom";
import classes from "./UserDashboardLayout.module.css";
const UserDashboardLayout = () => {
    return (
        <section className={classes.dashboard_container}>
            <DashboardSidebar />
            <Outlet
                style={{
                    marginTop: "200px"
                }}
            />
        </section>
    );
};

export default UserDashboardLayout;
