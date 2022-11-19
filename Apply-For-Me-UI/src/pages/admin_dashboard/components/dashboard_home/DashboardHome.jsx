import style from "./DashboardHome.module.css";
import ApplicationList from "../application_list/ApplicationList";
import { Link } from "react-router-dom";

const DashboardHome = () => {
    return (
        <div className={style.dashboard}>
            <div className={style.header}>
                <h1>Good evening Admin, &#128075;</h1>
                <p>Here is how you are fairing today</p>
                <div className={style.summary}>
                    <p className={style.card}>
                        100
                        <br />
                        <p>Interviewed</p>
                    </p>
                    <p className={style.card}>
                        60
                        <br />
                        <p>Applied Jobs</p>
                    </p>
                    <p className={style.card}>
                        23
                        <br />
                        <p>Total Applications</p>
                    </p>
                    <button><Link to="/dashboard/application-form">Job application form</Link></button>
                </div>
            </div>
            <div className={style.list}>
                <div className={style.list_header}>
                    <p>New Applications (23)</p>
                    <p><Link to="/dashboard/applications">View all</Link></p>
                </div>
                <ApplicationList />
            </div>
        </div>
    );
};

export default DashboardHome;
