import styles from "../Applications.module.css";
import { HiOutlineChevronLeft, HiOutlineChevronRight } from "react-icons/hi2";
import { FaSortDown, FaSortUp } from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import { columns } from "../columns";
import { renderDate } from "../utils";
import React from "react";

const Table = ({ applications, sortColumn, handleSort, pageSize }) => {
    const navigate = useNavigate();
    const total = applications.length;

    function raiseSort(path) {
        if (sortColumn.path === path)
            sortColumn.order = sortColumn.order === "asc" ? "desc" : "asc";
        else {
            sortColumn.path = path;
            sortColumn.order = "asc";
        }
    }

    function renderSortIcon(column) {
        if (column.path !== sortColumn.path) return null;

        if (sortColumn.order === "asc") return <FaSortUp />;

        return <FaSortDown />;
    }
    return (
        <div className={styles.applications_table_wrapper}>
            <div className={styles.applications_table_container}>
                <table>
                    <thead>
                        <tr className={styles.applications_table_head_row}>
                            {columns.map(column => (
                                <th
                                    key={column.path}
                                    className={
                                        column.label === "Location"
                                            ? styles.hide_tablet
                                            : column.label === "Job Duration"
                                            ? styles.hide_tablet
                                            : ""
                                    }
                                    onClick={() => {
                                        raiseSort(column.path);
                                        handleSort({
                                            path: column.path,
                                            order:
                                                sortColumn.order === "asc"
                                                    ? "desc"
                                                    : "asc"
                                        });
                                    }}
                                >
                                    {column.label} {renderSortIcon(column)}
                                </th>
                            ))}
                        </tr>
                    </thead>
                    <tbody>
                        {applications.length > 0 ? (
                            applications.map((application, index) => (
                                <tr
                                    className={
                                        styles.applications_table_body_row
                                    }
                                    key={`${application.company}-${index}`}
                                    onClick={() =>
                                        navigate(
                                            `/dashboard/applications/${application.id}`
                                        )
                                    }
                                >
                                    <td>
                                        <div>{application.company}</div>
                                        <div className={styles.show_tablet}>
                                            {application.location}
                                        </div>
                                    </td>
                                    <td>
                                        <div>{application.jobTitle}</div>
                                        <div className={styles.show_tablet}>
                                            {application.jobType}
                                        </div>
                                    </td>
                                    <td className={styles.hide_tablet}>
                                        {application.location}
                                    </td>
                                    <td>{application.salaryRange}</td>
                                    <td className={styles.hide_tablet}>
                                        {application.jobDuration}
                                    </td>
                                    <td>{renderDate(application.date)}</td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td
                                    colSpan={columns.length}
                                    style={{
                                        textAlign: "center"
                                    }}
                                >
                                    Nothing to Display
                                </td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>

            <div className={styles.applications_footer}>
                <span>
                    {`1-${pageSize < total ? pageSize : total}`}/{total}
                </span>
                <span>
                    <HiOutlineChevronLeft />
                    <HiOutlineChevronRight />
                </span>
            </div>
        </div>
    );
};

export default Table;
