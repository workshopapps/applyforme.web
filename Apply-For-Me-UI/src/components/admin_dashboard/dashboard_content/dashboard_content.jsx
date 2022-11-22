import './dashboard_content.css';
import { RR_Admin_list } from './RR_admin_list/RR_admin_list';
export const DashboardContent=()=>{
    return(
        <>
        <div className="applicantsContainer">
            <h2 className='profile_name'>Hello John Cooper</h2>
            <div className="statisticsContainer">
                <h2>Statistical</h2>
                <select style={{background:"whitesmoke"}} name="statistic_sorter" id="statistic_sorter">
                    <option value="oldest">Today, 16th Nov. 2022</option>
                    <option value="newest">Today, 16th Nov. 2021</option>
                </select>
            </div>
            <div className='overflow' >
                <div className="applicants">
                    <div style={{background:"#2E3192",color:"white"}}>
                        <h3 className="amount">Total Applications</h3>
                        <h1 className="value">5000</h1>
                    </div>
                    <div className='users_recruiter_text'>
                        <h3 className="amount">Total Users</h3>
                        <h1 className="value">10000</h1>
                    </div>
                    <div className='users_recruiter_text'>
                        <h3 className="amount">Total Reverse recruiters</h3>
                        <h1 className="value">3000</h1>
                    </div>
                </div>
            </div>
            <RR_Admin_list/>
            </div>
        </>
    )
}