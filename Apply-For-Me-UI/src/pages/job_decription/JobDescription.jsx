import React, { useState } from "react";
import { HiOutlineBuildingOffice2 } from "react-icons/hi2";
import { AiOutlineClockCircle } from "react-icons/ai";
import { CiLocationOn } from "react-icons/ci";
// import TopNav from "../applications/components/topNav/TopNav";
import styles from "./JobDecription.module.css";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";
import { useParams } from "react-router-dom";
import { useEffect } from "react";
import axios from "axios";
import { toast } from "react-toastify";
import { useCallback } from "react";

const JobDescription = () => {
    const { jobId } = useParams();
    const [descriptionDetails, setDescriptionDetails] = useState();
    const token = localStorage.getItem("tokenHngKey");
    const getJobDescriptions = useCallback(async () => {
        try {
           
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/job-submission/user/detail/${jobId}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setDescriptionDetails(response?.data);
        } catch (error) {
            toast.error(`Could not get description: ${error}`);
        }
    },[jobId, token]);

    useEffect(() => {
        getJobDescriptions();
    }, [ getJobDescriptions]);

    return (
        <div className={styles.jobContainer}>
            <TopBar
                title={"Job Description"}
                style={{
                    marginTop: "auto",
                    color: "#2e3192",
                    fontWeight: "500",
                    // marginLeft: "12rem",
                    width: "100%"
                }}
            />
            <div className={styles.application_main}>
                <div className={styles.job_header}>
                    <h4>{descriptionDetails?.jobTitle}</h4>
                    <div className={styles.job_header_wrapper}>
                        <span className={styles.job_header_icons}>
                            <HiOutlineBuildingOffice2 />
                            {descriptionDetails?.jobCompany}
                        </span>
                        <span className={styles?.job_header_icons}>
                            <CiLocationOn />
                            {descriptionDetails?.jobLocation}
                        </span>
                        <span className={styles.job_header_icons}>
                            <AiOutlineClockCircle />
                            {descriptionDetails?.createdOn?.split("T").shift()}
                        </span>
                    </div>
                    <div className={styles.job_header_salary}>
                        {descriptionDetails?.salaryRange}
                    </div>
                </div>
                <div className={styles.job_details}>
                    <div>
                        <h5>Salary Range</h5>
                        <p>{descriptionDetails?.professionalProfile?.salaryRange}</p>
                    </div>
                    <div>
                        <h5>Job Summary</h5>
                        <p>{descriptionDetails?.summary}</p>
                    </div>
                    <div>
                        <h5>Job Link</h5>
                        <p>
                            {descriptionDetails?.jobLink}
                        </p>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default JobDescription;
