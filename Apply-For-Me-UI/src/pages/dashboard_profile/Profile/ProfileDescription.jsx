import { useNavigate, useParams } from "react-router-dom";

import { useEffect, useState } from "react";
import { BsFillArrowLeftSquareFill } from "react-icons/bs";
import axios from "axios";
import styles from "./Profile.module.css";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";

export default function ProfileDescription() {

    // eslint-disable-next-line no-unused-vars
    const { id } = useParams();
    const [profileDesc, setProfileDesc] = useState(null);

    // eslint-disable-next-line no-unused-vars
    const token = localStorage.getItem("tokenKey");
    let tokenKey = "tokenHngKey";
    let storedToken = localStorage.getItem(tokenKey);
    console.log(storedToken);
    useEffect(() => {
        axios
            .get(
                "https://api.applyforme.hng.tech/api/v1/professional/profiles",
                {
                    headers: {
                        "Authorization": `Bearer ${storedToken}`
                    }
                }
            )
            .then(response => {
                // handle success

                setProfileDesc(response.data);
            })
            .catch(error => {
                // handle error
                console.log(error);
            });
    }, []);

    const oneprofile = profileDesc?.find(obj => obj.id === parseInt(id));


    const navigate = useNavigate();
    return (
        <div className={styles.profile_description}>
            <TopBar />

            <button onClick={() => navigate(-1)} className={styles.prev_btn}>
                <BsFillArrowLeftSquareFill className={styles.back_icon} />
            </button>
            <div className={styles.profiledesc_details}>
                {/* <h6>Job Profile Info</h6> */}
                <div>
                    <p>{oneprofile?.profileTitle}</p>
                    <h5>Job Title</h5>
                </div>
                {/* <div>
                    <p>not specified yet</p>
                    <h5>Job Location</h5>
                </div> */}
                <div>
                    <p>{oneprofile?.jobSeniority}</p>
                    <h5>Experience</h5>
                </div>
                <div>
                    <p>{oneprofile?.employmentType}</p>
                    <h5>Employment Type</h5>
                </div>
                <div>
                    <p>{oneprofile?.salaryRange}</p>
                    <h5>Salary Expectation</h5>
                </div>
                <div>
                    <a href={`${oneprofile?.resumeLink}`}>
                        <p className={styles.link}>Click here to download</p>
                    </a>
                    <h5>Uploaded CV</h5>
                </div>
                <div>
                    <p>{oneprofile?.coverLetterSubject}</p>
                    <h5>Cover letter subject</h5>
                </div>
                <div>
                    <p>{oneprofile?.coverLetterContent}</p>
                    <h5>Cover letter body</h5>
                </div>
            </div>
        </div>
    );
}