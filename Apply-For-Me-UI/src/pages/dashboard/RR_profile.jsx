import React, { useState } from "react";
import DashboardHeader from "../../components/dashboard/DashboardHeader";
import DashBoardPage from "../dashboard_page/DashBoardPage";
import UsersPage from "../users_page/UsersPage";
import { getActivePage } from "./service/DashbaordService";

const Dashboard = () => {
    
    const handlePageSwitch = data => {
        setPage(getActivePage(data));
    };

    return (
        <div>
            <RR func={handlePageSwitch} setInputSearchValue={dashboardSetSearchParams} />
            <UsersPage/>
        </div>
    );
};

export default Dashboard;