import styles from "../CreateProfile.module.css";
import classes from "./Settings.module.css";
import AddKeyWord from "../../components/AddKeyword/AddKeyword";

const Settings = ({ keywords, setKeywords }) => {
    return (
        <div className={classes.settings}>
            <div className={styles.form_body}>
                <h3>
                    Select the keywords that should be present in the job
                    posting
                </h3>
                <p>
                    Here, you have the opportunity to write specific keywords
                    your perfect job description would have.
                </p>
                <div className={classes.keywords_box}>
                    <h5>Included keywords</h5>

                    <AddKeyWord keywords={keywords} setKeywords={setKeywords} />
                </div>
            </div>
        </div>
    );
};

export default Settings;
