import "../styles/Nav.css";
import logo from "../../../assets/images/nav_logo.svg";

import { useState } from "react";
import { Sling as Hamburger } from "hamburger-react";

const Nav = () => {
    const [isOpen, setOpen] = useState(false);
    return (
        <nav>
            {/*position fixed for nav */}
            <div className="career-nav-fixed">
                <div className="career-nav-wrapper">
                    <div className="career-logo">
                        <img src={logo} alt="logo" />
                    </div>

                    <div className="career-links-and-button">
                        <div
                            className={`career-nav-links ${
                                isOpen || "display-none"
                            }`}
                        >
                            <ul>
                                <li>
                                    <a href="/about">About us</a>
                                </li>
                                <li>
                                    <a href="/pricing">Pricing plan</a>
                                </li>
                                <li>
                                    <a href="/blog/2">Blog</a>
                                </li>
                                <li>
                                    <a href="/faqs">FAQs</a>
                                </li>
                                <li>
                                    <a href="/contact">Contact us</a>
                                </li>
                            </ul>
                            {/* display only on mobile */}
                            <div className="career-buttons mobile">
                                <button className="career-signin-button">
                                    Sign in
                                </button>
                                <button className="career-get-started-button">
                                    Get Started
                                </button>
                            </div>
                        </div>
                    </div>
                    {/* display only on desktop */}
                    <div className="career-buttons desktop">
                        <button className="career-signin-button">
                            Sign in
                        </button>
                        <button className="career-get-started-button">
                            Get Started
                        </button>
                    </div>

                    <div className="hamburger">
                        <Hamburger
                            toggled={isOpen}
                            toggle={setOpen}
                            duration={1}
                            size={30}
                        />
                    </div>
                </div>
            </div>
        </nav>
    );
};

export default Nav;
