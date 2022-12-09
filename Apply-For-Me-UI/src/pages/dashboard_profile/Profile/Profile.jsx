import TopBar from "../components/TopBar/TopBar";
import styles from "./Profile.module.css";
import { Link, NavLink } from "react-router-dom";
import add from "../assets/add.png";

// eslint-disable-next-line no-unused-vars
const Profile = () => {
    const ProfileDetails = [
        {
            jobtitle: "Product Designer",
            id: 1,
            jobtype: "Hybrid",
            location: "London"
        },
        {
            jobtitle: "Game Developer",
            id: 2,
            jobtype: "Remote",
            location: "Nigeria"
        },
        {
            jobtitle: "Musician",
            id: 3,
            jobtype: "Remote",
            location: "Ghana"
        }
    ];
    const CurrentProfile = ProfileDetails.map(oneprofile => (
        <div key={oneprofile.id} className={styles.each_profile}>
            <div className={styles.edit_box}>
                <h3>{oneprofile.jobtitle}</h3>
                <div className={styles.job_deets}>
                    <p>{oneprofile.jobtype}</p>
                    <p>{oneprofile.location}</p>
                </div>
                <Link to={`/dashboard/user/${oneprofile.id}`}>See details</Link>
            </div>
        </div>
    ));

    return (
        <div className={styles.profile_page}>
            <TopBar />
            <NavLink
                to="/dashboard/user/create-profile"
                style={{ textDecoration: "none" }}
            >
                <button className={styles.createjob_button}>
                    <p>Create a job profile</p>
                    <img src={add} alt="add" />
                </button>
            </NavLink>
            <div>{CurrentProfile}</div>
        </div>
    );
};

export default Profile;
