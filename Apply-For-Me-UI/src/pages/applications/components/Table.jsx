/* eslint-disable no-unused-vars */
import styles from "../Applications.module.css";
import { Link } from "react-router-dom";
import ApplicationsListHeader from "./ApplicationsListHeader";
import axios from "axios";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { ToastContainer, toast } from "react-toastify";
import { useCallback } from "react";
const Table = () => {
    const [data, setData] = useState();
    const [pageCount, setPageCout] = useState(1);
    const token = localStorage.getItem("tokenHngKey");
    const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10
    });
    const [searchValue, setSearchValue] = useState("");
    const [availableItems, setAvailableItems] = useState([]);

    const fetchApplicants = useCallback(async () => {
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all`,
                {
                    params: {
                        "pageNo": pagination.pageNo,
                        "pageSize": pagination.pageSize
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setData(response?.data?.content);
            setPageCout(response.data?.totalPages);
        } catch (error) {
            toast.error(`${error}`);
            console.log("thisis", JSON.stringify(error.response))
        }
    }, [token, pagination.pageNo, pagination.pageSize]);

    const sortOldestToNewest = async () => {
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all`,
                {
                    params: {
                        "pageNo": pagination.pageNo,
                        "pageSize": pagination.pageSize,
                        "sortDir": "desc"
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setData(response.data?.content);
            setPageCout(response.data?.totalPages);
        } catch (error) {
            console.error(`Could not get applicants: ${error}`);
        }
    };
    const sortNewestToOldest = async () => {
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all`,
                {
                    params: {
                        "pageNo": pagination.pageNo,
                        "pageSize": pagination.pageSize,
                        "sortDir": "asc"
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setData(response.data?.content);
            setPageCout(response.data?.totalPages);
        } catch (error) {
            console.error(`Could not get applicants: ${error}`);
        }
    };

    useEffect(() => {
        fetchApplicants();
    }, [fetchApplicants]);

    useEffect(() => {
        const search = data?.filter(item =>
            item.jobTitle.toLowerCase().includes(searchValue)
        );
        setAvailableItems(search);
    }, [searchValue, data]);

    const handlePageClick = data => {
        setPagination(prevState => ({ ...prevState, "pageNo": data.selected }));
        fetchApplicants();
    };
    return (
        <div className={styles.applications_table_wrapper}>
            <ApplicationsListHeader
                sortOldestToNewest={sortOldestToNewest}
                sortNewestToOldest={sortNewestToOldest}
                setSearchValue={setSearchValue}
            />
            <ToastContainer />
            <div className={styles.applications_table_container}>
                <table>
                    <thead>
                        <tr className={styles.applications_table_head_row}>
                            <th>Company</th>
                            <th>Job title</th>
                            <th className={styles.hide_tablet}>State</th>
                            <th className={styles.hide_tablet}>Job Type</th>
                            <th>Date</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {availableItems?.map?.((application, index) => (
                            <tr
                                className={styles.applications_table_body_row}
                                key={index}
                            >
                                <td>
                                    <div className={styles.show_tablet}>
                                        {application.jobCompany}
                                    </div>
                                </td>
                                <td>
                                    <div className={styles.show_tablet}>
                                        {application.jobTitle}
                                    </div>
                                </td>
                                <td className={styles.hide_tablet}>
                                    {application.jobLocation}
                                </td>
                                <td className={styles.hide_tablet}>
                                    {application?.jobLocationType}
                                </td>
                                <td>
                                    <div className={styles.show_tablet}>
                                        {application.createdOn
                                            ?.split("T")
                                            .shift()}
                                    </div>
                                </td>
                                <td>
                                    <div className={styles.show_tablet}>
                                        <Link
                                            to={`/dashboard/applications/${application.id}`}
                                            style={{
                                                textDecoration: "none",
                                                color: "darkslategray",
                                                padding: "0.5rem",
                                                border: "1px solid darkslategray",
                                                borderRadius: "5px",
                                                fontSize: "14px"
                                            }}
                                        >
                                            view
                                        </Link>
                                    </div>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            {pageCount > 1 && (
                <div>
                    <ReactPaginate
                        breakLabel="..."
                        nextLabel=">"
                        pageRangeDisplayed={5}
                        pageCount={pageCount}
                        marginPagesDisplayed="1"
                        previousLabel="<"
                        renderOnZeroPageCount={null}
                        onPageChange={handlePageClick}
                        containerClassName="containerClassName"
                        pageClassName="pageClassName"
                        previousClassName="previousClassName"
                        activeClassName="activeClassName"
                        nextClassName="nextClassName"
                        pageLinkClassName="pageLinkClassName"
                    />
                </div>
            )}
        </div>
    );
};

export default Table;
