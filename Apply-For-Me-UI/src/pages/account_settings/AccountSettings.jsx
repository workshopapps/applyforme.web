import React, { useState } from "react";
import classes from "./AccountSettings.module.css";
import SettingsTopNav from "./SettingsTopNav";
import person from "../../assets/images/Friendly Ones Avatar.png";
import DashboardSidebar from "../../components/dashboard_sidebar/DashboardSidebar";
//import { getActiveLink } from './settingservice/SettingsSecondSidebar'

const AccountSettings = () => {
    const [activeLink, setActiveLink] = useState({
        profile: true,
        password: false,
        preference: false
    });

    const handleAciveLink = e => {
        e.preventDefault();
        let profile = false;
        let password = false;
        let preference = false;
        let profile_div = "none";
        let password_div = "none";
        let preference_div = "none";
        let id = e.target.getAttribute("id");
        console.log(id);
        if (id == "profile_btn") {
            profile = true;
            profile_div = "block";
        } else if (id == "password_btn") {
            password = true;
            password_div = "block";
        } else if (id == "preference_btn") {
            preference = true;
            preference_div = "block";
        } else {
            profile = true;
            profile_div = "block";
        }

        setActiveLink({ profile, password, preference });
        document.getElementById("profile_div").style.display = profile_div;
        document.getElementById("password_div").style.display = password_div;
        document.getElementById("preference_div").style.display =
            preference_div;
    };

    return (
        <div className={classes.account_settings_container}>
            <div className={classes.sidebar_container}>
                <DashboardSidebar />
            </div>

            <div className={classes.body_container}>
                <SettingsTopNav />

                <div className={classes.body_content}>
                    <div className={classes.second_sidenav}>
                        <ul>
                            <li
                                id="profile_btn"
                                className={
                                    activeLink.profile ? classes.active : ""
                                }
                                onClick={handleAciveLink}
                            >
                                Profile
                            </li>
                            <li
                                id="password_btn"
                                onClick={handleAciveLink}
                                className={
                                    activeLink.password ? classes.active : ""
                                }
                            >
                                Password
                            </li>
                            <li>Membership Status</li>

                            <li
                                onClick={handleAciveLink}
                                id="preference_btn"
                                className={
                                    activeLink.preference ? classes.active : ""
                                }
                            >
                                Account Preference
                            </li>
                        </ul>
                    </div>

                    <form className={classes.form}>
                        <div id="profile_div" style={{ display: "block" }}>
                            <h3>Personal Information</h3>
                            <div className={classes.change_image}>
                                <div className={classes.image}>
                                    <img src={person} alt="" />
                                </div>

                                <span>
                                    <a href="#">Change Picture</a>
                                </span>
                            </div>

                            <div className={classes.input_fields}>
                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="name">First Name</label>
                                        <input
                                            type="text"
                                            name="name"
                                            id="name"
                                            placeholder="First Name"
                                        />
                                    </div>
                                    <div className={classes.form_control}>
                                        <label htmlFor="name">Last Name</label>
                                        <input
                                            type="text"
                                            name="name"
                                            id="name"
                                            placeholder="Last Name"
                                        />
                                    </div>
                                </div>

                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="email">Email</label>
                                        <input
                                            type="email"
                                            name="email"
                                            id="email"
                                            placeholder="Email Address"
                                        />
                                    </div>
                                </div>

                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="number">
                                            Contact Number
                                        </label>
                                        <input
                                            type="text"
                                            name="number"
                                            id="number"
                                            placeholder="+234-567-890-00"
                                        />
                                    </div>
                                </div>

                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="address">Address</label>
                                        <input
                                            type="text"
                                            name="address"
                                            id="address"
                                            placeholder="36, Amen Estate"
                                        />
                                    </div>
                                </div>

                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="city">City</label>
                                        <input
                                            type="text"
                                            name="city"
                                            id="city"
                                            placeholder="Ikeja"
                                        />
                                    </div>
                                    <div className={classes.form_control}>
                                        <label htmlFor="state">State</label>
                                        <input
                                            type="text"
                                            name="state"
                                            id="state"
                                            placeholder="Lagos"
                                        />
                                    </div>
                                </div>

                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="country">Country</label>
                                        <input
                                            type="text"
                                            name="country"
                                            id="country"
                                            placeholder="Nigeria"
                                        />
                                    </div>
                                </div>

                                <div>
                                    <button>Save</button>
                                </div>
                            </div>
                        </div>

                        <div id="password_div" style={{ display: "none" }}>
                            <h3>Password page</h3>

                            <div className={classes.input_fields}>
                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="password">
                                            Old Password
                                        </label>
                                        <input type="password" />
                                    </div>
                                </div>
                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="password">
                                            New Password
                                        </label>
                                        <input type="password" />
                                    </div>
                                </div>
                                <div className={classes.row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="password">
                                            Confirm New Password
                                        </label>
                                        <input type="password" />
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div id="preference_div" style={{ display: "none" }}>
                            <div>
                                <h3>Notification</h3>
                                <p>
                                    Manage the kind of notification you get
                                    about your activities,interest and
                                    recommendations
                                </p>
                            </div>

                            <div></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default AccountSettings;
