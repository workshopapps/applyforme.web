import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import formStyling from "./TryoutForm.module.css";
import Input from "./components/Input";
import BlueButton from "components/buttons/blue_background/BlueButton";
import Dropdown from "./Dropdown/Dropdown";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { useFormik } from "formik";
import axios from "axios";
import { toast, ToastContainer } from "react-toastify";
import * as Yup from "yup";

const TryoutForm = () => {
    const [countries, setCountries] = useState();
    const [jobTitles, setJobTites] = useState();
    const [salaryRange, setSalaryRange] = useState();

    const navigate = useNavigate();
    // Create a Set that only contains unique values from the title property to prevent duplicates that may be fetched
    const uniqueTitles = new Set(
        countries?.map(onecountry => onecountry.title)
    );

    const uniqueJobTitles = new Set(jobTitles?.map(oneTitle => oneTitle.title));
    // Create an array of objects with the unique titles
    const countryNames = Array.from(uniqueTitles)?.map(title => ({
        label: title,
        value: title
    }));

    const uniqueSalary = new Set(
        salaryRange?.map(salary => salary.salary_range)
    );

    const salaryRanges = Array.from(uniqueSalary).map(salary => ({
        label: salary,
        value: salary
    }));

    const jobTitleNames = Array.from(uniqueJobTitles)?.map(title => ({
        label: title,
        value: title
    }));
    useEffect(() => {
        fetch("https://api.applyforme.hng.tech/api/v1/country/entries/all")
            .then(response => response.json())
            .then(data => setCountries(data));
        fetch("https://api.applyforme.hng.tech/api/v1/job-title/entries/all")
            .then(response => response.json())
            .then(data => setJobTites(data));
        fetch("https://api.applyforme.hng.tech/api/v1/salary-range/entries/all")
            .then(response => response.json())
            .then(data => setSalaryRange(data));
    }, []);

    const onSubmit = async values => {
        const res = await axios
            .post(
                "https://api.applyforme.hng.tech/api/v1/visitor/onboard",
                values
            )
            .then(response => {
                return response;
            })
            .catch(error => {
                return error?.response.data;
            });
        if (res.code === "409") {
            toast.error(res.message);
        }

        if (res.status === "200") {
            navigate("/tryout-form/success");
        }
    };

    const { values, handleChange, handleSubmit, handleBlur, touched, errors } =
        useFormik({
            // form state
            initialValues: {
                first_name: "",
                last_name: "",
                email_address: "",
                phone_number: "",
                job_location: "",
                job_title: "",
                job_seniority: "",
                employment_type: "",
                salary_range: "",
                job_location_type: ""
            },
            //   form validation
            validationSchema: Yup.object().shape({
                first_name: Yup.string()
                    .max(20, "Name must be 20 characters or less.")
                    .required("Please enter your first name"),
                last_name: Yup.string()
                    .max(20, "Name must be 20 characters or less.")
                    .required("please enter your last name"),
                email_address: Yup.string()
                    .email("Invalid email address")
                    .required("Email is required"),
                job_location: Yup.string().required(
                    "please enter your preffered Job location"
                ),
                job_title: Yup.string().required("Job title is required"),
                phone_number: Yup.string()
                    .min(
                        11,
                        "phone number must be between 11 and 14 characters"
                    )
                    .required("Please enter a phone number"),
                job_seniority: Yup.string().required("select experience level"),
                salary_range: Yup.string().required(
                    "please select desired salary range"
                ),
                employment_type: Yup.string().required("please select one"),
                job_location_type: Yup.string().required("Please select one")
            }),

            onSubmit
        });

    return (
        <div>
            <ToastContainer />
            <Nav />
            <div className={formStyling.form_wrapper}>
                <form onSubmit={handleSubmit}>
                    <p className={formStyling.personal_info}>
                        Please fill in your personal information below
                    </p>
                    <div>
                        {" "}
                        <Input
                            placeholder={"First name"}
                            value={values.first_name}
                            onChange={handleChange}
                            id={"first_name"}
                            onBlur={handleBlur}
                            newClass={
                                touched.first_name && errors.first_name
                                    ? "input-error"
                                    : ""
                            }
                        />
                        {touched.first_name && errors.first_name && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.first_name}
                            </small>
                        )}
                    </div>
                    <div>
                        <Input
                            placeholder={"Last name"}
                            value={values.last_name}
                            onChange={handleChange}
                            id={"last_name"}
                            onBlur={handleBlur}
                            newClass={
                                touched.last_name && errors.last_name
                                    ? "input-error"
                                    : ""
                            }
                        />
                        {touched.last_name && errors.last_name && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.last_name}
                            </small>
                        )}
                    </div>

                    <div>
                        <Input
                            placeholder={"Email address"}
                            value={values.email_address}
                            onChange={handleChange}
                            id={"email_address"}
                            onBlur={handleBlur}
                            newClass={
                                touched.email_address && errors.email_address
                                    ? "input-error"
                                    : ""
                            }
                        />
                        {touched.email_address && errors.email_address && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.email_address}
                            </small>
                        )}
                    </div>
                    <div>
                        <Input
                            placeholder={"Phone number"}
                            value={values.phone_number}
                            onChange={handleChange}
                            id={"phone_number"}
                            onBlur={handleBlur}
                            newClass={
                                touched.phone_number && errors.phone_number
                                    ? "input-error"
                                    : ""
                            }
                        />

                        {touched.phone_number && errors.phone_number && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.phone_number}
                            </small>
                        )}
                    </div>

                    <div className={formStyling.details}>
                        <p className={formStyling.personal_info}>
                            Complete your desired job info and location for our
                            job search.
                        </p>
                        <div>
                            <Dropdown
                                options={jobTitleNames}
                                value={values.job_title}
                                width={100}
                                onChange={handleChange}
                                placeholderText="Job Title"
                                id={"job_title"}
                                onBlur={handleBlur}
                            />
                            {touched.job_title && errors.job_title && (
                                <small
                                    style={{
                                        color: "#EB5757",
                                        paddingTop: "0.3rem"
                                    }}
                                >
                                    {errors.job_title}
                                </small>
                            )}
                            <span>
                                This job title will be used to find jobs around
                                the web
                            </span>
                        </div>
                        <div>
                            {" "}
                            <Dropdown
                                options={countryNames}
                                width={100}
                                placeholderText="Job Location"
                                value={values.job_location}
                                id={"job_location"}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            />
                            {touched.job_location && errors.job_location && (
                                <small
                                    style={{
                                        color: "#EB5757",
                                        paddingTop: "0.3rem"
                                    }}
                                >
                                    {errors.job_location}
                                </small>
                            )}
                        </div>

                        <span>Type a city or a country</span>

                        {/* <div className={formStyling.checkbox}>
                            <input type="checkbox" name="" id="" />{" "}
                            <label className={formStyling.only_remote}>
                                I want only remote jobs
                            </label>
                        </div> */}

                        <div>
                            <p>Job location type</p>
                            <Dropdown
                                options={[
                                    {
                                        label: "Hybrid",
                                        value: "hybrid"
                                    },
                                    {
                                        label: "Remote",
                                        value: "remote"
                                    },
                                    {
                                        label: "Onsite",
                                        value: "onsite"
                                    }
                                ]}
                                placeholderText="Select Job location type"
                                id={"job_location_type"}
                                value={values.job_location_type}
                                width={100}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            />

                            {touched.job_location_type &&
                                errors.job_location_type && (
                                    <small
                                        style={{
                                            color: "#EB5757",
                                            paddingTop: "0.3rem"
                                        }}
                                    >
                                        {errors.job_location_type}
                                    </small>
                                )}
                        </div>

                        <div
                            className={`${formStyling.detailsdropdown_box} ${formStyling.row_of_3}`}
                        >
                            <div>
                                <p>Experience</p>
                                <Dropdown
                                    options={[
                                        {
                                            label: "No experience",
                                            value: "trainee"
                                        },
                                        {
                                            label: "Entry level",
                                            value: "intern"
                                        },
                                        {
                                            label: "Mid level",
                                            value: "mid_level"
                                        },
                                        {
                                            label: "Senior level",
                                            value: "senior"
                                        }
                                    ]}
                                    placeholderText="Select experience"
                                    id={"job_seniority"}
                                    value={values.job_seniority}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />

                                {touched.job_seniority && errors.job_seniority && (
                                    <small
                                        style={{
                                            color: "#EB5757",
                                            paddingTop: "0.3rem"
                                        }}
                                    >
                                        {errors.job_seniority}
                                    </small>
                                )}
                            </div>
                            <div>
                                <p>Employment Type</p>
                                <Dropdown
                                    options={[
                                        {
                                            label: "Contract",
                                            value: "contract"
                                        },
                                        {
                                            label: "Full-time",
                                            value: "full_time"
                                        },
                                        {
                                            label: "Part-time",
                                            value: "part_time"
                                        }
                                    ]}
                                    placeholderText="Employment Type"
                                    id={"employment_type"}
                                    value={values.employment_type}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />

                                {touched.employment_type &&
                                    errors.employment_type && (
                                        <small
                                            style={{
                                                color: "#EB5757",
                                                paddingTop: "0.3rem"
                                            }}
                                        >
                                            {errors.employment_type}
                                        </small>
                                    )}
                            </div>
                            <div>
                                <p>Salary Expectation</p>
                                <Dropdown
                                    options={salaryRanges}
                                    placeholderText="Salary Expectation"
                                    id={"salary_range"}
                                    value={values.salary_range}
                                    onChange={handleChange}
                                    onBlur={handleBlur}
                                />

                                {touched.salary_range && errors.salary_range && (
                                    <small
                                        style={{
                                            color: "#EB5757",
                                            paddingTop: "0.3rem"
                                        }}
                                    >
                                        {errors.salary_range}
                                    </small>
                                )}
                            </div>
                        </div>
                        <div className={formStyling.button}>
                            <BlueButton
                                width={310}
                                text={"Submit"}
                                type={"submit"}
                            />
                        </div>
                    </div>
                </form>
            </div>
            <Footer />
        </div>
    );
};

export default TryoutForm;
