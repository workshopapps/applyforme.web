import React from "react";

import classes from "./Footer.module.css";
import { Link } from "react-router-dom";
import Logo from "../../assets/images/footer_logo.svg";
import Facebook from "../../assets/images/footer_facebook_logo.svg";
import Instagram from "../../assets/images/footer_instagram_logo.svg";
import Twitter from "../../assets/images/footer_twitter_logo.svg";
import Youtube from "../../assets/images/footer_youtube_logo.svg";
import GoogleDownload from "../../assets/images/google_play_download.svg";

const Footer = () => {
    return (
        <section className={classes.footer}>
            <div className={classes.footer__wrapper}>
                <div className={classes.about}>
                    <div className={classes.about__wrapper}>
                        <div>
                            <img src={Logo} alt="Apply for me logo" />
                        </div>

                        <div className={classes.about__text}>
                            <p>
                                Job hunting has never been easier. We got you
                                covered.
                            </p>
                            <div className={classes.about__text_google}>
                                <img
                                    src={GoogleDownload}
                                    alt="Google download icon"
                                />
                            </div>
                        </div>
                    </div>
                    <ul className={classes.footer__social_icons}>
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

                <ul className={classes.links}>
                    <li>Company</li>
                    <li>
                        <Link to="/about"> About Us</Link>
                    </li>
                    <li>
                        <Link to="/blog"> Blog</Link>
                    </li>
                    <li>
                        <Link to="/privacy"> Privacy Policy</Link>
                    </li>
                    <li>
                        <Link to="/t&c">Terms and conditions</Link>
                    </li>
                </ul>

                <ul className={classes.links}>
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

            <section className={classes.sub_footer}>
                <div className={classes.sub_footer__wrapper}>
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
