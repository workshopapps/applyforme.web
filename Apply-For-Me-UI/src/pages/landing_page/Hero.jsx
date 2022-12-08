/* eslint-disable no-unused-vars */
import React from "react";
import classes from "./Hero.module.css";
import { useNavigate } from "react-router-dom";
const Hero = () => {
    const token = localStorage.getItem("tokenKey");
    let tokenKey = "tokenHngKey";
    let storedToken = localStorage.getItem(tokenKey);
    const navigate = useNavigate();
    return (
        <div className={classes.hero_container}>
            <div className={classes.hero_content}>
                <div className={classes.left}>
                    <h3 className={classes.heading}>
                        Take a single step to your dream job
                    </h3>
                    <span style={{ color: "#52515B" }}>
                        Job hunting and application stress can be exhausting,
                        especially for those with little or no free time. With
                        the help of ApplyForMe, we help ease your stress, with
                        our simple and easy to navigate interface. We are your
                        lifelong Job/career assistant designed to make the
                        hunting process easy.
                    </span>
                    <div className={classes.uploadFile}>
                        {!storedToken && (
                            <button
                                className="fileLabel"
                                style={{
                                    color: "white",
                                    height: "60px",
                                    width: "240px",
                                    border: "1px solid #2E3192",
                                    backgroundColor: "#2E3192",
                                    display: "flex",
                                    alignItems: "center",
                                    justifyContent: "center",
                                    padding: "16px 32px",
                                    margin: "1rem 0",
                                    borderRadius: "5px"
                                }}
                                onClick={() => navigate("/tryout-form")}
                            >
                                Try it now
                            </button>
                        )}
                    </div>
                </div>

                <div className={classes.right}>
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669936036/Mask_group_afrsbg.png"
                        alt=""
                    />
                </div>
            </div>
        </div>
    );
};

export default Hero;
