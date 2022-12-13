import classes from "../../../RR_Dashboard/styles/Applications.module.css";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from 'axios';


const ApplicationList = () => {
    const [listArray, setListArray] = useState();
    const token = localStorage.getItem("tokenHngKey");
       const getApplicationDetail = async () => {
           try {
               const response = await axios.get(
                   "https://api.applyforme.hng.tech/api/v1/professional-profile/entries/all",
                   {
                       headers: {
                           "Authorization": `Bearer ${token}`
                       }
                   }
               );
               console.log(response.data)
               setListArray(response.data.content);
               console.log(listArray);
           } catch (err) {
               console.log(err.response?.data);
           }
       };
       useEffect(() => {
        getApplicationDetail ();
       }, []);
       console.log(listArray);
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
               listArray?.length!== 0 ? (
                    listArray?.map((entry, i) => {
                        return (
                            // Entry Row
                            <ul className={classes.stats_row} key={i}>
                                <li
                                    className={`${classes.stats_item} ${classes.stats_name}`}
                                >
                                    {entry.profileTitle}
                                </li>
                                <li
                                    className={`${classes.stats_item} ${classes.desktop_only}`}
                                >
                                    {entry.desiredJobTitle}
                                </li>
                                <li
                                    className={`${classes.stats_item} ${classes.desktop_only}`}
                                >
                                    {entry.salaryRange}
                                </li>
                                <li
                                    className={`${classes.stats_item} ${classes.desktop_only}`}
                                >
                                    {entry.preferredJobLocationType}
                                </li>
                                <li
                                    className={`${classes.stats_item} ${classes.stats_details}`}
                                >
                                    <Link to={`/professional-profile/user/details/${entry.id}`} className={classes.stats_details_view_button}>
                                       view
                                    </Link>
                                </li>
                            </ul>
                        );
                    })
                ):<h3 style={{textAlign:"center"}}>No applications have being made</h3>
            }
        </div>
    );
};
export default ApplicationList;
