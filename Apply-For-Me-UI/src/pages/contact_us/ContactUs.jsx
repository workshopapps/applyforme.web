import React from "react";
import ContactUsForm from "./components/ContactUsForm";
import LeftDetails from "./components/LeftDetails";
import "./components/ContactStyle.css";
import Nav from "../../components/nav/Nav";
import Footer from "../../components/footer/Footer";

const ContactUs = () => {
    return (
        <div className="contact">
            <Nav />

            <div className="contact-mid">
                <div className="form">
                    <ContactUsForm />
                </div>
                <div className="form-details">
                    <LeftDetails />
                </div>
            </div>

            <Footer />

            {/* <div className="copyright">
            <p>2022 ApplyForMe. All rights reserved</p>
    
            <p>Cookie Policy</p>
            <p>Terms of Service</p>
            <p>Cookie Setting</p>
    
         </div> */}
        </div>
    );
};

export default ContactUs;
