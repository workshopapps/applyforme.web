import styles from "./BackButton.module.css";
import { useNavigate } from "react-router-dom";
const BackButton = () => {
    const navigate = useNavigate();
    return (
        <div className={styles.back_button}>
            <button type="submit" onClick={() => navigate("/blog")}>
                <span>&lt;</span>
                <span>Back</span>
            </button>
        </div>
    );
};

export default BackButton;
