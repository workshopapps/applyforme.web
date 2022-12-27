import classes from "../../../RR_Dashboard/styles/Applications.module.css";
import ApplicationList from "../application_list/ApplicationList";
// eslint-disable-next-line no-unused-vars
import {useNavigate } from "react-router-dom";
import RRDNav from "pages/RR_Dashboard/components/RRD_Nav";
import { useEffect, useState } from "react";
import axios from "axios";
import { useCallback } from "react";
import Spinner from "components/spinner/Spinner";

const DashboardHome = () => {
    const navigate = useNavigate();
    const [statValue, setStatValue] = useState({});
    const token = localStorage.getItem("tokenHngKey");
    const [isLoading, setIsLoading] = useState(true);
    const getStatisticsDetail = useCallback( async () => {
        try {
            const response = await axios.get(
                "https://api.applyforme.hng.tech/api/v1/recruiter/applicant/statistics",
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setStatValue(response?.data);
            setIsLoading(false);
        } catch (err) {
            setIsLoading(false);
            console.log(err?.response?.data);
        }
    },[token]);
    useEffect(() => {
        getStatisticsDetail();
    }, [ getStatisticsDetail]);

    if (isLoading) {
        return <Spinner/>;
    }
    
    return (
        <section>
            <RRDNav />
            <div className={classes.rrd_applications_wrapper}>
                {/* Greetings */}
                <div className={classes.greeting_text}>
                    <h1>Good evening Admin, 👋🏼</h1>
                    <p>Here is how you are fairing today</p>
                </div>

                <div className={classes.applications_stats_and_button}>
                    {/* Applications stat on cards */}
                    <div className={classes.applications_stats}>
                        <div className={classes.applications_stat}>
                            <h2 className={classes.stat_number}>{statValue?.total_applications}</h2>
                            <p className={classes.stat_text}>
                                Total Job Profiles
                            </p>
                        </div>

                        <div className={classes.applications_stat}>
                            <h2 className={classes.stat_number}>{statValue?.applied_jobs}</h2>
                            <p className={classes.stat_text}>Applied Jobs</p>
                        </div>

                        <div className={classes.applications_stat}>
                            <h2 className={classes.stat_number}>0</h2>
                            <p className={classes.stat_text}>
                                Quota for the day
                            </p>
                        </div>
                    </div>
                    {/* Job Applications Button */}

                    
                </div>

                {/* New Applications Container */}
                <div className={classes.new_applications_stats}>
                    <div className={classes.view_all_wrapper}>
                        <h2 className={classes.new_applications_stats_heading}>
                            New Submissions
                        </h2>

                        <button
                            className={`${classes.view_all} ${classes.desktop_only}`}
                            onClick={() =>
                                navigate("/rr_admin/all_applications")
                            }
                        >
                            View all
                        </button>
                    </div>
                    <ApplicationList />
                </div>
            </div>
        </section>
    );
};

export default DashboardHome;
