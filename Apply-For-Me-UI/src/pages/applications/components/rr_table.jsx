/* eslint-disable no-unused-vars */
import styles from "./rr_table_module.css";
import { Link} from "react-router-dom";
import ApplicationsListHeader from "./RR_ApplicationsListHeader";
import axios from "axios";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
const Table = () => {
    const [data, setData] = useState([]);
    const [pageCount, setPageCout] = useState(1)
    const token = localStorage.getItem("tokenHngKey");
     const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10,
    });
    const fetchApplicants = async()=>{
                try{
                    const response = await axios.get(`https://api.applyforme.hng.tech/api/v1/professional-profile/entries/all`, 
                                            {
                                                params:{
                                                "pageNo": pagination.pageNo,
                                                "pageSize":pagination.pageSize,
                                                },
                                                headers: {
                                                    "Authorization": `Bearer ${token}`
                                                }
                                            }
                                            );
                                            console.log("REverse Recruiter", response.data)
                    setData(response.data?.content);
                    setPageCout(response.data?.totalPages);

                } catch (error) {
                    console.error(`Could not get applicants: ${error}`);
                }          
    }

    useEffect(() => {
        fetchApplicants();
    }, []);

   
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
                            <th>Name</th>
                            <th>Salary</th>
                            <th className={styles.hide_tablet}>Type</th>
                            <th className={styles.hide_tablet}>Details</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data?.map?.((application, index) => (
                            <tr
                                className={styles.applications_table_body_row}
                                key={`${application.jobCompany}-${index}`}
                                
                            >
                                <td>
                                    <div>{application.profileTitle}</div>
                                </td>
                                 <td>{application.salaryRange}</td>  
                                <td className={styles.hide_tablet}>
                                    {application.preferredJobLocationType}
                                </td>
                                <td>
                                    <Link to={`/professional-profile/user/details/${application.id}`} style={{textDecoration:"none"}}>
                                       view
                                     </Link>
                                </td>
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
                    pageCount={pageCount}
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