import styles from "../Applications.module.css";
import { HiOutlineBuildingOffice2 } from "react-icons/hi2";
import { BsPlusLg } from "react-icons/bs";
import { CiLocationOn } from "react-icons/ci";
import ApplicationsListHeader from "./ApplicationsListHeader";
import { Link } from "react-router-dom";
const ApplicationCard = ({ application }) => {
    return (
        <div className={styles.applications_card}>
            <div className={styles.applications_card_title}>
                <span>{application.jobTitle}</span>
                <span>{application.date}</span>
            </div>
            <div className={styles.applications_card_lo}>
                <HiOutlineBuildingOffice2 />
                {application.company}
            </div>
            <div className={styles.applications_card_lo}>
                <CiLocationOn />
                {application.location}
            </div>
            <div className={styles.applications_card_tag_wrapper}>
                <div>
                    <span className={styles.applications_card_tag}>
                        {application.jobDuration}
                    </span>
                    <span className={styles.applications_card_tag}>
                        {application.jobType}
                    </span>
                </div>
                <span>{application.salaryRange}</span>
            </div>
        </div>
    );
};
const ApplicationsListCard = ({ applications }) => {
    return (
        <div className={styles.applications_list_wrapper}>
            <ApplicationsListHeader />
            <div className={styles.applications_list_card}>
                {applications.map((application, index) => (
                    <ApplicationCard
                        key={`${application.company}-${index}`}
                        application={application}
                    />
                ))}
            </div>
            <button className={styles.applications_sort}>
                <Link to="/dashboard/user/create-profile"><BsPlusLg /></Link>
            </button>
        </div>
    );
};

export default ApplicationsListCard;
