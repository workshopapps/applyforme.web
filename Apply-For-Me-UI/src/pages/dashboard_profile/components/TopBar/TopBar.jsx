import styles from "./TopBar.module.css";
import profilepic from "../../assets/profilepic.png";
import notif from "../../assets/notif.png";
import { Link } from "react-router-dom";

const TopBar = () => {
    return (
        <div className={styles.topbar}>
            <h4>My Job Profile</h4>
            <div className={styles.picture_container}>
                <Link to="/dashboard/settings">
                    <img
                        src={profilepic}
                        alt="profilepic"
                        className={styles.profilepic}
                    />
                </Link>
                <img src={notif} alt="notif" className={styles.notif} />
            </div>
        </div>
    );
};

export default TopBar;
