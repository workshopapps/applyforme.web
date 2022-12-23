import React from 'react'
import classes from "./Hero.module.css"
import Avatar from "../../assets/images/Avatar1.png"
import Avatar2 from "../../assets/images/Avatar2.png"


const Reviews = () => {
  return (
    <div className={classes.reviews_container}>
        <div className={classes.reviews_content}>
            <div className={classes.top}>
                <span className={classes.sub_heading} style={{color:"#020313"}}>Testimonials</span>
                <h3>What they have to say about us</h3>
            </div>
            <div className={classes.bottom}>
                <div  className={classes.reviews_content_bottom_div}>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1671639153/Frame_51199_t6zuyx.svg" alt="object not found" className={classes.stars}/>
                    <p className={classes.reviews}>"We believe career is life, life is once, it is therefore worth enjoying.Study, work, travel, tour, worship, keep working and keep exploring.... It begins with you. We believe career is life, life is once, it is therefore worth enjoying.."</p>

                    <div className={classes.profile}>
                        <div  className={classes.profile_div_start}>
                            <img src={Avatar} alt="object not found" />
                        </div>                       
                        <div>
                            <span className={classes.name}>Jao Yung</span>
                            <span className={classes.position}>Software Develper,Google</span>
                        </div>
                    </div>
                </div>
                <div className={classes.reviews_content_bottom_div}>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1671639153/Frame_51199_t6zuyx.svg" alt="object not found" className={classes.stars}/>
                    <p className={classes.reviews}>"We believe career is life, life is once, it is therefore worth enjoying.Study, work, travel, tour, worship, keep working and keep exploring.... It begins with you. We believe career is life, life is once, it is therefore worth enjoying.."</p>

                    <div className={classes.profile}>
                        <div className={classes.profile_div_start}>
                            <img src={Avatar2} alt="object not found"  />
                        </div>
                        <div>
                            <span className={classes.name}>Kate James</span>
                            <span className={classes.position}>Product Designer, Apple</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Reviews