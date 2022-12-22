
import React from 'react'
import { useNavigate } from 'react-router-dom';
import classes from "./Hero.module.css";
const LearnMore = () => {
    const navigate = useNavigate();
    return (
        <div className={classes.learn_container}>
            <div className={classes.learn_content}>
                <div className={classes.topContainer}>
                    <div className={classes.top}>
                    <span
                        className={classes.subheading}
                        style={{ color: "#171B1D" }}
                    >
                        How it works
                    </span>
                    <h2 style={{ color: "#2E3192" }}>
                        With just these few steps, we put you out there
                    </h2>
                    <button onClick={()=>navigate("/faqs")}><img src="https://res.cloudinary.com/hamskid/image/upload/v1671621976/Frame_51260_fvilxo.svg"/></button>
                </div>
                <img src="https://res.cloudinary.com/hamskid/image/upload/v1670013377/Content_1_ovmknu.svg" className={classes.learnImg} alt="object not found" />
                <img src="https://res.cloudinary.com/hamskid/image/upload/v1670013058/Content_eyjw1o.svg" className={classes.learnImg2} alt="object not found" />

                </div>
                
                <div className={classes.bottom}>
                    <div className={classes.left}>
                        <h3>
                            This is what we’ve built so far, be one of our
                            success stories
                        </h3>
                    </div>
                    <div className={classes.right}>
                        <p className={classes.believe} style={{paddingLeft:"0"}}>We believe career is life, life is once, it is therefore worth enjoying.Study, work, travel, tour, worship, keep working and keep exploring.... It begins with you. We believe career is life, life is once, it is therefore worth enjoying.</p>

                        <div className={classes.boxes}>
                            <div
                                className={classes.box}
                                style={{ background: "none", paddingLeft:"0" }}
                            >
                                <div className={classes.figure}>10x</div>
                                <div style={{ color: "#52515B" }}  className={classes.figure_text}>
                                    Increase in productivity
                                </div>
                            </div>
                            <div
                                className={classes.box}
                                style={{ background: "none", paddingLeft:"0" }}
                            >
                                <div className={classes.figure}>300%</div>
                                <div style={{ color: "#52515B" }} className={classes.figure_text}>
                                    Return on investment
                                </div>
                            </div>
                            <div
                                className={classes.box}
                                style={{ background: "none", paddingLeft:"0" }}
                            >
                                <div className={classes.figure}>5k+</div>
                                <div style={{ color: "#52515B" }} className={classes.figure_text}>
                                    Happy customers
                                </div>
                            </div>
                            <div
                                className={classes.box}
                                style={{ background: "none", paddingLeft:"0" }}
                            >
                                <div className={classes.figure}>100+</div>
                                <div style={{ color: "#52515B" }} className={classes.figure_text}>
                                    5-star reviews
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default LearnMore;
