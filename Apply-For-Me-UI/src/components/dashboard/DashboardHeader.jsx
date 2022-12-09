import React, { useState } from "react";
import classes from "./DashboardHeader.module.css";
import { FiChevronLeft, FiPause, FiTrash } from "react-icons/fi";
import Logo from "../../assets/images/nav_logo.svg";
import Notification from "../../assets/images/notification.svg";
import ProfilePic from "../../assets/images/test_profile_picture.svg";
import Search from "../../assets/images/search.svg";
import SearchBlue from "../../assets/images/search_blue.svg";
import Menu from "../../assets/images/menu.svg";
import CloseMenu from "../../assets/images/close_menu.svg";
// import DashboardActiveIcon from "../../assets/images/dashboard_active_logo.svg";
// import DashboardDisabledIcon from "../../assets/images/dashboard_disabled_logo.svg";
// import UserDisabledIcon from "../../assets/images/users_disabled_logo.svg";
// import UserActiveIcon from "../../assets/images/users_active_logo.svg";
import Signout from "../../assets/images/signout.svg";
import ProgressBar from "../../assets/images/progress_bar.svg";
import { MobileNav } from "./mobileNav";
import { useNavigate } from "react-router-dom";
import ProfilePiture from "../../assets/images/profile_picture.svg";
import ProfileIcon from "../../assets/images/profile-circle.svg";
import { getActiveLink } from "./service/DashboardSidebarService";
import BlueButton from "../buttons/blue_background/BlueButton";
import BlueBorderButton from "../buttons/blue_border_button/BlueBorderButton";
import { useDispatch } from "react-redux";
import { userInfo } from "store/slice/UserSlice";

const DashboardHeader = ({ func, setInputSearchValue }) => {
    const [dashboardActive, setDashboardActive] = useState({
        dashboard: true,
        user: false
    });
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const [showModal, setShowModal] = useState(false);
    const [showMenuProfile, setShowMenuProfile] = useState(false);
    const [showProfileDetails, setShowProfileDetails] = useState(false);
    const [showMenu, setShowMenu] = useState(false);
    const handleActive = data => {
        setDashboardActive(getActiveLink(data));
    };
    const handleSubmit = event => {
        event.preventDefault();
        setShowModal(false);
        // Quota submission code goes here
    };
    const handleDashboardSubmit = event => {
        event.preventDefault();
        setInputSearchValue(event.target.search.value);
        event.target.search.value = "";
    };
    const handleLogout = () => {
        localStorage.removeItem("tokenHngKey");
        dispatch(userInfo(""));
        navigate("/");
    };
    const handleModalShow = () => {
        setShowModal(true);
    };

    const handleQuota = event => {
        event.preventDefault();
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

                        <img
                            src={Logo}
                            alt="Apply for me logo"
                            onClick={() => navigate("/")}
                        />
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
                                <img src={SearchBlue} alt="Search " />
                            </div>
                            <div
                                className={classes.user_avater}
                                onClick={() =>
                                    setShowMenuProfile(prevState => !prevState)
                                }
                                style={{ cursor: "pointer" }}
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
                                            onClick={() => {
                                                handleLogout();
                                                setShowMenuProfile(false);
                                            }}
                                        >
                                            <img
                                                src={Signout}
                                                alt="Signout logo"
                                            />
                                            <p>Sign out</p>
                                        </li>
                                    </ul>
                                </div>
                            )}
                        </div>
                        {/*form for searching for reverse recruiter admin  */}
                        {dashboardActive.dashboard && (
                            <form
                                className={classes.search}
                                onSubmit={event => handleDashboardSubmit(event)}
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
                        )}

                        {/*form for searching for users and reverse recruiter */}
                        {!dashboardActive.dashboard && (
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
                                    <img src={Search} alt="Search Logo" />
                                </button>
                            </form>
                        )}
                    </section>
                </nav>

                {/* Mobile nav */}
                {showMenu && <MobileNav setShowMenu={setShowMenu} />}
            </section>

            {showProfileDetails ? (
                <section className={classes.user_profile}>
                    <div className={classes.user_profile__header}>
                        <div className={classes.user_profile__header__text}>
                            <FiChevronLeft />
                            <p
                                onClick={() => {
                                    setShowProfileDetails(false);
                                }}
                            >
                                Go Back
                            </p>
                        </div>

                        <div className={classes.user_action}>
                            <div className={classes.user_action__btn__mobile}>
                                <FiPause className={classes.pause} />

                                <p>Suspend</p>
                            </div>
                            <div className={classes.user_action__btn__mobile}>
                                <FiTrash className={classes.trash} />

                                <p>Delete</p>
                            </div>
                        </div>
                    </div>
                    <div className={classes.user_profile__content}>
                        <div className={classes.profile_details}>
                            <div className={classes.img_details}>
                                <div className={classes.img_wrapper}>
                                    <img
                                        src={ProfilePiture}
                                        alt="profile picture"
                                    />
                                </div>

                                <div className={classes.img_text_details}>
                                    <p>Monthly Quota</p>
                                    <div
                                        className={
                                            classes.img_text_details__img_container
                                        }
                                    >
                                        <img
                                            src={ProgressBar}
                                            alt="Progress bar"
                                        />
                                    </div>
                                    <p>951/1300</p>
                                </div>
                            </div>

                            <div
                                className={
                                    classes.profile_details__text_content
                                }
                            >
                                <h3>Regina Griffin</h3>
                                <p>Reverse recruiter</p>
                                <p>ReginaGriffin505@gmail.com</p>

                                <p>+2348012345678</p>

                                <p>Female</p>

                                <BlueButton
                                    text="Assign Quota"
                                    width="214"
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

                                <p>Delete</p>
                            </div>
                        </div>
                    </div>
                </section>
            ) : (
                <section className={classes.toggle_user}>
                    <ul>
                        <li
                            onClick={() => {
                                handleActive("dashboard");
                                func("dashboardPage");
                            }}
                        >
                            {dashboardActive.dashboard ? (
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1670374365/Frame_51422_vbawt4.svg"
                                    alt="Dashboard logo"
                                    style={{width:"100%"}}
                                />
                            ) : (
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1670374510/Frame_51422_tptxu7.svg"
                                    alt="Dashboard logo"
                                    style={{width:"100%"}}
                                />
                            )}
                        </li>

                        <li
                            onClick={() => {
                                handleActive("user");
                                func("userPage");
                            }}
                        >
                            {dashboardActive.user ? (
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1670374510/Frame_51423_n4kay9.svg"
                                    alt="Disabled User logo"
                                    style={{width:"100%"}}
                                />
                            ) : (
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1670374366/Frame_51423_xfapfz.svg"
                                    alt="Disabled User logo"
                                    style={{width:"100%"}}
                                />
                            )}
                        </li>
                    </ul>
                </section>
            )}

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

export default DashboardHeader;
