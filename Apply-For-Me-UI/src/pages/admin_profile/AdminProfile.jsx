import React from "react";
import notif from "../../assets/images/notifications_icon.png";
import calendar from "../../assets/images/calendar_month.png";
import BlueButton from "../../components/buttons/blue_background/BlueButton";
import BlueBorderButton from "../../components/buttons/blue_border_button/BlueBorderButton";
import classes from "./AdminProfile.module.css";


const AdminProfile = () => {
    return <div className={classes.profile_container} >
        <div className={classes.profile_header}>
            <h1>Profile</h1>
            <div className={classes.profile_notif}>
                <img src={notif} alt="profile image" />
                <img src={calendar} alt="calendar" />
            </div>
        </div>

        <div className={classes.profile_body}>
            <img src="https://source.unsplash.com/mEZ3PoFGs_k" alt="profile image" />
            <hr />
            <div className={classes.profile_info}>
                <div className={classes.profile_info_item}>
                    <p className={classes.item_title}>Username:</p>
                    <p className={classes.item_detail}>Regina505</p>
                </div>

                <div className={classes.profile_info_item}>
                    <p className={classes.item_title}>Name:</p>
                    <p className={classes.item_detail}>Regina Griffin</p>
                </div>

                <div className={classes.profile_info_item}>
                    <p className={classes.item_title}>Email:</p>
                    <p className={classes.item_detail}>reginagriffin505@gmail.com</p>
                </div>

                <div className={classes.profile_info_item}>
                    <p className={classes.item_title}>Phone Number:</p>
                    <p className={classes.item_detail}>+2348012345678</p>
                </div>

                <div className={classes.profile_info_item}>
                    <p className={classes.item_title}>Gender:</p>
                    <p className={classes.item_detail}>Female</p>
                </div>
            </div>
            <hr />

            <div className={classes.profile_footer}>
                <div className={classes.profile_footer_item}>
                    <BlueButton text="Edit Profile" width="144" />
                    <BlueBorderButton text="Change Password" width="194" />
                </div>
            </div>
        </div>

    </div>;
};

export default AdminProfile;
