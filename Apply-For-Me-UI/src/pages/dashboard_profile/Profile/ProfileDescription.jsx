import { useNavigate, useParams } from "react-router-dom";
import styles from "./Profile.module.css";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";

export default function ProfileDescription() {
    const { id } = useParams();
    const navigate = useNavigate();
    return (
        <div className={styles.profile_description}>
            <TopBar />
            <p>{id}</p>
            <button onClick={() => navigate(-1)} className={styles.prev_btn}>
                &lt; Go back
            </button>
            <div className={styles.profiledesc_details}>
                <h6>Job Profile Info</h6>
                <div>
                    <p>not specified yet</p>
                    <h5>Job Title</h5>
                </div>
                <div>
                    <p>not specified yet</p>
                    <h5>Job Location</h5>
                </div>
                <div>
                    <p>none specified</p>
                    <h5>Experience</h5>
                </div>
                <div>
                    <p>none specified</p>
                    <h5>Employment Type</h5>
                </div>
                <div>
                    <p>none specified</p>
                    <h5>Salary Expectation</h5>
                </div>
                <div>
                    <p>not uploaded yet</p>
                    <h5>Uploaded CV</h5>
                </div>
                <div>
                    <p>none yet</p>
                    <h5>Cover letter subject</h5>
                </div>
                <div>
                    <p>Dear, idjisnb </p>
                    <h5>Cover letter body</h5>
                </div>
            </div>
        </div>
    );
}
