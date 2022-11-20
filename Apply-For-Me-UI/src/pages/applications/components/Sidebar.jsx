import React from "react";
import styles from "../layouts/ApplicationDashboard.module.css";
import { Link } from "react-router-dom";
import afmLogo from "../assets/afm_logo.svg";
import dashboardIcon from "../assets/dashboard_logo.svg";
import applicationsLogo from "../assets/office_briefcase_dashboard_logo.svg";
import userIcon from "../assets/user.svg";

const Sidebar = () => {
    const [active, setActive] = React.useState("");
    return (
        <div className={styles.layout_sidebar}>
            <Link to="/" className={styles.brand_logo}>
                <img src={afmLogo} alt="Brand Logo" width={60} height={27} />
            </Link>
            <nav className={styles.layout_navigation}>
                <Link
                    to="/dashboard"
                    onClick={() => setActive("dashboard")}
                    className={active === "dashboard" ? styles.__active : ""}
                >
                    <img src={dashboardIcon} alt="Dashboard icon" />
                    <p>Dashboard</p>
                </Link>
                <Link
                    to="/dashboard/job-profile"
                    onClick={() => setActive("job-profile")}
                    className={active === "job-profile" ? styles.__active : ""}
                >
                    <img src={userIcon} alt="Job Profile icon" />
                    <p>Job Profile</p>
                </Link>
                <Link
                    to="/dashboard/applications"
                    onClick={() => setActive("applications")}
                    className={active === "applications" ? styles.__active : ""}
                >
                    <img src={applicationsLogo} alt="Briefcase icon" />
                    <p>Applications</p>
                </Link>
            </nav>
        </div>
    );
};

export default Sidebar;
