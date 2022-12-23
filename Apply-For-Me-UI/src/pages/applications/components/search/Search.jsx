import styles from "./Search.module.css";
import { AiOutlineSearch } from "react-icons/ai";

const Search = ({setSearchValue}) => {
    const handleChange = (e)=>{
        setSearchValue(e.target.value);
    }
    return (
        <form
            className={styles.applications_search_form}
            onSubmit={e => e.preventDefault()}
        >
            <AiOutlineSearch />
            <input type="search" placeholder="Search..." onChange={handleChange}/>
        </form>
    );
};

export default Search;
