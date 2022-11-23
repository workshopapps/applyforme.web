import style from "./AdminDashboard.module.css";

import { Routes, Route } from "react-router-dom";
import Applications from "./components/applications/Applications";

const AdminDashboard = () => {
    return (
        <>
            <Routes className={style}>
                <Route path="/application-form" element={<DashboardHome />} />
                <Route path="/" element={<ApplicationForm />} />
                <Route path="/details" element={<ApplicantDetails />} />
                <Route path="/applications" element={<Applications />} />
            </Routes>
        </>
    );
};

export default AdminDashboard;
