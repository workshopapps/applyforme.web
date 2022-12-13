import React, { useState, useEffect } from "react";
import classes from "./DashboardHeader.module.css";
import { FiChevronLeft, FiPause, FiTrash } from "react-icons/fi";
import Logo from "../../assets/images/nav_logo.svg";
import Notification from "../../assets/images/notification.svg";
import ProfilePic from "../../assets/images/test_profile_picture.svg";
import Search from "../../assets/images/search.svg";
import SearchBlue from "../../assets/images/search_blue.svg";
import Menu from "../../assets/images/menu.svg";
import CloseMenu from "../../assets/images/close_menu.svg";
// import NotificationDark from "../../assets/images/notification_dark.svg";
import Signout from "../../assets/images/signout.svg";
import ProgressBar from "../../assets/images/progress_bar.svg";
import { MobileNav } from "./mobileNav";
import { useNavigate } from "react-router-dom";
import ProfileIcon from "../../assets/images/profile-circle.svg";
// import Help from "../../assets/images/help_outline.svg";
// import { getActiveLink } from "./service/DashboardSidebarService";
import BlueButton from "../buttons/blue_background/BlueButton";
import BlueBorderButton from "../buttons/blue_border_button/BlueBorderButton";
import { useParams } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getRRAdminProfile } from "store/slice/RR_AdminSlice";
import { userInfo } from "store/slice/UserSlice";
import axios from "axios";
import { toast } from "react-toastify";
const url = "https://api.applyforme.hng.tech";
// import { Navigate } from "react-router-dom";

