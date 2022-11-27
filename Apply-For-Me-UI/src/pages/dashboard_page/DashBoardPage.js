import React from "react";
import { DashboardContent } from "../../components/admin_dashboard/dashboard_content/dashboard_content";

const DashBoardPage = ({inputSearchValue}) => {
    return (
        <>
            <DashboardContent inputSearchValue={inputSearchValue}/>
        </>
    )
};

export default DashBoardPage;

