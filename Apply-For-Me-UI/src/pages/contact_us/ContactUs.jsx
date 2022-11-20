import React from "react";
import Form  from "./components/Form";
import LeftDetails from "./components/LeftDetails";


import "./components/ContactStyle.css";
import Nav from "../../components/nav/Nav";
import Footer from "../../components/footer/Footer";


const ContactUs = () => {
    return (
        <div className="contact">
          <div className="contact-nav-wrapper">
            <Nav/>
          </div>
    
    
    
          <div className="contact-mid">
            <div className="form">
              <Form/>
            </div>
            <div className="form-details">
               <LeftDetails/>
            </div>
          </div>
    
    
         <div>
          <Footer/>
         </div>
    
         {/* <div className="copyright">
            <p>2022 ApplyForMe. All rights reserved</p>
    
            <p>Cookie Policy</p>
            <p>Terms of Service</p>
            <p>Cookie Setting</p>
    
         </div> */}
    
    
    
          
        </div>
      )
};

export default ContactUs;
