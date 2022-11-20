import { useState } from 'react';
import './RR_admin_List.css';
import { List } from './RR_smaple_list';
export const RR_Admin_list=()=>{
    
    const [rangeEnd, setRangeEnd]= useState(4);
    const [rangeStart, setRangeStart]= useState(0);
    const [counter, setCounter]= useState(1);
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
            <table className="tableContainer">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Date registered</th>
                        <th> <label htmlFor="applicants">Sort By: </label>
                            <select name="applicants" id="applicants">
                                <option value="oldest">Most Active</option>
                                <option value="newest">newest</option>
                            </select>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    {
                    
                    counter <=  List.length? List.map((user, index)=>{
                        const {name,work,date,img} = user;
                        if((index >= rangeStart) && (index <= rangeEnd) ){
                            return(
                                <tr key={index}>
                                    <td style={{paddingBottom:"1rem"}}>
                                        <div className="name_table_data">
                                            <span style={{width:"15%"}}>
                                                <img style={{width:"100%"}}  src={img} alt="object not found"/>
                                            </span>
                                            <h3 style={{marginLeft:"0.4rem"}}>{name}</h3>
                                        </div>
                                    </td>
                                    <td><h3 style={{fontWeight:"400"}}>{work}</h3></td>
                                    <td><h3 style={{fontWeight:"400"}}>{date}</h3></td>
                                    <td>
                                        <div className="viewContainer">
                                            <button>view Profile</button>
                                            <span className="dropdown">
                                                <img className="icon" src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Group_caynky.png" alt="object not found"/>
                                                <div className="dropdownContent">
                                                         <img src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Frame_51367_mndagi.png"/>
                                                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Frame_51368_n4nns4.png"/>
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
            <div className='mobileList'>
                <div>
                    <label htmlFor="applicants">Sort By: </label>
                    <select name="applicants" id="applicants">
                        <option value="oldest">Most Active</option>
                        <option value="newest">newest</option>
                    </select>
                </div>
                
                    {
                        List.map((user, index)=>{
                            const {name,work,img} = user;
                            if((index >= rangeStart) && (index <= rangeEnd) ){
                                return(
                                    <div className='RRlist' key={index}>
                                        <div className='img_rapper'>
                                            <img style={{width:'100%'}} src={img} alt="object not found"/>
                                        </div>
                                        <div>
                                            <h3>{name}</h3>
                                            <h3>{work}</h3>
                                        </div>
                                        <div className="view_mobile_Container">
                                            <span className="dropdown">
                                                    <img className="icon" src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Group_caynky.png" alt="object not found"/>
                                                    <div className="dropdownContent">
                                                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Frame_51367_mndagi.png"/>
                                                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Frame_51368_n4nns4.png"/>
                                                    </div>
                                                </span>
                                            <button>view</button>
                                        </div>
                                    </div>
                                )

                            }
                        })
                    }
              
            </div>
            <div className="pagination">
                <h5>1-5 of {List.length}</h5>
                <div className="pagiantion_control">
                    {counter >= 4?<span onClick={backwardHandler}><img style={{width:'60%'}} src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/back-arrow_e22btd.png" alt="object not found"/></span>:null}
                    {counter < List.length ?<span onClick={forwardHandler}><img style={{width:'60%'}} src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/arrow_back_ios_new_wskxof.png" alt="object not found"/></span>:null}
                </div> 
            </div>
            
        </>
    )
}