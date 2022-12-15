/* eslint-disable no-unused-vars */
import styles from "../Applications.module.css";
import { useNavigate } from "react-router-dom";
import ApplicationsListHeader from "./ApplicationsListHeader";
import axios from "axios";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { ToastContainer, toast } from "react-toastify";
const Table = () => {
    const [data, setData] = useState();
    const [pageCount, setPageCout] = useState(1);
    const navigate = useNavigate();
    const token = localStorage.getItem("tokenHngKey");
    const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10
    });
    //https://api.applyforme.hng.tech/api/v1/applicant/jobs-applied
    //https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all
    const fetchApplicants = async () => {
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all`,
                {
                    params: {
                        "pageNo": pagination.pageNo,
                        "pageSize": pagination.pageSize
                    },headers: {
                        "Authorization": `Bearer ${token}`
                    }
                    
                }
            );
            console.log(response.data)
            setData(response?.data?.content)
            setPageCout(response.data?.totalPages);
        } catch (error) {
            toast.error(`Could not get applicants: ${error}`);
        }
    };

    useEffect(() => {
        fetchApplicants();
    }, []);

    const handlePageClick = data => {
        setPagination(prevState => ({ ...prevState, "pageNo": data.selected }));
        fetchApplicants();
    };
    return (
        <div className={styles.applications_table_wrapper}>
            <ApplicationsListHeader />
            <ToastContainer />
            <div className={styles.applications_table_container}>
                <table>
                    <thead>
                        <tr className={styles.applications_table_head_row}>
                            <th>Company</th>
                            <th>Job title</th>
                            <th className={styles.hide_tablet}>State</th>
                            <th>Salary Range</th>
                            <th className={styles.hide_tablet}>Job Type</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data?.map?.((application, index) => (
                            <tr
                                className={styles.applications_table_body_row}
                                key={index}
                                onClick={()=>navigate(`/dashboard/applications/${application.id}`)}
                            >
                                <td>
                                    <div>{application.jobCompany}</div>
                                    <div className={styles.show_tablet}>
                                        {application.jobCompany}
                                    </div>
                                </td>
                                <td>
                                    <div>{application.jobTitle}</div>
                                    <div className={styles.show_tablet}>
                                        {application.jobTitle}
                                    </div>
                                </td>
                                <td className={styles.hide_tablet}>
                                    {application.jobLocation}
                                </td>
                                <td className={styles.hide_tablet}>
                                    {application?.professionalProfile?.salaryRange}
                                </td>
                                <td className={styles.hide_tablet}>
                                    {application.jobLocationType}
                                </td>
                                <td>{application.createdOn?.split("T").shift()}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            {
                 pageCount > 1 &&(
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
                )
            }
        </div>
    );
};

export default Table;
