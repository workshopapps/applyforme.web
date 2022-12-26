import React, { useState } from "react";
import classes from "./DashboardSidebar.module.css";
import Logo from "../../assets/images/afm-logo.svg";
import DashboardIcon from "../../assets/images/dashboard_logoo.svg";
import ProfileIcon from "../../assets/images/profile_dashboard_logoo.svg";
import BriefCaseIcon from "../../assets/images/office_briefcase_dashboard_logoo.svg";
import activeDashboardIcon from "../../assets/images/active_dashboard.svg";
import activeProfileIcon from "../../assets/images/active_profile.svg";
import activeApplicationsIcon from "../../assets/images/active_applications.svg";
import mobileOverviewIcon from "../../assets/images/bottomnav-overview-icon.svg";
import mobileProfilesIcon from "../../assets/images/bottom_nav_profile.svg";
import mobileApplicationsIcon from "../../assets/images/bottomnav-applications-icon.svg";
import activeMobileDashboard from "../../assets/images/mobile_active_dashboard.svg";
import activeMobileProfile from "../../assets/images/mobile_active_profile.svg";
import activeMobileApplications from "../../assets/images/mobile_active_applications.svg";

import { useGlobalContext } from "../../hooks/context";

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
                webActive: activeDashboardIcon,
                mobile: mobileOverviewIcon,
                mobileActive: activeMobileDashboard
            },
            title: "Dashboard",
            web_title: "Dashboard"
        },
        {
            path: "/dashboard/user",
            img: {
                web: ProfileIcon,
                webActive: activeProfileIcon,
                mobile: mobileProfilesIcon,
                mobileActive: activeMobileProfile
            },
            title: "Profile",
            web_title: "My job profile"
        },
        {
            path: "/dashboard/applications",
            img: {
                web: BriefCaseIcon,
                webActive: activeApplicationsIcon,
                mobile: mobileApplicationsIcon,
                mobileActive: activeMobileApplications
            },
            title: "Applications",
            web_title: "Applications"
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
                                        <img
                                            src={link.img.webActive}
                                            alt="Dashboard icon"
                                        />
                                        <p>{link.web_title}</p>
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
                                        <img
                                            src={link.img.mobileActive}
                                            alt="Dashboard active"
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
