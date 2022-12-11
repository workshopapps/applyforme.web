import React from "react";
import "./DashboardNothing.css";

//import NewUserDashboard from "./NewUserDashboard";
import NewUserDashboard from "./NewUserDashboard";

const DashboardNothing = () => {
    return (
        <div className="main-dashboard-page">
            {/* <OldUserDashboard/> */}
            {/* <OldUserDashboard/> */}
            <NewUserDashboard />
        </div>
    );
};

export default DashboardNothing;
