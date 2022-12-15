import React from "react";
import { HiOutlineBuildingOffice2 } from "react-icons/hi2";
import { AiOutlineClockCircle } from "react-icons/ai";
import { CiLocationOn } from "react-icons/ci";
// import TopNav from "../applications/components/topNav/TopNav";
import styles from "./JobDecription.module.css";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";

const job = {
    jobTitle: "UX Researcher",
    company: "Cuberto",
    location: "New York",
    salaryRange: "$1000 - $3000/month",
    date: "10 November, 2021",
    jobSummary: `At Cuberto, we are building the future with the latest and greatest technology ever made. Equipped with the newest tools and best-known practices, we provide end-to-end software solutions to businesses to elevate their place in the rapidly-changing world.

In order to strengthen our forces, we are looking for a UX/UI Designer.`,
    reponsibilities: [
        ` Gather and evaluate user requirements in collaboration with product managers and engineers`,
        `Illustrate design ideas using storyboards, user journeys, process flows, and sitemaps`,
        `Design graphic user interface elements, like menus, tabs, and widgets`,
        `Develop UI mockups and prototypes that clearly illustrate how sites function and look like`,
        `Create original graphic designs (e.g. images, sketches, and tables)`,
        `Prepare and present rough drafts to internal teams and key stakeholders`,
        `Identify and troubleshoot UX problems (e.g. responsiveness)`,
        `Conduct layout adjustments based on user feedback`
    ],
    skills: [
        `4+ Year proven work experience as a UX/UI Designer or similar role`,
        `Portfolio of design projects`,
        `Good time-management skills`,
        `Knowledge of wireframe tools(Adobe XD, Balsamiq, Paper wireframing)`
    ]
};

const JobDescription = () => {
    return (
        <div
            style={{
                width: "100%"
            }}
        >
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
                    <h4>{job.jobTitle}</h4>
                    <div className={styles.job_header_wrapper}>
                        <span className={styles.job_header_icons}>
                            <HiOutlineBuildingOffice2 />
                            {job.company}
                        </span>
                        <span className={styles.job_header_icons}>
                            <CiLocationOn />
                            {job.location}
                        </span>
                        <span className={styles.job_header_icons}>
                            <AiOutlineClockCircle />
                            {job.date}
                        </span>
                    </div>
                    <div className={styles.job_header_salary}>
                        {job.salaryRange}
                    </div>
                </div>
                <div className={styles.job_details}>
                    <div>
                        <h5>Job Summary</h5>
                        <p>{job.jobSummary}</p>
                    </div>
                    <div>
                        <h5>Responsibilities</h5>
                        <ul>
                            {job.reponsibilities.map(responsibility => (
                                <li key={responsibility}>{responsibility}</li>
                            ))}
                        </ul>
                    </div>
                    <div>
                        <h5>Skills and Experience</h5>
                        <ul>
                            {job.skills.map(skill => (
                                <li key={skill}>{skill}</li>
                            ))}
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default JobDescription;
