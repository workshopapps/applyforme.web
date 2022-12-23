import styles from "../Applications.module.css";
import { HiOutlineBuildingOffice2 } from "react-icons/hi2";
// import { BsPlusLg } from "react-icons/bs";
import { CiLocationOn } from "react-icons/ci";
import ApplicationsListHeader from "./ApplicationsListHeader";
import blueadd from "../../dashboard_profile/assets/blue-add.png";
import { Link } from "react-router-dom";
import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { toast } from "react-toastify";
import { useCallback } from "react";


const ApplicationsListCard = () => {
    const [data, setData] = useState([]);
    const token = localStorage.getItem("tokenHngKey");

    const fetchApplicants =  useCallback(  async () => {
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all`,
                {
                   headers: {
                        "Authorization": `Bearer ${token}`
                    }
                    
                }
            );
            setData(response?.data?.content)
        } catch (error) {
            console.log(error?.response)
            toast.error(`Could not get applicants: ${error}`);
        }
    },[token]) 

    const sortOldestToNewest = async()=>{
        try{
            const response = await axios.get(`https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all`, 
                {
                    params:{
                        "sortDir":"desc"
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setData(response.data?.content);

        } catch (error) {
            console.error(`Could not get applicants: ${error}`);
        }          
    }   
    
    const sortNewestToOldest = async()=>{
        try{
            const response = await axios.get(`https://api.applyforme.hng.tech/api/v1/job-submission/user/entries/all`, 
                {
                    params:{
                    "sortDir":"asc"
                    },
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setData(response.data?.content);

        } catch (error){
            console.error(`Could not get applicants: ${error}`);
        }          
    } 

    useEffect(() => {
        fetchApplicants();
    }, [ fetchApplicants]);

    return (
        <div className={styles.applications_list_wrapper}>
            <ApplicationsListHeader sortOldestToNewest={sortOldestToNewest} sortNewestToOldest={sortNewestToOldest}/>
            <div className={styles.applications_list_card}>
                {data?.map((application, index) => (
                     <div className={styles.applications_card} key={index}>
                        <div className={styles.applications_card_title}>
                            <span>{application?.jobTitle}</span>
                            <span>{application?.createdOn?.split("T").shift()}</span>
                        </div>
                     <div className={styles.applications_card_lo}>
                         <HiOutlineBuildingOffice2 />
                         {application?.jobCompany}
                     </div>
                     <div className={styles.applications_card_lo}>
                         <CiLocationOn />
                         {application?.jobLocation}
                     </div>
                     <div className={styles.applications_card_tag_wrapper}>
                         <div>
                             <span className={styles.applications_card_tag}>
                                 {application?.professionalProfile?.employmentType}
                             </span>
                             <span className={styles.applications_card_tag}>
                                 {application?.jobLocationType}
                             </span>
                         </div>
                         <span>{application?.professionalProfile?.salaryRange}</span>
                     </div>
                 </div>
                    
                ))}
            </div>
            <Link to="/dashboard/user/create-profile">
                <div className="btn_plus_fixed">
                    <img src={blueadd} alt="add" />
                </div>
            </Link>
            {/* <button className={styles.applications_sort}>
                <Link to="/dashboard/user/create-profile"><BsPlusLg /></Link>
            </button> */}
        </div>
    );
};

export default ApplicationsListCard;
