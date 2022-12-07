
import { useState,useEffect } from 'react';
import { useSelector} from 'react-redux';
import './RR_admin_List.css';
import { Desktop_List } from './desktop_list_wrapper';
import { Mobile_view_list } from './mobile_list_wrapper';
export const RR_Admin_list=({inputSearchValue})=>{
    const RR_recruiter = useSelector((state)=>state.RRadmin);
    const [search, setSearch] = useState([]);
    const [rangeEnd, setRangeEnd]= useState(4);
    const [rangeStart, setRangeStart]= useState(0);
    const [counter, setCounter]= useState(1);
    
    useEffect(()=>{
        const avilableList = (RR_recruiter.loadingStatus ==="success" && RR_recruiter.list.length !==0) ? RR_recruiter.list.content.filter((item)=>item.firstName.toLowerCase().includes(inputSearchValue)):[]
        setSearch(avilableList);
    }, [inputSearchValue, RR_recruiter.list]);

    const forwardHandler = () => {
        setRangeEnd(prevState => prevState + 5);
        setRangeStart(prevState => prevState + 5);
        setCounter(prevState => prevState + 5);
    };
    const backwardHandler = () => {
        setRangeEnd(prevState => prevState - 5);
        setRangeStart(prevState => prevState - 5);
        setCounter(prevState => prevState - 5);
    };


    return (
        <>
            <div className="sort_header">
                <h3 style={{color:"#2E3192",fontWeight:"bolder"}}>RR Admin List</h3>
                <div>
                    <button> + Add Admin</button>
                </div>
            </div>

            {/* desktop view for RR Admin List*/}
            <table className="tableContainer">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Date registered</th>
                        <th>
                            {" "}
                            <label htmlFor="applicants">Sort By: </label>
                            <select name="applicants" id="applicants">
                                <option value="oldest">Most Active</option>
                            </select>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                        search.length !==0 &&
                        counter <= search.length? search.map((user, index)=>{
                            const {firstName,currentJobTitle,id,createdOn} = user;
                            if( (index >= rangeStart) && (index <= rangeEnd) ){
                                return(
                                    <tr key={index}>
                                        <Desktop_List firstName={firstName} currentJobTitle={currentJobTitle} id={id} createdOn={createdOn}/>
                                    </tr> 
                                )
                            }
                        }):null

                    }
                        
                    
                        
                </tbody> 
            </table>

            {/* mobile view for RR Admin List*/}
            <div className="mobileList">
                <div>
                    <label htmlFor="applicants">Sort By: </label>
                    <select name="applicants" id="applicants">
                        <option value="oldest" disabled>
                            Most Active
                        </option>
                    </select>
                </div>
                    {
                        search.length !==0 && 
                        (RR_recruiter.loadingStatus === "success" && RR_recruiter.list.length !==0) &&
                        counter <= RR_recruiter.list.content.length? RR_recruiter.list.content.map((user, index)=>{
                           const {firstName,currentJobTitle,id} = user;
                            if((index >= rangeStart) && (index <= rangeEnd) ){
                                return(
                                    <div className='RRlist' key={index}>
                                         <Mobile_view_list firstName={firstName} currentJobTitle={currentJobTitle} id={id} />
                                    </div>
                                  
                                )
                            }
                        }):null
                    }
            </div>

            {/* loading state handler */}
            {RR_recruiter.loadingStatus === "pending" && (
                <p style={{ textAlign: "center" }}>
                    Please wait while we fetch the data...
                </p>
            )}
            {search.length ===0 && <p>Admin not found</p>}

            <div className="pagination">
                <h5>
                    1-5 of{" "}
                    {RR_recruiter.loadingStatus === "success" && RR_recruiter.list.content.length}
                </h5>
                <div className="pagiantion_control">
                    {counter >= 4 ? (
                        <span onClick={backwardHandler}>
                            <img
                                style={{ width: "60%" }}
                                src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/back-arrow_e22btd.png"
                                alt="object not found"
                            />
                        </span>
                    ) : null}
                    {RR_recruiter.loadingStatus === "success" &&
                        (counter < RR_recruiter.list.content.length ? (
                            <span onClick={forwardHandler}>
                                <img
                                    style={{ width: "60%" }}
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/arrow_back_ios_new_wskxof.png"
                                    alt="object not found"
                                />
                            </span>
                        ) : null)}
                </div>
            </div>
        </>
    );
};
