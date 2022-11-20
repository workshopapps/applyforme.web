import { Link } from "react-router-dom";
import DarkBlueButton from "../../buttons/dark_blue_button/DarkBlueButton";
import style from "./deleteAccount.module.css";

const DeleteAccountModal = () => {
    return (
        <div className={style.wrapper}>
            <h2 className={style.heading}>Delete your Account</h2>
            <p className={style.contentText}>We're sorry to see you go</p>
            <p className={style.contentText2}>Before you go</p>

            <ul className={style.list}>
                <li>
                    Are you tired of getting email Notifications from us, you
                    can{" "}
                    <Link to="/" className={style.link}>
                        disable them here
                    </Link>
                </li>
                <li>
                    If you want to edit your profile, you can{" "}
                    <Link to="/" className={style.link}>
                        do that here
                    </Link>
                </li>
                <li>
                    Account deletion is final. There will be no way to restore
                    your account.
                </li>
            </ul>
            <div className={style.button_wrapper}>
                <DarkBlueButton text="Never mind, Keep my account " />
                <button type="button" className={style.delete}>
                    Delete my Account
                </button>
            </div>
        </div>
    );
};

export default DeleteAccountModal;
