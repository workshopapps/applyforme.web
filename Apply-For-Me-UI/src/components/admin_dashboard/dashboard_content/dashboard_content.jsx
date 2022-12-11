import jwtDecode from "jwt-decode";
import { useState, useEffect } from "react";
import "./dashboard_content.css";
import { RR_Admin_list } from "./RR_admin_list/RR_admin_list";
import axios from "axios";
export const DashboardContent = ({ inputSearchValue }) => {
    const [statValue, setStatValue] = useState();
    const [statistics, setStatisticsValue] = useState({
        applications: "0",
        users: "0",
        recruiter: "0"
    });
    const statisticsList = [
        {
            date: "Tuesday, 16th Nov. 2022",
            applications: "0",
            users: "0",
            recruiter: "0"
        }
    ];

    const createRecruiter = async () => {
        try {
            const response = await axios.get(
                "https://api.applyforme.hng.tech/api/v1/statistic/counts-part-one",

                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setStatValue(response.data);
        } catch (err) {
            console.log(err.response?.data);
        }
    };
    useEffect(() => {
        createRecruiter();
    }, []);
    console.log(statValue);

    const token = localStorage.getItem("tokenHngKey");
    let decoded = jwtDecode(token);
    const { fullName } = decoded;
    const statisticsHandler = e => {
        statisticsList.find(item => {
            if (e.target.value === item.date) {
                setStatisticsValue({
                    applications: item.applications,
                    users: item.users,
                    recruiter: item.recruiter
                });
            }
        });
        console.log(e.target.value);
    };
    return (
        <>
            <div className="applicantsContainer">
                <h2 className="profile_name">Hello {fullName}</h2>
                <div className="statisticsContainer">
                    <h2 className="list-header">Statistics</h2>
                    <select
                        name="statistic_sorter"
                        id="statistic_sorter"
                        onChange={statisticsHandler}
                    >
                        {statisticsList.map((statistics, index) => {
                            return (
                                <option key={index} value={statistics.date}>
                                    {statistics.date}
                                </option>
                            );
                        })}
                    </select>
                </div>
                <div className="overflow">
                    <div className="applicants">
                        <div>
                            <h6 className="amount">Total Applications</h6>
                            <h1 className="value" style={{ color: "white" }}>
                                {statValue?.total_applications}
                            </h1>
                        </div>
                        <div className="users_recruiter_text">
                            <h6 className="amount">Total Users</h6>
                            <h1 className="value">{statValue?.total_users}</h1>
                        </div>
                        <div className="users_recruiter_text">
                            <h6 className="amount">Total Reverse recruiters</h6>
                            <h1 className="value">
                                {statValue?.total_reverse_recruiters}
                            </h1>
                        </div>
                    </div>
                </div>
                <RR_Admin_list inputSearchValue={inputSearchValue} />
            </div>
        </>
    );
};
