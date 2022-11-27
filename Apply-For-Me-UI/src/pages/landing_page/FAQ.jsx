import React from "react";
import { Link } from "react-router-dom";
import { useState } from "react";
import classes from "./Hero.module.css";
import arrowdown from "../../assets/images/arrow-down.png";

const FAQ = () => {
    const [faQuestions] = useState([
        {
            id: 1,
            question: "What is afm",
            answer: `A reverse recruiting platform puts your
            cv and profile ahead of other job
            applicants all you have to do is attend
            your interview`,
            month: "4 months ago",
            linkText: "learn more",
            imgUrl: "../../assets/images/arrow-down.png"
        },
        {
            id: 2,
            question: " Is there a limit to number of applications",
            answer: `A reverse recruiting platform puts your
            cv and profile ahead of other job
            applicants all you have to do is attend
            your interview`,
            month: "4 months ago",
            linkText: "learn more",
            imgUrl: "../../assets/images/arrow-down.png"
        },
        {
            id: 3,
            question: "  Is there a limit to number of applications",
            answer: `A reverse recruiting platform puts your
            cv and profile ahead of other job
            applicants all you have to do is attend
            your interview`,
            month: "4 months ago",
            linkText: "learn more",
            imgUrl: "../../assets/images/arrow-down.png"
        },
        {
            id: 4,
            question: "Can you help with my cv",
            answer: `A reverse recruiting platform puts your
            cv and profile ahead of other job
            applicants all you have to do is attend
            your interview`,
            month: "4 months ago",
            linkText: "learn more",
            imgUrl: "../../assets/images/arrow-down.png"
        },
        {
            id: 5,
            question: "  Does afm writes cover letter",
            answer: `A reverse recruiting platform puts your
            cv and profile ahead of other job
            applicants all you have to do is attend
            your interview`,
            month: "4 months ago",
            linkText: "learn more",
            imgUrl: "../../assets/images/arrow-down.png"
        },
        {
            id: 6,
            question: "Is there a refund policy",
            answer: `A reverse recruiting platform puts your
            cv and profile ahead of other job
            applicants all you have to do is attend
            your interview`,
            month: "4 months ago",
            linkText: "learn more",
            imgUrl: "../../assets/images/arrow-down.png"
        },
        {
            id: 7,
            question: " How do i know if im invited for an interview",
            answer: `A reverse recruiting platform puts your
            cv and profile ahead of other job
            applicants all you have to do is attend
            your interview`,
            month: "4 months ago",
            linkText: "learn more",
            imgUrl: "../../assets/images/arrow-down.png"
        }
    ]);
    const [toggle, setToggle] = useState(false);
    const [faqId, setID] = useState(0);

    function onToggle(id) {
        setToggle(!toggle);
        setID(id);
    }

    const faqList = faQuestions.map((faq, i) => (
        <li key={i} onClick={() => onToggle(faq.id)}>
            <div className={classes.faq1}>
                <p>{faq.question}</p>
                <img src={arrowdown} alt="" />
            </div>

            {toggle && faqId === faq.id ? (
                <div className={classes.faq_one} id={faq.id}>
                    <p>{faq.answer}</p>
                    <h5>{faq.month}</h5>
                    <Link to="/faqs/faqspage">Learn more</Link>
                </div>
            ) : (
                <></>
            )}
        </li>
    ));

    return (
        <div className={classes.FAQ_container}>
            <div className={classes.FAQ_content}>
                <div>
                    <div className={classes.text}>
                        <h3>Frequently asked questions</h3>
                        <p>
                            "We believe career is life, life is once, it is
                            therefore worth enjoying.Study, work, travel, tour,
                            worship, keep working and keep
                        </p>

                        <Link to="/contact">
                            <button>Contact Us</button>
                        </Link>
                    </div>
                </div>

                <div>
                    <ul>{faqList}</ul>
                </div>
            </div>
        </div>
    );
};

export default FAQ;
