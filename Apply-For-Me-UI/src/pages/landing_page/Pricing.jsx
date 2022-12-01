import React from "react";
import { useNavigate } from "react-router-dom";
import tick from "../../assets/images/tick.png";
import classes from "./Hero.module.css";

const Pricing = () => {
    const navigate = useNavigate();
    return (
        <div className={classes.pricing_container}>
            <div className={classes.pricing_content}>
                <div className={classes.top}>
                    <span className={classes.sub_heading} style={{color:"#52515B"}}>
                        Payment services
                    </span>
                    <h3>Our pricing plan</h3>
                    <button type="button" onClick={() => navigate("/pricing")} style={{background:"#4E2E92"}}>
                        View All
                    </button>
                </div>

                <div className={classes.bottom}>
                    <div className={classes.left}>
                        <div className={classes.list}>
                            <img src="https://res.cloudinary.com/hamskid/image/upload/v1669823434/Vector_efol82.png" alt="object not found" />
                            <div>
                                <h4 style={{fontWeight:"600"}}>Applications</h4>
                                <span style={{color:"#52515B",lineHeight:"30px"}}>
                                As part of the basic plan, we send 15 applications every month to various employers who are searching for your skill-set 
                                </span>
                            </div>
                        </div>
                        <div className={classes.list}>
                            <img src="https://res.cloudinary.com/hamskid/image/upload/v1669823434/Vector_efol82.png" alt="object not found" />
                            <div>
                                <h4 style={{fontWeight:"600"}}>Applications</h4>
                                <span style={{color:"#52515B",lineHeight:"30px"}}>
                                You can create up to 5 job profiles of different qualifications in search of various roles within an organisation
                                </span>
                            </div>
                        </div>
                        <div className={classes.list}>
                            <img src="https://res.cloudinary.com/hamskid/image/upload/v1669823434/Vector_efol82.png" alt="object not found" />
                            <div>
                                <h4 style={{fontWeight:"600"}}>Applications</h4>
                                <span style={{color:"#52515B",lineHeight:"30px"}}>
                                We provide you with cutting-edge reviews on your CV that get you through the door to have an interview with your potential employer
                                </span>
                            </div>
                        </div>
                    </div>

                    <div className={classes.price_card}>
                        <div className={classes.top}>
                            <span className={classes.type}>Basic plan</span>
                            <span className={classes.figure} style={{color:"#4E2E92"}}>$15.99</span>
                            <span className={classes.interval} style={{color:"#020313"}}>Per month</span>
                        </div>

                        <div className={classes.bottom}>
                            <span style={{color:"#020313"}}>
                                <img src="https://res.cloudinary.com/hamskid/image/upload/v1669824289/Vector_8_g5z2yz.png" alt="object not found" />
                                up to 15 applications per month
                            </span>
                            <span style={{color:"#020313"}}>
                                <img src="https://res.cloudinary.com/hamskid/image/upload/v1669824289/Vector_8_g5z2yz.png" alt="object not found" />
                                can create upto 5 job profiles
                            </span>
                            <span style={{color:"#020313"}}>
                                <img src="https://res.cloudinary.com/hamskid/image/upload/v1669824289/Vector_8_g5z2yz.png" alt="object not found" />
                                Access to 2 customer care session on CV review
                            </span>
                        </div>

                        <div className={classes.btn_area}>
                            <button
                                type="button"
                                onClick={() => navigate("/pricing")}
                                style={{background:"#4E2E92"}}
                            >
                                Get Started
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Pricing;
