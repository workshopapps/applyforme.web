import React, { useState } from "react";
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

    const [dashboardsearchParams, dashboardSetSearchParams] = useState("");

    return (
        <div>
            <DashboardHeader
                func={handlePageSwitch}
                setInputSearchValue={dashboardSetSearchParams}
            />
            {page.dashboardPage ? (
                <DashBoardPage inputSearchValue={dashboardsearchParams} />
            ) : (
                <UsersPage />
            )}
        </div>
    );
};

export default Dashboard;
