import styles from "../CreateProfile.module.css";
import classes from "./Settings.module.css";
// import closecircle from "../../assets/close-circle.png";
import Input from "../../InputField/InputField";

const Settings = () => {
    function handleInputChange() {
        //
    }
    return (
        <div className={classes.settings}>
            <div className={styles.form_body}>
                <h3>
                    Select the keywords that should be present in the job
                    posting
                </h3>
                <p>
                    Here you have the opportunity to write the specific keyword
                    your perfect job description would have.
                </p>
                <div className={classes.cover_letter}>
                    <h5>Included keywords</h5>
                    <Input
                        type="text"
                        placeholder="Fintech"
                        value={name}
                        name="name"
                        width={90}
                        onChange={handleInputChange}
                    />
                    <h5>Type keywords and press enter</h5>
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
