import React from 'react'
import classes from "./Hero.module.css"
import arrowdown from "../../assets/images/arrow-down.png"

const FAQ = () => {
    return (
        <div className={classes.FAQ_container}>
            <div className={classes.FAQ_content}>
                <div>
                    <div className={classes.text}>
                        <h3>Frequently asked questions</h3>
                        <p>"We believe career is life, life is once, it is therefore worth enjoying.Study, work, travel, tour, worship, keep working and keep</p>

                        <button>Contact Us</button>

                    </div>
                </div>

                <div>
                    <ul>
                        <li>What do I have to do? <img src={arrowdown} alt="" /></li>
                        <li>Who can apply <img src={arrowdown} alt="" /></li>
                        <li>Who is applying  on this jobs for me <img src={arrowdown} alt="" /></li>
                        <li>What do I have to do? <img src={arrowdown} alt="" /></li>
                        <li>Who can apply <img src={arrowdown} alt="" /></li>
                    </ul>
                </div>

            </div>
        </div>
    )
}

export default FAQ