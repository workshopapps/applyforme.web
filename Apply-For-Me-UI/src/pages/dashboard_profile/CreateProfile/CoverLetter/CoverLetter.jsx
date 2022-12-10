import styles from "../CreateProfile.module.css";
import classes from "./CoverLetter.module.css";
// import Dropdown from "../../components/Dropdown/Dropdown";
import Input from "../../components/InputField/InputField";
const CoverLetter = ({ formData, setFormData }) => {
    return (
        <form className={styles.form_body}>
            <h3>Create a cover letter template for this profile</h3>
            {/* <div className={styles.dropdownbox}>
                <h5>Template name</h5>
                <Dropdown
                    options={[{ label: "Browse Templates", value: "" }]}
                    width={90}
                />
            </div> */}
            <div className={classes.cover_letter}>
                <label>
                    <p className={classes.cl_text}>Cover letter subject</p>
                </label>
                <Input
                    type="text"
                    value={formData.coverletter_subject}
                    name="coverletter_subject"
                    width={90}
                    onChange={e => {
                        setFormData({
                            ...formData,
                            coverletter_subject: e.target.value
                        });
                    }}
                />
            </div>
            <div>
                <label>
                    <p className={classes.cl_text}>Cover letter body</p>
                </label>
                <textarea
                    className={classes.cl_textarea}
                    placeholder="Hello,
I checked your website and social profiles recently and I came across your job posting regarding the opening at london.I am interested in applying my knowledge in a real project in Rapid river where I will learn a lot of things!I want to learn if you have opportunities related to my profile. I have attached my resume to let you learn more about me.
I would love to talk to you in more detail. Let me know your availability in the coming weeks.
Thanks,
Enwono Ikono"
                    value={formData.coverletter_body}
                    name="coverletter_body"
                    onChange={e => {
                        setFormData({
                            ...formData,
                            coverletter_body: e.target.value
                        });
                    }}
                />
            </div>
        </form>
    );
};

export default CoverLetter;
