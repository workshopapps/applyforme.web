import { BsChevronLeft } from "react-icons/bs";
import { Link } from "react-router-dom";
import styles from "./goback.module.css";

const GoBack = () => {
    return (
        <div className={styles.container}>
            <Link to="/" className={styles.button}>
                <BsChevronLeft />
                Go back to the homepage
            </Link>
        </div>
    );
};

export default GoBack;
