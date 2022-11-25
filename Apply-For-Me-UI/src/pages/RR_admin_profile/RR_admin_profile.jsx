import RR_admin_Profile from "components/dashboard/RR_ProfilePage";
import UsersPage from "pages/users_page/UsersPage";
import { useState } from "react";

export const RR_admin_profile = () => {
    const [dashboardSetSearchParams] = useState("");

    return (
        <>
            <RR_admin_Profile setInputSearchValue={dashboardSetSearchParams} />
            <UsersPage />
        </>
    );
};
