import React, { useState } from "react";
import { useFormik } from "formik";
import * as Yup from "yup";
import axios from "axios";
import ContactModal from "./ContactModal";

const ContactUsForm = () => {
    const [submitBtn, setSubmitBtn] = useState(false);
    const onSubmit = (values, actions) => {
        console.log(actions);
        axios
            .post("https://api.applyforme.hng.tech/api/v1/contact-us", values)
            .then(response => {
                console.log(response);
            })
            .catch(error => {
                console.log(error);
            });
        console.log(values, actions);
        setSubmitBtn(true);
        actions.resetForm();
    };

    const { values, handleBlur, handleChange, touched, errors, handleSubmit } =
        useFormik({
            // form state
            initialValues: {
                first_name: "",
                last_name: "",
                email_address: "",
                message: "",
                privacy_policy: false,
                phone_number: ""
            },

            //   form validation
            validationSchema: Yup.object().shape({
                first_name: Yup.string()
                    .max(20, "Name must be 20 characters or less.")
                    .required("Please enter your first name"),
                last_name: Yup.string()
                    .max(20, "Name must be 20 characters or less.")
                    .required("please enter your last name"),
                email_address: Yup.string()
                    .email("Invalid email address")
                    .required("Email is required"),
                message: Yup.string().required("please enter your message"),
                phone_number: Yup.number()
                    .min(11)
                    .required("Please enter a phone number"),
                privacy_policy: Yup.boolean().oneOf([true], "please agree")
            }),

            onSubmit
        });

    return (
        <div className="form-body">
            <form onSubmit={handleSubmit}>
                <div className="form-first-line">
                    <div className="form-group first-line-1">
                        <label htmlFor="first_name">First Name</label>
                        <input
                            type="text"
                            name="first_name"
                            id="first_name"
                            className={
                                touched.first_name && errors.first_name
                                    ? "input-error"
                                    : ""
                            }
                            value={values.first_name}
                            onChange={handleChange}
                            onBlur={handleBlur}
                            placeholder="Enter first name"
                        />
                        {touched.first_name && errors.first_name && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.first_name}
                            </small>
                        )}
                    </div>

                    <div className="form-group first-line-2">
                        <label htmlFor="last_name">Last Name</label>
                        <input
                            type="text"
                            id="last_name"
                            name="last_name"
                            className={
                                touched.last_name && errors.last_name
                                    ? "input-error"
                                    : ""
                            }
                            placeholder="Enter your last name"
                            value={values.last_name}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.last_name && errors.last_name && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.last_name}
                            </small>
                        )}
                    </div>
                </div>

                <div className="form-second-line">
                    <div className="form-group">
                        <label>Email</label>
                        <input
                            type="email"
                            id="email"
                            name="email_address"
                            className={
                                touched.email_address && errors.email_address
                                    ? "input-error"
                                    : ""
                            }
                            placeholder="yourname@gmail.com"
                            value={values.email_address}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />

                        {touched.email_address && errors.email_address && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.email_address}
                            </small>
                        )}
                    </div>
                </div>

                <div className="form-third-line">
                    <div className="form-group">
                        <label>Phone Number</label>
                        <input
                            type="tel"
                            id="phoneNumber"
                            name="phone_number"
                            className={
                                touched.phone_number && errors.phone_number
                                    ? "input-error"
                                    : ""
                            }
                            placeholder="Enter your phone number"
                            value={values.phone_number}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.phone_number && errors.phone_number && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.phone_number}
                            </small>
                        )}
                    </div>
                </div>

                <div className="form-fourth-line">
                    <div className="form-group">
                        <label>Message</label>
                        <div>
                            <textarea
                                id="message"
                                name="message"
                                cols="30"
                                rows="5"
                                className={
                                    touched.message && errors.message
                                        ? "textarea-error"
                                        : ""
                                }
                                placeholder="message"
                                value={values.message}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            ></textarea>
                            {touched.message && errors.message && (
                                <small
                                    style={{
                                        color: "#EB5757",
                                        paddingTop: "0.3rem"
                                    }}
                                >
                                    {errors.message}
                                </small>
                            )}
                        </div>
                    </div>
                </div>

                <div className="form-fifth-line">
                    <div className="radio-group">
                        <input
                            type="checkbox"
                            id="check"
                            name="privacy_policy"
                            value={values.privacy_policy}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />

                        <label className="privacy">
                            {" "}
                            I have read the afm Privacy Policy
                        </label>
                    </div>
                    {touched.privacy_policy && errors.privacy_policy && (
                        <small
                            style={{ color: "#EB5757", paddingTop: "0.3rem" }}
                        >
                            {errors.privacy_policy}
                        </small>
                    )}
                </div>

                <button type="submit" className="submit-button">
                    Send Message
                </button>
            </form>

            {submitBtn && <ContactModal setSubmitBtn={setSubmitBtn} />}
        </div>
    );
};

export default ContactUsForm;
