import { NavLink } from "react-router-dom";
import styles from "./Success.module.css";
import success from "../assets/success.png";
import TopBar from "../TopBar/TopBar";
import BlueButton from "../../../components/buttons/blue_background/BlueButton";

const Success = () => {
    return (
        <div className={styles.success_page}>
            <TopBar />
            <p>All done! You can view your new job profile</p>
            <div className={styles.success_message}>
                <img src={success} alt="completed" />
                <p>Congratulations Enwono,</p>
                <p>
                    Your profile is being matched to get you your dream job sit
                    back and wait for your interview. You can view submited
                    applications in “my applications”
                </p>
                <NavLink
                    to="/dashboard/user/profile-list"
                    style={{ textDecoration: "none" }}
                >
                    <BlueButton text={"Go to my job profile"} width={300} />
                </NavLink>
            </div>
        </div>
    );
};

export default Success;
