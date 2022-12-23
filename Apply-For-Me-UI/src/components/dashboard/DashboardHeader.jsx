/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from "react";
import classes from "./DashboardHeader.module.css";
import { FiChevronLeft, FiPause, FiTrash } from "react-icons/fi";
import Logo from "../../assets/images/nav_logo.svg";
import Notification from "../../assets/images/notification.svg";
import LetteredAvatar from "react-lettered-avatar";
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
import ProfileIcon from "../../assets/images/profile-circle.svg";
import { getActiveLink } from "./service/DashboardSidebarService";
import BlueButton from "../buttons/blue_background/BlueButton";
import BlueBorderButton from "../buttons/blue_border_button/BlueBorderButton";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";
import { useRef } from "react";

const DashboardHeader = ({ func}) => {
    const [searchData, setSearchData] = useState([])
    const [data, setdata] = useState([])
    const {superAdminApplicantsList,list} = useSelector(state => state.RRadmin);
    const [dashboardActive, setDashboardActive] = useState({
        dashboard: true,
        user: false
    });
    useEffect(()=>{
        if(dashboardActive.dashboard === true){
            setdata(list.content)
            setSearchData(list.content)
        }else{
            setdata(superAdminApplicantsList.content)
            setSearchData(superAdminApplicantsList.content)
        }
    },[superAdminApplicantsList,list,dashboardActive.dashboard ])

    const navigate = useNavigate();
    const dispatch = useDispatch();
    const { user } = useSelector(state => state.user);
    const userName = user.fullName;
    const [mobileSearch, setMobileSearch] = useState(false);
    const [showModal, setShowModal] = useState(false);
    const [showMenuProfile, setShowMenuProfile] = useState(false);
    const [showProfileDetails, setShowProfileDetails] = useState(false);
    const [showMenu, setShowMenu] = useState(false);
    const [activateSearchContainer, setActivateSearchContainer] = useState(false)
    const handleActive = data => {
        setDashboardActive(getActiveLink(data));
    };
    const searchRef = useRef(null);
    const handleDashboardSubmit = event => {
        event.preventDefault();
        if(dashboardActive.dashboard){
            const itemFound = data.filter((item)=>item.firstName.toLowerCase().includes(searchRef.current.value))
            setSearchData(itemFound)
        }else{
            const itemFound = data.filter((item)=>item.membership?.firstName.toLowerCase().includes(searchRef.current.value))
            setSearchData(itemFound)
        }
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
    const handleChange =(e)=>{
        if(dashboardActive.dashboard){
            const itemFound = data.filter((item)=>item.firstName.toLowerCase().includes(e.target.value))
            setSearchData(itemFound)
        }else{
            const itemFound = data.filter((item)=>item.membership?.firstName.toLowerCase().includes(e.target.value))
            setSearchData(itemFound)
        }
    }
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
                                <img
                                    src={SearchBlue}
                                    alt="Search "
                                    onClick={() =>
                                        setMobileSearch(prev => !prev)
                                    }
                                />
                            </div>
                            <div
                                className={classes.user_avater}
                                onClick={() =>
                                    setShowMenuProfile(prevState => !prevState)
                                }
                                style={{ cursor: "pointer" }}
                            >
                                <LetteredAvatar
                                    name={userName}
                                    backgroundColor={"#78909c"}
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
                        {
                            <form
                                className={classes.search}
                                onSubmit={event => handleDashboardSubmit(event)}
                            >
                                <input
                                    ref={searchRef}
                                    type="search"
                                    name="search"
                                    placeholder="Search for Users and Reverse Recruiter"
                                    onFocus={()=>setActivateSearchContainer(true)}
                                    onChange={handleChange}
                                />
                                <button type="submit">
                                    {" "}
                                    <img src={Search} alt="Apply for me logo" />
                                </button>
                            </form>
                        }

                        {/*form for searching for users and reverse recruiter */}
                    </section>
                </nav>

                {/* Mobile nav */}
                {mobileSearch && (
                    <form
                        className={classes.mobilesearch}
                        onSubmit={event => handleDashboardSubmit(event)}
                    >
                        <input
                            ref={searchRef}
                            type="search"
                            name="search"
                            className={classes.mobile_inp}
                            placeholder="Search for and Reverse Recruiter"
                            onFocus={()=>setActivateSearchContainer(true)}
                            onChange={handleChange}
                        />
                        <button
                            type="submit"
                            className={classes.mobile_btn_cont}
                        >
                            {" "}
                            <img
                                src={Search}
                                alt="Apply for me logo"
                                className={classes.mobile_btn}
                            />
                        </button>
                    </form>
                )}
                {
                    activateSearchContainer && (
                        <div className={classes.SearchContainer}>
                            <div>
                                <img className={classes.SearchContainer_cancel} onClick={()=>setActivateSearchContainer(false)} src="https://res.cloudinary.com/hamskid/image/upload/v1670603040/close-svgrepo-com_1_ie1sje.svg" alt="object not found"/>
                            </div>
                             <p>Page: 1</p>
                            {
                                dashboardActive.dashboard && searchData?.map((data, index)=>{
                                    return(
                                        <div className={classes.SearchContainer_child_div} key={index}
                                         onClick={() =>
                                            navigate(`/user-page/reverseRecruiterAdmin/${data?.id}`)
                                        }>
                                            <div className={classes.SearchContainer_child_div_wrapper}>
                                                <div className={classes.SearchContainer_img_wrapper}>
                                                    <LetteredAvatar
                                                        name={data?.firstName }
                                                        backgroundColor={"#78909c"}
                                                    /> 
                                                </div>
                                                <div>
                                                    <p className={classes.SearchContainer_name}>{data?.firstName}</p>
                                                    <p className={classes.SearchContainer_email}>{data?.emailAddress}</p>
                                                </div>
                                            </div>
                                        </div>
                                    )
                                })
                            }
                            {
                                dashboardActive.user && searchData?.map((data, index)=>{
                                    return(
                                        <div className={classes.SearchContainer_child_div} key={index}  onClick={()=>
                                             navigate(`/superAdmin/applicants/profiles/details/${data?.membership?.id}`)}>
                                            <div className={classes.SearchContainer_child_div_wrapper}>
                                                <div className={classes.SearchContainer_img_wrapper}>
                                                    <LetteredAvatar
                                                        name={data?.membership?.firstName }
                                                        backgroundColor={"#78909c"}
                                                    /> 
                                                </div>
                                                <div>
                                                    <p className={classes.SearchContainer_name}>{data?.membership?.firstName}</p>
                                                    <p className={classes.SearchContainer_email}>{data?.membership?.emailAddress}</p>
                                                </div>
                                            </div>
                                        </div>
                                    )
                                })
                            }
                        </div>
                    )
                }
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
                                    <LetteredAvatar
                                        name={userName}
                                        backgroundColor={"#78909c"}
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
                                    style={{ width: "100%" }}
                                />
                            ) : (
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1670374510/Frame_51422_tptxu7.svg"
                                    alt="Dashboard logo"
                                    style={{ width: "100%" }}
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
                                    style={{ width: "100%" }}
                                />
                            ) : (
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1670374366/Frame_51423_xfapfz.svg"
                                    alt="Disabled User logo"
                                    style={{ width: "100%" }}
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
