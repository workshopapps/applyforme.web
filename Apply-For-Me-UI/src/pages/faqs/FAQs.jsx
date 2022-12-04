import React from "react";
import Footer from "../../components/footer/Footer";
import Nav from '../../components/nav/Nav';
import './faqs.css';
import FaqsBox from "./FaqsBox";


const FAQs = () => {
    let text_1 = 'What is afm';
    let text_2 = 'Is there a limit to number of applications';
    let text_3 = 'Can you help with my cv';
    let text_4 = 'Does afm writes cover letter';
    let text_5 = 'Is there refund policy';
    let text_6 = 'How do i know if im invited for an interview';
   

    return (
        <div className="faq">
            <Nav />
            <div className="faqs__hero">
                <h2>How can we help you?</h2>
                <p>Find below all the frequent questions and answer about afm</p>
            </div>
            <div className="faqs__section">
               <FaqsBox text={text_1} />
               <FaqsBox text={text_2} />
               <FaqsBox text={text_3} />
               <FaqsBox text={text_4} />
               <FaqsBox text={text_5} />
               <FaqsBox text={text_6}  />
            </div>
            <Footer />
        </div>
    )
};

export default FAQs;
