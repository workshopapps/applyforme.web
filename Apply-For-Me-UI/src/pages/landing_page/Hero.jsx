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
                    <span style={{color:"#52515B"}}>
                    Job hunting and application stress can be exhausting, especially for those with little or no free time. With the help of ApplyForMe, we help ease your stress, with our simple and easy to navigate interface. We are your lifelong Job/career assistant designed to make the hunting process easy.



                    </span>

                    <div className={classes.browse}>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669932063/Vector_9_musiqa.png" alt="object not found" />
                        <span style={{color:" #52515B", background:"white",margin:"0.5rem 0"}}>
                            Drop your CV here to get the best matches or{" "}
                            <label htmlFor="file" style={{color:"#2A73D5"}}>browse</label>
                        </span>
                        <span className={classes.base}>Supports PDF, Docs</span>
                    </div>
                    <div className={classes.uploadFile}>
                        <input type="file" id="file" accept="image/*" style={{padding:"1rem 0"}}/>
                        <label htmlFor="file" className="fileLabel" style={{ color:"white",height:"60px" ,width:"140px", backgroundColor:"#202065", display:"flex",alignItems:"center",justifyContent:"center",padding:"2rem 0", margin:"1rem 0", borderRadius:"10px"}}>Upload File</label>
                    </div>
                    
                </div>

                <div className={classes.right}>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1669936036/Mask_group_afrsbg.png" alt="" />
                </div>
            </div>
        </div>
    );
};

export default Hero;
