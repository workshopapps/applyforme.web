/* eslint-disable no-unused-vars */
import React from "react";
import classes from "./Hero.module.css";
import { useNavigate } from "react-router-dom";
import { motion } from "framer-motion";
const Hero = () => {
    const token = localStorage.getItem("tokenKey");
    let tokenKey = "tokenHngKey";
    let storedToken = localStorage.getItem(tokenKey);
    const navigate = useNavigate();
    return (
        <motion.div 
            initial={{ opacity: 0 }}
            whileInView={{ opacity: 1 }}
            viewport={{ once: true }}
            className={classes.hero_container}>
            <div className={classes.hero_content}>
                <div className={classes.left}>
                    <motion.h3
                        initial={{ opacity: 0, scaleY: 0.5 }}
                        animate={{ opacity: 1, scaleY: 1 }}
                        transition={{ duration: 0.5 }} className={classes.heading}>
                        Take a single step to your dream job
                    </motion.h3>
                    <span style={{ color: "#52515B" }}>
                    Job hunting and application stress can be exhausting, especially for those with little or no free time.
                    With our simple and easy to navigate interface. We are your lifelong Job/career assistant designed to
                    make the hunting process easy.
                    </span>
                    <div className={classes.uploadFile}>
                        {!storedToken && (
                            <button
                                className={classes.fileLabel}
                                onClick={() => navigate("/tryout-form")}
                            >
                                Try it now
                            </button>
                        )}
                    </div>
                </div>

                <div className={classes.right}>
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1671795809/Mask_group_1_ky5sqo.svg"
                        alt="object not found"
                    />
                </div>
            </div>
        </motion.div>
    );
};

export default Hero;
