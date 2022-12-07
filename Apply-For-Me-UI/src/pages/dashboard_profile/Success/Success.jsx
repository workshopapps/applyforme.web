import { NavLink } from "react-router-dom";
import styles from "./Success.module.css";
import success from "../assets/success.png";
import TopBar from "../components/TopBar/TopBar";
import BlueButton from "../../../components/buttons/blue_background/BlueButton";
import { useEffect, useState } from "react";
import axios from "axios";

const Success = () => {
    const [profileList, setProfileList] = useState();

    // eslint-disable-next-line no-unused-vars
    const token = localStorage.getItem("tokenKey");
    let tokenKey = "tokenHngKey";
    let storedToken = localStorage.getItem(tokenKey);
    useEffect(() => {
        axios
            .get("https://api.applyforme.hng.tech/api/v1/applicant/profiles", {
                headers: {
                    "Authorization": `Bearer ${storedToken}`
                }
            })
            .then(response => {
                // handle success
                setProfileList(response.data);
                console.log(profileList);
            })
            .catch(error => {
                // handle error
                console.log(error);
            });
    }, []);
    return (
        <div className={styles.success_page}>
            <TopBar />
            <p>All done! You can view your new job profile</p>
            <div className={styles.success_message}>
                <img src={success} alt="completed" />
                <p>Congratulations Enwono,</p>
                <p>
                    Your profile is being matched to get you your dream job sit
                    back and wait for your interview. You can view submited
                    applications in “my applications”
                </p>
                <NavLink
                    to="/dashboard/user/profile-list"
                    style={{ textDecoration: "none" }}
                >
                    <BlueButton text={"Go to my job profile"} width={300} />
                </NavLink>
            </div>
        </div>
    );
};

export default Success;
