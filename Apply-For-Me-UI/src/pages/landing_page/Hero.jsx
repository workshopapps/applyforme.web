import React from "react";
import classes from "./Hero.module.css";
import heroimg from "../../assets/images/heroimg.png";
import upload from "../../assets/images/upload_file.png";

const Hero = () => {
    return (
        <div className={classes.hero_container}>
            <div className={classes.hero_content}>
                <div className={classes.left}>
                    <h3 className={classes.heading}>
                        Take a single step to your dream job
                    </h3>
                    <span>
                        We believe career is life, life is once, it is therefore
                        worth enjoying.Study, work, travel, tour, worship, keep
                        working and keep exploring.... It begins with you. We
                        believe career is life, life is once, it is therefore
                        worth enjoying.
                    </span>

                    <div className={classes.browse}>
                        <img src={upload} alt="" />
                        <span>
                            Drop your CV here to get the best matches or{" "}
                            <a href="#">browse</a>
                        </span>
                        <span className={classes.base}>Supports PDF, Docs</span>
                    </div>
                </div>

                <div className={classes.right}>
                    <img src={heroimg} alt="" />
                </div>
            </div>
        </div>
    );
};

export default Hero;
