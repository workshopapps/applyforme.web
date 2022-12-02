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
        </div>
    );
};

export default ContactUs;
