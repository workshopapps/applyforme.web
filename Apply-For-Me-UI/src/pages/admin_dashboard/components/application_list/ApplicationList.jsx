import classes from "../../../RR_Dashboard/styles/Applications.module.css";
import { useEffect } from "react";
import { Link } from "react-router-dom";
import instance from "../axios/axios";

const list = [
    {
        name: "Sharon Sunday",
        jobTitle: "Product Design",
        plan: "Premium",
        salary: "$10,000 - $15,000",
        type: "Remote",
        details: "View"
    },
    {
        name: "Sharon Sunday",
        jobTitle: "Product Design",
        plan: "Basic",
        salary: "$10,000 - $15,000",
        type: "Hybrid",
        details: "View"
    },
    {
        name: "Sharon Sunday",
        jobTitle: "Product Design",
        plan: "Standard",
        salary: "$10,000 - $15,000",
        type: "Remote",
        details: "View"
    },
    {
        name: "Michael Anu",
        jobTitle: "Product Design",
        plan: "Premium",
        salary: "$10,000 - $15,000",
        type: "On-site",
        details: "View"
    },
    {
        name: "Michael Anu",
        jobTitle: "Product Design",
        plan: "Basic",
        salary: "$10,000 - $15,000",
        type: "Remote",
        details: "View"
    },
    {
        name: "Michael Anu",
        jobTitle: "Product Design",
        plan: "Standard",
        salary: "$10,000 - $15,000",
        type: "Remote",
        details: "View"
    }
];

const ApplicationList = () => {
    // const [posts, setPosts] = useState([]);

    useEffect(() => {
        instance
            .get("/api/v1/recruiter/application/entries")
            .then(response => {
                console.log(response);
            })
            .catch(err => console.log(err));
    }, []);

    return (
        // Application stats Table
        <div className={classes.new_applications_stats_table}>
            {/* Heading Row */}
            <ul className={classes.stats_row}>
                <li
                    className={`${classes.stats_heading} ${classes.stats_name}`}
                >
                    Name
                </li>
                <li
                    className={`${classes.stats_heading} ${classes.desktop_only}`}
                >
                    Job title
                </li>
                <li
                    className={`${classes.stats_heading} ${classes.stats_plan}`}
                >
                    Plan
                </li>
                <li
                    className={`${classes.stats_heading} ${classes.desktop_only}`}
                >
                    Salary
                </li>
                <li
                    className={`${classes.stats_heading} ${classes.desktop_only}`}
                >
                    Type
                </li>
                <li
                    className={`${classes.stats_heading} ${classes.stats_details}`}
                >
                    Details
                </li>
            </ul>

            {list.map((entry, i) => {
                return (
                    // Entry Row
                    <ul className={classes.stats_row} key={i}>
                        <li
                            className={`${classes.stats_item} ${classes.stats_name}`}
                        >
                            {entry.name}
                        </li>
                        <li
                            className={`${classes.stats_item} ${classes.desktop_only}`}
                        >
                            {entry.jobTitle}
                        </li>
                        <li
                            className={`${classes.stats_item} ${classes.stats_plan}`}
                        >
                            {entry.plan}
                        </li>
                        <li
                            className={`${classes.stats_item} ${classes.desktop_only}`}
                        >
                            {entry.salary}
                        </li>
                        <li
                            className={`${classes.stats_item} ${classes.desktop_only}`}
                        >
                            {entry.type}
                        </li>
                        <li
                            className={`${classes.stats_item} ${classes.stats_details}`}
                        >
                            <Link
                                to="/dashboard/admin/details"
                                className={classes.stats_details_view_button}
                            >
                                {entry.details}
                            </Link>
                        </li>
                    </ul>
                );
            })}
        </div>
    );
};
export default ApplicationList;
