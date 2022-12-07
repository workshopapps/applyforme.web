import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import formStyling from "./TryoutForm.module.css";
import Input from "./components/Input";
import BlueButton from "components/buttons/blue_background/BlueButton";

const TryoutForm = () => {
    return (
        <div>
            <Nav />
            <div className={formStyling.form_wrapper}>
                <form action="" method="post">
                    <p>Please fill in your personal information below.</p>
                    <Input placeholder={"First name"} />
                    <Input placeholder={"Last name"} />
                    <Input placeholder={"Email address"} />
                    <Input placeholder={"Phone number"} />
                    <p>
                        Complete your desired job info and location for our job
                        search.
                    </p>
                    <select className={formStyling.select} name="" id="">
                        <option value="" selected disabled>
                            Job title
                        </option>
                        <option value="">Front-end developer</option>
                        <option value="">Back-end developer</option>
                        <option value="">Mobile developer</option>
                        <option value="">Product designer</option>
                        <option value="">Product manager</option>
                    </select>
                    <select className={formStyling.select} name="" id="">
                        <option value="" selected disabled>
                            Job location
                        </option>
                    </select>
                    <div className={formStyling.checkbox}>
                        <input type="checkbox" name="" id="" />{" "}
                        <p>I want only remote jobs</p>
                    </div>
                    <div className={formStyling.wrapping_col}>
                        <div className={formStyling.row_of_3}>
                            <div>
                                <label htmlFor="">Experience level</label>
                                <select
                                    className={formStyling.select}
                                    name=""
                                    id=""
                                >
                                    <option value="" selected disabled>
                                        No experience
                                    </option>
                                </select>
                            </div>
                            <div>
                                <label htmlFor="">Employment type</label>
                                <select
                                    className={formStyling.select}
                                    name=""
                                    id=""
                                >
                                    <option value="" selected disabled>
                                        Full time
                                    </option>
                                </select>
                            </div>
                            <div>
                                <label htmlFor="">Salary expectation</label>
                                <select
                                    className={formStyling.select}
                                    name=""
                                    id=""
                                >
                                    <option value="" selected disabled>
                                        $10,000 - $15,000
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div className={formStyling.button}>
                            <BlueButton width={310} text={"Submit"} />
                        </div>
                    </div>
                </form>
            </div>
            <Footer />
        </div>
    );
};

export default TryoutForm;
