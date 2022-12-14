import React, { useState } from "react";
import { ToastContainer } from "react-toastify";
import DashboardHeader from "../../components/dashboard/DashboardHeader";
import DashBoardPage from "../dashboard_page/DashBoardPage";
import UsersPage from "../users_page/UsersPage";
import { getActivePage } from "./service/DashbaordService";

const Dashboard = () => {
    const [page, setPage] = useState({
        dashboardPage: true,
        userPage: false
    });

    const handlePageSwitch = data => {
        setPage(getActivePage(data));
    };

    return (
        <div>
            <ToastContainer />
            <DashboardHeader
                func={handlePageSwitch}
            />
            {page.dashboardPage ? (
                <DashBoardPage/>
            ) : (
                <UsersPage/>
            )}
        </div>
    );
};

export default Dashboard;
