import style from "./ApplicationForm.module.css";
import goBackIcon from "../../../../assets/images/back_arrow.svg";
import { useState,useEffect } from "react";

import { Link, useNavigate, useParams } from "react-router-dom";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";
import jwtDecode from "jwt-decode";
import { toast } from "react-toastify";
import axios from "axios";

const ApplicationForm = () => {

    const {id} = useParams();
    const token = localStorage.getItem("tokenHngKey");
    const decoded = jwtDecode(localStorage.getItem("tokenHngKey"))
    console.log(decoded);
    const [professional, setProfessional] = useState()
     const [state, setState] = useState({
        name: "",
        role: "",
        plan: "",
        company: "",
        reverse_recruiter: ""
    });
    const handleSubmit=(e)=>{
        e.preventDefault();
        const submitDetails = async () => {
            console.log( state?.company, )
            try {
                const response = await axios.post(
                    "https://api.applyforme.hng.tech/api/v1/job-submission/save",
                    {
                        "professional_id":professional?.id,
                        "applier_id": decoded.memberId,
                        "professional_profile_id": professional?.professional?.id,
                        "job_company": state?.company
                    },
                    {
                        headers: {
                            "Authorization": `Bearer ${token}`
                        }
                    }
                );
                toast.success("seccesful")
                console.log(response.data)
                setDetails(response?.data?.professional);
            } catch (err) {
                 toast.error("seccesful")
                console.log(err.response?.data);
            }
        };
        submitDetails();
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
            setProfessional(response.data);
            console.log(professional);
        } catch (err) {
            console.log(err.response?.data);
        }
    };

    useEffect(()=>{
        getProfessionalProfile()
    },[])

   

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
            value: `${professional?.professional?.member?.firstName}`
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
            value: `${decoded.fullName}`
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
            <form className={style.form} onSubmit={handleSubmit}>
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
