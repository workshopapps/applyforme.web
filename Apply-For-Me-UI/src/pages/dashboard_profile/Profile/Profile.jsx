import TopBar from "../components/TopBar/TopBar";
import styles from "./Profile.module.css";
import { Link, useNavigate } from "react-router-dom";
import add from "../assets/add.png";
import { AiOutlineEye, AiOutlineDelete } from "react-icons/ai";
import { BsPencil } from "react-icons/bs";
import Modal from "react-modal";
import { useState } from "react";
import axios from "axios";

const Profile = ({ profileList }) => {
    const navigate = useNavigate();
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [activeId, setActiveId] = useState();

    // eslint-disable-next-line no-unused-vars
    const token = localStorage.getItem("tokenKey");
    let tokenKey = "tokenHngKey";
    let storedToken = localStorage.getItem(tokenKey);
    function handleModal(id) {
        setModalIsOpen(true);
        setActiveId(id);
    }

    function handleCancelClick() {
        setModalIsOpen(false);
    }
    // eslint-disable-next-line no-unused-vars
    const handleDeleteClick = async id => {
        console.log(activeId);
        try {
            axios
                .delete(
                    `https://api.applyforme.hng.tech/api/v1/job-profile/delete/${id}`,

                    {
                        headers: {
                            "Authorization": `Bearer ${storedToken}`,
                            "Content-Type": "application/json"
                        }
                    }
                )
                .then(function (response) {
                    console.log(response);
                })
                .catch(function (error) {
                    console.log(error);
                });
            setModalIsOpen(false);
        } catch (error) {
            console.log(error);
        }
        // window.location.reload(false);
    };
    const CurrentProfile = profileList?.map(oneprofile => (
        <div key={oneprofile.id} className={styles.each_profile}>
            <div className={styles.edit_box}>
                <h3>{oneprofile.profileTitle}</h3>
                <p>{oneprofile.jobLocation}</p>
                <div className={styles.ved_icons}>
                    <Link
                        to={{
                            pathname: `/dashboard/user/${oneprofile.id}`,
                            state: { oneprofile }
                        }}
                    >
                        <AiOutlineEye className={styles.view_icon} />
                    </Link>
                    <Link
                        to={{
                            pathname: `/dashboard/user/${oneprofile.id}/edit`,
                            state: { oneprofile }
                        }}
                    >
                        <BsPencil className={styles.update_icon} />
                    </Link>
                    <AiOutlineDelete
                        onClick={() => handleModal(oneprofile.id)}
                        className={styles.delete_icon}
                    />
                </div>
            </div>

            <Modal
                style={{
                    overlay: {
                        position: "fixed",
                        background: "rgba(21, 24, 104, 0.03)",
                        backdropFilter: 'blur("1px")'
                    }
                }}
                isOpen={modalIsOpen}
                className={styles.delete_modal}
                appElement={document.getElementById("root") || undefined}
                onRequestClose={() => {
                    setModalIsOpen(false);
                }}
                id={oneprofile.id.toString()}
            >
                <p>Are you sure you want to delete this job profile?</p>
                <div className={styles.modal_buttons}>
                    <button onClick={() => handleCancelClick()}>Cancel</button>
                    <button onClick={() => handleDeleteClick(activeId)}>
                        Delete
                    </button>
                </div>
            </Modal>
        </div>
    ));

    return (
        <div className={styles.profile_page}>
            <TopBar />
            <button
                className={styles.createjob_button}
                onClick={() => navigate("/dashboard/user/create-profile")}
            >
                <p>Create a job profile</p>
                <img src={add} alt="add" />
            </button>
            <div>{CurrentProfile}</div>
        </div>
    );
};

export default Profile;
