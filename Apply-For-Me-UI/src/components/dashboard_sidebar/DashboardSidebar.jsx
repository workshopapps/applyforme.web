import React, { useState } from "react";
import classes from "./DashboardSidebar.module.css";
import Logo from "../../assets/images/footer_logo.svg";
import DashboardIcon from "../../assets/images/dashboard_logo.svg";
import ProfileIcon from "../../assets/images/profile_dashboard_logo.svg";
import BriefCaseIcon from "../../assets/images/office_briefcase_dashboard_logo.svg";
import UsersIcon from "../../assets/images/users_dashboard_logo.svg";
import MessageIcon from "../../assets/images/envelope_badged_dashboard_logo.svg";
import HelpIcon from "../../assets/images/help_dashboard_logo.svg";
import LogoutIcon from "../../assets/images/logout_dashboard_logo.svg";
import { getActiveLink } from "./service/DashboardSidebarService";
import { Link } from "react-router-dom";

const DashboardSidebar = () => {
    const [activeLink, setActiveLink] = useState({
        dashboard: true,
        profile: false,
        application: false,
        users: false,
        messages: false,
        help: false
    });

    const handleAciveLink = link => {
        setActiveLink(() => getActiveLink(link));
    };
    return (
        <section className={classes.sidebar_container}>
            <ul>
                <li>
                    <img src={Logo} alt="Footer logo" />
                </li>
                <li
                    className={activeLink.dashboard ? classes.__active : ""}
                    onClick={() => handleAciveLink("dashboard")}
                >
                    <Link to="/dashboard/">
                        <img src={DashboardIcon} alt="Dashboard icon" />
                        <p>Dashboard</p>
                    </Link>
                </li>
                <li
                    className={activeLink.profile ? classes.__active : ""}
                    onClick={() => handleAciveLink("profile")}
                >
                    {" "}
                    <Link to="#">
                        <img src={ProfileIcon} alt="ProfileIcon icon" />
                        <p>Profile</p>
                    </Link>
                </li>
                <li
                    className={activeLink.application ? classes.__active : ""}
                    onClick={() => handleAciveLink("application")}
                >
                    {" "}
                    <Link to="#">
                        <img src={BriefCaseIcon} alt="BriefCase icon" />
                        <p>Applications</p>
                    </Link>
                </li>
                <li
                    className={activeLink.users ? classes.__active : ""}
                    onClick={() => handleAciveLink("users")}
                >
                    <Link to="#">
                        <img src={UsersIcon} alt="BriefCase icon" />
                        <p>Users</p>
                    </Link>
                </li>
                <li
                    className={activeLink.messages ? classes.__active : ""}
                    onClick={() => handleAciveLink("messages")}
                >
                    <Link to="#">
                        <img src={MessageIcon} alt="Message icon" />
                        <p>Messages</p>
                    </Link>
                </li>
            </ul>

            <ul>
                <li
                    className={activeLink.help ? classes.__active : ""}
                    onClick={() => handleAciveLink("help")}
                >
                    <Link to="#">
                        <img src={HelpIcon} alt="Help icon" />
                        <p>Help</p>
                    </Link>
                </li>

                <li>
                    <img src={LogoutIcon} alt="Logouticon" />
                    <p>Sign out</p>
                </li>
            </ul>
        </section>
    );
};

export default DashboardSidebar;
