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
import { NavLink, useNavigate } from "react-router-dom";

const DashboardSidebar = () => {
    const [activeLink, setActiveLink] = useState({
        dashboard: true,
        profile: false,
        application: false,
        users: false,
        messages: false,
        help: false
    });

    const navigate = useNavigate();
    const handleAciveLink = link => {
        setActiveLink(() => getActiveLink(link));
    };

    const links = [
        {
            path: "/dashboard/",
            img: {
                web: DashboardIcon,
                mobile: mobileOverviewIcon
            },
            title: "Dashboard"
        },
        {
            path: "/dashboard/user",
            img: {
                web: ProfileIcon,
                mobile: mobileProfilesIcon
            },
            title: "Profile"
        },
        {
            path: "/dashboard/applications",
            img: {
                web: BriefCaseIcon,
                mobile: mobileApplicationsIcon
            },
            title: "Applications"
        }
    ];

    const { userRole } = useGlobalContext();

    return (
        <>
            <section className={classes.sidebar_container}>
                <ul>
                    <li onClick={() => navigate("/")}>
                        <img src={Logo} alt="Footer logo" />
                    </li>
                    {userRole === "user" &&
                        links.map((link, i) => {
                            return (
                                <li
                                    key={i}
                                    className={
                                        activeLink.dashboard
                                            ? classes.__active
                                            : ""
                                    }
                                    onClick={() => handleAciveLink("dashboard")}
                                >
                                    <NavLink
                                        to={link.path}
                                        className={({ isActive }) =>
                                            isActive
                                                ? classes.active
                                                : classes.inactive
                                        }
                                    >
                                        <img
                                            src={link.img.web}
                                            alt="Dashboard icon"
                                        />
                                        <p>{link.title}</p>
                                    </NavLink>
                                </li>
                            );
                        })}
                </ul>
            </section>
            <section
                className={[classes.sidebar_container, classes.mobile].join(
                    " "
                )}
            >
                <ul>
                    {userRole === "user" &&
                        links.map((link, i) => {
                            return (
                                <li
                                    key={i}
                                    className={
                                        activeLink.dashboard
                                            ? classes.__active
                                            : ""
                                    }
                                    onClick={() => handleAciveLink("dashboard")}
                                >
                                    <NavLink
                                        to={link.path}
                                        className={({ isActive }) =>
                                            isActive
                                                ? classes.mobile_active
                                                : classes.mobile_inactive
                                        }
                                    >
                                        <img
                                            src={link.img.mobile}
                                            alt="Dashboard icon"
                                        />
                                        <p>{link.title}</p>
                                    </NavLink>
                                </li>
                            );
                        })}
                </ul>
            </section>
        </>
    );
};

export default DashboardSidebar;