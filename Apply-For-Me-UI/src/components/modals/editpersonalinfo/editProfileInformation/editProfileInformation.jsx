import "./editProfileInformation.css";
import { useDispatch } from "react-redux";
import { updateSuperAdminProfileInfo } from "store/slice/RR_AdminSlice";
import { useFormik } from "formik";
import * as Yup from "yup";

export const EditInfoContent = ({ setEditModal, img }) => {
    const dispatch = useDispatch();
    const onSubmit = (values, actions) => {
        dispatch(updateSuperAdminProfileInfo(values));
        actions.resetForm();
    };

    const { values, handleBlur, handleChange, touched, errors, handleSubmit } =
        useFormik({
            // form state
            initialValues: {
                first_name: "",
                last_name: "",
                date_of_birth: "",
                email_address: "",
                phone_number: "",
                city: "",
                state: ""
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
                city: Yup.string().required("please enter your city"),
                phone_number: Yup.string()
                    .min(
                        11,
                        "Phone number must be between 11 and 14 characters"
                    )
                    .required("Please enter a phone number"),
                state: Yup.string().required("please enter your state"),
                date_of_birth: Yup.string().required(
                    "Please select your date of birth"
                )
            }),

            onSubmit
        });

    return (
        <div className="edit_profileContent">
             <label htmlFor="profile">
                <input type="file" id="profile" name="profile"/>
                <img src={img} alt="object not found"/>
            </label>
            <form onSubmit={handleSubmit}>
                <div className="edit_field">
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
                                color: "#EB5757"
                            }}
                        >
                            {errors.first_name}
                        </small>
                    )}
                </div>
                <div className="edit_field">
                    <input
                        type="text"
                        name="last_name"
                        id="last_name"
                        className={
                            touched.last_name && errors.last_name
                                ? "input-error"
                                : ""
                        }
                        value={values.last_name}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="Enter last name"
                    />

                    {touched.last_name && errors.last_name && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.last_name}
                        </small>
                    )}
                </div>
                <div className="edit_field">
                    <input
                        type="date"
                        name="date_of_birth"
                        id="date_of_birth"
                        className={
                            touched.date_of_birth && errors.date_of_birth
                                ? "input-error"
                                : ""
                        }
                        value={values.date_of_birth}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="DD/MM/YYYY"
                    />

                    {touched.date_of_birth && errors.date_of_birth && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.date_of_birth}
                        </small>
                    )}
                </div>

                <div className="edit_field">
                    <input
                        type="email"
                        name="email_address"
                        id="email_address"
                        className={
                            touched.email_address && errors.email_address
                                ? "input-error"
                                : ""
                        }
                        value={values.email_address}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="Enter Email address"
                    />

                    {touched.email_address && errors.email_address && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.email_address}
                        </small>
                    )}
                </div>
                <div className="edit_field">
                    <input
                        type="text"
                        name="phone_number"
                        id="phone_number"
                        className={
                            touched.phone_number && errors.phone_number
                                ? "input-error"
                                : ""
                        }
                        value={values.phone_number}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="Enter Phone number"
                    />

                    {touched.phone_number && errors.phone_number && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.phone_number}
                        </small>
                    )}
                </div>

                <div className="edit_field">
                    <input
                        type="text"
                        name="city"
                        id="city"
                        className={
                            touched.city && errors.city ? "input-error" : ""
                        }
                        value={values.city}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="City"
                    />

                    {touched.city && errors.city && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.city}
                        </small>
                    )}
                </div>

                <div className="edit_field">
                    <input
                        type="text"
                        name="state"
                        id="state"
                        className={
                            touched.state && errors.state ? "input-error" : ""
                        }
                        value={values.state}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="State"
                    />

                    {touched.state && errors.state && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.state}
                        </small>
                    )}
                </div>

                <div className="editButtonDiv">
                    <button
                        type="button"
                        style={{
                            color: "#2E3192",
                            background: "white",
                            border: "1px solid #2E3192"
                        }}
                        onClick={() => setEditModal(false)}
                    >
                        Cancel
                    </button>
                    <button
                        type="submit"
                        style={{
                            color: "white",
                            background: "#2E3192",
                            border: "1px solid white"
                        }}
                    >
                        Save
                    </button>
                </div>
            </form>
        </div>
    );
};
