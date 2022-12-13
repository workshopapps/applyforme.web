/* eslint-disable react/jsx-pascal-case */
import { useNavigate } from "react-router";
import ProfilePic from "../../assets/images/clearProfilePic.svg";
import BlueButton from "components/buttons/blue_background/BlueButton";
import rrpCss from "./rrp.module.css";
import { NotificationHead } from "components/superAdmmin_profile/profile_page_notification/notification_head";

const RRProfile = () => {
    const navigate = useNavigate();
    return (
        <div className={rrpCss.page}>
            <NotificationHead notificationCount="0"/>
            <div className={rrpCss.rr_profile_container}>
                <div className={rrpCss.back_button}>
                    <button type="submit" onClick={()=>window.history.back()}>
                        <span>&lt;</span>
                        <span>Profile Details</span>
                    </button>
                </div>
                <div className={rrpCss.topSection}>
                    <img
                        className={rrpCss.ProfilePic}
                        src={ProfilePic}
                        alt="User Profile"
                    />
                    <div className={rrpCss.btn}>
                        <BlueButton text={"Edit profile"} />
                    </div>
                </div>
                <div className={rrpCss.infoSection}>
                    <div className={rrpCss.info_container}>
                        <div className={rrpCss.isubinfo_container}>
                            <p>UserName:</p>
                            <p>Regina505</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Name:</p>
                            <p>Regina Griffin</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>UserName:</p>
                            <p>Regina505</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Email:</p>
                            <p>ReginaGriffin505@gmail.com</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Phone number:</p>
                            <p>+2348012345678</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Gender</p>
                            <p>Female</p>
                        </div>
                     </div>
                </div>
                <div className={rrpCss.bottomSection}>
                    <div className={rrpCss.btn_bottom}>
                        <BlueButton text={"Edit profile"} />
                    </div>
                    <button className={rrpCss.change_password}>
                        Change Password
                    </button>
                </div>
                
            </div>
            
        </div>
    );
};

export default RRProfile;
