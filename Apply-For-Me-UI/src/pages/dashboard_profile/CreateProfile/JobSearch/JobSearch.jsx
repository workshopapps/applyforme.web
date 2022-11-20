import styles from "../CreateProfile.module.css";
import classes from "./JobSearch.module.css";
import file from "../../assets/file.png";
import Input from "../../InputField/InputField";
import { useState } from "react";
const JobSearch = () => {
    const [jobtitle, setJobTitle] = useState("");
    const [city, setCity] = useState("");
    function handleJobInputChange(e) {
        setJobTitle(e.target.value);
    }
    function handleCityInputChange(e) {
        setCity(e.target.value);
    }
    return (
        <form className={styles.form_body}>
            <h3>Complete your desired job info and location</h3>
            <div className={classes.dropdownbox}>
                <Input
                    type="text"
                    value={jobtitle}
                    name="name"
                    width={90}
                    onChange={handleJobInputChange}
                />

                <h5>This job title will be used to find jobs around the web</h5>
            </div>
            <div className={classes.dropdownbox}>
                <Input
                    type="text"
                    value={city}
                    name="name"
                    width={90}
                    onChange={handleCityInputChange}
                />

                <h5>Type a city or country</h5>
            </div>
            <br />
            <div className={classes.remotecheckbox}>
                <input
                    type="checkbox"
                    id="isFriendly"
                    // checked={}
                />
                <label htmlFor="isFriendly">I want only remote jobs</label>
            </div>
            <div className={classes.detailsdropdown_box}>
                <div>
                    <p>Experience</p>
                    <Input type="text" name="name" width={70} />
                </div>
                <div>
                    <p>Employment Type</p>
                    <Input type="text" name="name" width={70} />
                </div>
                <div>
                    <p>Salary Expectation</p>
                    <Input type="text" name="name" width={70} />
                </div>
            </div>
            <div className={classes.uploadcv_box}>
                <p>Upload your CV</p>
                <div className={classes.draghere}>
                    <img src={file} alt="drag" />
                    <h6>Drag n Drop here</h6>
                    <h6>Or</h6>
                    <h5>Browse</h5>
                </div>
            </div>
        </form>
    );
};

export default JobSearch;
