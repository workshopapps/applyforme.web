/* eslint-disable react/jsx-pascal-case */
import { useNavigate } from "react-router";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";
import ProfilePic from "../../assets/images/clearProfilePic.svg";
import BlueButton from "components/buttons/blue_background/BlueButton";
import rrpCss from "./rrp.module.css";

const RRProfile = () => {
    const navigate = useNavigate();
    return (
        <div className={rrpCss.page}>
            <RRD_Nav />
            <div className={rrpCss.back_button}>
                <button type="submit" onClick={() => navigate("")}>
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
                <div className={`${rrpCss.details} ${rrpCss.left}`}>
                    <p>UserName:</p>
                    <p>Name:</p>
                    <p>Email:</p>
                    <p>Phone number:</p>
                    <p>Gender</p>
                </div>
                <div className={`${rrpCss.details} ${rrpCss.right}`}>
                    <p>Regina505</p>
                    <p>Regina Griffin</p>
                    <p>ReginaGriffin505@gmail.com</p>
                    <p>+2348012345678</p>
                    <p>Female</p>
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
    );
};

export default RRProfile;
