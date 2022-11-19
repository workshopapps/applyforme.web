import {useNavigate } from 'react-router-dom';
import './admin_screen.css'
import { DashboardContent } from './dashboard_content/dashboard_content';
export const AdminScreen=()=>{
    const navigate=useNavigate();
    
    return(
        <div>
            <div className="navpills">
                <div className="navpills_inner">
                    <div>
                        <img src="/Frame 51422.png"/>
                    </div>
                    <div onClick={()=>navigate('/dashboard/users')}>
                        <img src="/Frame 51423.png"/>
                   </div>
                </div>
            </div>
            <div>
                <DashboardContent/>
            </div>
        </div>
    )
}