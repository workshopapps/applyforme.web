import TopBar from "../components/TopBar/TopBar";
import styles from "./Profile.module.css";
import { Link, useNavigate } from "react-router-dom";
import add from "../assets/add.png";

// eslint-disable-next-line no-unused-vars
const Profile = ({ profileList }) => {
    const navigate = useNavigate();

    const CurrentProfile = profileList?.map(oneprofile => (
        <div key={oneprofile.id} className={styles.each_profile}>
            <div className={styles.edit_box}>
                <h3>{oneprofile.profileTitle}</h3>
                <div className={styles.job_deets}>
                    <p>{oneprofile.jobLocation}</p>
                    <p>{oneprofile.preferredJobLocationType}</p>
                </div>
                <Link
                    to={{
                        pathname: `/dashboard/user/${oneprofile.id}`,
                        state: { oneprofile }
                    }}
                >
                    See details
                </Link>
            </div>
        </div>
    ));

    return (
        <div className={styles.profile_page}>
            <TopBar />
            <button
                className={styles.createjob_button}
                onClick={() => navigate("/dashboard/user/create-profile")}
            >
                <p>Create a job profile</p>
                <img src={add} alt="add" />
            </button>
            <div>{CurrentProfile}</div>
        </div>
    );
};

export default Profile;
