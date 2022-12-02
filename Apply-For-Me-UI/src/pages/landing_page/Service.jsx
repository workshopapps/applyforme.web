import React from 'react'
import classes from "./Hero.module.css"
const Service = () => {
    return (
        <div className={classes.services_container}>
            <div className={classes.services_content}>
                <div className={classes.box}>
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669932063/Vector_11_kqi58k.png"
                        alt="object not found"
                    />
                    <h3>
                        Apply to over a hundred Jobs without lifting a finger
                    </h3>
                    <p>
                        ApplyForMe helps submit your application to over a
                        hundred jobs. That's a wider coverage than you would
                        achieve on your own. .
                    </p>
                </div>

                <div className={classes.box}>
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669932063/Vector_11_kqi58k.png"
                        alt="object not found"
                    />
                    <h3>We match you with the best Jobs out there</h3>
                    <p>
                        We submit your applications to numerous companies that
                        have openings that match your needs, skills, and
                        preferences .
                    </p>
                </div>

                <div className={classes.box}>
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669932063/Vector_11_kqi58k.png"
                        alt="object not found"
                    />
                    <h3>All you have to do is attend Job Interviews </h3>
                    <p>
                        Updates would be communicated to you as soon as we
                        receive them and we schedule face-to-face meetings
                        between you and your potential employers .
                    </p>
                </div>
            </div>
        </div>
    );
};

export default Service;
