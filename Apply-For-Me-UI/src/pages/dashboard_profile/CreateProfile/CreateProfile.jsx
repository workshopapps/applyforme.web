import { useState } from "react";
import CoverLetter from "./CoverLetter/CoverLetter";
import JobSearch from "./JobSearch/JobSearch";
import Review from "./Review/Review";
import Settings from "./Settings/Settings";
import styles from "./CreateProfile.module.css";
import TopBar from "../components/TopBar/TopBar";
import BlueButton from "../../../components/buttons/blue_background/BlueButton";
import { ToastContainer } from "react-toastify";

const CreateProfile = () => {
    const [step, setStep] = useState(0);
    const [keywords, setKeywords] = useState([]);
    // eslint-disable-next-line no-unused-vars
    const [modalIsOpen, setModalIsOpen] = useState(false);

    const FormSteps = ["JobSearch", "CoverLetter", "Settings", "Review"];
    const FormDisplay = () => {
        if (step === 0) {
            return (
                <JobSearch
                    formData={formData}
                    setFormData={setFormData}
                    step={step}
                    setStep={setStep}
                />
            );
        } else if (step === 1) {
            return (
                <CoverLetter formData={formData} setFormData={setFormData} />
            );
        } else if (step === 2) {
            return (
                <Settings
                    formData={formData}
                    setFormData={setFormData}
                    keywords={keywords}
                    setKeywords={setKeywords}
                />
            );
        } else if (step === 3) {
            return (
                <Review
                    formData={formData}
                    setFormData={setFormData}
                    keywords={keywords}
                    setKeywords={setKeywords}
                    setStep={setStep}
                />
            );
        }
    };
    const [formData, setFormData] = useState({
        job_title: "",
        location: "",
        isRemote: "",
        experience: "",
        employment_type: "",
        salary_expectation: "",
        cv_file: [],
        shortenedCVUrl: "",
        coverletter_subject: "",
        coverletter_body: "",
        coverletter_template: "",
        keywords: "",
        xyz: ""
    });

    return (
        <div className={styles.createprofile}>
            <TopBar
                title={"My Job Profile"}
                style={{
                    marginTop: "auto"
                }}
            />
            <p className={styles.createtext}>Let's create a new job profile</p>
            <div className={styles.content_mobile}>
                <nav className={styles.buttons_box}>
                    <button
                        onClick={() => setStep(0)}
                        className={
                            step === 0
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        JobSearch
                    </button>
                    <button
                        onClick={() => setStep(1)}
                        className={
                            step === 1
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        CoverLetter
                    </button>
                    <button
                        onClick={() => setStep(2)}
                        className={
                            step === 2
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        Settings
                    </button>
                    <button
                        onClick={() => setStep(3)}
                        className={
                            step === 3
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        Review
                    </button>
                </nav>
            </div>
            <div className={styles.content_desktop}>
                <nav className={styles.buttons_box}>
                    <button
                        onClick={() => setStep(0)}
                        className={
                            step === 0
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        JobSearch
                    </button>
                    <button
                        onClick={() => setStep(1)}
                        className={
                            step === 1
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        Template
                    </button>
                    <button
                        onClick={() => setStep(2)}
                        className={
                            step === 2
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        Settings
                    </button>
                    <button
                        onClick={() => setStep(3)}
                        className={
                            step === 3
                                ? styles.button_active
                                : styles.button_inactive
                        }
                    >
                        Review
                    </button>
                </nav>
            </div>

            <div>
                <ToastContainer />

                <div>{FormDisplay()}</div>
                <div className={styles.stepbuttons}>
                    {step < 3 && (
                        <BlueButton
                            disabled={step === FormSteps.length}
                            // width={150}
                            text={"Save and Continue"}
                            func={() => {
                                setStep(currStep => currStep + 1);
                            }}
                        />
                    )}
                </div>
            </div>
        </div>
    );
};

export default CreateProfile;
