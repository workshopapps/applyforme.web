import React,{ useState } from "react";
import { useFormik } from "formik";
import * as Yup from "yup";
import axios from 'axios';

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

<<<<<<< HEAD
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
=======
    const initialValues = { first_name: "", last_name: "",  phone_number: "", 'message': "" , privacy_policy: "true" };
    const [formValues, setFormValues] = useState(initialValues);

    
    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormValues({ ...formValues, [name]: value });
      };
    
      const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('https://official-volunux.uc.r.appspot.com/api/v1/contact-us', formValues )
    
        .then(response => {
            console.log(response)
        })
        .catch(error => {
            console.log(error)
        })

        alert('Your message has been sent sent. Thank You!')

      };


  return (
    <div className="form-body">
        <form onSubmit={handleSubmit}>
>>>>>>> edd3271319c7e284bb1fcdf144f544d70299a639

    return (
        <div className="form-body">
            <form onSubmit={handleSubmit}>
                <div className="form-first-line">
                    <div className="form-group first-line-1">
<<<<<<< HEAD
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
=======
                        <label>First Name</label>
                        <input type="text" name='first_name' required value={formValues.first_name} onChange={handleChange}/>
                       
                    </div>

                    <div className="form-group first-line-2">
                        <label>Last Name</label>
                        <input type="text" name='last_name' required value={formValues.last_name} onChange={handleChange}></input>
                      
>>>>>>> edd3271319c7e284bb1fcdf144f544d70299a639
                    </div>
                </div>

                <div className="form-second-line">
                    <div className="form-group">
                        <label>Email</label>
<<<<<<< HEAD
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
=======
                        <input type="email" name='email_address' required value={formValues.email_address} onChange={handleChange}></input>
                       
                    </div>
>>>>>>> edd3271319c7e284bb1fcdf144f544d70299a639

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
<<<<<<< HEAD
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
=======
                        <input type="text" name='phone_number' required value={formValues.phone_number} onChange={handleChange}></input>
>>>>>>> edd3271319c7e284bb1fcdf144f544d70299a639
                    </div>
                </div>

                <div className="form-fourth-line">
                    <div className="form-group">
                        <label>Message</label>
<<<<<<< HEAD
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
=======
                        <div className="textarea">
                           <textarea  name='message' required value={formValues.message} onChange={handleChange}></textarea>
                          
>>>>>>> edd3271319c7e284bb1fcdf144f544d70299a639
                        </div>
                    </div>
                </div>

                <div className="form-fifth-line">
                    <div className="radio-group">
<<<<<<< HEAD
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
=======
                        <input type="radio" value={formValues.privacy_policy} onChange={handleChange}></input>
                        <label className="privacy"> I have read the afm privacy</label>
>>>>>>> edd3271319c7e284bb1fcdf144f544d70299a639
                    </div>
                    {touched.check && errors.check && (
                        <small style={{ color: "red" }}>{errors.check}</small>
                    )}
                </div>

<<<<<<< HEAD
                <button type="submit">Send Message</button>
            </form>
        </div>
    );
};
=======
                <button value='submit' >Send Message</button>

        </form>
      
    </div>
  );
}
>>>>>>> edd3271319c7e284bb1fcdf144f544d70299a639

export default ContactUsForm;
