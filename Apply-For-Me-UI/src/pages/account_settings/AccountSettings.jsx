import React, { useState } from 'react'
import "./AccountSettings.css"
import SettingsTopNav from './SettingsTopNav'
import person from "../../assets/images/Friendly Ones Avatar.png"
import SettingsSidebar from './SettingsSidebar'
//import { getActiveLink } from './settingservice/SettingsSecondSidebar'

const AccountSettings = () => {
    const [activeLink, setActiveLink] = useState({
        profile: true,
        password: false,
        preference: false,
    });

    const handleAciveLink = () => {
        setActiveLink(() => document.getElementById("password"));
    };

    return (
        <div className='account_settings_container'>
            <div className='sidebar_container'>
                <SettingsSidebar />
            </div>

            <div className="body_container">
                <SettingsTopNav />

                <div className="body_content">
                    <div className="second_sidenav">
                        <ul>
                            <li
                                className={activeLink.profile ? document.getElementsByClassName('active') : ""}
                                onClick={handleAciveLink}
                            >
                                Profile
                            </li>
                            <li
                                className={activeLink.password ? document.getElementsByClassName('active') : ""}
                            // onClick={() => document.querySelectorAll("#passwordContent")}
                            >
                                Password
                            </li>
                            <li>Membership Status</li>

                            <li
                                className={activeLink.preference ? document.getElementsByClassName('active') : ""}
                            // onClick={() => document.querySelectorAll("#preference")}
                            >
                                Account Preference
                            </li>
                        </ul>
                    </div>

                    <form>
                        <div id='profile'>
                            <h3>Personal Information</h3>
                            <div className='change_image'>
                                <div className='image'>
                                    <img src={person} alt="" />
                                </div>

                                <span>
                                    <a href="#">Change Picture</a>
                                </span>
                            </div>

                            <div className="input_fields">
                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor='name'>First Name</label>
                                        <input type="text" name="name" id="name" placeholder='First Name' />
                                    </div>
                                    <div className="form-control">
                                        <label htmlFor='name'>Last Name</label>
                                        <input type="text" name="name" id="name" placeholder='Last Name' />
                                    </div>
                                </div>

                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor="email">Email</label>
                                        <input type="email" name="email" id="email" placeholder='Email Address' />
                                    </div>
                                </div>

                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor="number">Contact Number</label>
                                        <input type="text" name="number" id="number" placeholder='+234-567-890-00' />
                                    </div>
                                </div>

                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor="address">Address</label>
                                        <input type="text" name="address" id="address" placeholder='36, Amen Estate' />
                                    </div>
                                </div>

                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor='city'>City</label>
                                        <input type="text" name="city" id="city" placeholder='Ikeja' />
                                    </div>
                                    <div className="form-control">
                                        <label htmlFor='state'>State</label>
                                        <input type="text" name="state" id="state" placeholder='Lagos' />
                                    </div>
                                </div>

                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor="country">Country</label>
                                        <input type="text" name="country" id="country" placeholder='Nigeria' />
                                    </div>
                                </div>

                                <div>
                                    <button>Save</button>
                                </div>
                            </div>
                        </div>

                        <div id='passwordContent'>
                            <h3>Password page</h3>

                            <div className="input_fields">
                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor="password">Old Password</label>
                                        <input type="password" />
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor="password">New Password</label>
                                        <input type="password" />
                                    </div>
                                </div>
                                <div className="row">
                                    <div className="form-control">
                                        <label htmlFor="password">Confirm New Password</label>
                                        <input type="password" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>

                    <div id="preference">
                        <div>
                            <h3>Notification</h3>
                            <p>Manage the kind of notification you get about your activities,interest and recommendations</p>
                        </div>

                        <div>

                        </div>
                    </div>

                </div>
            </div>
        </div>
    )
}

export default AccountSettings