import style from "./ApplicantDetails.module.css";

import pdfIcon from "../../../../assets/images/pdf-icon.svg";
import goBackIcon from "../../../../assets/images/back_arrow.svg";

import { Link } from "react-router-dom";

const details = {
    name: "Sharon Sunday",
    role: "Product Design",
    dateJoined: "Oct 4, 2021",
    email: "Sharon@yahoo.com",
    phone: "+234822398736",
    membership: "Premium",
    experience: "3",
    industry: "Tech",
    salary: "$10,000 - $15,000",
    type: "Remote"
};

const ApplicationDetails = () => {
    return (
        <article className={style.container}>
            <div className={style.go_back_link}>
                <Link to="/dashboard/admin">
                    <img src={goBackIcon} alt="" />
                </Link>
                <span className={style.view_applicants}>
                    View Applicants details
                </span>
            </div>
            <div className={style.header}>
                <span className={style.circle}>SS</span>
                <div>
                    <span className={`${style.details} ${style.details_name}`}>
                        {details.name}
                    </span>
                    <span className={style.details}>{details.role} Role</span>
                    <span className={style.details}>
                        Date joined: {details.dateJoined}
                    </span>
                </div>
            </div>
            <section className={style.job_information}>
                <h2>Job Information</h2>
                <div>
                    <div className={style.info_field}>
                        <h4>Name</h4>
                        <p>{details.name}</p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Email</h4>
                        <p>{details.email}</p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Phone Number</h4>
                        <p>{details.phone}</p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Membership Plan</h4>
                        <p>{details.membership}</p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Experience</h4>
                        <p>{details.experience}</p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Industry</h4>
                        <p>{details.industry}</p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Salary Expectation</h4>
                        <p>{details.salary}</p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Employment Type</h4>
                        <p>{details.type}</p>
                    </div>
                </div>
            </section>
            <section className={style.job_information}>
                <h2>Attachments</h2>
                <div>
                    <div className={style.info_field}>
                        <h4>CV</h4>
                        <p>
                            <img src={pdfIcon} alt="pdf icon" /> OrasmithCV.pdf
                        </p>
                    </div>
                    <div className={style.info_field}>
                        <h4>Cover Letter</h4>
                        <p>
                            <img src={pdfIcon} alt="pdf icon" />{" "}
                            Orasmithcoverletter.pdf
                        </p>
                    </div>
                </div>
            </section>
        </article>
    );
};

export default ApplicationDetails;
