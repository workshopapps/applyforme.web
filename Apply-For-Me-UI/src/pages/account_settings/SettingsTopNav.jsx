import React from "react";
import classes from "./AccountSettings.module.css";
import person from "../../pages/dashboard_profile/assets/profilepic.png";
import bell from "../../pages/dashboard_profile/assets/notif.png";

const SettingsTopNav = () => {
    return (
        <div className={classes.top_nav}>
            <div className={classes.nav_content}>
                <h2>Account Settings</h2>

                <div>
                    <div className={classes.nav_image}>
                        <img src={bell} alt="" className={classes.bell} />
                        <img src={person} alt="" className={classes.person} />
                    </div>
                </div>
            </div>
        </div>
    );
};

export default SettingsTopNav;
