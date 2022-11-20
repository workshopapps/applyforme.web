import styles from "../CreateProfile.module.css";
import classes from "./CoverLetter.module.css";
// import Dropdown from "../../Dropdown/Dropdown";
// import BlueBorderButton from "../../../../components/buttons/blue_border_button/BlueBorderButton";
import Input from "../../InputField/InputField";
import { useState } from "react";
const CoverLetter = () => {
    const [coverlettersubject, setCoverLetterSubject] = useState("");
    function handleCLInputChange(e) {
        setCoverLetterSubject(e.target.value);
    }
    return (
        <form className={styles.form_body}>
            <h3>Create a cover letter template for this profile</h3>
            <div className={styles.dropdownbox}>
                <h5>Template name</h5>
                <Input
                    type="text"
                    value={coverlettersubject}
                    name="name"
                    width={90}
                    onChange={handleCLInputChange}
                />
            </div>
            <div className={classes.cover_letter}>
                <label>
                    <h5>Cover letter subject</h5>
                </label>
                <Input
                    type="text"
                    value={coverlettersubject}
                    name="name"
                    width={90}
                    onChange={handleCLInputChange}
                />
            </div>
            <div>
                <label>
                    <h5>Cover letter body</h5>
                </label>
                <textarea
                    className={classes.cl_textarea}
                    placeholder="Hello,
I checked your website and social profiles recently and I came across your job posting regarding the opening at london.I am interested in applying my knowledge in a real project in Rapid river where I will learn a lot of things!I want to learn if you have opportunities related to my profile. I have attached my resume to let you learn more about me.
I would love to talk to you in more detail. Let me know your availability in the coming weeks.
Thanks,
Enwono Ikono"
                />
            </div>
            {/* <BlueBorderButton text={"Save"} width={120} /> */}
        </form>
    );
};

export default CoverLetter;
