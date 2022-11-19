import style from "./AdminDashboard.module.css";

import { Routes, Route } from "react-router-dom";
import DashboardHome from "./components/dashboard_home/DashboardHome";
import ApplicationDetails from "./components/application_details/ApplicationDetails";
import ApplicationForm from './components/application_form/ApplicationForm';

const AdminDashboard = () => {
    return (
        <Routes className={style}>
            <Route path="/" element={<DashboardHome/>}/>
            <Route path="/application-form" element={<ApplicationForm/>} />
            <Route path="/details" element={<ApplicationDetails/>} />
        </Routes>
    );
};

export default AdminDashboard;
