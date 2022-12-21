/* eslint-disable no-unused-vars */
import "./rr_table_module.css";
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
                    setData(response.data?.content);
                    setPageCout(response.data?.totalPages);

                } catch (error) {
                    console.error(`Could not get applicants: ${error}`);
                }          
    }
    const sortOldestToNewest = async()=>{
        try{
            const response = await axios.get(`https://api.applyforme.hng.tech/api/v1/professional-profile/entries/all`, 
                {
                    params:{
                    "pageNo": pagination.pageNo,
                    "pageSize":pagination.pageSize,
                    "sortDir":"desc"
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
    }   
    const sortNewestToOldest = async()=>{
        try{
            const response = await axios.get(`https://api.applyforme.hng.tech/api/v1/professional-profile/entries/all`, 
                {
                    params:{
                    "pageNo": pagination.pageNo,
                    "pageSize":pagination.pageSize,
                    "sortDir":"asc"
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
    }   

    useEffect(() => {
        fetchApplicants();
    }, []);

   
    const handlePageClick =(data)=>{
        setPagination(prevState =>({...prevState,"pageNo":data.selected}));
        fetchApplicants();
       
    }
    return (
        <div>
            <ApplicationsListHeader sortOldestToNewest={sortOldestToNewest} sortNewestToOldest={sortNewestToOldest}/>
            <div className="table_wrap">
                <div className="div_table">
                    <div className="div_table_child">Name</div>
                    <div className="div_table_child_hideOnMobile">Salary</div>
                    <div className="div_table_child">Type</div>
                    <div className="div_table_child">Details</div>
                </div>
                {data?.map((application, index) => {
                    return(
                            <div className="div_table" key={index}>
                                <div className="div_table_child">{application.profileTitle}</div>
                                <div className="div_table_child_hideOnMobile">{application.salaryRange}</div>
                                <div className="div_table_child">{application.preferredJobLocationType}</div>
                                <div className="div_table_child"> 
                                    <Link to={`/professional-profile/user/details/${application.id}`} style={{textDecoration:"none", color:"darkslategray",padding:"0.5rem", border:"1px solid darkslategray", borderRadius:"5px", fontSize:"14px"}}>
                                        view
                                    </Link>
                                </div>
                            </div>
                    )
                })}
                
            </div>

            {
                 pageCount > 1 && (
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
                )
            }
        </div>
    );
};

export default Table;