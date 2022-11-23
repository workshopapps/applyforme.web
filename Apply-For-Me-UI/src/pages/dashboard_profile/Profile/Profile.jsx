import TopBar from "../TopBar/TopBar";
import styles from "./Profile.module.css";
import { NavLink } from "react-router-dom";
import edit from "../assets/edit.png";
import add from "../assets/add.png";

const Profile = () => {
    const ProfileDetails = [
        {
            jobtitle: "Product Designer",
            id: 1,
            emailssent: 5,
            formsfilled: 3,
            jobtype: "Onsite, hybrid",
            location: "London"
        }
        // { jobtitle: "Product Designer", id: 2 },
    ];
    const CurrentProfile = ProfileDetails.map(oneprofile => (
        <div key={oneprofile.id} className={styles.each_profile}>
            <div className={styles.edit_box}>
                <img src={edit} alt="edit" />
                <div>
                    <h4>{oneprofile.jobtitle}</h4>
                    {/* <div className={styles.emails_forms}>
                        <p>{oneprofile.emailssent} emails sent </p>
                        <p>.</p>
                        <p>{oneprofile.formsfilled} forms filled</p>
                    </div> */}
                </div>
            </div>
            <h4>{oneprofile.jobtype}</h4>
            <h4>{oneprofile.location}</h4>
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
