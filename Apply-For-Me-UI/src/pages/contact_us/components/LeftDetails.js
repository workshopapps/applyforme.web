import React from 'react';
import operator from "../img/operator.png";
import mail from "../img/mail.png";
import "./ContactStyle.css";

const LeftDetails = () => {
  return (
    <div className="leftdetail">
        <div className="img-wrapper">
            <img className="img-first"  src={operator}/>

        </div>
        <div className="details">
            <h1>Do You Have Queries OR Suggestions?</h1>
            <p>
                We appreciate your visit to our website and we will like to have
                feedback on your experience in the use and navigation of our site.
                We guarantee an absolute strict adherence to information security
                and also and also a swift implementation to your feedback. Reach 
                out to our representative on the email address below.

            </p>

            <a href="https://www.info@afm.com"><img src={mail} className="img-icon"/><span>info@afm.com</span></a>

        </div>
      
    </div>
  );
}

export default LeftDetails;
