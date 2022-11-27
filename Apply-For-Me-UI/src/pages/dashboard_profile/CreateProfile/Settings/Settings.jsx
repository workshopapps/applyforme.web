import styles from "../CreateProfile.module.css";
import classes from "./Settings.module.css";
// import closecircle from "../../assets/close-circle.png";
import Input from "../../InputField/InputField";

const Settings = ({ formData, setFormData }) => {
    return (
        <div className={classes.settings}>
            <div className={styles.form_body}>
                <h3>
                    Select the keyword that should be present in the job posting
                </h3>
                <p>
                    Here you have the opportunity to write a specific keyword
                    your perfect job description would have.
                </p>
                <div className={classes.cover_letter}>
                    <h5>Included keyword</h5>
                    <Input
                        type="text"
                        value={formData.keyword}
                        name="keyword"
                        width={90}
                        onChange={e => {
                            setFormData({
                                ...formData,
                                keyword: e.target.value
                            });
                        }}
                    />
                    <h5>Type keyword</h5>

                    {/* <div className={classes.keywords}>
                        <span className={classes.each_keyword}>
                            <p>UI/UX Design</p>
                            <img src={closecircle} alt="remove" />
                        </span>
                        <span className={classes.each_keyword}>
                            <p>Web 3</p>
                            <img src={closecircle} alt="remove" />
                        </span>
                    </div> */}
                </div>
            </div>
        </div>
    );
};

export default Settings;
