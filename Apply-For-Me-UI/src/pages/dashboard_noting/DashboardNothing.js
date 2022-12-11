import React from "react";
import "./DashboardNothing.css";

//import NewUserDashboard from "./NewUserDashboard";
import NewUserDashboard from "./NewUserDashboard";
import GoBack from "./GoBack";

const DashboardNothing = () => {
    return (
        <div className="main-dashboard-page">
            {/* <OldUserDashboard/> */}
            {/* <OldUserDashboard/> */}
            <NewUserDashboard />
            <GoBack />
        </div>
    );
};

export default DashboardNothing;
