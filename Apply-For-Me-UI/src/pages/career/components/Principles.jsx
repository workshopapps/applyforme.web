import "../styles/Principles.css";
import bottomLeft from "../assets/images/bottom-left.svg";
import bottomRight from "../assets/images/bottom-right.svg";
import topLeft from "../assets/images/top-left.svg";
import topRight from "../assets/images/top-right.svg";
import underCurve from "../assets/images/under-curve.svg";
import tick from "../assets/images/task-tick.svg";

const Principles = () => {
    return (
        <section>
            <div className="principles-wrapper">
                <div className="principles-heading">
                    <h2>Our Principles</h2>
                    <img src={underCurve} alt="" />
                </div>

                <div className="principles-container">
                    <div className="border-container">
                        <img src={topLeft} alt="" />
                        <img src={topRight} alt="" />
                    </div>
                    <div className="principles">
                        <div className="principles-row principles-row-one">
                            <div className="principle principle-one">
                                <div className="principle-tick">
                                    <img src={tick} alt="" />
                                </div>
                                <div className="principle-content">
                                    <h2>Trust</h2>
                                    <p>
                                        Our users trust us to help them find
                                        their dream roles
                                    </p>
                                </div>
                            </div>

                            <div className="principle principle-two">
                                <div className="principle-tick">
                                    <img src={tick} alt="" />
                                </div>
                                <div className="principle-content">
                                    <h2>Security</h2>
                                    <p>
                                        We ensure all user data are kept secured
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div className="principles-row principles-row-two">
                            <div className="principle principle-three">
                                <div className="principle-tick">
                                    <img src={tick} alt="" />
                                </div>
                                <div className="principle-content">
                                    <h2>Excellence</h2>
                                    <p>
                                        We work above and beyond for our users
                                    </p>
                                </div>
                            </div>

                            <div className="principle principle-final">
                                <div className="principle-tick">
                                    <img src={tick} alt="" />
                                </div>
                                <div className="principle-content">
                                    <h2>Satisfaction</h2>
                                    <p>
                                        Everything we do is targeted at ensuring
                                        we offer the best to our customers
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="border-container">
                        <img src={bottomLeft} alt="" />
                        <img src={bottomRight} alt="" />
                    </div>
                </div>
            </div>
        </section>
    );
};

export default Principles;
