import { NavLink } from "react-router-dom";
import styles from "../CreateProfile.module.css";
import classes from "./Review.module.css";
import { useNavigate } from "react-router-dom";
import BlueButton from "../../../../components/buttons/blue_background/BlueButton";
import LightButton from "../../../../components/buttons/light_button/LightButton";
const Review = ({ formData, keywords }) => {
    const navigate = useNavigate();
    function handleSubmit() {
        if (formData.job_title === "") {
            return alert("Please enter a job title");
        } else if (formData.location === "") {
            return alert("Please select your location");
        } else if (formData.experience === "") {
            return alert("Please select your experience");
        } else if (formData.employment_type === "") {
            return alert("Please select your employment type");
        } else if (formData.salary_expectation === "") {
            return alert("Please select your salary expectation");
        } else if (formData.coverletter_subject === "") {
            return alert("Please enter a cover letter subject");
        } else if (formData.coverletter_body === "") {
            return alert("Please enter a cover letter body");
        }
        navigate("/dashboard/user/success");
    }
    return (
        <div className={styles.form_body}>
            <h3>Review your profile and it's good to go!</h3>
            <h3 className={classes.review_jobtitle}>{formData.job_title}</h3>
            <h5>Job title</h5>
            <hr className={styles.hr_one} />
            <div className={classes.review_box}>
                <div className={classes.review_box_left}>
                    <h6>Search Info</h6>
                    <div>
                        <p>
                            {formData.location}
                            {formData.isRemote ? ", remote" : null}
                        </p>
                        <h5>Job location</h5>
                    </div>
                    <div>
                        <p>{formData.experience}</p>
                        <h5>Experience</h5>
                    </div>
                    <div>
                        <section className={classes.review_keywords}>
                            {keywords?.map((k, index) => (
                                <p key={`${k.k}+${index}`}>{k}</p>
                            ))}
                        </section>
                        <h5>Keywords</h5>
                    </div>
                    <h6>Personal Info</h6>
                    <div>
                        <p>{formData.cv_file.name}</p>
                        <h5>Uploaded CV</h5>
                    </div>
                    <div>
                        <p>enwono_id@yahoo.com</p>
                        <h5>Personal email</h5>
                    </div>
                </div>
                <hr className={styles.hr_one} />
                <div className={classes.cl_template}>
                    <div>
                        <h6>Cover letter template</h6>
                        <div>
                            <p>{formData.coverletter_subject}</p>
                            <h5>Cover letter subject</h5>
                        </div>
                        <div className={classes.coverletter_body}>
                            <h6>Cover letter body</h6>
                            <div className={classes.review_textarea}>
                                {formData.coverletter_body}
                            </div>
                            <div className={classes.review_buttons}>
                                <BlueButton
                                    func={handleSubmit}
                                    text={"Send profile for searching"}
                                />
                                <NavLink
                                    to="/dashboard/user/create-profile"
                                    style={{ textDecoration: "none" }}
                                >
                                    <LightButton text={"Go back to edit"} />
                                </NavLink>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Review;
