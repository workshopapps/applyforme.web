import styles from "./DragDropFile.module.css";
import file from "../../../pages/dashboard_profile/assets/file.png";

const DragDropFile = ({ onChange }) => {
    return (
        <div>
            <label htmlFor="cv" className={styles.drop_container}>
                <img src={file} alt="file" width={40} />
                <span className={styles.drop_title}>
                    <p>Drag n Drop here</p>
                    <p>Or</p>
                    <h5>Browse</h5>
                </span>
                <input
                    type="file"
                    id="cv"
                    // accept=".jpg, .jpeg, .png"
                    required
                    onChange={onChange}
                />
            </label>
        </div>
    );
};

export default DragDropFile;
