import React, { useState } from "react";
import classes from "../../../components/dashboard/DashboardHeader.module.css";
import Logo from "../../../assets/images/nav_logo.svg";
import Notification from "../../../assets/images/notification.svg";
import ProfilePic from "../../../assets/images/profileImg.png";
import Search from "../../../assets/images/search.svg";
import SearchBlue from "../../../assets/images/search_blue.svg";
import Menu from "../../../assets/images/menu.svg";
import Signout from "../../../assets/images/signout.svg";
import { MobileNav } from "components/dashboard/mobileNav";
import { useNavigate } from "react-router-dom";
import { userInfo } from "store/slice/UserSlice"; 
import ProfileIcon from "../../../assets/images/profile-circle.svg";
import { useDispatch } from "react-redux";

const RRD_Nav = () => {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    const [showMenuProfile, setShowMenuProfile] = useState(false);
    // const [showProfileDetails, setShowProfileDetails] = useState(false);
    const [showMenu, setShowMenu] = useState(false);

    const handleSubmit = event => {
        event.preventDefault();
        event.target.search.value = "";
        // Quota submission code goes here
    };
    const handleSignOut =()=>{
        
        localStorage.removeItem("tokenHngKey");
        dispatch(userInfo(""));
        navigate("/");
    
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

                        <img src={Logo} alt="Apply for me logo" onClick={()=>navigate("/")}/>
                    </div>

                    <section className={classes.swap_nav}>
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
                                                navigate("/");
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
                                            <p onClick={handleSignOut}>Sign out</p>
                                        </li>
                                    </ul>
                                </div>
                            )}
                        </div>
                    </section>
                </nav>

                {/* Mobile nav */}
                {showMenu && <MobileNav setShowMenu={setShowMenu} />}
            </section>
        </section>
    );
};

export default RRD_Nav;
