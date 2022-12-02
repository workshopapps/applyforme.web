import {useState} from 'react'
import './dashboard_content.css';
import { RR_Admin_list } from './RR_admin_list/RR_admin_list';
export const DashboardContent=({inputSearchValue})=>{
    const [statistics, setStatisticsValue] = useState({
        applications:"5000",
        users:"10000",
        recruiter:"3000"

    });
    const statisticsList =[{
        date:"Tuesday, 16th Nov. 2022",
        applications:"5000",
        users:"10000",
        recruiter:"3000"

    },{
        date:"Monday, 20th June. 2022",
        applications:"8000",
        users:"20000",
        recruiter:"6000"
    },{
        date:"Wenesday, 19th May. 2021",
        applications:"13000",
        users:"12000",
        recruiter:"8000"
    }]

    const statisticsHandler=(e)=>{
        statisticsList.find((item)=>{
            if(e.target.value === item.date){
                setStatisticsValue({
                    applications:item.applications,
                    users:item.users,
                    recruiter:item.recruiter
                });

            }
        })
        console.log(e.target.value);

    }
    return(
        <>
        <div className="applicantsContainer">
            <h2 className='profile_name'>Hello John Cooper</h2>
            <div className="statisticsContainer">
                <h2>Statistical</h2>
                <select style={{background:"whitesmoke"}} name="statistic_sorter" id="statistic_sorter" onChange={statisticsHandler}>
                    {
                        statisticsList.map((statistics, index)=>{
                            return(
                                <option key={index} value={statistics.date}>{statistics.date}</option>
                            )
                        })
                    }
                </select>
            </div>
            <div className='overflow' >
                <div className="applicants">
                    <div style={{background:"#2E3192",color:"white"}}>
                        <h3 className="amount">Total Applications</h3>
                        <h1 className="value" style={{color:"white"}}>{statistics.applications}</h1>
                    </div>
                    <div className='users_recruiter_text'>
                        <h3 className="amount">Total Users</h3>
                        <h1 className="value">{statistics.users}</h1>
                    </div>
                    <div className='users_recruiter_text'>
                        <h3 className="amount">Total Reverse recruiters</h3>
                        <h1 className="value">{statistics.recruiter}</h1>
                    </div>
                </div>
            </div>
            <RR_Admin_list inputSearchValue={inputSearchValue}/>
            </div>
        </>
    )
}