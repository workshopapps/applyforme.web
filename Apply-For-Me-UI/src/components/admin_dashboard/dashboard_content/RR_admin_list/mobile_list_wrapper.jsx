import './RR_admin_List.css';
import { useNavigate } from 'react-router-dom';

export const Mobile_view_list =({first_name,current_job_title,id,avatar})=>{
    const navigate = useNavigate();
    return(
       <>
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
        </>
    )
}