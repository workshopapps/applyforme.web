import React from 'react'
import classes from "./Hero.module.css"
import content from "../../assets/images/Content.png"

const LearnMore = () => {
    return (
        <div className={classes.learn_container}>
            <div className={classes.learn_content}>
                <h2>With just these few steps, we put you out there</h2>

                <button>Learn More</button>

                <img src={content} alt="" />

                <div className={classes.bottom}>
                    <div className={classes.left}>
                        <h3>This is what we’ve built so far, be one of our success stories</h3>
                    </div>

                    <div className={classes.right}>
                        <p>We believe career is life, life is once, it is therefore worth enjoying.Study, work, travel, tour, worship, keep working and keep exploring.... It begins with you. We believe career is life, life is once, it is therefore worth enjoying.</p>

                        <div className={classes.boxes}>
                            <div className={classes.box}>
                                <span className={classes.figure}>10x</span>
                                <span>Increase in productivity</span>
                            </div>
                            <div className={classes.box}>
                                <span className={classes.figure}>300%</span>
                                <span>Return on investment</span>
                            </div>
                            <div className={classes.box}>
                                <span className={classes.figure}>5k+</span>
                                <span>Happy customers</span>
                            </div>
                            <div className={classes.box}>
                                <span className={classes.figure}>100+</span>
                                <span>5-star reviews</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default LearnMore