/* eslint-disable no-unused-vars */
import styles from "../CreateProfile.module.css";
import classes from "./JobSearch.module.css";
import pdf from "../../assets/pdf.png";
import Dropdown from "../../components/Dropdown/Dropdown";
import DragDropFile from "pages/dashboard_profile/components/DragDropFile/DragDropFile";
import { useState, useEffect } from "react";
import axios from "axios";

const JobSearch = ({ formData, setFormData }) => {
    const [countries, setCountries] = useState();
    const [requestStatus, setRequestStatus] = useState("idle");

    // Create a Set that only contains unique values from the title property to prevent duplicates that may be fetched
    const uniqueTitles = new Set(
        countries?.map(onecountry => onecountry.title)
    );

    // Create an array of objects with the unique titles
    const countryNames = Array.from(uniqueTitles)?.map(title => ({
        label: title,
        value: title
    }));

    useEffect(() => {
        fetch("https://api.applyforme.hng.tech/api/v1/country/entries/all")
            .then(response => response.json())
            .then(data => setCountries(data));
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
            // Second POST request
            const fd = new FormData();
            fd.set("file", file);
            const secondResponse = await fetch(firstResponse.data, {
                method: "PUT",
                body: fd
            });
            const shortenedCVUrl = secondResponse.url.split("?")[0];
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
                    options={[
                        {
                            label: "Backend engineer",
                            value: "Backend engineer"
                        },
                        {
                            label: "Data scientist",
                            value: "Data scientist"
                        },
                        {
                            label: "Frontend engineer",
                            value: "Frontend engineer"
                        },
                        { label: "Game developer", value: "Game developer" },
                        { label: "Illustrator", value: "Illustrator" },
                        {
                            label: "Musician",
                            value: "Musician"
                        },
                        {
                            label: "No code developer",
                            value: "No code developer"
                        },
                        {
                            label: "Product designer",
                            value: "Product designer"
                        },
                        {
                            label: "Product manager",
                            value: "Product manager"
                        },
                        {
                            label: "Sound engineer",
                            value: "Sound engineer"
                        },
                        { label: "UX researcher", value: "UX researcher" }
                    ]}
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
                        options={[
                            { label: "$3,000-$5,000", value: "$3,000-$5,000" },
                            {
                                label: "$5,000-$10,000",
                                value: "$5,000-$10,000"
                            },
                            {
                                label: "$10,000-$15,000",
                                value: "$10,000-$15,000"
                            },
                            {
                                label: "$15,000-$25,000",
                                value: "$15,000-$25,000"
                            }
                        ]}
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
                        <img src={pdf} alt="pdf" />
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
