import React, { useState } from "react";
import classes from "./DashboardSidebar.module.css";
import Logo from "../../assets/images/afm-logo.svg";
import DashboardIcon from "../../assets/images/dashboard_logo.svg";
import ProfileIcon from "../../assets/images/profile_dashboard_logo.svg";
import BriefCaseIcon from "../../assets/images/office_briefcase_dashboard_logo.svg";
import mobileOverviewIcon from "../../assets/images/bottomnav-overview-icon.svg";
import mobileProfilesIcon from "../../assets/images/bottomnav-profiles-icon.svg";
import mobileApplicationsIcon from "../../assets/images/bottomnav-applications-icon.svg";

import { useGlobalContext } from "../../hooks/context";

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
            path: "#",
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
                    <li>
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
                                    <Link to={link.path}>
                                        <img
                                            src={link.img.web}
                                            alt="Dashboard icon"
                                        />
                                        <p>{link.title}</p>
                                    </Link>
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
                                    <Link to={link.path}>
                                        <img
                                            src={link.img.mobile}
                                            alt="Dashboard icon"
                                        />
                                        <p>{link.title}</p>
                                    </Link>
                                </li>
                            );
                        })}
                </ul>
            </section>
        </>
    );
};

export default DashboardSidebar;
