import styles from "./Search.module.css";
import { AiOutlineSearch } from "react-icons/ai";

const Search = () => {
    return (
        <form
            className={styles.applications_search_form}
            onSubmit={e => e.preventDefault()}
        >
            <AiOutlineSearch />
            <input type="search" placeholder="Search..." />
        </form>
    );
};

export default Search;
