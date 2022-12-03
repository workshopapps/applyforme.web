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
                <div className="form-details">
                    <LeftDetails />
                </div>
                <div className="contact-form">
                    <ContactUsForm />
                    <div className="more-details">
                        <p>
                            You could also fill the form and send us a message.
                            We guarantee an absolute strict adherence to
                            information security and also a swift implementation
                            to your feedback
                        </p>
                    </div>
                </div>
            </div>

            <Footer />
        </div>
    );
};

export default ContactUs;
