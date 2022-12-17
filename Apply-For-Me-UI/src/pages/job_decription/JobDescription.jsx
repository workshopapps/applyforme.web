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

// const job = {
//     jobTitle: "UX Researcher",
//     company: "Cuberto",
//     location: "New York",
//     salaryRange: "$1000 - $3000/month",
//     date: "10 November, 2021",
//     jobSummary: `At Cuberto, we are building the future with the latest and greatest technology ever made. Equipped with the newest tools and best-known practices, we provide end-to-end software solutions to businesses to elevate their place in the rapidly-changing world.

// In order to strengthen our forces, we are looking for a UX/UI Designer.`,
//     reponsibilities: [
//         ` Gather and evaluate user requirements in collaboration with product managers and engineers`,
//         `Illustrate design ideas using storyboards, user journeys, process flows, and sitemaps`,
//         `Design graphic user interface elements, like menus, tabs, and widgets`,
//         `Develop UI mockups and prototypes that clearly illustrate how sites function and look like`,
//         `Create original graphic designs (e.g. images, sketches, and tables)`,
//         `Prepare and present rough drafts to internal teams and key stakeholders`,
//         `Identify and troubleshoot UX problems (e.g. responsiveness)`,
//         `Conduct layout adjustments based on user feedback`
//     ],
//     skills: [
//         `4+ Year proven work experience as a UX/UI Designer or similar role`,
//         `Portfolio of design projects`,
//         `Good time-management skills`,
//         `Knowledge of wireframe tools(Adobe XD, Balsamiq, Paper wireframing)`
//     ]
// };

const JobDescription = () => {
    const { jobId } = useParams();
    const [descriptionDetails, setDescriptionDetails] = useState();
    console.log(jobId);
    const getJobDescriptions = async () => {
        try {
            const token = localStorage.getItem("tokenHngKey");
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/job-submission/user/detail/${jobId}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log("job description", response.data);
            setDescriptionDetails(response?.data);
        } catch (error) {
            toast.error(`Could not get description: ${error}`);
        }
    };

    useEffect(() => {
        getJobDescriptions();
    }, []);

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
                        <h5>Job Summary</h5>
                        <p>{descriptionDetails?.summary}</p>
                    </div>
                    <div>
                        <h5>Job Link</h5>
                        <p>
                            {descriptionDetails?.jobLink}
                        </p>
                    </div>
                    {/* <div>
                        <h5>Skills and Experience</h5>
                        <p>{descriptionDetails?.professionalProfile}</p>
                    </div> */}
                </div>
            </div>
        </div>
    );
};

export default JobDescription;
