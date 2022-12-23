import styles from "./AddKeyWord.module.css";
import Input from "../InputField/InputField.jsx";

const AddKeyword = ({ keywords, setKeywords }) => {
    function handleKeyDown(e) {
        if (e.key !== "Enter") return;
        const value = e.target.value;
        if (!value.trim()) return;

        let same = false;
        console.log(same);
        keywords?.forEach(k => {
            if (value === k) {
                same = true;
            }
        });
        // same ? null : setKeywords([...keywords, value]);
        if (keywords.length <= 1) {
            setKeywords([...keywords, value]);
        }
        e.target.value = "";
    }
    function removeKeyWord(index) {
        setKeywords(keywords?.filter((el, i) => i !== index));
    }
    return (
        <div className={styles.keywords_input_container}>
            <div>
                <Input
                    type="text"
                    onKeyDown={handleKeyDown}
                    className={styles.keyword_input}
                    placeholder="type a keyword"
                    width={100}
                />
                <h5>Type keyword and press Enter (Max. 2 keywords)</h5>
            </div>
            {keywords?.map((keyword, index) => (
                <div
                    key={`${keyword.keyword}+${index}`}
                    className={styles.keyword_item}
                >
                    <span className={styles.text}>{keyword}</span>
                    <span
                        className={styles.close}
                        onClick={() => removeKeyWord(index)}
                    >
                        &times;
                    </span>
                </div>
            ))}
        </div>
    );
};

export default AddKeyword;
