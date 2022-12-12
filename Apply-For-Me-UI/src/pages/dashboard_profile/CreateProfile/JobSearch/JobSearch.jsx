/* eslint-disable no-unused-vars */
import styles from "../CreateProfile.module.css";
import classes from "./JobSearch.module.css";
// import pdf from "../../assets/pdf.png";
import Dropdown from "../../components/Dropdown/Dropdown";
import DragDropFile from "pages/dashboard_profile/components/DragDropFile/DragDropFile";
import { useState, useEffect } from "react";
import axios from "axios";
import { HiOutlineDocumentDuplicate } from "react-icons/hi";

const JobSearch = ({ formData, setFormData }) => {
    const [countries, setCountries] = useState();
    const [jobTitles, setJobTitles] = useState();
    const [salaryRanges, setSalaryRanges] = useState();
    const [requestStatus, setRequestStatus] = useState("idle");

    // Arrange in alphabetical order
    const jobTitlesSorted = jobTitles?.reverse();

    // Create a Set that only contains unique values from the title property to prevent duplicates that may be fetched
    const uniqueTitles = new Set(
        countries?.map(onecountry => onecountry.title)
    );

    const uniqueJobTitles = new Set(
        jobTitlesSorted?.map(oneJobTitle => oneJobTitle.title)
    );

    const uniqueSalaries = new Set(
        salaryRanges?.map(onesalaryrange => onesalaryrange.salary_range)
    );

    // Create an array of objects with the unique titles
    const countryNames = Array.from(uniqueTitles)?.map(title => ({
        label: title,
        value: title
    }));

    const jobTitleNames = Array.from(uniqueJobTitles)?.map(title => ({
        label: title,
        value: title
    }));

    const salaryNames = Array.from(uniqueSalaries)?.map(title => ({
        label: title,
        value: title
    }));

    //
    const token = localStorage.getItem("tokenKey");
    let tokenKey = "tokenHngKey";
    let storedToken = localStorage.getItem(tokenKey);

    useEffect(() => {
        fetch("https://api.applyforme.hng.tech/api/v1/country/entries/all")
            .then(response => response.json())
            .then(data => setCountries(data));
    }, []);
    useEffect(() => {
        fetch("https://api.applyforme.hng.tech/api/v1/job-title/entries/all")
            .then(response => response.json())
            .then(data => setJobTitles(data));
    }, []);
    useEffect(() => {
        fetch("https://api.applyforme.hng.tech/api/v1/salary-range/entries/all")
            .then(response => response.json())
            .then(data => setSalaryRanges(data));
    }, []);

    const handleCvUpload = async e => {
        setFormData({ ...formData, cv_file: undefined });
        setFormData({ ...formData, cv_file: e.target.files[0] });

        const file = e.target.files[0];
        const fileName = file?.name;
        const fileExtension = fileName?.split(".").pop();
        //Make POST requests
        setRequestStatus("loading");
        try {
            // First POST request
            const firstResponse = await axios.post(
                `https://api.applyforme.hng.tech/api/v1/upload/pre-signed-resume?extension=.${fileExtension}`
            );
            console.log(firstResponse.data);
            // Second POST request
            const fd = new FormData();
            fd.set("file", file);
            const secondResponse = await fetch(firstResponse.data, {
                method: "PUT",
                body: fd
            });
            console.log(secondResponse);
            const shortenedCVUrl = secondResponse.url.split("?")[0];
            console.log(shortenedCVUrl);
            setFormData({
                ...formData,
                cv_file: e.target.files[0],
                shortenedCVUrl: shortenedCVUrl
            });
            setRequestStatus("idle");
        } catch (error) {
            setRequestStatus("idle");
        }
    };

    return (
        <div className={styles.form_body}>
            <h3>Complete your desired job info and location</h3>
            <div className={classes.dropdownbox}>
                <Dropdown
                    options={jobTitleNames}
                    width={90}
                    value={formData.job_title}
                    onChange={e => {
                        setFormData({
                            ...formData,
                            job_title: e.target.value
                        });
                    }}
                    placeholderText="Job Title"
                />

                <h5>This job title will be used to find jobs around the web</h5>
            </div>
            <div className={classes.dropdownbox}>
                <Dropdown
                    options={countryNames}
                    value={formData.location}
                    width={90}
                    placeholderText="Job Location"
                    onChange={e => {
                        setFormData({
                            ...formData,
                            location: e.target.value
                        });
                    }}
                />

                <h5>Type a city or country</h5>
            </div>
            <div className={classes.dropdownbox}>
                <Dropdown
                    options={[
                        { label: "Hybrid", value: "Hybrid" },
                        { label: "Remote", value: "Remote" },
                        { label: "Onsite", value: "Onsite" }
                    ]}
                    width={90}
                    placeholderText="Location Type"
                    value={formData.isRemote}
                    onChange={e => {
                        setFormData({
                            ...formData,
                            isRemote: e.target.value
                        });
                    }}
                />
                <h5>Select your preferred location type</h5>
            </div>
            {/* <div className={classes.remotecheckbox}>
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
            </div> */}
            <div className={classes.detailsdropdown_box}>
                <div>
                    <p>Experience</p>
                    <Dropdown
                        options={[
                            { label: "No experience", value: "trainee" },
                            { label: "Entry level", value: "intern" },
                            { label: "Mid level", value: "mid_level" },
                            { label: "Senior level", value: "senior" }
                        ]}
                        placeholderText="Select experience"
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
                            { label: "Contract", value: "contract" },
                            { label: "Full-time", value: "full_time" },
                            { label: "Part-time", value: "part_time" }
                        ]}
                        placeholderText="Employment Type"
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
                        options={salaryNames}
                        placeholderText="Salary Expectation"
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
            {formData.cv_file?.type && (
                <div>
                    <div className={classes.uploaded_file}>
                        <HiOutlineDocumentDuplicate
                            className={classes.doc_icon}
                        />
                        <p>{formData.cv_file.name}</p>
                        <button
                            onClick={() => {
                                setFormData({
                                    ...formData,
                                    cv_file: []
                                });
                            }}
                        >
                            x
                        </button>
                    </div>
                </div>
            )}
            <div>
                {requestStatus === "loading" && (
                    // Show a loading animation when the request is in progress
                    <div className={classes.loading_animation} />
                )}
            </div>
            <div className={classes.uploadcv_box}>
                <p>Upload your CV</p>

                <DragDropFile
                    onChange={e => {
                        handleCvUpload(e);
                    }}
                />
            </div>
        </div>
    );
};

export default JobSearch;
