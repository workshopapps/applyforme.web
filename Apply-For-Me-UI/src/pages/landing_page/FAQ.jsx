import React from "react";
import { Link } from "react-router-dom";
import { useState, useRef } from "react";
import classes from "./Hero.module.css";
import arrowdown from "../../assets/images/arrow-down.png";

const FAQ = () => {
    const rotateRef = useRef(null);
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
        }
    ]);
    const [toggle, setToggle] = useState(false);
    const [faqId, setID] = useState(0);

    function onToggle(id) {
        setToggle(!toggle);
        setID(id);
        rotateRef.current.classList.add("rotateImg");
    }

    const faqList = faQuestions.map((faq, i) => (
        <li key={i} onClick={() => onToggle(faq.id)} >
            <div className={classes.faq1}>
                <p>{faq.question}</p>
               <img src={arrowdown} alt="object not found" ref={rotateRef} className={classes.rotate_image}/>
                {/* {toggle && <img src="https://res.cloudinary.com/hamskid/image/upload/v1671799257/Vector_3_auvm1i.svg" alt=""/> } */}
            </div>

            {toggle && faqId === faq.id ? (
                <div className={classes.faq_one} id={faq.id}>
                    <p className="faqlist">{faq.answer}</p>
                    {/* <h5 className="faqlist">{faq.month}</h5> */}
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
                        Our recruiters are highly experienced, and they know exactly what to look for when they're recruiting.
                        </p>

                        <Link to="/contact">
                            <button>Contact Us</button>
                        </Link>
                    </div>
                </div>

                <div className={classes.FAQ_main_div}>
                    <ul>{faqList}</ul>
                </div>
            </div>
        </div>
    );
};

export default FAQ;
