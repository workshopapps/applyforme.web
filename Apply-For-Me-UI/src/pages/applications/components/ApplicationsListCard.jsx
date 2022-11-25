import styles from "../Applications.module.css";
import { HiOutlineBuildingOffice2 } from "react-icons/hi2";
import { CiLocationOn } from "react-icons/ci";
import { useNavigate } from "react-router-dom";
import { renderDate } from "../utils";

const ApplicationCard = ({ application, onClick }) => {
    return (
        <div className={styles.applications_card} onClick={onClick}>
            <div className={styles.applications_card_title}>
                <span>{application.jobTitle}</span>
                <span>{renderDate(application.date)}</span>
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
    const navigate = useNavigate();

    return (
        <div className={styles.applications_list_wrapper}>
            <div className={styles.applications_list_card}>
                {applications.map((application, index) => (
                    <ApplicationCard
                        key={`${application.company}-${index}`}
                        application={application}
                        onClick={() =>
                            navigate(
                                `/dashboard/applications/${application.id}`
                            )
                        }
                    />
                ))}
            </div>
        </div>
    );
};

export default ApplicationsListCard;
