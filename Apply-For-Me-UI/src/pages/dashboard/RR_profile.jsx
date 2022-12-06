import React from "react";

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