import styles from "./TopBar.module.css";
import profilepic from "../../assets/profilepic.png";
import notif from "../../assets/notif.png";

const TopBar = () => {
    return (
        <div className={styles.topbar}>
            <h4>My Job Profile</h4>
            <div className={styles.picture_container}>
                <img
                    src={profilepic}
                    alt="profilepic"
                    className={styles.profilepic}
                />
                <img src={notif} alt="notif" className={styles.notif} />
            </div>
        </div>
    );
};

export default TopBar;
