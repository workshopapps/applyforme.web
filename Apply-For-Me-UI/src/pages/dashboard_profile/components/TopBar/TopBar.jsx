import styles from "./TopBar.module.css";
// import profilepic from "../../assets/profilepic.png";
// import notif from "../../assets/notif.png";
import { Link } from "react-router-dom";
import LetteredAvatar from "react-lettered-avatar";
import { useSelector } from "react-redux";

const TopBar = ({ title, style, subtitle, subStyle }) => {
    const { user } = useSelector(state => state.user);

    const userName = user.fullName;
    return (
        <div className={styles.topbar}>
            <div className={styles.texts}>
                <h4 style={style} className={styles.heading}>
                    {title}
                </h4>
                <p style={subStyle} className={styles.sub_heading}>
                    {subtitle}
                </p>
            </div>
            <div className={styles.picture_container}>
                {/* <img src={notif} alt="notif" className={styles.notif} /> */}
                <Link to="/dashboard/settings">
                    {/* <img
                        src={profilepic}
                        alt="profilepic"
                        className={styles.profilepic}
                    /> */}
                    <LetteredAvatar
                        name={userName}
                        backgroundColor={"#78909c"}
                    />
                </Link>
            </div>
        </div>
    );
};

export default TopBar;
