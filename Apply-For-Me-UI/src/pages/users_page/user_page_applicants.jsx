import axios from "axios";
import "./user_page_applicants.css";
import { useCallback, useState } from "react";
import { useEffect } from "react";
import { useParams } from "react-router-dom";

export const SuperApplicantsPage = () => {
    const token = localStorage.getItem("tokenHngKey");
    const { id } = useParams();
    const [applicants, setApplicants] = useState();

    const getApplicantsInfo = useCallback(async e => {
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/super-admin/applicant/detail/${id}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setApplicants(response?.data);
        } catch (error) {
            console.log(error.response?.data);
        }
    },[id, token]);

    useEffect(() => {
        getApplicantsInfo();
    }, [getApplicantsInfo]);

    return (
        <div className="applicants_profile_container">
            <div>
                <span>
                    <img
                        className="nav_back"
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669298685/Frame_51450_hkzsj8.png"
                        alt="object not found"
                        onClick={() => window.history.back()}
                    />
                </span>
                <h3 className="profile_header">Applicants Details</h3>
            </div>
            <div className="proile_info_container">
                <p className="profile-text-size">
                    <span className="proile_info_container_label">Name:</span>{" "}
                    {applicants?.membership?.firstName}{" "}
                    {applicants?.membership?.lastName}
                </p>
                <p className="profile-text-size">
                    <span className="proile_info_container_label">Email:</span>{" "}
                    {applicants?.membership?.emailAddress}
                </p>
                <p className="profile-text-size">
                    <span className="proile_info_container_label">
                        Address:
                    </span>{" "}
                    {applicants?.membership?.address}
                </p>
                <p className="profile-text-size">
                    <span className="proile_info_container_label">
                        Date of Birth:
                    </span>{" "}
                    {applicants?.membership?.dateOfBirth}
                </p>
                <p className="profile-text-size">
                    <span className="proile_info_container_label">
                        Phone Number:
                    </span>{" "}
                    {applicants?.membership?.phoneNumber}
                </p>
            </div>
            <div className="proile_info_container">
                <p className="profile-text-size"><span className="proile_info_container_label">Country:</span> {applicants?.membership?.countryOfResidence?.title}</p>
                <p className="profile-text-size"><span className="proile_info_container_label">City:</span>  {applicants?.membership?.city}</p>
                <p className="profile-text-size"><span className="proile_info_container_label">Nationality:</span> {applicants?.membership?.nationality?.title}</p>
                <p className="profile-text-size"><span className="proile_info_container_label">State:</span> {applicants?.membership?.state}</p>
                <p className="profile-text-size"><span className="proile_info_container_label">Total Profile Applications:</span> {applicants?.totalProfessionalProfile}</p>
                <p className="profile-text-size"><span className="proile_info_container_label">Total Profile Submissions:</span> {applicants?.totalSubmissions}</p>

            </div>
        </div>
    );
};
