/* eslint-disable no-unused-vars */
import { NavLink } from "react-router-dom";
import styles from "../CreateProfile.module.css";
import classes from "./Review.module.css";
import { useNavigate } from "react-router-dom";
import BlueButton from "../../../../components/buttons/blue_background/BlueButton";
import LightButton from "../../../../components/buttons/light_button/LightButton";
import axios from "axios";
import { useSelector } from "react-redux";
import { useState } from "react";
import { toast, ToastContainer } from "react-toastify";

const Review = ({ formData, keywords, setStep }) => {
    const [response, setResponse] = useState(null);
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();
    let included_keywords = String(keywords);

    if (included_keywords.length <= 0) {
        included_keywords = "No keywords";
    }
    console.log(included_keywords);
    console.log(formData);

    const { user } = useSelector(state => state.user);
    const userEmail = user.sub;
    const token = localStorage.getItem("tokenKey");
    let tokenKey = "tokenHngKey";
    let storedToken = localStorage.getItem(tokenKey);
    const handleSubmit = async () => {
        if (formData.job_title === "") {
            return alert("Please enter a job title");
        } else if (formData.location === "") {
            return alert("Please select your location");
        } else if (formData.isRemote === "") {
            return alert("Please select your job location type");
        } else if (formData.experience === "") {
            return alert("Please select your experience");
        } else if (formData.employment_type === "") {
            return alert("Please select your employment type");
        } else if (formData.salary_expectation === "") {
            return alert("Please select your salary expectation");
        } else if (formData.shortenedCVUrl === "") {
            return alert("Please upload a CV");
        } else if (formData.coverletter_subject === "") {
            return alert("Please enter a cover letter subject");
        } else if (formData.coverletter_body.length === "") {
            return alert("Please enter a cover letter body");
        }

        setLoading(true);
        try {
            // Make POST request
            const finalResponse = await fetch(
                "https://api.applyforme.hng.tech/api/v1/job-profile/save",
                {
                    method: "POST",
                    headers: {
                        Authorization: `Bearer ${storedToken}`,
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        job_title: formData.job_title,
                        passport_link: "string",
                        resume_link: formData.shortenedCVUrl,
                        cover_letter_link: "string",
                        cover_letter_subject: formData.coverletter_subject,
                        cover_letter_content: formData.coverletter_body,
                        salary_range: formData.salary_expectation,
                        employment_type: formData.employment_type,
                        job_location: formData.location,
                        job_location_type: formData.isRemote,
                        job_seniority: formData.experience,
                        desired_job_title: "string",
                        industry: "string",
                        years_of_experience: 0,
                        other_skills: "string",
                        other_comment: "string",
                        included_keywords: included_keywords
                    })
                }
            );
            const finalResponseJson = await finalResponse.json();
            setLoading(false);
            toast.success("Profile successfully created");
            // console.log(finalResponse);
            navigate("/dashboard/user/success");
        } catch (error) {
            alert("Failed to submit, please try again");
            toast.error("Failed to submit. Please try again");
        }
    };
    // console.log(formData);
    return (
        <div className={styles.form_body}>
            <ToastContainer />
            <h3>Review your profile and it's good to go!</h3>
            <div className={classes.review_top}>
                <div>
                    {formData.job_title ? (
                        <h3 className={classes.review_jobtitle}>
                            {formData.job_title}
                        </h3>
                    ) : (
                        <p className={classes.not_filled}>Not specified yet</p>
                    )}

                    <h5>Job title</h5>
                </div>
                <div className={classes.review_top_email}>
                    <p>{userEmail}</p>
                    <h5>Personal email</h5>
                </div>
            </div>
            <hr className={classes.hr_one} />
            <div className={classes.review_box}>
                <div className={classes.review_box_left}>
                    <div>
                        {formData.location ? (
                            <p>{formData.location}</p>
                        ) : (
                            <p className={classes.not_filled}>
                                Not specified yet
                            </p>
                        )}
                        <h5>Job location</h5>
                    </div>
                    <div>
                        {formData.experience ? (
                            <p>{formData.experience}</p>
                        ) : (
                            <p className={classes.not_filled}>
                                Not specified yet
                            </p>
                        )}
                        <h5>Experience</h5>
                    </div>
                    <div>
                        {included_keywords ? (
                            <section className={classes.review_keywords}>
                                {included_keywords}
                            </section>
                        ) : (
                            <p className={classes.not_filled}>None specified</p>
                        )}
                        <h5>Keywords</h5>
                    </div>
                    <div>
                        {formData.cv_file?.name ? (
                            <p className={classes.pdf_name}>
                                {formData.cv_file?.name}
                            </p>
                        ) : (
                            <p className={classes.not_filled}>
                                Not uploaded yet
                            </p>
                        )}
                        <h5>Uploaded CV</h5>
                    </div>
                </div>
                {/* <hr className={styles.hr_one} /> */}
                <div className={classes.cl_template}>
                    <div>
                        <h6>Cover letter template</h6>
                        <div>
                            {formData.coverletter_subject ? (
                                <p>{formData.coverletter_subject}</p>
                            ) : (
                                <p className={classes.not_filled}>
                                    Not yet written
                                </p>
                            )}
                            <h5>Cover letter subject</h5>
                        </div>
                        <div className={classes.coverletter_body}>
                            <h6>Cover letter body</h6>
                            <div className={classes.review_textarea}>
                                {formData.coverletter_body ? (
                                    <p className={classes.clbody_text}>
                                        {formData.coverletter_body}
                                    </p>
                                ) : (
                                    <p className={classes.not_filled}>
                                        Not yet written
                                    </p>
                                )}
                            </div>
                            {loading && (
                                <div className={classes.loading_animation} />
                            )}

                            <div className={classes.review_buttons}>
                                <LightButton
                                    text={"Go back to edit"}
                                    func={() => setStep(0)}
                                />
                                <BlueButton
                                    func={handleSubmit}
                                    text={"Send profile for searching"}
                                />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Review;
