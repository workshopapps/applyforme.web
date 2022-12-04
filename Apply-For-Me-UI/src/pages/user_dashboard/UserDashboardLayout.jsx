/* eslint-disable no-unused-vars */
import React from "react";
// import DashboardSidebar from "../../components/dashboard_sidebar/DashboardSidebar";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";
import { Outlet, useNavigate } from "react-router-dom";

import classes from "./UserDashboardLayout.module.css";
import { useSelector } from "react-redux";
const UserDashboardLayout = () => {
    const navigate = useNavigate();
    const { user } = useSelector(state => state.user);

    return (
        <section className={classes.dashboard_container}>
            {/* <DashboardSidebar /> */}
            <RRD_Nav />
            <Outlet />
        </section>
    );
};

export default UserDashboardLayout;
