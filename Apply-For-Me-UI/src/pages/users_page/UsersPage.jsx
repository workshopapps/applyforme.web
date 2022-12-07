import React from "react";
import { FiChevronDown, FiChevronRight, FiChevronLeft } from "react-icons/fi";
import { useSelector } from "react-redux";
import classes from "./UserPage.module.css";
const UsersPage = () => {
    const list = useSelector(state => state.RRadmin);
    console.log(list);
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
                    <thead>
                        <tr className={classes.table__head}>
                            <th>Name</th>
                            <th className={classes.hide_on_mobile}>
                                Email Address
                            </th>
                            <th>Plan</th>
                            <th className={classes.hide_on_mobile}>
                                Application done
                            </th>
                            <th className={classes.hide_header_desktop}>
                                Stat
                            </th>
                            <th className={classes.hide_on_mobile}>
                                Interviews
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {list.superAdminApplicantsList.length !== 0 &&
                            list.superAdminApplicantsList.content.map(list => {
                                return (
                                    <tr
                                        className={classes.user_details}
                                        key={list.membership.id}
                                    >
                                        <td>{list.membership.firstName}</td>
                                        <td className={classes.hide_on_mobile}>
                                            {" "}
                                            {list.membership.emailAddress}
                                            {list.membership.emailAddress}
                                        </td>
                                        <td>basic</td>
                                        <td>{list.totalSubmissions} of 15</td>
                                        <td>basic</td>
                                    </tr>
                                );
                            })}
                    </tbody>
                </table>

                <section className={classes.pagination}>
                    <p>
                        1-6 of{" "}
                        {list.superAdminApplicantsList.length !== 0 &&
                            list.superAdminApplicantsList.content.length}
                    </p>
                    <div className={classes.pagination__inc_dec}>
                        <FiChevronLeft />
                        <FiChevronRight />{" "}
                    </div>
                </section>
            </section>
        </div>
    );
};

export default UsersPage;
