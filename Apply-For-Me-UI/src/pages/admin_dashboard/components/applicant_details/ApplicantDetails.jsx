import style from "./ApplicantDetails.module.css";

import pdfIcon from "../../../../assets/images/pdf-icon.svg";
import goBackIcon from "../../../../assets/images/back_arrow.svg";

import { Link, useParams } from "react-router-dom";
import Nav from "pages/RR_Dashboard/components/RRD_Nav";
import { useState, useEffect } from "react";
import Spinner from "components/spinner/Spinner";

const ApplicationDetails = () => {
    const { id } = useParams();
    const token = localStorage.getItem("tokenHngKey");
    const [details, setDetails] = useState();
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        setIsLoading(true);
        fetch(
            `https://api.applyforme.hng.tech/api/v1/professional-profile/detail/${id}`,
            {
                headers: {
                    "Authorization": `Bearer ${token}`
                }
            }
        )
            .then(response => response.json())
            .then(data => {
                setDetails(data);
                console.log(data);
                setIsLoading(false);
            })
            .catch(error => {
                console.log(error);
            });
    }, [id, token]);

    if (isLoading) {
        return <Spinner />;
    }

    return (
        <div>
            <Nav />
            <div className={style.container}>
                <div className={style.go_back_link}>
                    <Link to="/rr_admin">
                        <img src={goBackIcon} alt="" />
                    </Link>
                    <span
                        className={style.view_applicants}
                        onClick={() => window.history.back()}
                    >
                        View Applicants details
                    </span>
                </div>
                <div className={style.header}>
                    <span className={style.circle}>
                        <img
                            src={details?.professional?.member?.avatar}
                            alt="profile avatar"
                        />
                    </span>
                    <div>
                        <span
                            className={`${style.details} ${style.details_name}`}
                        >
                            {`${details?.professional?.member?.firstName} ${details?.professional?.member?.lastName}`}
                        </span>
                        <span className={style.details}>
                            {details?.professional?.member?.roles} Role
                        </span>
                        {/* <span className={style.details}>
                            Date joined:{" "}
                            {details?.professional.member.updatedOn}
                        </span> */}
                    </div>
                </div>
                <section className={style.job_information}>
                    <h2>Job Information</h2>
                    <div className={style.field_container}>
                        <div className={style.info_field}>
                            <h4>Name</h4>
                            <p>{details?.profileTitle}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Email</h4>
                            <p>{details?.professional?.member?.emailAddress}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Phone Number</h4>
                            <p>{details?.professional?.member?.phoneNumber}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Experience Level</h4>
                            <p>{details?.jobSeniority}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Experience</h4>
                            <p>{details?.yearsOfExperience}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Industry</h4>
                            <p>{details?.industry}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Salary Expectation</h4>
                            <p>{details?.salaryRange}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Employment Type</h4>
                            <p>{details?.employmentType}</p>
                        </div>
                    </div>
                </section>
                <section className={style.job_information}>
                    <h2>Attachments</h2>
                    <div>
                        <div className={style.info_field}>
                            <h4>CV</h4>
                            <a href={details?.resumeLink} download>
                                <img src={pdfIcon} alt="pdf icon" />{" "}
                                {`${details?.professional?.member?.firstName}CV.pdf`}
                            </a>
                        </div>
                        <div className={style.info_field}>
                            <h4>Cover Letter</h4>
                            <a href={details?.coverLetterLink} download>
                                <img src={pdfIcon} alt="pdf icon" /> get cover
                                letter
                            </a>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    );
};

export default ApplicationDetails;
