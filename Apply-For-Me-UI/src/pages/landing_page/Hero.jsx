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
                        initial={{ opacity: 0, y: 100 }}
                        animate={{ opacity: 1, y: 1 }}
                        transition={{ duration: 0.5 }} className={classes.heading}>
                        Take a single step to your dream job
                    </motion.h3>
                    <motion.span
                        initial={{ opacity: 0, y: 100 }}
                        animate={{ opacity: 1, y: 1 }}
                        transition={{ duration: 0.5,delay:0.1 }}
                     style={{ color: "#52515B" }}>
                    Job hunting and application stress can be exhausting, especially for those with little or no free time.
                    With our simple and easy to navigate interface. We are your lifelong Job/career assistant designed to
                    make the hunting process easy.
                    </motion.span>
                    <motion.div
                     initial={{ opacity: 0, y: 100 }}
                     animate={{ opacity: 1, y: 1 }}
                     transition={{ duration: 0.5,delay:0.2 }}
                     className={classes.uploadFile}>
                        {!storedToken && (
                            <button
                                className={classes.fileLabel}
                                onClick={() => navigate("/tryout-form")}
                            >
                                Try it now
                            </button>
                        )}
                    </motion.div>
                </div>

                <motion.div
                    initial={{ opacity: 0, x: 200 }}
                    animate={{ opacity: 1, x: 1 }}
                    transition={{ duration: 0.5,delay:0.2 }}
                    className={classes.right}>
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1671795809/Mask_group_1_ky5sqo.svg"
                        alt="object not found"
                    />
                </motion.div>
            </div>
        </motion.div>
    );
};

export default Hero;
