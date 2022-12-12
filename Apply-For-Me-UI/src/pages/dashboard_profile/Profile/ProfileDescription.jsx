import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { BsFillArrowLeftSquareFill } from "react-icons/bs";
import axios from "axios";
import classes from "./Profile.module.css";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";

export default function ProfileDescription() {
    // eslint-disable-next-line no-unused-vars
    const { id } = useParams();
    const [profileDesc, setProfileDesc] = useState(null);
    const [done, setDone] = useState(null);

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
                setDone("done");
            })
            .catch(error => {
                // handle error
                console.log(error);
            });
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    const oneprofile = profileDesc?.find(obj => obj.id === parseInt(id));
    // console.log(oneprofile);
    const navigate = useNavigate();
    if (done !== "done") {
        return (
            <div className={classes.loading_box}>
                <div className={classes.loading_animate} />
                <p>Loading...</p>
            </div>
        );
    } else {
        return (
            <div className={classes.profile_description}>
                <div className={classes.sidemarg}>
                    <TopBar />
                    <button
                        onClick={() => navigate(-1)}
                        className={classes.prev_btn}
                    >
                        <BsFillArrowLeftSquareFill
                            className={classes.back_icon}
                        />
                    </button>
                    <div className={classes.profiledesc_details}>
                        <div>
                            <p>{oneprofile?.profileTitle}</p>
                            <h5>Job Title</h5>
                        </div>
                        <div>
                            <p>{oneprofile?.jobLocation}</p>
                            <h5>Job Location</h5>
                        </div>
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
                                <p className={classes.link}>
                                    Click here to download
                                </p>
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
            </div>
        );
    }
}
