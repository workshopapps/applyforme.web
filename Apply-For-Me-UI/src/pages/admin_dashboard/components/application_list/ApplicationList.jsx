import classes from "../../../RR_Dashboard/styles/Applications.module.css";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import '../../../RR_Dashboard/styles/Applications.module.css';
import axios from "axios";
import { useCallback } from "react";
import Spinner from "components/spinner/Spinner";

const ApplicationList = () => {
    const [listArray, setListArray] = useState();
    const [isLoading, setIsLoading] = useState(true);

    const token = localStorage.getItem("tokenHngKey");
    const getApplicationDetail = useCallback(async () => {
        try {
            const response = await axios.get(
                "https://api.applyforme.hng.tech/api/v1/professional-profile/entries/all",
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setListArray(response.data.content);
            setIsLoading(false);
        } catch (err) {
            console.log(err.response?.data);
        }
    }, [token]);
    useEffect(() => {
        getApplicationDetail();
    }, [getApplicationDetail]);

    if (isLoading) {
        return <Spinner />;
    }
    return (
        // Application stats Table
        <div className={classes.new_applications_stats_table}>
            <div className={classes.entry_mappping}>
                <h5 className={`${classes.entry_map} ${classes.mobile_opt}`}>Name</h5>
                <h5 className={`${classes.entry_maps} ${classes.mobile_option} ${classes.tab_option}`}>UserPlan</h5>
                <h5 className={`${classes.entry_maps} ${classes.mobile_opt}`}>Job Title</h5>
                <h5 className={`${classes.entry_maps} ${classes.mobile_option}`}>Salary</h5>
                <h5 className={`${classes.entry_maps} ${classes.mobile_option}`}>Type</h5>
                <h5 className={classes.entry_mapt}>Details</h5>
            </div>
            {listArray?.length !== 0 ? (
                listArray?.map((entry, i) => {
                    return (
                        <div className='entry_mapping' key={i}>
                            <div className={classes.entry_mappping}>
                                <div className={`${classes.entry_map} ${classes.mobile_opt}`}>
                                    <span style ={{paddingRight: '5px' }}>
                                        {entry.professional.member.firstName }
                                    </span>
                                    <span>
                                        {entry.professional.member.lastName }
                                    </span>
                                </div>
                                <div className={`${classes.entry_maps} ${classes.mobile_option} ${classes.tab_option}`}>Basic Plan</div>
                                <div className={`${classes.entry_maps} ${classes.mobile_opt}`}>{entry.profileTitle}</div>
                                <div className={`${classes.entry_maps} ${classes.mobile_option}`}>{entry.salaryRange}</div>
                                <div className={`${classes.entry_maps} ${classes.mobile_option}`}>{entry.preferredJobLocationType}</div>
                                <div className={classes.entry_mapt}>
                                    <Link
                                        to={`/professional-profile/user/details/${entry.id}`}
                                        className={
                                            classes.stats_details_view_button
                                        }
                                        style={{
                                            textDecoration: "none",
                                            color: "#2E3192",
                                            // padding: "0.5rem",
                                            // border: "1px solid darkslategray",
                                            // borderRadius: "5px"
                                        }}
                                    >
                                        view
                                    </Link>
                                </div>
                            </div>
                        </div>
                    );
                })
            ) : (
                <h3 style={{ textAlign: "center" }}>
                    No applications have being made
                </h3>
            )}
        </div>
    );
};
export default ApplicationList;