const RR_admin_Profile = ({ setInputSearchValue }) => {
    const navigate = useNavigate();
    const [mobileSearch, setMobileSearch] = useState(false);
    const [showModal, setShowModal] = useState(false);
    const [showMenuProfile, setShowMenuProfile] = useState(false);
    const dispatch = useDispatch();
    const token = localStorage.getItem("tokenHngKey");
    const recruiter = useSelector(state => state.RRadmin);
   
    const { firstName, emailAddress, phoneNumber, currentJobTitle } =
        recruiter.reverseRProfile;
    // const [showProfileDetails, setShowProfileDetails] = useState(false);
    const [showMenu, setShowMenu] = useState(false);
    const id = useParams();
    const newId = {id}
    console.log(newId.id.id)
    useEffect(() => {
        dispatch(getRRAdminProfile(id));
    }, [dispatch, getRRAdminProfile, id]);

    const handleSubmit = event => {
        event.preventDefault();
        setInputSearchValue(event.target.search.value);
        event.target.search.value = "";
        setShowModal(false);
        // Quota submission code goes here
    };
    const deleteHandler = async()=> {
        try {
            const response = await axios.delete(
                `${url}/api/v1/super-admin/recruiter/${newId.id.id}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log(response);
            console.log("success")
            toast("delete successful")
            navigate("/user-page");
            return response?.data;
        } catch (error) {
            console.log(error)
            toast.error(error.response?.data?.message);
            return error.response?.data;
        }
    }

    const handleModalShow = () => {
        setShowModal(true);
    };
    const handleQuota = event => {
        event.preventDefault();
    };
     const handleLogout = () => {
        localStorage.removeItem("tokenHngKey");
        dispatch(userInfo(""));
        navigate("/");
    };
    return (
        <section className={classes.main_container}>
            <section className={classes.header}>
                {/* Desktop View Menu & Tablet  */}
                <nav className={classes.desktop_menu}>
                    <div className={classes.logo_container}>
                        {!showMenu && (
                            <img
                                src={Menu}
                                alt="Notification logo"
                                className={classes.menu}
                                onClick={() => setShowMenu(true)}
                            />
                        )}

                        <img src={Logo} alt="Apply for me logo" />
                    </div>

                    <section className={classes.swap_nav}>
                        <div className={classes.notification_user}>
                            <div className={classes.notice_logo}>
                                <img
                                    src={Notification}
                                    alt="Notification logo"
                                />
                            </div>
                            <div className={classes.search_logo}>
                                <img src={SearchBlue} alt="Search "  onClick={()=>setMobileSearch(prev =>!prev)}/>
                            </div>
                            <div
                                className={classes.user_avater}
                                onClick={() => setShowMenuProfile(true)}
                            >
                                <img
                                    src={ProfilePic}
                                    alt="User Profile Picture"
                                />
                            </div>
                            {showMenuProfile && (
                                <div
                                    className={classes.drop_down}
                                    onClick={() => setShowMenuProfile(false)}
                                >
                                    <ul>
                                        <li
                                            type="button"
                                            onClick={() => {
                                                navigate("/user-page/profile");
                                            }}
                                        >
                                            <img
                                                src={ProfileIcon}
                                                alt="Profile logo"
                                            />
                                            <p>Profile</p>
                                        </li>

                                        <li
                                            onClick={() =>
                                                setShowMenuProfile(false)
                                            }
                                        >
                                            <img
                                                src={Signout}
                                                alt="Signout logo"
                                            />
                                            <p onClick={handleLogout}>Sign out</p>
                                        </li>
                                    </ul>
                                </div>
                            )}
                        </div>

                        {/*form for searching for users and reverse recruiter */}
                        <form
                            className={classes.search}
                            onSubmit={event => handleSubmit(event)}
                        >
                            <input
                                type="search"
                                name="search"
                                placeholder="Search for Users and Reverse Recruiter"
                            />
                            <button type="submit">
                                {" "}
                                <img src={Search} alt="Apply for me logo" />
                            </button>
                        </form>
                    </section>
                </nav>

                {/* Mobile nav */}
                  {mobileSearch && 
                    
                         <form
                                className={classes.search}
                                onSubmit={event => handleSubmit(event)}
                            >
                               <input
                                    type="search"
                                    name="search"
                                    className={classes.mobile_inp}
                                    placeholder="Search for and Reverse Recruiter"
                                />
                                <button type="submit" className={classes.mobile_btn_cont}>
                                    {" "}
                                    <img src={Search} alt="Apply for me logo"  className={classes.mobile_btn}/>
                                </button>
                            </form>
                }
                {showMenu && <MobileNav setShowMenu={setShowMenu} />}
            </section>

            <section className={classes.user_profile}>
                <div className={classes.user_profile__header}>
                    <div className={classes.user_profile__header__text}>
                        <FiChevronLeft />
                        <p onClick={() => navigate("/user-page")}>Go Back</p>
                    </div>

                    <div className={classes.user_action}>
                        <div className={classes.user_action__btn__mobile}>
                            <FiPause className={classes.pause} />

                            <p>Suspend</p>
                        </div>
                        <div className={classes.user_action__btn__mobile}>
                            <FiTrash className={classes.trash} />
                            <p onClick={deleteHandler}>Delete</p>
                        </div>
                    </div>
                </div>
                <div className={classes.user_profile__content}>
                    <div className={classes.profile_details}>
                        <div className={classes.img_details}>
                            <div className={classes.img_wrapper}>
                                <img src={ProfilePic} alt="profile picture" />
                            </div>

                            <div className={classes.img_text_details}>
                                <p>Monthly Quota</p>
                                <div
                                    className={
                                        classes.img_text_details__img_container
                                    }
                                >
                                    <img src={ProgressBar} alt="Progress bar" />
                                </div>
                                <p>951/1300</p>
                            </div>
                        </div>

                        <div className={classes.profile_details__text_content}>
                            <h3>{firstName}</h3>
                            <p>{currentJobTitle}</p>
                            <p>{emailAddress}</p>
                            <p>{phoneNumber}</p>
                            <p>Female</p>

                            <BlueButton
                                text="Assign Quota"
                                width="364"
                                func={handleModalShow}
                            />
                        </div>
                    </div>

                    <div className={classes.user_action}>
                        <div className={classes.user_action__btn}>
                            <FiPause className={classes.pause} />

                            <p>Suspend</p>
                        </div>
                        <div className={classes.user_action__btn}>
                            <FiTrash className={classes.trash} />

                            <p onClick={deleteHandler}>Delete</p>
                        </div>
                    </div>
                </div>
            </section>
            {showModal && (
                <section className={classes.modal_container}>
                    <div className={classes.modal_wrapper}>
                        <div className={classes.close_modal}>
                            <img
                                src={CloseMenu}
                                alt="Close"
                                onClick={() => setShowModal(false)}
                            />
                        </div>
                        <form onSubmit={e => handleQuota(e)}>
                            <div className={classes.input_container}>
                                <p>Select month</p>
                                <select>
                                    <option value="January">January</option>
                                </select>
                            </div>

                            <div className={classes.input_container}>
                                <input
                                    type="number"
                                    placeholder="Enter digits"
                                />
                            </div>

                            <div className={classes.btn_container}>
                                <BlueButton
                                    text="Set"
                                    width="195"
                                    type="submit"
                                    func={() => {}}
                                />
                                <BlueBorderButton
                                    text="Cancel"
                                    width="195"
                                    func={() => setShowModal(false)}
                                />
                            </div>
                        </form>
                    </div>
                </section>
            )}
        </section>
    );
};

export default RR_admin_Profile;
