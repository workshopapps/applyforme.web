import React, { useState } from "react";
import classes from "./AccountSettingsNew.module.css";
// import SettingsTopNav from "./SettingsTopNav";
import LetteredAvatar from "react-lettered-avatar";
// import { useEffect } from "react";
import axios from "axios";
// import TopBar from "pages/dashboard_profile/components/TopBar/TopBar";
import { useSelector } from "react-redux";
import { toast, ToastContainer } from "react-toastify";

const AccountSettingsNew = ({ details }) => {
    //User Info
    const { user } = useSelector(state => state.user);

    const fullName = user.fullName;
    // const userEmail = user.sub;
    // const [countryDetails, setCountryDetails] = useState([]);

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

    console.log(updateInfo, setFormField);

    // const submitForm = () => {
    //     updateInfo();
    // };

    return (
        <div className={classes.account_settings_container}>
            <ToastContainer />
            <div className={classes.body_container}>
                <div className={classes.body_content}>
                    <div className={classes.general_details}>
                        <h2>General Details</h2>
                        <p>Update your photo and personal detail here</p>
                    </div>

                    <div className={classes.details_settings}>
                        <div className={classes.details_setting}>
                            <h3 className={classes.settings_heading}>
                                Personal Details
                            </h3>
                            <form
                                onSubmit={e => e.preventDefault()}
                                className={classes.settings_form}
                            >
                                <div className={classes.form_row}>
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

                                <div className={classes.form_row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="email">Email</label>
                                        <input
                                            onChange={event =>
                                                setFormField({
                                                    ...formField,
                                                    email: event.target.value
                                                })
                                            }
                                            value={formField.email}
                                            type="email"
                                            readOnly
                                            name="email"
                                            id="email"
                                            placeholder="Email Address"
                                        />
                                    </div>

                                    <div className={classes.form_control}>
                                        <label htmlFor="number">
                                            Phone Number
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

                                <div className={classes.form_row}>
                                    <div className={classes.form_control}>
                                        <label htmlFor="password">
                                            Password
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
                                    <button
                                        className={
                                            classes.update_personal_details
                                        }
                                    >
                                        Update
                                    </button>
                                </div>
                            </form>
                        </div>

                        <div className={classes.photo_and_plan_settings}>
                            <h3 className={classes.settings_heading}>
                                Your Photo
                            </h3>

                            <div className={classes.edit_photo}>
                                <div className={classes.previous_photo}>
                                    <LetteredAvatar
                                        name={fullName}
                                        backgroundColor={"#52515B"}
                                    />
                                </div>
                                <div className={classes.edit_photo_buttons}>
                                    <h3
                                        className={`${classes.settings_heading} ${classes.settings_heading_without_border}`}
                                    >
                                        Edit your photo
                                    </h3>
                                    <div className={classes.edit_buttons}>
                                        <button
                                            className={classes.edit_button_red}
                                        >
                                            Delete
                                        </button>
                                        <button
                                            className={classes.edit_button_blue}
                                        >
                                            Update
                                        </button>
                                    </div>
                                </div>
                            </div>

                            <div className={classes.edit_plan_container}>
                                <h4 className={classes.plan_details}>
                                    Plan details
                                </h4>
                                <div className={classes.edit_plan}>
                                    <div className={classes.current_plan}>
                                        Basic Plan
                                    </div>
                                    <button
                                        className={`${classes.change_plan} ${classes.edit_button_blue}`}
                                    >
                                        change plan
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className={classes.membership_plan_container}>
                        <h3 className={classes.settings_heading}>
                            Membership and Billing
                        </h3>
                        <div className={classes.plan_details_container}>
                            <div className={classes.plan_details}>
                                <div className={classes.card_details_container}>
                                    <div className={classes.card_details}>
                                        <img
                                            src="https://res.cloudinary.com/doiq3txf7/image/upload/v1674223425/Praise%20Files/mastercard-svg_itpbkk.svg"
                                            alt=""
                                        />
                                        <p className={classes.card_number}>
                                            ********<span>67789</span>
                                        </p>
                                    </div>
                                    <p>
                                        To remove this card add another card
                                        first
                                    </p>
                                </div>
                                <div className={classes.next_billing_date}>
                                    <p>Next billing Date</p>
                                    <h3
                                        className={`${classes.settings_heading} ${classes.settings_heading_without_border}  ${classes.settings_heading_without_padding}`}
                                    >
                                        Your next billing date is January 31,
                                        2023
                                    </h3>
                                </div>
                            </div>

                            <button className={classes.preferred_card}>
                                Preferred Card
                            </button>

                            <button
                                className={`${classes.change_plan} ${classes.edit_button_blue}`}
                            >
                                edit billing details
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default AccountSettingsNew;
