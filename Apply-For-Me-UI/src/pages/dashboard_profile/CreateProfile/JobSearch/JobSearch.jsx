import styles from "../CreateProfile.module.css";
import classes from "./JobSearch.module.css";
import pdf from "../../assets/pdf.png";
import Dropdown from "../../components/Dropdown/Dropdown";
import DragDropFile from "pages/dashboard_profile/components/DragDropFile/DragDropFile";
import { useState, useEffect } from "react";

const JobSearch = ({ formData, setFormData }) => {
    const [countries, setCountries] = useState();
    const countrynames = countries?.map(onecountry => ({
        label: onecountry.title,
        value: onecountry.title
    }));
    const countryNames = countrynames?.reverse();

    countryNames?.splice(1, 0, {
        label: "Job Location",
        value: ""
    });

    useEffect(() => {
        fetch(
            "https://official-volunux.uc.r.appspot.com/api/v1/country/entries/all"
        )
            .then(response => response.json())
            .then(data => setCountries(data));
    }, []);
    return (
        <form className={styles.form_body}>
            <h3>Complete your desired job info and location</h3>
            <div className={classes.dropdownbox}>
                <Dropdown
                    options={[
                        { label: "Job Title", value: "" },
                        { label: "Designer", value: "Designer" },
                        {
                            label: "Front-end Developer",
                            value: "Front-end Developer"
                        },
                        {
                            label: "Back-end Developer",
                            value: "Back-end Developer"
                        }
                    ]}
                    width={90}
                    value={formData.job_title}
                    onChange={e => {
                        setFormData({
                            ...formData,
                            job_title: e.target.value
                        });
                    }}
                />

                <h5>This job title will be used to find jobs around the web</h5>
            </div>
            <div className={classes.dropdownbox}>
                <Dropdown
                    options={countryNames}
                    value={formData.location}
                    width={90}
                    onChange={e => {
                        setFormData({
                            ...formData,
                            location: e.target.value
                        });
                    }}
                />

                <h5>Type a city or country</h5>
            </div>
            <br />
            <div className={classes.remotecheckbox}>
                <input
                    type="checkbox"
                    id="isRemote"
                    checked={formData.isRemote}
                    name="isRemote"
                    onChange={e => {
                        setFormData({
                            ...formData,
                            isRemote: e.target.checked
                        });
                    }}
                />
                <label htmlFor="isRemote">I want only remote jobs</label>
            </div>
            <div className={classes.detailsdropdown_box}>
                <div>
                    <p>Experience</p>
                    <Dropdown
                        options={[
                            { label: "Experience", value: "" },
                            { label: "No experience", value: "No experience" },
                            { label: "Entry Level", value: "Entry level" },
                            { label: "Mid-Level", value: "Mid-Level" },
                            { label: "Senior Level", value: "Senior Level" }
                        ]}
                        value={formData.experience}
                        onChange={e => {
                            setFormData({
                                ...formData,
                                experience: e.target.value
                            });
                        }}
                    />
                </div>
                <div>
                    <p>Employment Type</p>
                    <Dropdown
                        options={[
                            { label: "Employment Type", value: "" },
                            { label: "Contract", value: "Contract" },
                            { label: "Full-time", value: "Full-time" },
                            { label: "Part-Time", value: "Part-time" }
                        ]}
                        value={formData.employment_type}
                        onChange={e => {
                            setFormData({
                                ...formData,
                                employment_type: e.target.value
                            });
                        }}
                    />
                </div>
                <div>
                    <p>Salary Expectation</p>
                    <Dropdown
                        options={[
                            { label: "Salary", value: "" },
                            { label: "$3,000-$5,000", value: "salary1" },
                            { label: "$5,000-$10,000", value: "salary2" },
                            { label: "$10,000-$15,000", value: "salary3" },
                            { label: "$15,000-$25,000", value: "salary4" }
                        ]}
                        value={formData.salary_expectation}
                        onChange={e => {
                            setFormData({
                                ...formData,
                                salary_expectation: e.target.value
                            });
                        }}
                    />
                </div>
            </div>
            {formData.cv_file.name && (
                <div className={classes.uploaded_file}>
                    <img src={pdf} alt="pdf" />
                    <p>{formData.cv_file.name}</p>
                    <button
                        onClick={() => {
                            setFormData({
                                ...formData,
                                cv_file: false
                            });
                        }}
                    >
                        x
                    </button>
                </div>
            )}
            <div className={classes.uploadcv_box}>
                <p>Upload your CV</p>
                <DragDropFile
                    onChange={e => {
                        setFormData({
                            ...formData,
                            cv_file: e.target.files[0]
                        });
                    }}
                />
            </div>
        </form>
    );
};

export default JobSearch;
