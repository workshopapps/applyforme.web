import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";
// import avatar from "./img/avatar.png";
// import notification from "./img/notification.png";
import "./DashboardNothing.css";
import GoBackMobile from "./GoBackMobile";
import axios from "axios";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";

const NewUserDashboard = () => {
    const { user } = useSelector(state => state.user);
    const username = user.fullName;
    const userName = username?.split(" ")[0];
    const token = localStorage.getItem("tokenHngKey");
    const [statValue, setStatValue] = useState();
    const getStatisticsDetail = async () => {
        try {
            const response = await axios.get(
                "https://api.applyforme.hng.tech/api/v1/member/stats",
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setStatValue(response?.data);
        } catch (err) {
            console.log(err?.response?.data);
        }
    };
    useEffect(() => {
        getStatisticsDetail();
    }, []);
    return (
        <div className="dashboardnothing">
            {/* this is the top stripe */}

            <TopBar
                title={`Welcome ${userName},`}
                style={{
                    width: "100%",
                    marginTop: "auto",
                    color: "#2e3192",
                    fontWeight: "700",
                    marginLeft: "2.5rem"
                }}
                subtitle={`Let's get started`}
            />

            <hr></hr>

            {/* section for overview */}

            <section className="dashboard-overview">
                <GoBackMobile />
                <h5>Overview</h5>

                <div className="overview-cards-wrapper">
                    <div className="overview-card-wrapper">
                        <div className="overview-card">
                            <h3>{statValue?.total_number_of_profile}</h3>
                            <p>Total Submissions</p>
                        </div>
                    </div>

                    <div className="overview-card-wrapper">
                        <div className="overview-card">
                            <h3>0</h3>
                            <p>Completed Interview</p>
                        </div>
                    </div>

                    <div className="overview-card-wrapper">
                        <div className="overview-card">
                            <h3>{statValue?.total_number_of_profile}</h3>
                            <p>Totals Applications</p>
                        </div>
                    </div>

                    <div className="mobile-create">
                        <span> Welcome, you have no job profile yet Tap </span>
                        <span>
                            {" "}
                            <Link to="/dashboard/user/create-profile">
                                {" "}
                                <button> + </button>{" "}
                            </Link>{" "}
                        </span>
                        <span>to create a new job profile</span>
                    </div>
                </div>
            </section>

            {/* section for nothing to see here */}

            <section className="nothing-to-see-here">
                <div className="normal-create">
                    Nothing to see here
                    <Link to="/dashboard/user/create-profile">
                        <button>Create a Job Profile +</button>
                    </Link>{" "}
                    to get started
                </div>
            </section>
        </div>
    );
};

export default NewUserDashboard;
