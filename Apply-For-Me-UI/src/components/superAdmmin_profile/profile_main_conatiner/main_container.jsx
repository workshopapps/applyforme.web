import { useState, useEffect } from "react";
import { PasswordContent } from "../../modals/editpersonalinfo/editPassword/editPassword";
import { EditInfoContent } from "../../modals/editpersonalinfo/editProfileInformation/editProfileInformation";
import "./main_container.css";
import { useNavigate } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { getSuperAdminProfileInfo } from "store/slice/RR_AdminSlice";
import LetteredAvatar from "react-lettered-avatar";

export const MainContainer = () => {
    const personalDetails = useSelector(state => state.RRadmin);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(getSuperAdminProfileInfo());
    }, [dispatch]);
    const { superAdminProfileDetails } = personalDetails;
    console.log(superAdminProfileDetails);
    const [showEditModal, setEditModal] = useState(false);
    const [showPasswordModal, setPasswordModal] = useState(false);
    const navigate = useNavigate();

    return (
        <>
            <div className="ProfileMainContainer">
                <div
                    onClick={() => navigate("/user-page")}
                    className="button-type"
                >
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669298685/Frame_51450_hkzsj8.png"
                        alt="object not found"
                    />
                </div>
                <div className="profile_header">
                    <h1>Profile</h1>
                    <button
                        className="profile_content_btn"
                        onClick={() => setEditModal(prevState => !prevState)}
                    >
                        <img
                            src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/pencil-edit_g9boq4.png"
                            alt="object not found"
                        />
                        <h4>Edit</h4>
                    </button>
                </div>
                <div className="proileInfoContainer">
                    <div className="mobile_info_top_view">
                        <div className="mobile_img_top">
                            {/* <img
                                style={{ width: "100%" }}
                                src={img}
                                alt="object not found"
                            /> */}
                            <LetteredAvatar
                                name={superAdminProfileDetails?.firstName}
                                backgroundColor={"#78909c"}
                                size="100"
                                radius="10"
                            />
                        </div>
                        <div className="mobile_info_top">
                            <div className="proileInfo">
                                <h4 className="proileInfolabel">Name</h4>
                                <h4 className="proileInfovalue">
                                    {superAdminProfileDetails &&
                                        superAdminProfileDetails.firstName}{" "}
                                    {superAdminProfileDetails &&
                                        superAdminProfileDetails.lastName}
                                </h4>
                            </div>
                            <div className="proileInfo">
                                <h4 className="proileInfolabel">
                                    Email Address
                                </h4>
                                <h4 className="proileInfovalue">
                                    {" "}
                                    {superAdminProfileDetails &&
                                        superAdminProfileDetails.emailAddress}
                                </h4>
                            </div>
                        </div>
                    </div>
                    <div className="desktop_info_top">
                        <div className="proileInfo">
                            <h4 className="proileInfolabel">Name</h4>
                            <h4 className="proileInfovalue">
                                {superAdminProfileDetails &&
                                    superAdminProfileDetails.firstName}{" "}
                                {superAdminProfileDetails &&
                                    superAdminProfileDetails.lastName}
                            </h4>
                        </div>
                        <div className="proileInfo">
                            <h4 className="proileInfolabel">Email Address</h4>
                            <h4 className="proileInfovalue">
                                {" "}
                                {superAdminProfileDetails &&
                                    superAdminProfileDetails.emailAddress}
                            </h4>
                        </div>
                    </div>

                    <div className="proileInfo">
                        <h4 className="proileInfolabel">Phone Number</h4>
                        <h4 className="proileInfovalue">
                            {superAdminProfileDetails &&
                                superAdminProfileDetails.phoneNumber}
                        </h4>
                    </div>
                    <div className="proileInfo">
                        <h4 className="proileInfolabel">City</h4>
                        <h4 className="proileInfovalue">
                            {superAdminProfileDetails &&
                                superAdminProfileDetails.city}
                        </h4>
                    </div>
                    <div className="proileInfo">
                        <h4 className="proileInfolabel">State</h4>
                        <h4 className="proileInfovalue">
                            {superAdminProfileDetails &&
                                superAdminProfileDetails.state}
                        </h4>
                    </div>
                    <div className="proileInfo">
                        <h4 className="proileInfolabel">Dob</h4>
                        <h4 className="proileInfovalue">
                            {superAdminProfileDetails &&
                                superAdminProfileDetails.dateOfBirth}
                        </h4>
                    </div>
                </div>
                <div className="changePassword" style={{ marginTop: "0.5rem" }}>
                    <h1>Password</h1>
                    <button
                        className="profile_content_btn"
                        onClick={() =>
                            setPasswordModal(prevState => !prevState)
                        }
                    >
                        <img
                            src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/pencil-edit_g9boq4.png"
                            alt="object not found"
                        />
                        <h4>Change</h4>
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
                            superAdminProfileDetails={superAdminProfileDetails}
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
        </>
    );
};
