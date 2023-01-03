import React, { useEffect, useState } from "react";
import styles from "pages/pricing_plan/pricing.module.css";
import { useNavigate, useLocation} from "react-router-dom";

//Importing bluebutton component
import BlueBorderButton from "components/buttons/blue_border_button/BlueBorderButton";

//The question component
import Question from "pages/pricing_plan/question/Question";

import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import BlueButton from "components/buttons/blue_background/BlueButton";
import { useSelector } from "react-redux";
import { toast, ToastContainer } from "react-toastify";


const Pricing = ({
    primaryHeading,
    primaryText,
    plans,
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
    const  [paymentInterval, setpaymentInterval] = useState();

    useEffect(()=>{
        toggle.yearly?setpaymentInterval("yearly"):setpaymentInterval("monthly");
    },[toggle.yearly,paymentInterval])

    const location = useLocation();

    const { user } = useSelector(state => state.user);
    const navigate = useNavigate();

    return (
        <>
            <ToastContainer/>
            <Nav />
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
                                       setToggle({ yearly: false , monthly: true })                          
                                }
                                className={
                                    toggle.monthly ? styles.active_toggle : ""
                                }
                            >
                                {toggleInfo.text1}
                            </p>
                            <div className={styles.toggle_state}
                                onClick={() =>
                                        setToggle({ yearly: !toggle.yearly , monthly: !toggle.monthly })                                   
                                }
                                    >
                                <span
                                    className={styles.toggle_circle}
                                    style={{
                                        right: toggle.yearly ? "4px" : ""
                                    }}
                                ></span>
                            </div>
                            <p
                                onClick={() =>
                                    setToggle({ yearly: false , monthly: true })
                                }
                                className={
                                    toggle.yearly ? styles.active_toggle : ""
                                }
                            >
                                {toggleInfo.text2}
                            </p>
                        </div>
                        {/* <div className={styles.seemore}>
                            <p className={styles.seemorePar}>See more plans</p>
                        </div> */}
                        <div className={styles.majorPlan}>
                            {plans.map(
                                (
                                    {
                                        planName,
                                        price,
                                        duration,
                                        model,
                                        btnText,
                                        stamp
                                    },
                                    index
                                ) => {
                                    return (
                                        <div
                                            className={styles.card}
                                            key={index}
                                        >
                                            <div className={styles.choices}>
                                                <p
                                                    className={
                                                        styles.choice_text
                                                    }
                                                >
                                                    {stamp}
                                                </p>
                                            </div>

                                            <h3
                                                className={styles.card__heading}
                                            >
                                                {planName}
                                            </h3>
                                            <p className={styles.card__price}>
                                                $ {price}
                                            </p>
                                            <p
                                                className={
                                                    styles.card__duration
                                                }
                                            >
                                                {duration}
                                            </p>

                                            <div
                                                className={styles.statusWrapper}
                                            >
                                                {model.map(
                                                    (
                                                        { icon, text, alt },
                                                        index
                                                    ) => {
                                                        return (
                                                            <div
                                                                className={
                                                                    styles.status
                                                                }
                                                                key={index}
                                                            >
                                                                <img
                                                                    src={icon}
                                                                    alt={alt}
                                                                    className={
                                                                        styles.status__img
                                                                    }
                                                                />
                                                                <p
                                                                    className={
                                                                        styles.status__text
                                                                    }
                                                                >
                                                                    {text}
                                                                </p>
                                                            </div>
                                                        );
                                                    }
                                                )}
                                            </div>
                                            {(user) ? (
                                                <BlueButton
                                                    text="Get Plan"
                                                    width={200}
                                                    func={() => {
                                                        let isAuthorized;
                                                        user?.roles?.forEach(role=>{
                                                            if(role.includes('Professional')){
                                                                isAuthorized = true;
                                                            }
                                                        })
                                                        if(isAuthorized && (price !=="0")){
                                                            navigate(`/checkout/${planName}/${paymentInterval}/${price}`)
                                                        }
                                                        else if(isAuthorized && (price ==="0")){
                                                            return
                                                        }else{
                                                            toast.error("Unauthorized");
                                                        }                                                    
                                                    }}
                                                />
                                            ) : (
                                                <>
                                                <BlueButton
                                                        width={200}
                                                        text={btnText}
                                                        func={()=> navigate("/wel2",{state: {from: location}})}
                                                    />{" "}
                                                </>
                                            )}
                                        </div>
                                    );
                                }
                            )}
                        </div>

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


                            <BlueBorderButton text={faqBtnText} func={()=>navigate("/contact")}/>

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
