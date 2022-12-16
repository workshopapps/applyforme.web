import React, { useState } from "react";
import classes from "./AccountSettings.module.css";
// import SettingsTopNav from "./SettingsTopNav";
// import person from "../../pages/dashboard_profile/assets/profilepic.png";
import LetteredAvatar from "react-lettered-avatar";
import { useEffect } from "react";
import axios from "axios";
import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";
import { useSelector } from "react-redux";
import { toast, ToastContainer } from "react-toastify";
// import DashboardSidebar from "../../components/dashboard_sidebar/DashboardSidebar";
//import { getActiveLink } from './settingservice/SettingsSecondSidebar'

const AccountSettings = ({ details }) => {
    //User Info
    const { user } = useSelector(state => state.user);

    const fullName = user.fullName;
    const userEmail = user.sub;
    const [countryDetails, setCountryDetails] = useState([]);

    const [formField, setFormField] = useState({
        first_name: details?.firstName,
        last_name: details?.lastName,
        email: details?.emailAddress,
        phone_number: details?.phoneNumber,
        address: details?.address,
        city: "",
        state: "",
        country_of_residence: "",
        nationality: "",
        date_of_birth: details?.dateOfBirth,
        username: ""
    });

    const fetchCountry = async () => {
        const token = localStorage.getItem("tokenHngKey");
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/country/entries/all`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            setCountryDetails(response.data);
        } catch (err) {
            console.log("error for country", err);
        }
    };

    const post = {
        "first_name": formField.first_name,
        "last_name": formField.last_name,
        "country_of_residence": Number(formField.country),
        "date_of_birth": formField.dateOfBirth,
        "current_job_title": formField.currentJobTitle,
        "email_address": formField.email,
        "username": formField.username,
        "phone_number": formField.phone_number,
        "city": formField.city,
        "state": formField.state,
        "address": formField.address
    };
    const updateInfo = async () => {
        const token = localStorage.getItem("tokenHngKey");
        try {
            // eslint-disable-next-line no-unused-vars
            const res = await axios.put(
                `https://api.applyforme.hng.tech/api/v1/member/update`,
                post,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    },
                    params: { "id": details.id }
                }
            );
            toast.success("Profile successfully updated");
        } catch (err) {
            console.log("error for update", err);
            toast.error(err?.response.data.message);
        }
    };

    useEffect(() => {
        fetchCountry();
    }, []);

    const submitForm = () => {
        updateInfo();
    };

    const [activeLink, setActiveLink] = useState({
        profile: true,
        password: false,
        preference: false
    });

    // const handleCvUpload = async e => {
    //     // setFormData({ ...formData, cv_file: undefined });
    //     setFormField({ ...formField, img_file: e.target.files[0] });

    //     const file = e.target.files[0];
    //     const fileName = file?.name;
    //     const fileExtension = fileName?.split(".").pop();
    //     //Make POST requests
    //     // setRequestStatus("loading");
    //     try {
    //         // First POST request
    //         const firstResponse = await axios.post(
    //             `https://api.applyforme.hng.tech/api/v1/upload/pre-signed-avatar?extension=.${fileExtension}`
    //         );
    //         console.log(firstResponse.data);
    //         // Second POST request
    //         const fd = new FormData();
    //         fd.set("file", file);
    //         const secondResponse = await fetch(firstResponse.data, {
    //             method: "PUT",
    //             body: fd
    //         });
    //         console.log(secondResponse);
    //         const shortenedCVUrl = secondResponse.url.split("?")[0];
    //         console.log(shortenedCVUrl);
    //         setFormField({
    //             ...formField,
    //             cv_file: e.target.files[0],
    //             shortenedCVUrl: shortenedCVUrl
    //         });
    //         // setRequestStatus("idle");
    //     } catch (error) {
    //         console.log(error);
    //         // setRequestStatus("idle");
    //     }
    // };

    return (
        <div className={classes.account_settings_container}>
            <div className={classes.body_container}>
                <TopBar
                    title={"Account Settings"}
                    style={{
                        marginTop: "auto",
                        color: "#2e3192",
                        fontWeight: "700",
                        marginLeft: "2.5rem"
                    }}
                />
                <hr />
                <div className={classes.body_content}>
                    <div className={classes.second_sidenav}>
                        <ul>
                            <li
                                id="profile_btn"
                                className={`${
                                    activeLink.profile && classes.active
                                }`}
                                onClick={() =>
                                    setActiveLink({
                                        ...activeLink,
                                        profile: true,
                                        password: false,
                                        preference: false
                                    })
                                }
                            >
                                Profile
                            </li>
                            <li
                                id="password_btn"
                                onClick={() =>
                                    setActiveLink({
                                        ...activeLink,
                                        profile: false,
                                        password: true,
                                        preference: false
                                    })
                                }
                                className={`${
                                    activeLink.password && classes.active
                                }`}
                            >
                                Password
                            </li>
                            {activeLink.Membership && (
                                <li>Membership Status</li>
                            )}

                            <li
                                onClick={() =>
                                    setActiveLink({
                                        ...activeLink,
                                        profile: false,
                                        password: false,
                                        preference: true
                                    })
                                }
                                id="preference_btn"
                                className={`${
                                    activeLink.preference && classes.active
                                }`}
                            >
                                Account Preference
                            </li>
                        </ul>
                    </div>
                    <ToastContainer />
                    <form
                        onSubmit={e => e.preventDefault()}
                        className={classes.form}
                    >
                        {activeLink.profile && (
                            <div id="profile_div">
                                <h3>Personal Information</h3>
                                <div className={classes.change_image}>
                                    <div className={classes.image}>
                                        <LetteredAvatar
                                            name={fullName}
                                            backgroundColor={"#78909c"}
                                        />
                                    </div>
                                </div>

                                <div className={classes.input_fields}>
                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="first_name">
                                                First Name
                                            </label>
                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        first_name:
                                                            event.target.value
                                                    })
                                                }
                                                value={formField?.first_name}
                                                type="text"
                                                name="first_name"
                                                id="first_name"
                                                placeholder="First Name"
                                            />
                                        </div>
                                        <div className={classes.form_control}>
                                            <label htmlFor="last_name">
                                                Last Name
                                            </label>
                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        last_name:
                                                            event.target.value
                                                    })
                                                }
                                                value={formField.last_name}
                                                type="text"
                                                name="last_name"
                                                id="last_name"
                                                placeholder="Last Name"
                                            />
                                        </div>
                                    </div>

                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="email">Email</label>
                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        email: event.target
                                                            .value
                                                    })
                                                }
                                                value={userEmail}
                                                type="email"
                                                readOnly
                                                name="email"
                                                id="email"
                                                placeholder="Email Address"
                                            />
                                        </div>
                                    </div>

                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="number">
                                                Contact Number
                                            </label>
                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        phone_number:
                                                            event.target.value
                                                    })
                                                }
                                                value={formField.phone_number}
                                                type="text"
                                                name="number"
                                                id="number"
                                                placeholder="+234-567-890-00"
                                            />
                                        </div>
                                    </div>

                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="address">
                                                Address
                                            </label>
                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        address:
                                                            event.target.value
                                                    })
                                                }
                                                value={formField.address}
                                                type="text"
                                                name="address"
                                                id="address"
                                                placeholder="36, Amen Estate"
                                            />
                                        </div>
                                    </div>

                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="city">City</label>
                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        city: event.target.value
                                                    })
                                                }
                                                value={formField.city}
                                                type="text"
                                                name="city"
                                                id="city"
                                                placeholder="Ikeja"
                                            />
                                        </div>
                                        <div className={classes.form_control}>
                                            <label htmlFor="state">State</label>
                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        state: event.target
                                                            .value
                                                    })
                                                }
                                                value={formField.state}
                                                type="text"
                                                name="state"
                                                id="state"
                                                placeholder="Lagos"
                                            />
                                        </div>
                                    </div>

                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="country_of_residence">
                                                Country
                                            </label>
                                            <select
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        country_of_residence:
                                                            event.target.value
                                                    })
                                                }
                                                value={
                                                    formField.country_of_residence
                                                }
                                                type="text"
                                                name="country"
                                            >
                                                <option value="">
                                                    Select a country
                                                </option>
                                                {countryDetails.map(item => (
                                                    <option
                                                        key={item.id}
                                                        value={item.id}
                                                    >
                                                        {item.title}
                                                    </option>
                                                ))}
                                            </select>
                                        </div>
                                    </div>

                                    <div>
                                        <button onClick={submitForm}>
                                            Save
                                        </button>
                                    </div>
                                </div>
                            </div>
                        )}

                        {activeLink.password && (
                            <div id="password_div">
                                <h3 style={{ fontWeight: "bold" }}>
                                    Change Password
                                </h3>

                                <div className={classes.input_fields}>
                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="password">
                                                Old Password
                                            </label>

                                            <input
                                                type="password"
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        old_password:
                                                            event.target.value
                                                    })
                                                }
                                                value={formField.old_password}
                                            />
                                        </div>
                                    </div>
                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="password">
                                                New Password
                                            </label>

                                            <input
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        new_password:
                                                            event.target.value
                                                    })
                                                }
                                                value={formField.new_password}
                                                type="password"
                                            />
                                        </div>
                                    </div>
                                    <div className={classes.row}>
                                        <div className={classes.form_control}>
                                            <label htmlFor="password">
                                                Confirm New Password
                                            </label>

                                            <input
                                                value={
                                                    formField.confirm_new_password
                                                }
                                                onChange={event =>
                                                    setFormField({
                                                        ...formField,
                                                        confirm_new_password:
                                                            event.target.value
                                                    })
                                                }
                                                type="password"
                                            />
                                        </div>
                                    </div>
                                    <div>
                                        <button>Save</button>
                                    </div>
                                </div>
                            </div>
                        )}

                        {activeLink.preference && (
                            <div id="preference_div">
                                <div>
                                    <h3>Notifications</h3>
                                    <div>
                                        <p>
                                            Manage the kind of notifications you
                                            get about your activities, interest
                                            and recommendations
                                        </p>
                                    </div>
                                </div>

                                <div></div>
                            </div>
                        )}
                    </form>
                </div>
            </div>
        </div>
    );
};

export default AccountSettings;
