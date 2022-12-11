import React from "react";
import classes from "../styles/Applications.module.css";
import axios from 'axios';


const names = [
    "Sharon Sunday",
    "Sharon Sunday",
    "Sharon Sunday",
    "Michael Anu",
    "Michael Anu",
    "Michael Anu",
    "Michael Anu"
];

const plans = [
    "Premium",
    "Basic",
    "Standard",
    "Premium",
    "Basic",
    "Standard",
    "Standard"
];

const types = [
    "Remote",
    "Hybrid",
    "Remote",
    "On-site",
    "On-site",
    "Remote",
    "Remote"
];

const Applications = () => {
    const [newApplication, setNewApplication] = useState();

   const getList = async () => {
    try {
        console.log("1234")
        const response = await axios.get({
            url: 'https://api.applyforme.hng.tech/api/v1/recruiter/applicant/entries?pageNo=0&sortBy=id&sortDir=asc&from=11-11-22&to=12-12-22&q=a',
            // method: GET,
            // headers: { Authorization: `Bearer ${localStorage.getItem("tokenHngKey")}`}
        })

        console.log(response)
        setNewApplication(response)
    } catch (error) {
        console.log(error)
    }
   }
   useEffect(()=>{
       getList();
   }, [])
    return (
        <section>
            <div className={classes.rrd_applications_wrapper}>
                {/* Greetings */}
                <div className={classes.greeting_text}>
                    <h1>Good evening Admiaaaaaaan, 👋🏼</h1>
                    <p>Here is how you are fairing today</p>
                </div>
                {/* Applications stat on cards */}
                <div className={classes.applications_stats}>
                    <div className={classes.applications_stat}>
                        <h2 className={classes.stat_number}>100</h2>
                        <p className={classes.stat_text}>Total Applications</p>
                    </div>

                    <div className={classes.applications_stat}>
                        <h2 className={classes.stat_number}>60</h2>
                        <p className={classes.stat_text}>Applied Jobs</p>
                    </div>

                    <div className={classes.applications_stat}>
                        <h2 className={classes.stat_number}>23</h2>
                        <p className={classes.stat_text}>Quota for the day</p>
                    </div>
                </div>
                {/* Job Applications Button */}
                <button className={classes.job_application_form_button}>
                    Job Application Form
                </button>
                {/* New Applications Container */}
                <div className={classes.new_applications_stats}>
                    <div className={classes.view_all_wrapper}>
                        <h2 className={classes.new_applications_stats_heading}>
                            New Applications <span>{.length}</span>
                        </h2>

                        <button
                            className={`${classes.view_all} ${classes.desktop_only}`}
                        >
                            View all
                        </button>
                    </div>

                    <div className={classes.new_applications_stats_table}>
                        <div className={classes.stats_name}>
                            <ul>
                                <li
                                    className={classes.stats_heading}
                                    key={"heading"}
                                >
                                    Names
                                </li>

                                {/* render names from array */}
                                {names.map((name, index) => (
                                    <>
                                        <li
                                            key={index}
                                            className={classes.stats_item}
                                        >
                                            {name}
                                        </li>
                                        <div
                                            className={classes.stats_border_fix}
                                        ></div>
                                    </>
                                ))}
                            </ul>
                        </div>
                        <div
                            className={`${classes.stats_job_title} ${classes.desktop_only}`}
                        >
                            <ul>
                                <li
                                    className={classes.stats_heading}
                                    key={"heading"}
                                >
                                    Job title
                                </li>

                                {/* render same content for every element in the name array */}
                                {names.map((name, index) => (
                                    <>
                                        <li
                                            key={index}
                                            className={classes.stats_item}
                                        >
                                            Product Design
                                        </li>
                                        <div
                                            className={classes.stats_border_fix}
                                        ></div>
                                    </>
                                ))}
                            </ul>
                        </div>
                        <div className={classes.stats_plan}>
                            <ul>
                                <li
                                    className={classes.stats_heading}
                                    key={"heading"}
                                >
                                    Plan
                                </li>

                                {/* render plans from array */}
                                {plans.map((plan, index) => (
                                    <>
                                        <li
                                            key={index}
                                            className={classes.stats_item}
                                        >
                                            {plan}
                                        </li>
                                        <div
                                            className={classes.stats_border_fix}
                                        ></div>
                                    </>
                                ))}
                            </ul>
                        </div>
                        <div
                            className={`${classes.stats_salary} ${classes.desktop_only}`}
                        >
                            <ul>
                                <li
                                    className={classes.stats_heading}
                                    key={"heading"}
                                >
                                    Salary
                                </li>

                                {/* render same content for every element in the name array */}
                                {names.map((name, index) => (
                                    <>
                                        <li
                                            key={index}
                                            className={classes.stats_item}
                                        >
                                            $10,000 - $15,000
                                        </li>
                                        <div
                                            className={classes.stats_border_fix}
                                        ></div>
                                    </>
                                ))}
                            </ul>
                        </div>
                        <div
                            className={`${classes.stats_type} ${classes.desktop_only}`}
                        >
                            <ul>
                                <li
                                    className={classes.stats_heading}
                                    key={"heading"}
                                >
                                    Type
                                </li>

                                {/* render type from array */}
                                {types.map((type, index) => (
                                    <>
                                        <li
                                            key={index}
                                            className={classes.stats_item}
                                        >
                                            {type}
                                        </li>
                                        <div
                                            className={classes.stats_border_fix}
                                        ></div>
                                    </>
                                ))}
                            </ul>
                        </div>
                        <div className={classes.stats_details}>
                            <ul>
                                <li
                                    className={classes.stats_heading}
                                    key={"heading"}
                                >
                                    Details
                                </li>

                                {/* render same content for every element in the name array */}
                                {names.map((name, index) => (
                                    <>
                                        <li
                                            key={index}
                                            className={classes.stats_item}
                                        >
                                            <button
                                                className={
                                                    classes.stats_details_view_button
                                                }
                                            >
                                                View
                                            </button>
                                        </li>
                                        <div
                                            className={classes.stats_border_fix}
                                        ></div>
                                    </>
                                ))}
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
};

export default Applications;
