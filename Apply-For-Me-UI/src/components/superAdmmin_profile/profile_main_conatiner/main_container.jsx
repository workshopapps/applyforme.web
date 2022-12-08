import { useState,useEffect } from "react";
import { PasswordContent } from "../../modals/editpersonalinfo/editPassword/editPassword";
import { EditInfoContent } from "../../modals/editpersonalinfo/editProfileInformation/editProfileInformation";
import "./main_container.css";
import { useNavigate } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { getSuperAdminProfileInfo } from "store/slice/RR_AdminSlice";

export const MainContainer = ({ img }) => {
    const personalDetails = useSelector((state)=>state.RRadmin);
    const dispatch = useDispatch();
    useEffect(()=>{
        dispatch(getSuperAdminProfileInfo());
    })
    const {superAdminProfileDetails} = personalDetails;
    console.log(superAdminProfileDetails)
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
                            <img
                                style={{ width: "100%" }}
                                src={img}
                                alt="object not found"
                            />
                        </div>
                        <div className="mobile_info_top">
                            <div className="proileInfo">
                                <h2 className="proileInfolabel">Name</h2>
                                <h2 className="proileInfovalue">
                                    {superAdminProfileDetails && superAdminProfileDetails.firstName} {superAdminProfileDetails && superAdminProfileDetails.lastName}
                                </h2>
                            </div>
                            <div className="proileInfo">
                                <h2 className="proileInfolabel">
                                    Email Address
                                </h2>
                                <h2 className="proileInfovalue">
                                    {" "}
                                    {superAdminProfileDetails && superAdminProfileDetails.emailAddress}
                                </h2>
                            </div>
                        </div>
                    </div>
                    <div className="desktop_info_top">
                        <div className="proileInfo">
                            <h2 className="proileInfolabel">Name</h2>
                            <h2 className="proileInfovalue">
                                {superAdminProfileDetails && superAdminProfileDetails.firstName} {superAdminProfileDetails && superAdminProfileDetails.lastName}
                            </h2>
                        </div>
                        <div className="proileInfo">
                            <h2 className="proileInfolabel">Email Address</h2>
                            <h2 className="proileInfovalue">
                                {" "}
                                {superAdminProfileDetails && superAdminProfileDetails.emailAddress}
                            </h2>
                        </div>
                    </div>

                    <div className="proileInfo">
                        <h2 className="proileInfolabel">Phone Number</h2>
                        <h2 className="proileInfovalue">
                        {superAdminProfileDetails && superAdminProfileDetails.phoneNumber}
                        </h2>
                    </div>
                    <div className="proileInfo">
                        <h2 className="proileInfolabel">Address</h2>
                        <h2 className="proileInfovalue">{superAdminProfileDetails && superAdminProfileDetails.city}</h2>
                    </div>
                    <div className="proileInfo">
                        <h2 className="proileInfolabel">Dob</h2>
                        <h2 className="proileInfovalue">{superAdminProfileDetails && superAdminProfileDetails.dateOfBirth}</h2>
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
                    <div
                        className="editProfileContent"
                        style={{ width: "fitContent" }}
                    >
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
                        <EditInfoContent />
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
