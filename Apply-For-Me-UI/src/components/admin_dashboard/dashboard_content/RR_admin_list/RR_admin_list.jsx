import { useState,useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux';
import './RR_admin_List.css';
export const RR_Admin_list=({inputSearchValue})=>{
    
    const RR_recruiter = useSelector((state)=>state.RRadmin);
    const [search, setSearch] = useState([]);

    const navigate = useNavigate();
    const [rangeEnd, setRangeEnd]= useState(4);
    const [rangeStart, setRangeStart]= useState(0);
    const [counter, setCounter]= useState(1);
    
    useEffect(()=>{
        const avilableList = (RR_recruiter.loadingStatus ==="success" && RR_recruiter.list.content.length !==0) ? RR_recruiter.list.content.filter((item)=>item.first_name.toLowerCase().includes(inputSearchValue)):[]
        setSearch(avilableList);
    },[inputSearchValue,RR_recruiter.list])
    
            
    const forwardHandler=()=>{
        setRangeEnd((prevState)=>prevState+5);
        setRangeStart((prevState)=>prevState+5);
        setCounter((prevState)=>prevState+5);
       
    }
    const backwardHandler=()=>{
        setRangeEnd((prevState)=>prevState-5);
        setRangeStart((prevState)=>prevState-5);
        setCounter((prevState)=>prevState-5);  
    }

    return(
        <>
            <div className="sort_header">
                <h3 style={{color:"#2E3192",fontWeight:"bolder"}}>RR Admin List</h3>
                <div>
                    <button> + Add Admin</button>
                </div>
            </div>

             {/* desktop view for RR Admin List*/ }
            <table className="tableContainer">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Date registered</th>
                        <th> <label htmlFor="applicants">Sort By: </label>
                            <select name="applicants" id="applicants">
                                <option value="oldest">Most Active</option>
                            </select>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                    RR_recruiter.loadingStatus === "success" &&
                    counter <= RR_recruiter.list.content.length? RR_recruiter.list.content.map((user, index)=>{
                        const {first_name,current_job_title,created_on,avatar,id} = user;
                        if((index >= rangeStart) && (index <= rangeEnd) ){
                            return(
                                <tr key={index}>
                                    <td>
                                        <div className="name_table_data">
                                            <span style={{width:"15%"}}>
                                                <img style={{width:"100%"}}  src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/Frame_51202_uoy0ee.png" alt="object not found"/>
                                            </span>
                                            <h3 style={{marginLeft:"0.4rem"}}>{first_name}</h3>
                                        </div>
                                    </td>
                                    <td><h3 style={{fontWeight:"400"}}>{current_job_title}</h3></td>
                                    <td><h3 style={{fontWeight:"400"}}>{created_on}</h3></td>
                                    <td>
                                        <div className="viewContainer">
                                            <button onClick={()=>navigate(`/reverseRecruiterAdmin/${id}`)}>view Profile</button>
                                            <span className="dropdown">
                                                <img className="three_dot_icon" src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Group_caynky.png" alt="object not found"/>
                                                <div className="dropdownContent">
                                                         <img src="https://res.cloudinary.com/hamskid/image/upload/v1669300167/Frame_51367_phrq53.png" style={{marginBottom:"0.7rem"}}/>
                                                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669300167/Frame_51368_oevqxr.png"/>
                                                </div>
                                            </span>
                                        </div>
                                    </td>
                                </tr>
                            )

                        }
                    }):null}
                </tbody> 
            </table>


            {/* mobile view for RR Admin List*/ }
            <div className='mobileList'>
                <div>
                    <label htmlFor="applicants">Sort By: </label>
                    <select name="applicants" id="applicants">
                        <option value="oldest">Most Active</option>
                        <option value="newest">newest</option>
                    </select>
                </div>
                
                    {
                        RR_recruiter.loadingStatus === "success" &&
                        counter <= RR_recruiter.list.content.length? RR_recruiter.list.content.map((user, index)=>{
                            const {first_name,current_job_title,avatar,id} = user;
                            if((index >= rangeStart) && (index <= rangeEnd) ){
                                return(
                                    <div className='RRlist' key={index}>
                                        <div className='img_rapper'>
                                            <img style={{width:'100%'}} src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/Frame_51202_uoy0ee.png" alt="object not found"/>
                                        </div>
                                        <div style={{width:"50%"}}>
                                            <h3>{first_name}</h3>
                                            <h3>{current_job_title}</h3>
                                        </div>
                                        <div className="view_mobile_Container">
                                            <span className="dropdown">
                                                    <img className="three_dot_icon" src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Group_caynky.png" alt="object not found"/>
                                                    <div className="dropdownContent">
                                                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669300167/Frame_51367_phrq53.png" style={{marginBottom:"0.7rem"}}/>
                                                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669300167/Frame_51368_oevqxr.png"/>
                                                    </div>
                                                </span>
                                            <button onClick={()=>navigate(`/reverseRecruiterAdmin/${id}`)}>view</button>
                                        </div>
                                    </div>
                                )

                            }
                        }):null
                    }
            </div>

            {/* loading state handler */}
            {RR_recruiter.loadingStatus ==="pending" && <p style={{textAlign:"center"}}>Please wait while we fetch the data...</p>}
            
            <div className="pagination">
                <h5>1-5 of {RR_recruiter.loadingStatus ==="success" && RR_recruiter.list.content.length}</h5>
                <div className="pagiantion_control">
                    {counter >= 4?<span onClick={backwardHandler}><img style={{width:'60%'}} src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/back-arrow_e22btd.png" alt="object not found"/></span>:null}
                    { RR_recruiter.loadingStatus ==="success" && (counter < RR_recruiter.list.content.length ?<span onClick={forwardHandler}><img style={{width:'60%'}} src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/arrow_back_ios_new_wskxof.png" alt="object not found"/></span>:null)}
                </div> 
            </div>
            
        </>
    )
}