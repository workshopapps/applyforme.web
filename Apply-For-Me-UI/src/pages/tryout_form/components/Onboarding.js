/* eslint-disable no-unused-vars */
import { useNavigate, useParams } from "react-router-dom";
import Input from "./Input";
import BlueButton from "components/buttons/blue_background/BlueButton";
import { useFormik } from "formik";
import jwt_decode from "jwt-decode";
import Nav from "components/nav/Nav";
import * as Yup from "yup";
import axios from "axios";
import { useDispatch, useSelector } from "react-redux";
import { userInfo } from "store/slice/UserSlice";
import styles from "./onboarding.module.css";

const Onboarding = () => {
    const { token } = useParams();
    const navigate = useNavigate();
    const dispatch = useDispatch();
    const { user } = useSelector(state => state.user);
    const onSubmit = async values => {
        console.log(token);

        const res = await axios
            .put(
                `https://api.applyforme.hng.tech/api/v1/visitor/${token}/complete-onboard`,
                values
            )
            .then(response => {
                let decoded = jwt_decode(response.data.token);
                let tokenKey = "tokenHngKey";
                localStorage.setItem(tokenKey, response.data.token);
                dispatch(userInfo(decoded));
                navigate("/dashboard");
                return response?.data;
            })
            .catch(error => {
                return error;
            });
    };

    const { values, handleChange, handleSubmit, handleBlur, touched, errors } =
        useFormik({
            // form state
            initialValues: {
                new_password: "",
                confirmation_password: ""
            },
            //   form validation
            validationSchema: Yup.object().shape({
                new_password: Yup.string().required("Password is required"),
                confirmation_password: Yup.string()
                    .required("Please retype your password.")
                    .oneOf(
                        [Yup.ref("new_password")],
                        "Your passwords do not match."
                    )
            }),

            onSubmit
        });

    return (
        <div>
            <Nav />
            <h2 className={styles.heading}>Complete Temporary Login</h2>

            <div className={styles.container}>
                <form onSubmit={handleSubmit} className={styles.form}>
                    <div className="input--field">
                        <Input
                            type="password"
                            placeholder={"Please enter a new password"}
                            value={values.new_password}
                            onChange={handleChange}
                            id={"new_password"}
                            onBlur={handleBlur}
                            newClass={
                                touched.new_password && errors.new_password
                                    ? "input-error"
                                    : ""
                            }
                        />

                        {touched.new_password && errors.new_password && (
                            <small
                                style={{
                                    color: "#EB5757",
                                    paddingTop: "0.3rem"
                                }}
                            >
                                {errors.new_password}
                            </small>
                        )}
                    </div>

                    <div className="input--field">
                        <Input
                            type="password"
                            placeholder={"Confirm password"}
                            value={values.confirmation_password}
                            onChange={handleChange}
                            id={"confirmation_password"}
                            onBlur={handleBlur}
                            newClass={
                                touched.confirmation_password &&
                                errors.confirmation_password
                                    ? "input-error"
                                    : ""
                            }
                        />

                        {touched.confirmation_password &&
                            errors.confirmation_password && (
                                <small
                                    style={{
                                        color: "#EB5757",
                                        paddingTop: "0.3rem"
                                    }}
                                >
                                    {errors.confirmation_password}
                                </small>
                            )}
                    </div>

                    <div className={styles.button}>
                        <BlueButton
                            width={310}
                            text={"Submit"}
                            type={"submit"}
                        />
                    </div>
                </form>
            </div>
        </div>
    );
};

export default Onboarding;
