import styles from "../Applications.module.css";
import { HiOutlineChevronLeft, HiOutlineChevronRight } from "react-icons/hi2";
import { useNavigate } from "react-router-dom";
import ApplicationsListHeader from "./ApplicationsListHeader";
import { applications } from "../applicationsMock";
const Table = () => {
    const navigate = useNavigate();
    return (
        <div className={styles.applications_table_wrapper}>
            <ApplicationsListHeader />
            <div className={styles.applications_table_container}>
                <table>
                    <thead>
                        <tr className={styles.applications_table_head_row}>
                            <th>Company</th>
                            <th>Job title</th>
                            <th className={styles.hide_tablet}>Location</th>
                            <th>Salary Range</th>
                            <th className={styles.hide_tablet}>Job Duration</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {applications.map((application, index) => (
                            <tr
                                className={styles.applications_table_body_row}
                                key={`${application.company}-${index}`}
                                onClick={() =>
                                    navigate(
                                        `/dashboard/applications/${application.id}`
                                    )
                                }
                            >
                                <td>
                                    <div>{application.company}</div>
                                    <div className={styles.show_tablet}>
                                        {application.location}
                                    </div>
                                </td>
                                <td>
                                    <div>{application.jobTitle}</div>
                                    <div className={styles.show_tablet}>
                                        {application.jobType}
                                    </div>
                                </td>
                                <td className={styles.hide_tablet}>
                                    {application.location}
                                </td>
                                <td>{application.salaryRange}</td>
                                <td className={styles.hide_tablet}>
                                    {application.jobDuration}
                                </td>
                                <td>{application.date}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>

            <div className={styles.applications_footer}>
                <span>1-10/60</span>
                <span>
                    <HiOutlineChevronLeft />
                    <HiOutlineChevronRight />
                </span>
            </div>
        </div>
    );
};

export default Table;
