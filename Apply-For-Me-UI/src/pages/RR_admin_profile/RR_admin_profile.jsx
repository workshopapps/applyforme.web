import RR_admin_Profile from "components/dashboard/RR_ProfilePage";
import {RRApplicantsPage} from "components/admin_dashboard/dashboard_content/applicants"
import { useState } from "react";
import { ToastContainer } from "react-toastify";

export const RR_admin_profile = () => {
    const [dashboardsearchParams, dashboardSetSearchParams] = useState("");

    return (
        <>
            <ToastContainer/>
            <RR_admin_Profile setInputSearchValue={dashboardSetSearchParams}/>
            <RRApplicantsPage  inputSearchValue={dashboardsearchParams}/>
        </>
    );
};
