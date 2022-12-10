import React from "react";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { useDispatch, useSelector } from "react-redux";
import { getRecruiterApplicants } from "store/slice/RR_AdminSlice";
import classes from "./applicants.module.css";

export const RRApplicantsPage = () => {

    const dispatch = useDispatch();
    const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10,
    });
    const handlePageClick =(data)=>{
        setPagination(prevState =>({...prevState,"pageNo":data.selected}));
        dispatch( getRecruiterApplicants(pagination));
       
    }
    useEffect(()=>{
        dispatch( getRecruiterApplicants(pagination));
    },[dispatch, getRecruiterApplicants])

    const list = useSelector(state => state.RRadmin);
    console.log(list);
    return (
        <div className={classes.main_container}>
           <div className="statisticsContainer">
                <h2  className="list-header">Statistics</h2>
                <select name="statistic_sorter" id="statistic_sorter">
                    {list.RRApplicantsList.length !== 0 &&
                         (list.applicantsloadingStatus === "success" && list.RRApplicantsList.length !==0) &&
                            list.RRApplicantsList.content?.map((statistics, index)=>{
                            return(
                                <option key={index} value={statistics.membership.createdOn?.split("T").shift()}>{statistics.membership.createdOn?.split("T").shift()}</option>
                            )
                        })
                    }
                </select>
            </div>

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
                        {list.RRApplicantsList.length !== 0 &&
                         (list.applicantsloadingStatus === "success" && list.RRApplicantsList.length !==0) &&
                            list.RRApplicantsList.content?.map(list => {
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
                {list.applicantsloadingStatus ==="pending" && <p style={{textAlign:"center"}}>Please wait...</p>}
                <div>
                <ReactPaginate
                    breakLabel="..."
                    nextLabel=">"
                    pageRangeDisplayed={5}
                    pageCount={list.RRApplicantsList?.totalPages}
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
            </section>
        </div>
    );
};


