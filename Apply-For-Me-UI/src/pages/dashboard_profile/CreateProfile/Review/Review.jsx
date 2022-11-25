import { NavLink } from "react-router-dom";
import styles from "../CreateProfile.module.css";
import classes from "./Review.module.css";
import BlueButton from "../../../../components/buttons/blue_background/BlueButton";
import LightButton from "../../../../components/buttons/light_button/LightButton";
const Review = ({ formData }) => {
    function handleSubmit() {
        if (formData.job_title === "") {
            return alert("Please enter a job title");
        } else if (formData.location === "") {
            return alert("Please select your location");
        }
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
                        <p>{formData.keyword}</p>
                        <h5>Keyword</h5>
                    </div>
                    {/* <h6>Personal Info</h6>
                    <div>
                        <p>enwono CV.pdf</p>
                        <h5>Uploaded CV</h5>
                    </div> */}
                    {/* <div>
                        <p>enwono_id@yahoo.com</p>
                        <h5>Personal email</h5>
                    </div> */}
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
                                {/* <NavLink
                                    to="/dashboard/user/success"
                                    style={{ textDecoration: "none" }}
                                > */}
                                <BlueButton
                                    func={handleSubmit}
                                    text={"Send profile for searching"}
                                />
                                {/* </NavLink> */}
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
