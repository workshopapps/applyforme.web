/* eslint-disable react/jsx-pascal-case */
import LetteredAvatar from "react-lettered-avatar";
import BlueButton from "components/buttons/blue_background/BlueButton";
import rrpCss from "./rrp.module.css";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";
import { useEffect, useState } from "react";
import { PasswordContent } from "components/modals/editpersonalinfo/editPassword/rr_editpassword";
import { EditInfoContent } from "components/modals/editpersonalinfo/editProfileInformation/rr_editProfile";
import { useSelector } from "react-redux";
import axios from "axios";
import { useCallback } from "react";

const RRProfile = () => {
    const url = "https://api.applyforme.hng.tech";
    const token = localStorage.getItem("tokenHngKey");
    const { user } = useSelector(state => state.user);
    const userName = user.fullName;
    const [details, setDetails] = useState();
    const getRecruiterProfile = useCallback(async () => {
        try {
            const response = await axios.get(
                `${url}/api/v1/recruiter/details`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log(response?.data);
            setDetails(response?.data);
            return response?.data;
        } catch (error) {
            return error.response?.data;
        }
    }, [token]);
    useEffect(() => {
        getRecruiterProfile();
    }, [getRecruiterProfile]);

    const [showEditModal, setEditModal] = useState(false);
    const [showPasswordModal, setPasswordModal] = useState(false);
    return (
        <div className={rrpCss.page}>
            <div className={rrpCss.rr_profile_container}>
                <RRD_Nav />
                <div className={rrpCss.back_button}>
                    <button type="submit" onClick={() => window.history.back()}>
                        <span>&lt;</span>
                        <span>Profile Details</span>
                    </button>
                </div>
                <div className={rrpCss.topSection}>
                    <div className={rrpCss.Lwrapper}>
                        <LetteredAvatar
                            name={userName}
                            backgroundColor={"#78909c"}
                            size="100"
                        />
                    </div>
                    <div
                        className={rrpCss.btn}
                        onClick={() => setEditModal(prevState => !prevState)}
                    >
                        <BlueButton text={"Edit profile"} />
                    </div>
                </div>
                <div className={rrpCss.infoSection}>
                    <div className={rrpCss.info_container}>
                        <div className={rrpCss.isubinfo_container}>
                            <p>UserName:</p>
                            <p>{details?.username}</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Name:</p>
                            <p>
                                {details?.firstName} {details?.lastName}
                            </p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Email:</p>
                            <p>{details?.emailAddress}</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Date Of Birth:</p>
                            <p>{details?.dateOfBirth}</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Phone number:</p>
                            <p>{details?.phoneNumber}</p>
                        </div>
                        <div className={rrpCss.isubinfo_container}>
                            <p>Gender</p>
                            <p>{details?.emailAddress}</p>
                        </div>
                    </div>
                </div>
                <div className={rrpCss.bottomSection}>
                    <div
                        className={rrpCss.btn_bottom}
                        onClick={() => setEditModal(prevState => !prevState)}
                    >
                        <BlueButton text={"Edit profile"} />
                    </div>
                    <button
                        className={rrpCss.change_password}
                        onClick={() =>
                            setPasswordModal(prevState => !prevState)
                        }
                    >
                        Change Password
                    </button>
                </div>
            </div>
            {showEditModal && (
                <div className="editContainer">
                    <div className="editProfileContent">
                        <div
                            className="modal_closal"
                            style={{ marginBottom: "2rem" }}
                        >
                            <img
                                src="https://res.cloudinary.com/hamskid/image/upload/v1669067698/Vector_rc9avy.png"
                                alt="object not found"
                                onClick={() =>
                                    setEditModal(prevState => !prevState)
                                }
                            />
                        </div>
                        <EditInfoContent
                            setEditModal={setEditModal}
                            details={details}
                        />
                    </div>
                </div>
            )}
            {showPasswordModal && (
                <div className="editContainer">
                    <div className="editpasswordContent">
                        <div
                            className="modal_closal"
                            style={{ marginBottom: "2rem" }}
                        >
                            <img
                                src="https://res.cloudinary.com/hamskid/image/upload/v1669067698/Vector_rc9avy.png"
                                alt="object not found"
                                onClick={() =>
                                    setPasswordModal(prevState => !prevState)
                                }
                            />
                        </div>
                        <PasswordContent />
                    </div>
                </div>
            )}
        </div>
    );
};

export default RRProfile;
