/* eslint-disable no-unused-vars */
import TopBar from "../components/TopBar/TopBar";
import styles from "./Profile.module.css";
import { Link, NavLink, useNavigate } from "react-router-dom";
import add from "../assets/add.png";
import blueadd from "../assets/blue-add.png";
import { AiOutlineEye, AiOutlineDelete } from "react-icons/ai";
import { BsPencil, BsThreeDotsVertical } from "react-icons/bs";
import Modal from "react-modal";
import { useState } from "react";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

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
            toast("Profile deleted successfully");
            setTimeout(() => {
                window.location.reload();
            }, 3000);
        } catch (error) {
            toast("Error deleting. Please, try again");
            console.log(error);
        }
    };
    const CurrentProfile = profileList?.map(oneprofile => (
        <div key={oneprofile.id} className={styles.each_profile}>
            <div className={styles.edit_box}>
                <div className={styles.title_location}>
                    <h3>{oneprofile.profileTitle}</h3>
                    <p>{oneprofile.jobLocation}</p>
                </div>

                <span className={styles.dropdown}>
                    <BsThreeDotsVertical className={styles.three_dot_icon} />

                    <div className={styles.dropdownContent}>
                        <div className={styles.icon_text_box}>
                            <Link
                                to={{
                                    pathname: `/dashboard/user/${oneprofile.id}`,
                                    state: { oneprofile }
                                }}
                                className={styles.crud_link}
                            >
                                <AiOutlineEye className={styles.view_icon} />
                                <p>View</p>
                            </Link>
                        </div>
                        <div className={styles.icon_text_box}>
                            <Link
                                to={{
                                    pathname: `/dashboard/user/${oneprofile.id}/edit`,
                                    state: { oneprofile }
                                }}
                                className={styles.crud_link}
                            >
                                <BsPencil className={styles.update_icon} />
                                <p>Edit</p>
                            </Link>
                        </div>
                        <div className={styles.icon_text_box}>
                            <div
                                className={styles.crud_link}
                                onClick={() => handleModal(oneprofile.id)}
                            >
                                <AiOutlineDelete
                                    className={styles.delete_icon}
                                />
                                <p>Delete</p>
                            </div>
                        </div>
                    </div>
                </span>
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
            <ToastContainer />
            <button
                className={styles.createjob_button}
                onClick={() => navigate("/dashboard/user/create-profile")}
            >
                <p>Create a job profile</p>
                <img src={add} alt="add" />
            </button>
            <div>{CurrentProfile}</div>
            <div className={styles.mobile_only}>
                <NavLink
                    to="/dashboard/user/create-profile"
                    style={{ textDecoration: "none" }}
                >
                    <div className={styles.btn_plus_fixed}>
                        <img src={blueadd} alt="add" />
                    </div>
                </NavLink>
            </div>
        </div>
    );
};

export default Profile;
