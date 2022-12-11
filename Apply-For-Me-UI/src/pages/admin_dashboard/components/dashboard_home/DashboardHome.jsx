import classes from "../../../RR_Dashboard/styles/Applications.module.css";
import ApplicationList from "../application_list/ApplicationList";
import { Link, useNavigate } from "react-router-dom";
// import axios from 'axios';
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";

const DashboardHome = () => {
    const navigate = useNavigate();
    // const getList = async () => {
    //     try {
    //         console.log("1234")
    //         const response = await axios.request({
    //             url: 'https://api.applyforme.hng.tech/api/v1/recruiter/application/entries?pageNo=0&pageSize=10&sortBy=id&sortDir=asc',
    //             method: 'GET',
    //             headers: { Authorization: `Bearer ${localStorage.getItem("tokenHngKey")}`}
    //         })
    
    //         console.log(response)
    //     } catch (error) {
    //         console.log(error)
    //     }
    //    }
    //    getList()
    return (
        <section>
            <RRD_Nav />
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
                            <h2 className={classes.stat_number}>100</h2>
                            <p className={classes.stat_text}>
                                Total Applications
                            </p>
                        </div>

                        <div className={classes.applications_stat}>
                            <h2 className={classes.stat_number}>60</h2>
                            <p className={classes.stat_text}>Applied Jobs</p>
                        </div>

                        <div className={classes.applications_stat}>
                            <h2 className={classes.stat_number}>23</h2>
                            <p className={classes.stat_text}>
                                Quota for the day
                            </p>
                        </div>
                    </div>
                    {/* Job Applications Button */}

                    <Link
                        className={classes.job_application_form_button}
                        to="/rr_admin/form"
                    >
                        Job Application Form
                    </Link>
                </div>

                {/* New Applications Container */}
                <div className={classes.new_applications_stats}>
                    <div className={classes.view_all_wrapper}>
                        <h2 className={classes.new_applications_stats_heading}>
                            New Applications <span>(23)</span>
                        </h2>

                        <button
                            className={`${classes.view_all} ${classes.desktop_only}`}
                            onClick={()=>navigate("/rr_admin/all_applications")}
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
