import style from "./welcome.module.css";
import DarkBlueButton from "../../buttons/dark_blue_button/DarkBlueButton";

const WelcomeModal = ({ user }) => {
    return (
        <div className={style.container}>
            <h2 className={style.heading}>
                Welcome, {user ? user : "Matthew"}
            </h2>
            <p className={style.text_content}>
                apply for me is an easy to understand service where we apply for
                jobs for you while you continue with your busy schedules
            </p>

            <DarkBlueButton text="continue" classes={style.button} />
        </div>
    );
};

export default WelcomeModal;
