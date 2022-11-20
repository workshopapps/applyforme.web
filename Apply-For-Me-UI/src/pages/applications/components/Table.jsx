import styles from "../Applications.module.css";
import { AiOutlineSearch } from "react-icons/ai";
import { IoFilterOutline } from "react-icons/io5";
import { HiOutlineChevronLeft, HiOutlineChevronRight } from "react-icons/hi2";
import Dropdown from "./Dropdown";

const Table = () => {
    return (
        <div className={styles.applications_table_wrapper}>
            <div className={styles.applications_table_header}>
                <form
                    className={styles.applications_search_form}
                    onSubmit={e => e.preventDefault()}
                >
                    <input type="search" placeholder="Search..." />
                    <AiOutlineSearch />
                </form>
                <div>
                    <IoFilterOutline />
                    <Dropdown />
                </div>
            </div>
            <div className={styles.applications_table_container}>
                <table>
                    <thead>
                        <tr className={styles.applications_table_head_row}>
                            <th>Company</th>
                            <th>Job title</th>
                            <th>Location</th>
                            <th>Salary Range</th>
                            <th>Job Duration</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr className={styles.applications_table_body_row}>
                            <td>Curberto</td>
                            <td>Lead UX Researcher</td>
                            <td>London</td>
                            <td>$3000+/m</td>
                            <td>Contract</td>
                            <td>10 Nov, 2021</td>
                        </tr>
                        <tr className={styles.applications_table_body_row}>
                            <td>Figmin</td>
                            <td>Lead UX Researcher</td>
                            <td>New York</td>
                            <td>$3000/m</td>
                            <td>Contract</td>
                            <td>10 Nov, 2021</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div className={styles.applications_footer}>
                <span>1-10/60</span>
                <span>
                    <HiOutlineChevronLeft />
                    <HiOutlineChevronRight />
                </span>
            </div>
        </div>
    );
};

export default Table;
