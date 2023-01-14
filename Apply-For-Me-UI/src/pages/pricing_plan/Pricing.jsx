import React, { useEffect, useState } from "react";
import styles from "pages/pricing_plan/pricing.module.css";
import { useNavigate } from "react-router-dom";

//Importing bluebutton component
import BlueBorderButton from "components/buttons/blue_border_button/BlueBorderButton";

//The question component
import Question from "pages/pricing_plan/question/Question";
import Plans3 from "./components/Plans3";
import Plans4 from "./components/Plans4";

import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
//import BlueButton from "components/buttons/blue_background/BlueButton";
//import { useSelector } from "react-redux";
import { ToastContainer } from "react-toastify";

const Pricing = ({
    primaryHeading,
    primaryText,
    plans,
    plansFull,
    toggleInfo,
    faqSection,
    secondaryHeading,
    secondaryText,
    faqSection: { faqHeading, faqText, faqBtnText }
}) => {
    const [toggle, setToggle] = useState({
        monthly: true,
        yearly: false
    });
    const [paymentInterval, setpaymentInterval] = useState();
    const [seeMore, setSeeMore] = useState(false);

    useEffect(() => {
        toggle.yearly
            ? setpaymentInterval("yearly")
            : setpaymentInterval("monthly");
    }, [toggle.yearly, paymentInterval]);
 
    const navigate = useNavigate();

    return (
        <>
            <ToastContainer />
            <Nav setSeeMore={setSeeMore} />
            <main className={styles.container}>
                <section className={styles.section__head}>
                    <div className={styles.headingWrapper}>
                        <h1 className={styles.mainheading}>{primaryHeading}</h1>
                        <p className={styles.primaryText}>{primaryText}</p>
                    </div>
                </section>
                <section className={styles.section__plans}>
                    <div className={styles.planWrapper}>
                        <div className={styles.toggle}>
                            <p
                                onClick={() =>
                                    setToggle({ yearly: false, monthly: true })
                                }
                                className={
                                    toggle.monthly ? styles.active_toggle : ""
                                }
                            >
                                {toggleInfo.text1}
                            </p>
                            <div
                                className={styles.toggle_state}
                                onClick={() =>
                                    setToggle({
                                        yearly: !toggle.yearly,
                                        monthly: !toggle.monthly
                                    })
                                }
                            >
                                <span
                                    className={styles.toggle_circle}
                                    style={{
                                        right: toggle.yearly ? "2px" : "2rem"
                                    }}
                                ></span>
                            </div>
                            <p
                                onClick={() =>
                                    setToggle({ yearly: false, monthly: true })
                                }
                                className={
                                    toggle.yearly ? styles.active_toggle : ""
                                }
                            >
                                {toggleInfo.text2}
                            </p>
                        </div>
                        {seeMore ? (
                            <Plans4
                                paymentInterval={paymentInterval}
                                plans={plans}
                            />
                        ) : (
                            <Plans3
                                paymentInterval={paymentInterval}
                                plans={plansFull}
                            />
                        )}

                        <p className={styles.disclaimer}>
                            **All CV rebuilds and reviews are on demand services
                            therefore prices are not included in the pricing
                            plan but based on individual requests.
                        </p>
                        {!seeMore && (
                            <div className={styles.seemore}>
                                <button
                                    type="button"
                                    className={styles.seemorePar}
                                    onClick={() => {
                                        setSeeMore(true);
                                    }}
                                >
                                    See more plans
                                </button>
                            </div>
                        )}
                    </div>
                </section>
                <section className={styles.subHead}>
                    <div className={styles.secondaryHeadWrapper}>
                        <h2 className={styles.secondaryHeading}>
                            {secondaryHeading}
                        </h2>
                        <p className={styles.secondaryText}>{secondaryText}</p>
                    </div>
                </section>
                <section className={styles.faq}>
                    <div className={styles.faqWrapper}>
                        <div className={styles.faqmain}>
                            <h2 className={styles.faqheading}>{faqHeading}</h2>
                            <p className={styles.faqText}>{faqText}</p>

                            <BlueBorderButton
                                text={faqBtnText}
                                func={() => navigate("/contact")}
                            />
                        </div>

                        <div className={styles.questionWrapper}>
                            {faqSection.questions.map((question, index) => {
                                return (
                                    <Question
                                        key={index}
                                        subIcon={question.subIcon}
                                        subQuestion={question.mainQuestion}
                                        answer={question.answer}
                                    />
                                );
                            })}
                        </div>
                    </div>
                </section>
            </main>
            <Footer />
        </>
    );
};

export default Pricing;
