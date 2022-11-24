import React from "react";
import { Link } from "react-router-dom";
import tick from "../../assets/images/tick.png";
import classes from "./Hero.module.css";

const Pricing = () => {
    return (
        <div className={classes.pricing_container}>
            <div className={classes.pricing_content}>
                <div className={classes.top}>
                    <span className={classes.sub_heading}>
                        Payment services
                    </span>
                    <h3>Our pricing plan</h3>

                    <Link to="/pricing">
                        <button className={classes.view_all_btn}>
                            View All
                        </button>
                    </Link>
                </div>

                <div className={classes.bottom}>
                    <div className={classes.left}>
                        <div className={classes.list}>
                            <img src={tick} alt="" />
                            <div>
                                <h4>Applications</h4>
                                <span>
                                    We believe career is life, life is once, it
                                    is therefore worth enjoying.Study, work,
                                    travel, tour, worship, keep working and keep
                                    exploring
                                </span>
                            </div>
                        </div>
                        <div className={classes.list}>
                            <img src={tick} alt="" />
                            <div>
                                <h4>Applications</h4>
                                <span>
                                    We believe career is life, life is once, it
                                    is therefore worth enjoying.Study, work,
                                    travel, tour, worship, keep working and keep
                                    exploring
                                </span>
                            </div>
                        </div>
                        <div className={classes.list}>
                            <img src={tick} alt="" />
                            <div>
                                <h4>Applications</h4>
                                <span>
                                    We believe career is life, life is once, it
                                    is therefore worth enjoying.Study, work,
                                    travel, tour, worship, keep working and keep
                                    exploring
                                </span>
                            </div>
                        </div>
                    </div>

                    <div className={classes.price_card}>
                        <div className={classes.top}>
                            <span className={classes.type}>Basic plan</span>
                            <span className={classes.figure}>$15.99</span>
                            <span className={classes.interval}>Per month</span>
                        </div>

                        <div className={classes.bottom}>
                            <span>
                                <img src={tick} alt="" />
                                up to 15 applications per month
                            </span>
                            <span>
                                <img src={tick} alt="" />
                                can create upto 5 job profiles
                            </span>
                            <span>
                                <img src={tick} alt="" />
                                Access to 2 customer care session on CV review
                            </span>
                        </div>

                        <Link to="/pricing" className={classes.btn_area}>
                            <button>Get Started</button>
                        </Link>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Pricing;
