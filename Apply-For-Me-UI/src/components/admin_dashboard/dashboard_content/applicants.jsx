import React from "react";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { useDispatch, useSelector } from "react-redux";
import { useParams } from "react-router-dom";
import { get_rr_applicants_list } from "store/slice/RR_AdminSlice";
import classes from "./applicants.module.css";

export const RRApplicantsPage = ({ inputSearchValue }) => {
    const dispatch = useDispatch();
    const list = useSelector(state => state.RRadmin);
    const {id} = useParams();
    const [search, setSearch] = useState([]);
    const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10
    });
    const handlePageClick = data => {
        setPagination(prevState => ({ ...prevState, "pageNo": data.selected }));
        dispatch(get_rr_applicants_list({
            "pageNo": data.selected,
            "pageSize": pagination.pageSize,
             member: id
        }));
    };
    useEffect(() => {
        const avilableList =
            list.recruiterApplicantsLoading === "success" &&
            list.recruiterApplicants?.length !== 0
                ? list.recruiterApplicants?.content?.filter(item =>
                      item.name
                          .toLowerCase()
                          .includes(inputSearchValue)
                  )
                : [];
        setSearch(avilableList);
    }, [inputSearchValue, list.recruiterApplicants]);

    useEffect(() => {
        dispatch(get_rr_applicants_list({
            "pageNo": pagination.pageNo,
            "pageSize": pagination.pageSize,
             member: id
        }));
    }, [dispatch]);

    return (
        <div className={classes.main_container}>
            <div className="statisticsContainer">
                <h2 className="list-header">All Applicants</h2>
                <select name="statistic_sorter" id="statistic_sorter">
                    <option value={new Date().toLocaleDateString()}>
                        {" "}
                        {new Date().toLocaleDateString()}
                    </option>
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
                        </tr>
                    </thead>
                    <tbody>
                        {search?.length !== 0 &&
                            list.recruiterApplicantsLoading === "success" &&
                            list.recruiterApplicants.length !== 0 &&
                            search?.map((list, index) => {
                                return (
                                    <tr
                                        className={classes.user_details}
                                        key={index}
                                    >
                                        <td>{list?.name}</td>
                                        <td className={classes.hide_on_mobile}>
                                            {" "}
                                            {list?.mail}
                                        </td>
                                        <td>{list?.plan}</td>
                                        <td>{list?.interviews}</td>
                                    </tr>
                                );
                            })}
                    </tbody>
                </table>
                {list.recruiterApplicantsLoading === "pending" && (
                    <p style={{ textAlign: "center" }}>Please wait...</p>
                )}
                {list.recruiterApplicantsLoading === "success" &&
                    search?.length === 0 && (
                        <p className="text-center">record not found</p>
                    )}
                {
                    list.recruiterApplicants?.totalPages > 1 && (
                        <div>
                            <ReactPaginate
                                breakLabel="..."
                                nextLabel=">"
                                pageRangeDisplayed={5}
                                pageCount={list.recruiterApplicants?.totalPages}
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
            </section>
        </div>
    );
};
