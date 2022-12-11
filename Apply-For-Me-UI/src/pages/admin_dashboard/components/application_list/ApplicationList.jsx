import classes from "../../../RR_Dashboard/styles/Applications.module.css";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from 'axios';


// const list = [
//     {
//         name: "Sharon Sunday",
//         jobTitle: "Product Design",
//         plan: "Premium",
//         salary: "$10,000 - $15,000",
//         type: "Remote",
//         details: "View"
//     },
//     {
//         name: "Sharon Sunday",
//         jobTitle: "Product Design",
//         plan: "Basic",
//         salary: "$10,000 - $15,000",
//         type: "Hybrid",
//         details: "View"
//     },
//     {
//         name: "Sharon Sunday",
//         jobTitle: "Product Design",
//         plan: "Standard",
//         salary: "$10,000 - $15,000",
//         type: "Remote",
//         details: "View"
//     },
//     {
//         name: "Michael Anu",
//         jobTitle: "Product Design",
//         plan: "Premium",
//         salary: "$10,000 - $15,000",
//         type: "On-site",
//         details: "View"
//     },
//     {
//         name: "Michael Anu",
//         jobTitle: "Product Design",
//         plan: "Basic",
//         salary: "$10,000 - $15,000",
//         type: "Remote",
//         details: "View"
//     },
//     {
//         name: "Michael Anu",
//         jobTitle: "Product Design",
//         plan: "Standard",
//         salary: "$10,000 - $15,000",
//         type: "Remote",
//         details: "View"
//     }
// ];

const ApplicationList = () => {
    // const [posts, setPosts] = useState([]);
    const [listArray, setListArray] = useState([]);


    const getList = async () => {
        try {
            // console.log("1234")
            const response = await axios.request({
                url: 'https://api.applyforme.hng.tech/api/v1/recruiter/application/entries?pageNo=0&pageSize=10&sortBy=id&sortDir=asc',
                method: 'GET',
                headers: { Authorization: `Bearer ${localStorage.getItem("tokenHngKey")}`}
            })
    
            // console.log(response.data.content);
            setListArray(response.data.content)
        } catch (error) {
            console.log(error)
        }
       }
       useEffect(() => {
          getList();
       }, []);
      



       const ArrayCOntent = listArray.map((entry, i) => {
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
                            {entry.job_title}
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
                            {entry.job_type}
                        </li>
                        <li
                            className={`${classes.stats_item} ${classes.stats_details}`}
                        >
                            <Link
                                to="/rr_admin/appilicants_details"
                                className={classes.stats_details_view_button}
                            >
                                {/* {entry.details} */}view
                            </Link>
                        </li>
                    </ul>
                );
            });

    // useEffect(() => {
    //     instance
    //         .get("https://api.applyforme.hng.tech/api/v1/recruiter/application/entries")
    //         .then(response => {
    //             console.log(response);
    //         })
    //         .catch(err => console.log(err));
    // }, []);

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


            {
                listArray.length=== 0 ? <div style={{textAlign:"center"}}>The list is empty</div> : {ArrayCOntent}
            }

            
        </div>
    );
};
export default ApplicationList;
