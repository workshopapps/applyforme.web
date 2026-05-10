// import AccountSet from "./AccountSet";
import AccountSettingsNew from "./AccountSettingsNew";
import { useState, useEffect } from "react";
import Spinner from "components/spinner/Spinner";

const AccountSettings = () => {
    const [memberdetails, setMemberDetails] = useState();
    const token = localStorage.getItem("tokenHngKey");

    useEffect(() => {
        fetch(`https://api.applyforme.hng.tech/api/v1/member/details`, {
            headers: {
                "Authorization": `Bearer ${token}`
            }
        })
            .then(response => response.json())
            .then(data => setMemberDetails(data));
    }, [token]);
    console.log("account settings:", memberdetails);
    if (!memberdetails) {
        return <Spinner />;
    }

    return <AccountSettingsNew details={memberdetails} />;
};

export default AccountSettings;
