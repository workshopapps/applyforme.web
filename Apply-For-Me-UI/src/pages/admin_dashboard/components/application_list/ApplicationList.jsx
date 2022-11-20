import style from "./ApplicationList.module.css";

import { Link } from "react-router-dom";

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
    return (
        <div className={style.list_list}>
            <ul>
                <li>Name</li>
                <li>Job title</li>
                <li>Plan</li>
                <li>Salary</li>
                <li>Type</li>
                <li>Details</li>
            </ul>
            {list.map((entry, i) => {
                return (
                    <ul key={i}>
                        <li>{entry.name}</li>
                        <li>{entry.jobTitle}</li>
                        <li>{entry.plan}</li>
                        <li>{entry.salary}</li>
                        <li>{entry.type}</li>
                        <li>
                            <Link to="/dashboard/admin/details">{entry.details}</Link>
                        </li>
                    </ul>
                );
            })}
        </div>
    );
};
export default ApplicationList;
