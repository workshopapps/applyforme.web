import styles from "../Applications.module.css";

const ApplicationCard = application => {
    return <div>{application.company}</div>;
};
const ApplicationsListCard = ({ applications }) => {
    return (
        <div className={styles.applications_list_card}>
            {applications.map((application, index) => (
                <ApplicationCard
                    key={`${application.company}-${index}`}
                    application={application}
                />
            ))}
        </div>
    );
};

export default ApplicationsListCard;
