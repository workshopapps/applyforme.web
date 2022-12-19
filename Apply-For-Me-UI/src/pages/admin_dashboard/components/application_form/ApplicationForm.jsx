import style from "./ApplicationForm.module.css";
import goBackIcon from "../../../../assets/images/back_arrow.svg";
import { useState, useEffect } from "react";

import { Link, useNavigate, useParams } from "react-router-dom";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";
import jwtDecode from "jwt-decode";
import { toast, ToastContainer } from "react-toastify";
import axios from "axios";

const ApplicationForm = () => {
    const { id } = useParams();
    const token = localStorage.getItem("tokenHngKey");
    const decoded = jwtDecode(localStorage.getItem("tokenHngKey"));
    console.log(decoded);
    const [professional, setProfessional] = useState();
    const [loading, setLoading] = useState(false);
    const [state, setState] = useState({
        name: "",
        role: "",
        company: "",
        reverse_recruiter: "",
        location: "",
        jobLink: "",
        summary: ""
    });

    const handleSubmit = e => {
        e.preventDefault();
        const submitDetails = async () => {
            try {
                setLoading(true);
                const response = await axios.post(
                    "https://api.applyforme.hng.tech/api/v1/job-submission/save",
                    {
                        "professional_id":
                            professional?.professional?.member.id,
                        "applier_id": decoded.memberId,
                        // eslint-disable-next-line no-dupe-keys
                        "applier_id": decoded.memberId,
                        "professional_profile_id": professional?.id,
                        "job_company": state?.company,
                        "job_title": state?.role,
                        "job_link": state.jobLink,
                        "job_location": state.location,
                        "summary": state.summary,
                        "other_comment": "unavailable"
                    },
                    {
                        headers: {
                            "Authorization": `Bearer ${token}`
                        }
                    }
                );
                setLoading(false);
                toast.success("Submission Successfull");
                console.log(response.data);
            } catch (error) {
                if (error) {
                    setLoading(false);
                    toast.error("Submission Failed");
                    console.log(error.response.data);
                }
            }
        };
        submitDetails();
    };

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
            console.log(response.data);
            setProfessional(response.data);
            console.log(professional);
        } catch (err) {
            console.log(err.response?.data);
        }
    };

    useEffect(() => {
        getProfessionalProfile();
    }, []);

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
            id: "company",
            labelText: "Company's Name",
            placeholder: "Rapid River",
            value: `${state.company}`
        },
        {
            id: "location",
            labelText: "Job location",
            placeholder: "Job Location",
            value: `${state.location}`
        },
        {
            id: "jobLink",
            labelText: "jobLink",
            placeholder: "Job Link",
            value: `${state.jobLink}`
        },
        {
            id: "summary",
            labelText: "job summary",
            placeholder: "job summary",
            value: `${state.summary}`
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
        <>
          <ToastContainer />
         <section className={style.application_form} style={{paddingBottom:"6rem"}}>
            
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
            <p className={style.FormHeader}>Please, fill this form for every application submitted</p>
            <form className={style.form} onSubmit={handleSubmit}>
                {applicationsFormData.map((item, index) => {
                    if(item.id === "summary"){
                        return(
                            <label htmlFor={item.id} key={index}>
                                <span>{item.labelText}</span>
                                <br />
                                <textarea
                                    name={item.id}
                                    id={item.id}
                                    type="text"
                                    className={style.textArea}
                                    placeholder={item.placeholder}
                                    value={item.value}
                                    onChange={handleChange}
                                    required
                                />
                             </label>
                        )
                    }else{
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
                                    required
                                />
                            </label>
                        );
                    }
                })}
            <div className={style.buttonContainer}>
                <input id="submit" type="submit" value="Submit" />
            </div>
            </form>
            {loading && (
                <div className={style.editContainer}>
                    <div className={style.progress}>Sending application...</div>
                </div>
            )}
        </section>
        </>
    );
};

export default ApplicationForm;
