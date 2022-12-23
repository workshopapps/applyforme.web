import axios from "axios";
import { useForm } from "react-hook-form";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { toast, ToastContainer} from "react-toastify";
import "./create_view.css";

export const CreateRecruiter = () => {
    const [password, setPassword] = useState("password");

    const token = localStorage.getItem("tokenHngKey");
    const {
        register,
        handleSubmit,
        formState: { errors }
    } = useForm();
    const navigate = useNavigate();
    const handletoggle = () => {
        password === "password" ? setPassword("text") : setPassword("password");
    };
    const [loading, setLoading] = useState(false);
    const [countries, setCountries] = useState([]);
    const [defaultPassword] = useState("78789898");
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

    useEffect(() => {
        getCountry();
    }, []);

    const submitHandler = ({
        fName,
        lName,
        eAddy,
        password,
        nationality,
        dob,
        cor,
        cjt,
        state,
        city,
        pNum,
        uName
    }) => {
        const createRecruiter = async () => {
            try {
                setLoading(true);
                const response = await axios.post(
                    "https://api.applyforme.hng.tech/api/v1/super-admin/recruiter/save",
                    {
                        "first_name": fName,
                        "last_name": lName,
                        "email_address": eAddy,
                        "password": password,
                        "nationality": nationality,
                        "country_of_residence": cor,
                        "date_of_birth": dob,
                        "current_job_title": cjt,
                        "username": uName,
                        "phone_number": pNum,
                        "city": city,
                        "state": state
                    },
                    {
                        headers: {
                            "Authorization": `Bearer ${token}`
                        }
                    }
                );
                setLoading(false);
                console.log(response);
                toast.success("Admin successfully created, an email has being sent to the recruiter ");
            } catch (err) {
                setLoading(false);
                console.log(err.response?.data);
                toast.error(err.response?.data?.message);
            }
        };
        createRecruiter();
    };

    return (
        <>
            <ToastContainer />
            <div className="recruiterContainer">
                <div className="rContainer_div_1">
                    <div className="afmdiv">
                        <img alt="object not found" src="https://res.cloudinary.com/hamskid/image/upload/v1670693251/Group_3_xwy8bo.svg" />
                    </div>
                    <div className="imgDiv ">
                        <img alt="object not found"
                            className="img_rr"
                            src="https://res.cloudinary.com/hamskid/image/upload/v1670693275/Mask_group_zajxrc.svg"
                        />
                    </div>
                </div>
                <div className="rContainer_div_2">
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669298685/Frame_51450_hkzsj8.png"
                        alt="object not found"
                        onClick={() => navigate("/user-page")}
                    />
                    <form onSubmit={handleSubmit(submitHandler)}>
                        <p className="formTitle">
                            Fill in Reverse Recruiter Details
                        </p>
                        <div className="fContainer">
                            <div className="labelConatiner">
                                <label htmlFor="fName">First Name</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="text"
                                    name="fName"
                                    id="fName"
                                    autoFocus
                                    {...register("fName", {
                                        required: "Please enter your first name"
                                    })}
                                />
                                {errors.fName && (
                                    <p className="text-danger ">
                                        {errors.fName.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="lName">Last Name</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="text"
                                    name="lName"
                                    id="lName"
                                    autoFocus
                                    {...register("lName", {
                                        required: "Please enter your Last name"
                                    })}
                                />
                                {errors.lName && (
                                    <p className="text-danger ">
                                        {errors.lName.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="eAddy">Email</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="email"
                                    name="eAddy"
                                    id="eAddy"
                                    autoFocus
                                    {...register("eAddy", {
                                        required:
                                            "Please enter your Email Address",
                                        pattern: {
                                            value: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$/i,
                                            message: "Enter valid email address"
                                        }
                                    })}
                                />
                                {errors.eAddy && (
                                    <p className="text-danger ">
                                        {errors.eAddy.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label
                                    htmlFor="password"
                                    className="password-label"
                                >
                                    Password
                                </label>
                                <input
                                    className="input-tab"
                                    required

                                    type="password"
                                    value={defaultPassword}

                                    name="password"
                                    id="password"
                                    autoFocus
                                    {...register("password", {
                                        required: "Please enter your Password",
                                        minLength: {
                                            value: 8,
                                            message:
                                                "password must be atleast eight characters"
                                        }
                                    })}
                                />
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1670631906/Vector_1_qntpu2.svg"
                                    alt="object not found"
                                    onClick={handletoggle}
                                />
                                {errors.password && (
                                    <p className="text-danger ">
                                        {errors.password.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="nationality">Nationality</label>
                                <select
                                    className="select-tab"
                                    required
                                    name="nationality"
                                    id="nationality"
                                    autoFocus
                                    {...register("nationality", {
                                        required:
                                            "Please enter your nationality"
                                    })}
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
                                {errors.nationality && (
                                    <p className="text-danger ">
                                        {errors.nationality.message}
                                    </p>
                                )}
                            </div>

                            <div className="labelConatiner">
                                <label htmlFor="dob">Date of Birth</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="date"
                                    name="dob"
                                    id="dob"
                                    autoFocus
                                    {...register("dob", {
                                        required:
                                            "Please enter your Date of birth"
                                    })}
                                />
                                {errors.dob && (
                                    <p className="text-danger ">
                                        {errors.dob.message}
                                    </p>
                                )}
                            </div>
                        </div>
                        <div className="sConatiner">
                            <div className="labelConatiner">
                                <label htmlFor="cor">Country of Resident</label>
                                <select
                                    className="select-tab"
                                    required
                                    name="cor"
                                    id="cor"
                                    autoFocus
                                    {...register("cor", {
                                        required:
                                            "Please enter your Country of resident"
                                    })}
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
                                {errors.cor && (
                                    <p className="text-danger ">
                                        {errors.cor.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="cjt">Current job title</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="text"
                                    name="cjt"
                                    id="cjt"
                                    autoFocus
                                    {...register("cjt", {
                                        required:
                                            "Please enter your current job title"
                                    })}
                                />
                                {errors.cjt && (
                                    <p className="text-danger ">
                                        {errors.cjt.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="uName">User Name</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="text"
                                    name="uName"
                                    id="uName"
                                    autoFocus
                                    {...register("uName", {
                                        required: "Please enter your user name"
                                    })}
                                />
                                {errors.uName && (
                                    <p className="text-danger ">
                                        {errors.uName.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="pNum">Phone Number</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="text"
                                    name="pNum"
                                    id="pNum"
                                    autoFocus
                                    {...register("pNum", {
                                        required:
                                            "Please enter your Phone number"
                                    })}
                                />
                                {errors.pNum && (
                                    <p className="text-danger ">
                                        {errors.pNum.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="city">City</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="text"
                                    name="city"
                                    id="city"
                                    autoFocus
                                    {...register("city", {
                                        required: "Please enter your city Name"
                                    })}
                                />
                                {errors.city && (
                                    <p className="text-danger ">
                                        {errors.city.message}
                                    </p>
                                )}
                            </div>
                            <div className="labelConatiner">
                                <label htmlFor="state">State</label>
                                <input
                                    className="input-tab"
                                    required
                                    type="text"
                                    name="state"
                                    id="state"
                                    autoFocus
                                    {...register("state", {
                                        required: "Please enter your State"
                                    })}
                                />
                                {errors.state && (
                                    <p className="text-danger ">
                                        {errors.state.message}
                                    </p>
                                )}
                            </div>
                        </div>
                        <div className="btnCont">
                            <button className="btn-primary" type="submit">
                                Save
                            </button>
                        </div>
                    </form>
                </div>
                {loading && (
                    <div className="editContainer">
                        <div className="progress">Creating admin...</div>
                    </div>
                )}
            </div>
        </>
    );
};
