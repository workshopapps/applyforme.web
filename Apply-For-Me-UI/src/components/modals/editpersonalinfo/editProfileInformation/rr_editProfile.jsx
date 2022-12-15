import "./editProfileInformation.css";
import { useDispatch } from "react-redux";
import { useFormik } from "formik";
import * as Yup from "yup";
import axios from "axios";
import { useEffect, useState } from "react";
import { toast } from "react-toastify";

export const EditInfoContent = ({ setEditModal, img }) => {
    const [countries, setCountries] = useState()
    const getCountry = async () => {
        try {
            const response = await axios.get(
                "https://api.applyforme.hng.tech/api/v1/country/entries/all"
            );
            setCountries(response?.data);
        } catch (err) {
            toast.error("An error occured.Request failed");
        }
    };
    useEffect(()=>{
        getCountry()
    },[])

    const onSubmit = (values, actions) => {
        const sendToEndPoint = async () => {
            try {
                const response = await axios.post(
                    "https://api.applyforme.hng.tech/api/v1/recruiter/update",
                    {
                        
                            "avatar": resFromContrl,
                            "first_name": values.first_name,
                            "last_name": values.last_name,
                            "nationality": values.nationality,
                            "country_of_residence": values.country_of_residence,
                            "date_of_birth":values.date_of_birth,
                            "current_job_title": values.current_job_title,
                            "email_address": values.email_address,
                            "username": values.username,
                            "phone_number": values.phone_number,
                            "city":values.city,
                            "state": values.state,
                            "address": values.address,
                          
                        
                    }
                );
                setResFromContrl(response?.data);
                console.log(response?.data);
            } catch (err) {
                console.log(err?.response?.data);
            }
        };
        sendToEndPoint();
        
        actions.resetForm();
    };
    const [fileToUpload, setFileToUpload] = useState("");
    const [resFromContrl, setResFromContrl] = useState("");
    const handleImageUpload = (e)=>{
        const file = e.target.files[0]
        TransformFile(file)
    }

    const TransformFile = (file)=>{
       const reader = new FileReader()
       if(file){
        reader.readAsDataURL(file)
        reader.onloadend = ()=>{
            setFileToUpload(reader.result)
            console.log(fileToUpload)
        }
            const sendToUploaderController = async () => {
                try {
                    const response = await axios.post(
                        "https://api.applyforme.hng.tech/api/v1/upload/pre-signed-avatar",
                        {
                            params:{
                                extension:fileToUpload
                            }
                            
                        }
                    );
                    setResFromContrl(response?.data);
                    toast.success("Upload complete")
                    console.log(response?.data);
                } catch (err) {
                    console.log(err?.response?.data);
                }
            };
            sendToUploaderController();

       }
    }
    const { values, handleBlur, handleChange, touched, errors, handleSubmit } =
        useFormik({
            // form state
            initialValues: {
                first_name: "",
                last_name: "",
                date_of_birth: "",
                current_job_title:"current_job_title",
                email_address: "",
                phone_number: "",
                nationality:"",
                country_of_residence:0,
                nationality:0,
                city: "",
                state: "",
                avatar:"",
                address: "",
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
                ),
                avatar:Yup.string().required("please choose a profile picture")
            }),

            onSubmit
        });

    return (
        <div className="edit_profileContent">
            <form onSubmit={handleSubmit}>
                <div className="edit_field">
                    <label htmlFor="avatar">
                        <input 
                            type="file" 
                            id="avatar" 
                            name="avatar"
                            onChange={handleImageUpload}
                        />
                        <img src={img} alt="object not found"/>
                    </label>
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
                            touched.city && errors.city ? "input-error" : ""
                        }
                        value={values.state}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="state"
                    />
                    {touched.state && errors.state && (
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
                        name="address"
                        id="address"
                        className={
                            touched.city && errors.city ? "input-error" : ""
                        }
                        value={values.address}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="address"
                    />
                    {touched.address && errors.address && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.address}
                        </small>
                    )}
                </div>

                 <div className="edit_field">
                    <input
                        type="text"
                        name="current_job_title"
                        id="current_job_title"
                        className={
                            touched.city && errors.city ? "input-error" : ""
                        }
                        value={values.current_job_title}
                        onChange={handleChange}
                        onBlur={handleBlur}
                        placeholder="current job title"
                    />
                    {touched.current_job_title && errors.current_job_title && (
                        <small
                            style={{
                                color: "#EB5757",
                                paddingTop: "0.1rem"
                            }}
                        >
                            {errors.current_job_title}
                        </small>
                    )}
                </div>

                <div className="edit_field">
                    <select
                        name="nationality"
                        id="nationality"
                        className={
                            touched.state && errors.state ? "input-error" : ""
                        }
                        onChange={handleChange}
                    >
                        {countries?.map(country => {
                            const { id, title } = country;
                            return (
                                <option key={id} value={id}>
                                    {title}
                                </option>
                            );
                        })}
                    </select>

                     <select
                        name="country_of_residence"
                        id="country_of_residence"
                        className={
                            touched.state && errors.state ? "input-error" : ""
                        }
                        onChange={handleChange}
                    >
                        {countries?.map(country => {
                            const { id, title } = country;
                            return (
                                <option key={id} value={id}>
                                    {title}
                                </option>
                            );
                        })}
                    </select>

                    {touched.nationality && errors.nationality && (
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
