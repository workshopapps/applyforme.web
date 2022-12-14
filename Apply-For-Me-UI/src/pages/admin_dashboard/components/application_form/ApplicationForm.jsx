import style from "./ApplicationForm.module.css";
import goBackIcon from "../../../../assets/images/back_arrow.svg";
import { useState } from "react";

import { Link, useNavigate, useParams } from "react-router-dom";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";

const ApplicationForm = () => {

    const {id} = useParams();
    console.log(id);
    const [submissionDetail,setSubmissionDetails] = useState({
        "professional_id": 0,
        "applier_id": 0,
        "professional_profile_id": 0,
        "job_title": "string",
        "job_link": "string",
        "job_location": "string",
        "job_company": "string",
        "summary": "string",
        "other_comment": "string"
    });
    
    const token = localStorage.getItem("tokenHngKey");
    const [details, setDetails] = useState();

    const getApplierDetails= async () => {
        try {
            const response = await axios.get(
                `${url}/api/v1/recruiter/details`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log("Recruiter Profile", response?.data);
            setDetails(response?.data)
            return response?.data;
           
        } catch (error) {
            return error.response?.data;
        }
    }

    const getProfessionalProfile = async () => {
        try {
            const response = await axios.get(
                `https://api.applyforme.hng.tech/api/v1/professional-profile/detail/${id}`,
                {
                    headers: {
                        "Authorization": `Bearer ${token}`
                    }
                }
            );
            console.log(response.data)
            setListArray(response.data.content);
            console.log(listArray);
        } catch (err) {
            console.log(err.response?.data);
        }
    };


    const [state, setState] = useState({
        name: "",
        role: "",
        plan: "",
        company: "",
        reverse_recruiter: ""
    });

    const handleChange = event => {
        const value = event.target.value;
        setState({
            ...state,
            [event.target.name]: value
        });
    };

    const applicationsFormData = [
        {
            id: "name",
            labelText: "Applicant's Name",
            placeholder: "John Doe",
            value: `${state.name}`
        },
        {
            id: "role",
            labelText: "Job Role",
            placeholder: "Product Design",
            value: `${state.role}`
        },
        {
            id: "plan",
            labelText: "Membership Plan",
            placeholder: "Premuim",
            value: `${state.plan}`
        },
        {
            id: "company",
            labelText: "Company's Name",
            placeholder: "Rapid River",
            value: `${state.company}`
        },
        {
            id: "reverse_recruiter",
            labelText: "Reverse Recruiter's Name",
            placeholder: "Ora Smith",
            value: `${state.reverse_recruiter}`
        }
    ];
    const navigate = useNavigate();

    return (
        <section className={style.application_form}>
            <RRD_Nav />
            <div className={style.go_back_link}>
                <Link to="/rr_admin">
                    <img src={goBackIcon} alt="" />
                </Link>
                <span
                    className={style.view_applicants}
                    onClick={() => navigate("/rr_admin/appilicants_details")}
                >
                    View Applicants details
                </span>
            </div>
            <form className={style.form}>
                <p>Please, fill this form for every application submitted</p>
                {applicationsFormData.map((item, index) => {
                    return (
                        <label htmlFor={item.id} key={index}>
                            <span>{item.labelText}</span>
                            <br />
                            <input
                                name={item.id}
                                id={item.id}
                                type="text"
                                placeholder={item.placeholder}
                                value={item.value}
                                onChange={handleChange}
                            />
                        </label>
                    );
                })}

                <input id="submit" type="submit" value="Submit" />
            </form>
        </section>
    );
};

export default ApplicationForm;
