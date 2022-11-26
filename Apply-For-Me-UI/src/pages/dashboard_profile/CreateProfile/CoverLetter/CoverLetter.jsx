import styles from "../CreateProfile.module.css";
import classes from "./CoverLetter.module.css";
// import Dropdown from "../../Dropdown/Dropdown";
// import BlueBorderButton from "../../../../components/buttons/blue_border_button/BlueBorderButton";
import Input from "../../InputField/InputField";
const CoverLetter = ({ formData, setFormData }) => {
    return (
        <form className={styles.form_body}>
            <h3>Create a cover letter template for this profile</h3>
            <div className={styles.dropdownbox}>
                <h5>Template name</h5>
                <Input
                    type="text"
                    value={formData.coverletter_temp}
                    name="coverletter_temp"
                    width={90}
                    onChange={e => {
                        setFormData({
                            ...formData,
                            coverletter_temp: e.target.value
                        });
                    }}
                />
            </div>
            <div className={classes.cover_letter}>
                <label>
                    <h5>Cover letter subject</h5>
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
                    <h5>Cover letter body</h5>
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
            {/* <BlueBorderButton text={"Save"} width={120} /> */}
        </form>
    );
};

export default CoverLetter;
