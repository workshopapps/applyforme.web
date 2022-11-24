import React from "react";
import LeftDetails from "./components/LeftDetails";
import Footer from "../../components/footer/Footer";
import Nav from "components/nav/Nav";
import "./components/ContactStyle.css";


const ContactUs = () => {
    return (
        <div className="contact">
          <div className="contact-nav-wrapper">
            <Nav/>
            {/* <Nav/> */}
          </div>
    
    
    
            <div className="form">
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
