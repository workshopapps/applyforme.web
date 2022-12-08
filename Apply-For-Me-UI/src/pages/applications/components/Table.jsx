/* eslint-disable no-unused-vars */
import styles from "../Applications.module.css";
import { HiOutlineChevronLeft, HiOutlineChevronRight } from "react-icons/hi2";
import { useNavigate } from "react-router-dom";
import ApplicationsListHeader from "./ApplicationsListHeader";
import axios from "axios";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
const Table = () => {
    const [data, setData] = useState([]);
    const [setError] = useState(false);
    const navigate = useNavigate();
     const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10,
    });
    const fetchApplicants =() =>{
            axios.get(`https://api.applyforme.hng.tech/api/v1/applicant/entries`, 
                    {
                        params:{
                        "pageNo": pagination.pageNo,
                        "pageSize":pagination.pageSize,
                        }
                    }
                )
                .then(res => {
                    setData(res.data.content);
                })
                .catch(err => {
                    return err.response.data
                })          
    }
    useEffect(() => {
        fetchApplicants();
    }, [fetchApplicants]);

   
    const handlePageClick =(data)=>{
        setPagination(prevState =>({...prevState,"pageNo":data.selected}));
         fetchApplicants();
       
    }
    return (
        <div className={styles.applications_table_wrapper}>
            <ApplicationsListHeader />
            <div className={styles.applications_table_container}>
                <table>
                    <thead>
                        <tr className={styles.applications_table_head_row}>
                            <th>Company</th>
                            <th>Job title</th>
                            <th className={styles.hide_tablet}>Location</th>
                            <th>Salary Range</th>
                            <th className={styles.hide_tablet}>Job Duration</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data?.map?.((application, index) => (
                            <tr
                                className={styles.applications_table_body_row}
                                key={`${application.jobCompany}-${index}`}
                                onClick={() =>
                                    navigate(
                                        `/dashboard/applications/${application.id}`
                                    )
                                }
                            >
                                <td>
                                    <div>{application.jobCompany}</div>
                                    <div className={styles.show_tablet}>
                                        {application.jobLocation}
                                    </div>
                                </td>
                                <td>
                                    <div>{application.jobTitle}</div>
                                    <div className={styles.show_tablet}>
                                        {application.jobType}
                                    </div>
                                </td>
                                <td className={styles.hide_tablet}>
                                    {application.jobLocation}
                                </td>
                                <td>{application.salaryRange}</td>
                                <td className={styles.hide_tablet}>
                                    {application.jobType}
                                </td>
                                <td>{application.date?.split("T").shift()}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>

            <div>
                <ReactPaginate
                    breakLabel="..."
                    nextLabel=">"
                    pageRangeDisplayed={5}
                    pageCount={25}
                    marginPagesDisplayed="1"
                    previousLabel="<"
                    renderOnZeroPageCount={null}
                    onPageChange={handlePageClick}
                    containerClassName="containerClassName"
                    pageClassName='pageClassName'
                    previousClassName='previousClassName'
                    activeClassName="activeClassName"
                    nextClassName='nextClassName'
                    pageLinkClassName="pageLinkClassName"
                />
                 </div>
        </div>
    );
};

export default Table;
