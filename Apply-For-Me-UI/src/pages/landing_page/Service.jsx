import React from "react";
import classes from "./Hero.module.css";
import tick from "../../assets/images/tick.png";

const Service = () => {
    return (
        <div className={classes.services_container}>
            <div className={classes.services_content}>
                <div>
                    <p>
                        We believe career is life, life is once, it is therefore
                        worth enjoying.Study, work, travel, tour, worship, keep
                        working and keep exploring.... It begins with you. We
                        believe career is life, life is once, it is therefore
                        worth enjoying.
                    </p>
                </div>

                <div className={classes.box}>
                    <img src={tick} alt="" />
                    <h3>All you have to do is attend Job Interviews </h3>
                    <p>
                        We believe career is life, life is once, it is therefore
                        worth enjoying.Study, work, travel, tour, worship, keep
                        working and keep exploring.... It begins with you. We
                        believe career is life, life is once, it is therefore
                        worth enjoying.
                    </p>
                </div>
            </div>
        </div>
    );
};

export default Service;
