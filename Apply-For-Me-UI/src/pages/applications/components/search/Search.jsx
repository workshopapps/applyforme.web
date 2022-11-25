import styles from "./Search.module.css";
import { AiOutlineSearch } from "react-icons/ai";

const Search = ({ value, onChange }) => {
    return (
        <form
            className={styles.applications_search_form}
            onSubmit={e => e.preventDefault()}
        >
            <input
                name="query"
                type="search"
                placeholder="Search..."
                value={value}
                onChange={e => onChange(e.currentTarget.value)}
            />
            <AiOutlineSearch />
        </form>
    );
};

export default Search;
