import React from "react";
import { FiChevronDown, FiChevronRight, FiChevronLeft } from "react-icons/fi";
import { useSelector } from "react-redux";
import classes from "./UserPage.module.css";
// import { Users } from "./user_page_service/UserPageService";
const UsersPage = () => {

    const applicantList = useSelector((state) => state.RRadmin)
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
                        {(applicantList.applicantList.content.length!==0) && applicantList.applicantList.content.map((list) => {
                            {/* ({
                                id,
                                name,
                                interviews,
                                plan,
                                applicationDone,
                                email */}
                            return (
                                <tr className={classes.user_details} key={list.membership.id}>
                                    <td>{list.membership.firstName}</td>
                                    <td className={classes.hide_on_mobile}>
                                        {" "}
                                        {list.membership.emailAddress}
                                    </td>
                                    <td>basic</td>
                                    <td>{list.totalSubmissions} of 15</td>
                                    <td className={classes.hide_on_mobile}>
                                        15
                                    </td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>

                <section className={classes.pagination}>
                    <p>1-6 of 50</p>
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
