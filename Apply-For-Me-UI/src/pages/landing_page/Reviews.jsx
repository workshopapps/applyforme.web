import React from "react";
import classes from "./Hero.module.css";
import stars from "../../assets/images/stars.png";
import Avatar from "../../assets/images/Avatar1.png";
import Avatar2 from "../../assets/images/Avatar2.png";
import elipse from "../../assets/landing-page-imgs/elipse.png";

const Reviews = () => {
    return (
        <div className={classes.reviews_container}>
            <div className={classes.reviews_content}>
                <div className={classes.top}>
                    <span className={classes.sub_heading}>Testimonials</span>
                    <h3>What they have to say about us</h3>
                </div>
                <div className={classes.elipse}>
                    <img src={elipse} alt="" />
                </div>

                <div className={classes.bottom}>
                    <div>
                        <img src={stars} alt="" className={classes.stars} />
                        <p>
                            "We believe career is life, life is once, it is
                            therefore worth enjoying.Study, work, travel, tour,
                            worship, keep working and keep exploring.... It
                            begins with you. We believe career is life, life is
                            once, it is therefore worth enjoying.."
                        </p>

                        <div className={classes.profile}>
                            <img src={Avatar} alt="" />
                            <div>
                                <span className={classes.name}>Jao Yung</span>
                                <span className={classes.position}>
                                    Position, Company name
                                </span>
                            </div>
                        </div>
                    </div>
                    <div>
                        <img src={stars} alt="" className={classes.stars} />
                        <p>
                            "We believe career is life, life is once, it is
                            therefore worth enjoying.Study, work, travel, tour,
                            worship, keep working and keep exploring.... It
                            begins with you. We believe career is life, life is
                            once, it is therefore worth enjoying.."
                        </p>

                        <div className={classes.profile}>
                            <img src={Avatar2} alt="" />
                            <div>
                                <span className={classes.name}>Jao Yung</span>
                                <span className={classes.position}>
                                    Position, Company name
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Reviews;
