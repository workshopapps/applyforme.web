import React from "react";
import { Link } from "react-router-dom";
import { useSelector } from "react-redux";
import avatar from "./img/avatar.png";
import notification from "./img/notification.png";
import "./DashboardNothing.css";
import GoBackMobile from "./GoBackMobile";

const NewUserDashboard = () => {
    const { user } = useSelector(state => state.user);
    const username = user.fullName;
    const userName = username?.split(" ")[0];
    return (
        <div className="dashboardnothing">
            {/* this is the top stripe */}

            <section className="top-dashboard-stripe">
                <div className="top-dashboard-left">
                    <h2>Welcome {userName},</h2>
                    <p>Let’s get started </p>
                </div>

                <div className="top-dashboard-right">
                    <div className="dashboard-img-wrapper">
                        <img src={notification} alt="icon" className="notif" />
                    </div>

                    <div className="dashboard-img-wrapper">
                        <Link to="/dashboard/settings">
                            <img
                                src={avatar}
                                alt="notification"
                                className="profilepic"
                            />
                        </Link>
                    </div>
                </div>
            </section>

            <hr></hr>

            {/* section for overview */}

            <section className="dashboard-overview">
                <GoBackMobile />
                <h5>Overview</h5>

                <div className="overview-cards-wrapper">
                    <div className="overview-card-wrapper">
                        <div className="overview-card">
                            <h3>0</h3>
                            <p>Total Application</p>
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
                            <h3>0</h3>
                            <p>Active Applications</p>
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
