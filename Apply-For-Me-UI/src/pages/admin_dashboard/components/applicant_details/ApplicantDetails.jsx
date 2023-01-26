import style from "./ApplicantDetails.module.css";

import pdfIcon from "../../../../assets/images/pdf-icon.svg";
import goBackIcon from "../../../../assets/images/back_arrow.svg";

import { Link, useParams } from "react-router-dom";
import Nav from "pages/RR_Dashboard/components/RRD_Nav";
import { useState, useEffect } from "react";
import Spinner from "components/spinner/Spinner";
import LetteredAvatar from "react-lettered-avatar";

const ApplicationDetails = () => {
    const { id } = useParams();
    const token = localStorage.getItem("tokenHngKey");
    const [details, setDetails] = useState();
    const [isLoading, setIsLoading] = useState(true);
    const [showCoverLetter, setShowCoverLetter] = useState(false);

    useEffect(() => {
      
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
                setDetails( data);
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
        <div style={{paddingBottom:"4rem"}}>
            <Nav />
            <div className={style.container}>
                <div className={style.go_back_link}>
                   
                        <img src={goBackIcon} alt="" onClick={()=>window.history.back()}/>
                    
                    <span
                        className={style.view_applicants}
                        onClick={() => window.history.back()}
                    >
                        View Applicants details
                    </span>
                </div>
                <div className={style.header}>
                    <span className={style.circle}>
                        <LetteredAvatar
                            name={details?.professional?.member?.firstName }
                            backgroundColor={"#52515b"}
                        />                      
                    </span>
                    <div>
                        <span
                            className={`${style.details} ${style.details_name}`}
                        >
                            {`${details?.professional?.member?.firstName} ${details?.professional?.member?.lastName}`}
                        </span>
                        <span className={style.details}>
                            {details?.professional?.member?.roles[0]?.title} Role
                        </span>
                        {/* <span className={style.details}>
                            Date joined:{" "}
                            {details?.professional.member.updatedOn}
                        </span> */}
                    </div>
                </div>
                <section className={style.job_information}>
                    <h2>Job Information</h2>
                    <div className={style.field_containers}>
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
                            <h4>Industry</h4>
                            <p>Tech</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Salary Expectation</h4>
                            <p>{details?.salaryRange}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Employment Type</h4>
                            <p>{details?.employmentType}</p>
                        </div>
                        <div className={style.info_field}>
                            <h4>Remaining Aplication</h4>
                            <p>52</p>
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
                             <h4 onClick={()=>setShowCoverLetter(prevState=>!prevState)}>Click to view cover letter</h4>
                        </div>
                        {
                            showCoverLetter &&(
                                <div className={style.cover}>
                                    {details?.coverLetterContent}
                                </div>
                            )
                        }
                       
                    </div>
                       
                </section>
                <div>
                    <Link
                        className={style.job_RR_form}
                        to={`/rr_admin/form/${details?.id}`}
                    >
                        Job Application Form
                    </Link>
                </div>
               
            </div>
        </div>
    );
};

export default ApplicationDetails;
