import React from 'react';
import facebook from "../img/facebook.png";
import instagram from "../img/instagram.png";
import twitter from "../img/twitter.png";
import youtube from "../img/youtube.png";
import bluebg from "../img/bluebg.png";
import googleplay from "../img/googleplay.png";
import "./ContactStyle.css";

const Footer = () => {
  return (
    <div className="footer">
        <div className="footer-first">
            <div className="footer-img-wrapper">
                <img src={bluebg} alt="logo"></img>

            </div>
            <p>
                Job hunting has never been<br></br>
                 easier. we got you covered
            </p>

            <div className="playstore-wrapper">
                <img src={googleplay} alt="playstore-logo"/>
                <img src={googleplay} alt="playstore-logo"/>

            </div>

            <div className="footer-second">
                <img src={facebook} alt="facebook-logo"/>
                <img src={instagram} alt="instagram-logo"/>
                <img src={twitter} alt="twitter-logo"/>
                <img src={youtube} alt="youtube-logo"/>


            </div>


        </div>

        <div className="footer-second">
                <img src={facebook} alt="facebook-logo"/>
                <img src={instagram} alt="instagram-logo"/>
                <img src={twitter} alt="twitter-logo"/>
                <img src={youtube} alt="youtube-logo"/>


        </div>
        
        <div className="footer-third">
            <h3>Company</h3>
            <ul>
                <li><a href="">About Us</a></li>
                <li><a href="">Blog</a></li>
                <li><a href="">Privacy Policy</a></li>
                <li><a href="">Terms and conditions</a></li>
            </ul>

        </div>

        <div className="footer-fourth">
            <h3>Help</h3>
            <ul>
                <li><a href="">Contact Us</a></li>
                <li><a href="">FAQs</a></li>
                <li><a href="">Pricing</a></li>
                <li><a href="">Careers</a></li>
            </ul>
        </div>
      
    </div>
  );
}

export default Footer;
