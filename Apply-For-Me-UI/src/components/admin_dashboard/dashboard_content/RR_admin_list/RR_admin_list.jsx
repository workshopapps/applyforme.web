
import { useState,useEffect } from 'react';
import { useDispatch, useSelector} from 'react-redux';
import './RR_admin_List.css';
import { DesktopList } from './desktop_list_wrapper';
import { MobileViewList } from './mobile_list_wrapper';
import { Fetch_RR_Admin } from 'store/slice/RR_AdminSlice';
import ReactPaginate from 'react-paginate';
import { useNavigate } from 'react-router-dom';
export const RRAdminList=()=>{
    const RR_recruiter = useSelector((state)=>state.RRadmin);
    const navigate = useNavigate()
    const dispatch = useDispatch();
    const [pagination, setPagination] = useState({
        "pageNo": 0,
        "pageSize": 10,
    });

    useEffect(()=>{
        dispatch(Fetch_RR_Admin(pagination));
    },[dispatch,pagination])
 
    const handlePageClick =(data)=>{
        setPagination(prevState =>({...prevState,"pageNo":data.selected}));
        dispatch(Fetch_RR_Admin(pagination));
    }


    return (
        <>
            <div className="sort_header">
                <div>
                    <h3 style={{color:"#2E3192",fontWeight:"bolder"}} className="list-header">RR Admin List</h3>
                    <button className="add-admin" onClick={()=>navigate("/create/recruiter/page")}>+ Add Admin</button>
                </div>
            </div>

            {/* desktop view for RR Admin List*/}
            <table className="tableContainer">
                <thead>
                    <tr>
                        <th className="thead_th">Name</th>
                        <th className="thead_th">Category</th>
                        <th className="thead_th">Date registered</th>
                        <th className="thead_th">Details</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        RR_recruiter.list?.length !==0 &&
                        (RR_recruiter.loadingStatus === "success" && RR_recruiter.list.length !==0) &&
                        RR_recruiter.list?.content?.map((user, index)=>{
                                const {firstName,currentJobTitle,id,createdOn} = user;
                                    return(
                                        <tr key={index}>
                                            <DesktopList firstName={firstName} currentJobTitle={currentJobTitle} id={id} createdOn={createdOn}/>
                                        </tr> 
                                    )
                            })
                    }         
                </tbody> 
            </table>

            {/* mobile view for RR Admin List*/}
            <div className="mobileList">
                <div>
                    <label htmlFor="applicants">Sort By: </label>
                    <select name="applicants" id="applicants">
                        <option value="true">
                            Most Active
                        </option>
                    </select>
                </div>
                    {
                        RR_recruiter.list?.length !==0 && 
                        (RR_recruiter.loadingStatus === "success" && RR_recruiter.list.length !==0) &&
                        RR_recruiter.list?.content.map((user, index)=>{
                            const {firstName,currentJobTitle,id} = user;
                                    return(
                                        <div className='RRlist' key={index}>
                                            <MobileViewList firstName={firstName} currentJobTitle={currentJobTitle} id={id} />
                                        </div>
                                    
                                    )                            
                        })
                    }
            </div>

            {/* loading state handler */}
            {RR_recruiter.loadingStatus === "pending" && (
                <p style={{ textAlign: "center" }}>
                    Please wait...
                </p>
            )}
            {(RR_recruiter.loadingStatus === "success" && RR_recruiter.list?.length ===0) && <p className="text-center">No admin has being created</p>}
            {
                RR_recruiter.list?.totalPages > 1 && (
                    <div>
                        <ReactPaginate
                            breakLabel="..."
                            nextLabel=">"
                            pageRangeDisplayed={5}
                            pageCount={RR_recruiter.list?.totalPages}
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
        </>
    );
};
