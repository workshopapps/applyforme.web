import { BsChevronLeft } from "react-icons/bs";
import { Link } from "react-router-dom";
import styles from "./goback.module.css";

const GoBackMobile = () => {
    return (
        <div className={styles.containers}>
            <Link to="/" className={styles.buttons}>
                <BsChevronLeft />
                Go back to the homepage
            </Link>
        </div>
    );
};

export default GoBackMobile;