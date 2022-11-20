import { useState } from "react";
import CoverLetter from "./CoverLetter/CoverLetter";
import JobSearch from "./JobSearch/JobSearch";
import Review from "./Review/Review";
import Settings from "./Settings/Settings";
import styles from "./CreateProfile.module.css";
import TopBar from "../TopBar/TopBar";
import BlueButton from "../../../components/buttons/blue_background/BlueButton";
import BlueBorderButton from "../../../components/buttons/blue_border_button/BlueBorderButton";
import LightButton from "../../../components/buttons/light_button/LightButton";

const CreateProfile = () => {
    const [step, setStep] = useState(0);

    const FormSteps = ["JobSearch", "CoverLetter", "Settings", "Review"];
    const FormDisplay = () => {
        if (step === 0) {
            return <JobSearch />;
        } else if (step === 1) {
            return <CoverLetter />;
        } else if (step === 2) {
            return <Settings />;
        } else if (step === 3) {
            return <Review />;
        }
    };
    return (
        <div className={styles.createprofile}>
            <TopBar />
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
                    {step === 0 ? (
                        <BlueButton text={"1"} func={() => setStep(0)} />
                    ) : (
                        <BlueBorderButton text={"1"} func={() => setStep(0)} />
                    )}
                    {step === 1 ? (
                        <BlueButton text={"2"} func={() => setStep(1)} />
                    ) : (
                        <BlueBorderButton text={"2"} func={() => setStep(1)} />
                    )}
                    {step === 2 ? (
                        <BlueButton text={"3"} func={() => setStep(2)} />
                    ) : (
                        <BlueBorderButton text={"3"} func={() => setStep(2)} />
                    )}
                    {step === 3 ? (
                        <BlueButton text={"4"} func={() => setStep(3)} />
                    ) : (
                        <BlueBorderButton text={"4"} func={() => setStep(3)} />
                    )}
                </nav>
            </div>

            <div>
                <div>{FormDisplay()}</div>
                <div className={styles.stepbuttons}>
                    {step > 0 && step < 3 && (
                        <LightButton
                            width={150}
                            text={"Back"}
                            disabled={step === 0}
                            func={() => {
                                setStep(currStep => currStep - 1);
                            }}
                        />
                    )}
                    {step < 3 && (
                        <BlueButton
                            disabled={step === FormSteps.length}
                            width={150}
                            text={"Next"}
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
