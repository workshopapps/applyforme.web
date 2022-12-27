import RRAdminProfile from "components/dashboard/RR_ProfilePage";
import { RRApplicantsPage } from "components/admin_dashboard/dashboard_content/applicants";
import { useState } from "react";
import { ToastContainer } from "react-toastify";

export const RRAdminProfilePage = () => {
    const [dashboardsearchParams, dashboardSetSearchParams] = useState("");

    return (
        <>
            <ToastContainer/>
            <RRAdminProfile setInputSearchValue={dashboardSetSearchParams}/>
            <RRApplicantsPage  inputSearchValue={dashboardsearchParams}/>
        </>
    );
};
