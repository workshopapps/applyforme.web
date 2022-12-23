import styles from "./DragDropFile.module.css";
import file from "../../assets/file.png";

const DragDropFile = ({ onChange }) => {
    return (
        <div>
            <label htmlFor="cv" className={styles.drop_container}>
                <img src={file} alt="file" className={styles.file_image} />
                <span className={styles.drop_title}>
                    <p>Drag n Drop here</p>
                    <p>Or</p>
                    <h5>Browse</h5>
                </span>
                <input
                    type="file"
                    id="cv"
                    accept="application/pdf, .doc,.docx"
                    required
                    onChange={onChange}
                />
            </label>
        </div>
    );
};

export default DragDropFile;
