import React from "react";
import { FiChevronDown } from "react-icons/fi";
import classes from "./UserPage.module.css";
const UsersPage = () => {
    return (
        <div className={classes.main_container}>
            <section className={classes.user_header}>
                <h4>All Applicants</h4>
                <div className={classes.month_year}>
                    <p>November, 2022</p>
                    <FiChevronDown />{" "}
                </div>
            </section>

            <section className={classes.applicant}>
                <table className={classes.table}>
                    <tr className={classes.table__head}>
                        <th>Name</th>
                        <th>Email Address</th>
                        <th>Plan</th>
                        <th>Application done</th>
                        <th>Interviews</th>
                        <th>Details</th>
                    </tr>
                    <hr className={classes.lines} />

                    <tr>
                        <td>Sharon Sunday</td>
                        <td>Sharon@gmail.com</td>
                        <td>Basic</td>
                        <td>8 of 5</td>
                        <td>15</td>
                        <td>Hello</td>
                    </tr>
                </table>
            </section>
        </div>
    );
};

export default UsersPage;
