import React from "react";
import { FiChevronDown, FiChevronRight, FiChevronLeft } from "react-icons/fi";
import BlueButton from "../../components/buttons/blue_background/BlueButton";
import classes from "./UserPage.module.css";
import { Users } from "./user_page_service/UserPageService";
const UsersPage = () => {
    const handleApplicantView = id => {
        console.log(id);
    };
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
                            <th className={classes.hide_on_mobile}>
                                Interviews
                            </th>
                            <th>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        {Users.map(
                            ({
                                id,
                                name,
                                interviews,
                                plan,
                                applicationDone,
                                email
                            }) => (
                                <tr className={classes.user_details} key={id}>
                                    <td>{name}</td>
                                    <td className={classes.hide_on_mobile}>
                                        {" "}
                                        {email}
                                    </td>
                                    <td>{plan}</td>
                                    <td className={classes.hide_on_mobile}>
                                        {applicationDone}
                                    </td>
                                    <td className={classes.hide_on_mobile}>
                                        {interviews}
                                    </td>
                                    <td className={classes.desktop_button}>
                                        <BlueButton text="view" width="70" />
                                    </td>

                                    <td
                                        type="button"
                                        className={classes.mobile_button}
                                        onClick={() => handleApplicantView(id)}
                                    >
                                        View
                                    </td>
                                </tr>
                            )
                        )}
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
