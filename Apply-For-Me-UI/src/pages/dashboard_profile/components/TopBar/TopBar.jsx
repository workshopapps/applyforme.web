import styles from "./TopBar.module.css";
// import profilepic from "../../assets/profilepic.png";
import notif from "../../assets/notif.png";
import { Link } from "react-router-dom";
import LetteredAvatar from "react-lettered-avatar";
import { useSelector } from "react-redux";

const TopBar = ({ title, style, subtitle, subStyle }) => {
    const { user } = useSelector(state => state.user);
    console.log(user);
    const userName = user.fullName;
    return (
        <div className={styles.topbar}>
            <div>
                <h4 style={style}>{title}</h4>
                <p style={subStyle}>{subtitle}</p>
            </div>
            <div className={styles.picture_container}>
                <img src={notif} alt="notif" className={styles.notif} />
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
