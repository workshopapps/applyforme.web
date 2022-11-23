import { NavLink } from "react-router-dom";
import styles from "../CreateProfile.module.css";
import classes from "./Review.module.css";
import BlueButton from "../../../../components/buttons/blue_background/BlueButton";
import LightButton from "../../../../components/buttons/light_button/LightButton";
const Review = () => {
    return (
        <div className={styles.form_body}>
            <h3>Review your profile and it's good to go!</h3>
            <h3 className={classes.review_jobtitle}> Product designer</h3>
            <h5>Job title</h5>
            <hr className={styles.hr_one} />
            <div className={classes.review_box}>
                <div className={classes.review_box_left}>
                    <p>Search Info</p>
                    <div>
                        <p>Remote</p>
                        <h5>Job location</h5>
                    </div>
                    <div>
                        <p>No experience</p>
                        <h5>Experience</h5>
                    </div>
                    <div>
                        <p>Web 3, Fintech</p>
                        <h5>Keywords</h5>
                    </div>
                    <p>Personal Info</p>
                    <div>
                        <p>enwono CV.pdf</p>
                        <h5>Uploaded CV</h5>
                    </div>
                    <div>
                        <p>enwono_id@yahoo.com</p>
                        <h5>Personal email</h5>
                    </div>
                </div>
                <hr className={styles.hr_one} />
                <div>
                    <div>
                        <h6>Cover letter template</h6>
                        <div>
                            <p>Application for UI/UX designer role</p>
                            <h5>Cover letter subject</h5>
                        </div>
                        <div className={classes.coverletter_body}>
                            <h6>Cover letter body</h6>
                            <textarea
                                className={classes.review_textarea}
                                placeholder="Hello,
                        I am interested in applying my knowledge in a real project in Rapid river where I will learn a lot of things!I want to learn if you have opportunities related to my profile. I have attached my resume to let you learn more about me.
                            I would love to talk to you in more detail. Let me know your availability in the coming weeks.
                            
                            Thanks,
                            Enwono Ikono"
                            />
                            <div className={classes.review_buttons}>
                                <NavLink
                                    to="/dashboard/user/success"
                                    style={{ textDecoration: "none" }}
                                >
                                    <BlueButton
                                        text={"Send profile for searching"}
                                    />
                                </NavLink>
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
