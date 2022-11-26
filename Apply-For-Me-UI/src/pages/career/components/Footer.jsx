import React from "react";

import "../styles/Footer.css";
import { Link } from "react-router-dom";
import Logo from "../../../assets/images/footer_logo.svg";
import Facebook from "../../../assets/images/footer_facebook_logo.svg";
import Instagram from "../../../assets/images/footer_instagram_logo.svg";
import Twitter from "../../../assets/images/footer_twitter_logo.svg";
import Youtube from "../../../assets/images/footer_youtube_logo.svg";
import GoogleDownload from "../../../assets/images/google_play_download.svg";
import "../../../";

const Footer = () => {
    return (
        <section className="footer">
            <div className="footer__wrapper">
                <div className="about">
                    <div className="about__wrapper">
                        <div>
                            <img src={Logo} alt="Apply for me logo" />
                        </div>

                        <div className="about__text">
                            <p>
                                Job hunting has never been easier. We got you
                                covered.
                            </p>
                            <div className="about__text_google">
                                <img
                                    src={GoogleDownload}
                                    alt="Google download icon"
                                />
                            </div>
                        </div>
                    </div>
                    <ul className="footer__social_icons">
                        <li>
                            <img src={Facebook} alt="Facebook logo" />
                        </li>
                        <li>
                            <img src={Instagram} alt="Instagram logo" />
                        </li>
                        <li>
                            <img src={Twitter} alt="Twitter logo" />
                        </li>
                        <li>
                            <img src={Youtube} alt="Youtube logo" />
                        </li>
                    </ul>
                </div>

                <ul className="links">
                    <li>Company</li>
                    <li>
                        <Link to="/about"> About Us</Link>
                    </li>
                    <li>
                        <Link to="/blog/3"> Blog</Link>
                    </li>
                    <li>
                        <Link to="/privacy"> Privacy Policy</Link>
                    </li>
                    <li>
                        <Link to="/t&c">Terms and conditions</Link>
                    </li>
                </ul>

                <ul className="links">
                    <li>Help</li>
                    <li>
                        <Link to="/contact"> Contact Us</Link>
                    </li>
                    <li>
                        <Link to="/faqs">FAQs</Link>
                    </li>
                    <li>
                        <Link to="/pricing"> Pricing</Link>
                    </li>
                    <li>
                        <Link to="/career"> Careers</Link>
                    </li>
                </ul>
            </div>

            <section className="sub_footer">
                <div className="sub_footer__wrapper">
                    <p>2022 ApplyForMe. All right reserved.</p>

                    <ul>
                        <li>
                            <Link to="/cookies">Cookies Policy</Link>
                        </li>
                        <li>
                            <Link to="/t&c">Terms of Service</Link>
                        </li>
                        <li>
                            <Link to="none">Cookies Settings</Link>
                        </li>
                    </ul>
                </div>
            </section>
        </section>
    );
};

export default Footer;
