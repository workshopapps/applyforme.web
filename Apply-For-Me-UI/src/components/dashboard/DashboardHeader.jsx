import React, { useState } from "react";
import classes from "./DashboardHeader.module.css";
import Logo from "../../assets/images/nav_logo.svg";
import Notification from "../../assets/images/notification.svg";
import ProfilePic from "../../assets/images/test_profile_picture.svg";
import Search from "../../assets/images/search.svg";
import SearchBlue from "../../assets/images/search_blue.svg";
import Menu from "../../assets/images/menu.svg";
import CloseMenu from "../../assets/images/close_menu.svg";
import DashboardActiveIcon from "../../assets/images/dashboard_active_logo.svg";
import DashboardDisabledIcon from "../../assets/images/dashboard_disabled_logo.svg";
import UserDisabledIcon from "../../assets/images/users_disabled_logo.svg";
import UserActiveIcon from "../../assets/images/users_active_logo.svg";
import NotificationDark from "../../assets/images/notification_dark.svg";
import Signout from "../../assets/images/signout.svg";
import Help from "../../assets/images/help_outline.svg";
import { getActiveLink } from "./service/DashboardSidebarService";

const DashboardHeader = ({ func }) => {
    const [dashboardActive, setDashboardActive] = useState({
        dashboard: false,
        user: true
    });

    const [showMenu, setShowMenu] = useState(false);

    const handleActive = data => {
        setDashboardActive(getActiveLink(data));
    };
    const handleSubmit = event => {
        event.preventDefault();
    };
    return (
        <section className={classes.main_container}>
            <section className={classes.header}>
                {/* Desktop View Menu & Tablet  */}
                <nav className={classes.desktop_menu}>
                    <div className={classes.logo_container}>
                        {!showMenu && (
                            <img
                                src={Menu}
                                alt="Notification logo"
                                className={classes.menu}
                                onClick={() => setShowMenu(true)}
                            />
                        )}
                        <img src={Logo} alt="Apply for me logo" />
                    </div>

                    <section className={classes.swap_nav}>
                        <div className={classes.notification_user}>
                            <div className={classes.notice_logo}>
                                <img
                                    src={Notification}
                                    alt="Notification logo"
                                />
                            </div>
                            <div className={classes.search_logo}>
                                <img src={SearchBlue} alt="Search " />
                            </div>
                            <div className={classes.user_avater}>
                                <img
                                    src={ProfilePic}
                                    alt="User Profile Picture"
                                />
                            </div>
                        </div>

                        <form
                            className={classes.search}
                            onSubmit={e => handleSubmit(e)}
                        >
                            <input
                                type="search"
                                name="search"
                                placeholder="Search for Users and Reverse Recruiter"
                            />
                            <button type="submit">
                                {" "}
                                <img src={Search} alt="Apply for me logo" />
                            </button>
                        </form>
                    </section>
                </nav>

                {/* Mobile nav */}
                {showMenu && (
                    <section
                        className={classes.mobile_menu_wrapper}
                        onClick={() => setShowMenu(false)}
                    >
                        <nav className={classes.mobile_menu}>
                            <section
                                className={[
                                    classes.mobile_section,
                                    classes.pads
                                ].join(" ")}
                            >
                                <div className={classes.close_menu}>
                                    <p>Menu</p>
                                    <img
                                        src={CloseMenu}
                                        alt="Close Menu logo"
                                        className={classes.menu}
                                        onClick={() => setShowMenu(false)}
                                    />
                                </div>
                            </section>

                            <section
                                className={[
                                    classes.mobile_section,
                                    classes.pads
                                ].join(" ")}
                            >
                                <div className={classes.notification}>
                                    <img
                                        src={NotificationDark}
                                        alt="Notification logo"
                                    />
                                    <p>Notifications</p>
                                </div>
                            </section>

                            <ul className={[classes.pads].join(" ")}>
                                <li onClick={() => setShowMenu(false)}>
                                    <img src={Help} alt="Help Icon" />
                                    Help
                                </li>

                                <li onClick={() => setShowMenu(false)}>
                                    <img src={Signout} alt="Help Icon" />
                                    <p>Sign Out</p>
                                </li>
                            </ul>
                        </nav>
                    </section>
                )}
            </section>

            <section className={classes.toggle_user}>
                <ul>
                    <li
                        onClick={() => {
                            handleActive("dashboard");
                            func("dashboardPage");
                        }}
                    >
                        {dashboardActive.dashboard ? (
                            <img
                                src={DashboardActiveIcon}
                                alt="Dashboard logo"
                            />
                        ) : (
                            <img
                                src={DashboardDisabledIcon}
                                alt="Dashboard logo"
                            />
                        )}
                        <p
                            className={
                                dashboardActive.dashboard
                                    ? classes.__active_toggle
                                    : ""
                            }
                        >
                            Dashboard
                        </p>
                    </li>

                    <li
                        onClick={() => {
                            handleActive("user");
                            func("userPage");
                        }}
                    >
                        {dashboardActive.user ? (
                            <img
                                src={UserActiveIcon}
                                alt="Disabled User logo"
                            />
                        ) : (
                            <img
                                src={UserDisabledIcon}
                                alt="Disabled User logo"
                            />
                        )}
                        <p
                            className={
                                dashboardActive.user
                                    ? classes.__active_toggle
                                    : ""
                            }
                        >
                            User
                        </p>
                    </li>
                </ul>
            </section>
        </section>
    );
};

export default DashboardHeader;
