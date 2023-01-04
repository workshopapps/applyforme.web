/* eslint-disable no-unused-vars */
import React from "react";
import { useNavigate } from "react-router-dom";
import classes from "./Hero.module.css";

const Pricing = () => {
    const navigate = useNavigate();
    return (
        <div className={classes.pricing_container}>
            <div className={classes.pricing_content}>
                <div className={classes.top}>
                    <span
                        className={classes.sub_heading}
                        style={{ color: "#52515B" }}
                    >
                        Payment services
                    </span>
                    <h3>Our pricing plan</h3>
                    <button
                        type="button"
                        onClick={() => navigate("/pricing")}
                        style={{ background: "#2E3192" }}
                    >
                        View All
                    </button>
                </div>

                <div className={classes.bottom}>
                    <div className={classes.left}>
                        <div className={classes.list}>
                            <img
                                src="https://res.cloudinary.com/hamskid/image/upload/v1669932063/Vector_10_rfw1zh.png"
                                alt="object not found"
                            />
                            <div>
                                <h4 style={{ fontWeight: "600" }}>
                                    Applications
                                </h4>
                                <span
                                    style={{
                                        color: "#52515B",
                                        lineHeight: "30px"
                                    }}
                                >
                                    As part of the basic plan, we send 60 job
                                    applications every month to various
                                    employers who are searching for your
                                    skill-set
                                </span>
                            </div>
                        </div>
                        <div className={classes.list}>
                            <img
                                src="https://res.cloudinary.com/hamskid/image/upload/v1669932063/Vector_10_rfw1zh.png"
                                alt="object not found"
                            />
                            <div>
                                <h4 style={{ fontWeight: "600" }}>
                                    Job Profiles
                                </h4>
                                <span
                                    style={{
                                        color: "#52515B",
                                        lineHeight: "30px"
                                    }}
                                >
                                    You can create up to 4 job profiles of
                                    different qualifications in search of
                                    various roles within an organisation
                                </span>
                            </div>
                        </div>
                        <div className={classes.list}>
                            <img
                                src="https://res.cloudinary.com/hamskid/image/upload/v1669932063/Vector_10_rfw1zh.png"
                                alt="object not found"
                            />
                            <div>
                                <h4 style={{ fontWeight: "600" }}>CV Review</h4>
                                <span
                                    style={{
                                        color: "#52515B",
                                        lineHeight: "30px"
                                    }}
                                >
                                    We provide you with cutting-edge reviews on
                                    your CV that get you through the door to
                                    have an interview with your potential
                                    employer
                                </span>
                            </div>
                        </div>
                    </div>

                    <div className={classes.price_card}>
                        <div className={classes.top}>
                            <span className={classes.type}>Basic plan</span>
                            <span
                                className={classes.figure}
                                style={{ color: "#2E3192" }}
                            >
                                $24.99
                            </span>
                            <span
                                className={classes.interval}
                                style={{ color: "#020313" }}
                            >
                                Per month
                            </span>
                        </div>

                        <div className={classes.bottom}>
                            <span style={{ color: "#020313" }}>
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1669939094/Vector_12_mmv9yq.png"
                                    alt="object not found"
                                />
                                up to 60 applications per month
                            </span>
                            <span style={{ color: "#020313" }}>
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1669939094/Vector_12_mmv9yq.png"
                                    alt="object not found"
                                />
                                can create up to 4 job profiles
                            </span>
                            <span style={{ color: "#020313" }}>
                                <img
                                    src="https://res.cloudinary.com/hamskid/image/upload/v1669939094/Vector_12_mmv9yq.png"
                                    alt="object not found"
                                />
                                Access to 2 customer care session on CV review
                            </span>
                        </div>

                        <div className={classes.btn_area}>
                            <button
                                type="button"
                                onClick={() => navigate("/pricing")}
                                style={{ background: "#2E3192" }}
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
