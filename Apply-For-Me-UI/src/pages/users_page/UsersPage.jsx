import React from "react";
import { useEffect, useState } from "react";
import { FiChevronDown} from "react-icons/fi";
import ReactPaginate from "react-paginate";
import { useDispatch, useSelector } from "react-redux";
import { SuperAdminApplicants } from "store/slice/RR_AdminSlice";
import classes from "./UserPage.module.css";

const UsersPage = () => {

    const dispatch = useDispatch();
    const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10,
    });
    const handlePageClick =(data)=>{
        setPagination(prevState =>({...prevState,"pageNo":data.selected}));
        dispatch(SuperAdminApplicants(pagination));
       
    }
    useEffect(()=>{
        dispatch(SuperAdminApplicants(pagination));
    },[dispatch,SuperAdminApplicants])

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
                         (list.applicantsloadingStatus === "success" && list.superAdminApplicantsList.length !==0) &&
                            list.superAdminApplicantsList.content?.map(list => {
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
                    pageCount={list.superAdminApplicantsList?.totalPages}
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

export default UsersPage;
