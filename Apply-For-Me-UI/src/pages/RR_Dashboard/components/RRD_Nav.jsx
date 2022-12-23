import React, { useState } from "react";
import classes from "../../../components/dashboard/DashboardHeader.module.css";
import Logo from "../../../assets/images/nav_logo.svg";
import Notification from "../../../assets/images/notification.svg";
import LetteredAvatar from "react-lettered-avatar";
import Search from "../../../assets/images/search.svg";
import SearchBlue from "../../../assets/images/search_blue.svg";
import Menu from "../../../assets/images/menu.svg";
import Signout from "../../../assets/images/signout.svg";
import { MobileNav } from "components/dashboard/mobileNav";
import { useNavigate } from "react-router-dom";
import { userInfo } from "store/slice/UserSlice";
import ProfileIcon from "../../../assets/images/profile-circle.svg";
import { useDispatch, useSelector } from "react-redux";
import { useRef } from "react";
import axios from "axios";
import { useEffect } from "react";
import { useCallback } from "react";



const RRD_Nav = () => {
    const [mobileSearch, setMobileSearch] = useState(false);
    const [activateSearchContainer, setActivateSearchContainer] = useState(false)
    const [searchData, setSearchData] = useState([])
    const [data, setdata] = useState([])
    const searchRef = useRef(null);
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const { user } = useSelector(state => state.user);
    const userName = user.fullName;
    const [showMenuProfile, setShowMenuProfile] = useState(false);
    // const [showProfileDetails, setShowProfileDetails] = useState(false);
    const [showMenu, setShowMenu] = useState(false);

    const handleSubmit = event => {
        event.preventDefault();
        const itemFound = data.filter((item)=>item.profileTitle.toLowerCase().includes(searchRef.current.value))
        setSearchData(itemFound)
        // Quota submission code goes here
    };
    const handleSignOut = () => {
        localStorage.removeItem("tokenHngKey");
        dispatch(userInfo(""));
        navigate("/");
    };
    const token = localStorage.getItem("tokenHngKey");
    const getApplicationDetail =  useCallback( async () => {
           try {
               const response = await axios.get(
                   "https://api.applyforme.hng.tech/api/v1/professional-profile/entries/all",
                   {
                       headers: {
                           "Authorization": `Bearer ${token}`
                       }
                   }
               );
               setSearchData(response.data.content);
               setdata(response.data.content)
           } catch (err) {
               console.log(err.response?.data);
           }
       },[token]);
       useEffect(() => {
        getApplicationDetail();
       }, [ getApplicationDetail ]);

        const handleChange =(e)=>{
            const itemFound = data.filter((item)=>item.profileTitle.toLowerCase().includes(e.target.value))
            setSearchData(itemFound)
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
                        {/*form for searching for users and reverse recruiter */}
                        <form
                            className={classes.search}
                            onSubmit={event => handleSubmit(event)}
                        >
                            <input
                               ref={searchRef}
                               type="search"
                               name="search"
                               placeholder="Search for Users"
                               onFocus={()=>setActivateSearchContainer(true)}
                               onChange={handleChange}
                            />
                            <button type="submit">
                                {" "}
                                <img src={Search} alt="Apply for me logo" />
                            </button>
                        </form>

                        <div className={classes.notification_user}>
                            <div className={classes.notice_logo}>
                                <img
                                    src={Notification}
                                    alt="Notification logo"
                                />
                            </div>
                            <div className={classes.search_logo}>
                                <img src={SearchBlue} alt="Search " 
                                    onClick={() =>
                                        setMobileSearch(prev => !prev)
                                    } 
                                />
                               
                            </div>
                            <div
                                className={classes.user_avater}
                                onClick={() => setShowMenuProfile(true)}
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
                                                navigate("/reverse/profile");
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
                                            <p onClick={handleSignOut}>
                                                Sign out
                                            </p>
                                        </li>
                                    </ul>
                                </div>
                            )}
                        </div>
                    </section>
                </nav>
                {/* Mobile nav */}
                {mobileSearch && (
                    <form
                        className={classes.mobilesearch}
                        onSubmit={event => handleSubmit(event)}
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
                               searchData?.map((data, index)=>{
                                    return(
                                        <div className={classes.SearchContainer_child_div} key={index} onClick={()=>navigate(`/professional-profile/user/details/${data?.id}`)}>
                                            <div className={classes.SearchContainer_child_div_wrapper}>
                                                <div className={classes.SearchContainer_img_wrapper}>
                                                <LetteredAvatar
                                                    name={data?.professional?.member?.firstName }
                                                    backgroundColor={"#78909c"}
                                                />  
                                                </div>
                                                <div>
                                                    <p className={classes.SearchContainer_name}>{data?.profileTitle}</p>
                                                    <p className={classes.SearchContainer_email}>{data?.professional?.member?.emailAddress}</p>
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
        </section>
    );
};

export default RRD_Nav;
