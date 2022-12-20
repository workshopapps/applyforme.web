import axios from "axios";
import React from "react";
import { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { SuperAdminApplicants } from "store/slice/RR_AdminSlice";
import classes from "./UserPage.module.css";
import { AiOutlineEye, AiOutlineDelete } from "react-icons/ai";

const UsersPage = ({ inputSearchValue }) => {
    const list = useSelector(state => state.RRadmin);
    const navigate = useNavigate();
    const [search, setSearch] = useState([]);
    const dispatch = useDispatch();
    const token = localStorage.getItem("tokenHngKey");
    const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10,
    });
    const handlePageClick =(data)=>{
        setPagination(prevState =>({...prevState,"pageNo":data.selected}));
        dispatch(SuperAdminApplicants(pagination));
       
    }
    useEffect(()=>{
        const avilableList = (list.applicantsloadingStatus ==="success" && list.superAdminApplicantsList?.length !==0) ? list.superAdminApplicantsList?.content?.filter((item)=>item.membership.firstName.toLowerCase().includes(inputSearchValue)):[]
        setSearch(avilableList);
    }, [inputSearchValue, list.superAdminApplicantsList]);
    
    useEffect(()=>{
        dispatch(SuperAdminApplicants(pagination));
    },[dispatch])


    const handleDeleteApplicants = async(e)=> {
        try {
            const response = await axios.delete(
                `https://api.applyforme.hng.tech/api/v1/super-admin/applicant/delete/${e.id}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log(response);
            toast("Applicants deleted successfully");
            setTimeout(() => {
                window.location.reload();
            }, 3000);

        } catch (error) {
            toast.error("An Error occured, Please  try again");
            console.log(error.response?.data?.message);
        }
    }
    return (
        <div className={classes.main_container}>
           <div className="statisticsContainer">
                <h2  className="list-header">All Applicants</h2>
                <select name="statistic_sorter" id="statistic_sorter">
                    <option value={new Date().toLocaleDateString()}> {new Date().toLocaleDateString()}</option>
                </select>
            </div>

            <section className={classes.applicant}>
                <table className={classes.table}>
                    <thead>
                        <tr className={classes.table__head}>
                            <th className={classes.table__head_th}>Name</th>
                            <th className={classes.hide_on_mobile}>
                                Email Address
                            </th>
                            <th>Plan</th>
                            <th className={classes.hide_on_mobile}>
                                Application Made
                            </th>
                            <th>Action</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        {search?.length !== 0 &&
                         (list.applicantsloadingStatus === "success" && list.superAdminApplicantsList.length !==0) &&
                            search?.map(list => {
                                const {id} = list.membership;
                                return (
                                    <tr
                                        className={classes.user_details}
                                        key={list.membership.id}
                                    >
                                        <td>{list.membership.firstName}</td>
                                        <td className={classes.hide_on_mobile}>
                                            {" "}
                                            {list.membership.emailAddress}
                                        </td>
                                        <td className={classes.hide_on_mobile}>basic</td>
                                        <td>{list.totalSubmissions}</td>
                                        <td>
                                            <span onClick={()=> navigate(`/superAdmin/applicants/profiles/details/${list.membership.id}`)} className={classes.view_button}>view</span><span onClick={(e)=>handleDeleteApplicants({id})} className={classes.delete_button}>delete</span>
                                        </td>
                                    </tr>
                                );
                            })}
                    </tbody>
                </table>
                {list.applicantsloadingStatus ==="pending" && <p style={{textAlign:"center"}}>Please wait...</p>}
                {(list.applicantsloadingStatus === "success" && search?.length ===0) && <p className="text-center">record not found</p>}
                
                    {
                        list.superAdminApplicantsList?.totalPages > 1 &&(
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
                        )
                    }
            </section>
        </div>
    );
};

export default UsersPage;
