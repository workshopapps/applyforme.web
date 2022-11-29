import React from "react";
import { useFormik } from "formik";
import * as Yup from "yup";

const onSubmit = (values, actions) => {
    console.log(values, actions);
};

const ContactUsForm = () => {
    const { values, handleBlur, handleChange, touched, errors, handleSubmit } =
        useFormik({
            // form state
            initialValues: {
                firstName: "",
                lastName: "",
                email: "",
                message: "",
                check: false,
                phoneNumber: ""
            },

            //   form validation
            validationSchema: Yup.object().shape({
                firstName: Yup.string()
                    .max(20, "Name must be 20 characters or less.")
                    .required("Please enter your first name"),
                lastName: Yup.string()
                    .max(20, "Name must be 20 characters or less.")
                    .required("please enter your last name"),
                email: Yup.string()
                    .email("Invalid email address")
                    .required("Email is required"),
                message: Yup.string().required("please enter your message"),
                phoneNumber: Yup.number()
                    .min(11)
                    .required("Please enter a phone number"),
                check: Yup.boolean().oneOf(
                    [true],
                    "You must agree to the terms"
                )
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
                            name="firstName"
                            id="first_name"
                            className={
                                touched.firstName && errors.firstName
                                    ? "input-error"
                                    : ""
                            }
                            value={values.firstName}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.firstName && errors.firstName && (
                            <small style={{ color: "red" }}>
                                {errors.firstName}
                            </small>
                        )}
                    </div>

                    <div className="form-group first-line-2">
                        <label htmlFor="last_name">Last Name</label>
                        <input
                            type="text"
                            id="last_name"
                            name="lastName"
                            className={
                                touched.lastName && errors.lastName
                                    ? "input-error"
                                    : ""
                            }
                            placeholder="Enter your last name"
                            value={values.lastName}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.lastName && errors.lastName && (
                            <small style={{ color: "red" }}>
                                {errors.lastName}
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
                            name="email"
                            className={
                                touched.email && errors.email
                                    ? "input-error"
                                    : ""
                            }
                            placeholder="yourname@gmail.com"
                            value={values.email}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />

                        {touched.email && errors.email && (
                            <small style={{ color: "red" }}>
                                {errors.email}
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
                            name="phoneNumber"
                            className={
                                touched.phoneNumber && errors.phoneNumber
                                    ? "input-error"
                                    : ""
                            }
                            placeholder="Enter your phone number"
                            value={values.phoneNumber}
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />
                        {touched.phoneNumber && errors.phoneNumber && (
                            <small style={{ color: "red" }}>
                                {errors.phoneNumber}
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
                                        : "textarea"
                                }
                                placeholder="message"
                                value={values.message}
                                onChange={handleChange}
                                onBlur={handleBlur}
                            ></textarea>
                            {touched.message && errors.message && (
                                <small style={{ color: "red" }}>
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
                            name="check"
                            value="checked"
                            onChange={handleChange}
                            onBlur={handleBlur}
                        />

                        <label className="privacy">
                            {" "}
                            I have read the afm privacy
                        </label>
                    </div>
                    {touched.check && errors.check && (
                        <small style={{ color: "red" }}>{errors.check}</small>
                    )}
                </div>

                <button type="submit">Send Message</button>
            </form>
        </div>
    );
};

export default ContactUsForm;
