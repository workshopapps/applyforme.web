import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import formStyling from "./TryoutForm.module.css";
import Input from "./components/Input";
import BlueButton from "components/buttons/blue_background/BlueButton";
import Dropdown from "./Dropdown/Dropdown";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const TryoutForm = () => {
    const [countries, setCountries] = useState();
    const navigate = useNavigate();
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
    return (
        <div>
            <Nav />
            <div className={formStyling.form_wrapper}>
                <form action="" onSubmit={e => e.preventDefault()}>
                    <p className={formStyling.personal_info}>
                        Please fill in your personal information below
                    </p>
                    <Input placeholder={"First name"} />
                    <Input placeholder={"Last name"} />
                    <Input placeholder={"Email address"} />
                    <Input placeholder={"Phone number"} />
                    <div className={formStyling.details}>
                        <p className={formStyling.personal_info}>
                            Complete your desired job info and location for our
                            job search.
                        </p>
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
                                {
                                    label: "Game developer",
                                    value: "Game developer"
                                },
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
                                {
                                    label: "UX researcher",
                                    value: "UX researcher"
                                }
                            ]}
                            width={100}
                            placeholderText="Job Title"
                        />
                        <span>
                            This job title will be used to find jobs around the
                            web
                        </span>
                        <Dropdown
                            options={countryNames}
                            width={100}
                            placeholderText="Job Location"
                        />
                        <span>Type a city or a country</span>

                        <div className={formStyling.checkbox}>
                            <input type="checkbox" name="" id="" />{" "}
                            <label className={formStyling.only_remote}>
                                I want only remote jobs
                            </label>
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
                                />
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
                                />
                            </div>
                            <div>
                                <p>Salary Expectation</p>
                                <Dropdown
                                    options={[
                                        {
                                            label: "$3,000-$5,000",
                                            value: "$3,000-$5,000"
                                        },
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
                                />
                            </div>
                        </div>
                        <div className={formStyling.button}>
                            <BlueButton
                                width={310}
                                text={"Submit"}
                                func={() => {
                                    setTimeout(() => {
                                        navigate("/tryout-form/success");
                                    }, 1500);
                                }}
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
