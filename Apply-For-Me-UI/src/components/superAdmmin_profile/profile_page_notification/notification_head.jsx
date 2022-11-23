import  "./notification_head.css";
import { useState } from "react";
export const NotificationHead =({userName, notificationCount, userImage})=>{
    const [showMobileNav, setShowMobileNav] = useState(false);
    return(
        <div className="notification_icon" style={{position:"relative"}}>
            <div className="head_barge">
                <img className="not_burger"  style={{width:'26%',height:'26%'}} src="https://res.cloudinary.com/hamskid/image/upload/v1669063349/Vector_bj9ixf.png" alt="object not found" onClick={()=>setShowMobileNav(true)}/>
                <span><img className="notification_icon_amf"  src="https://res.cloudinary.com/hamskid/image/upload/v1669063349/Frame_yqkxnb.png" alt="object not found"/></span>
            </div>
            <div>
                <img className="notification_icon_img"  src="https://res.cloudinary.com/hamskid/image/upload/v1668864953/Vector_jfm392.png" alt="object not found"/>
                <span style={{width:'30%',marginLeft:"1rem"}}><img style={{width:'30%'}}  src={userImage} alt="object not found"/></span>
               {notificationCount >0? <h6 className="notification_count">{notificationCount}</h6>:null}
            </div>
            {
                showMobileNav &&(
                    <div className="profile_mobile_nav">
                <div className="menu-Header">
                    <h2  style={{color:"grey"}}>Menu</h2>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067698/Vector_rc9avy.png" alt="object not found" onClick={()=>setShowMobileNav(false)}/>
                </div>
                <div className="section_menu_sect">
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067768/Frame_131_mvd9x7.png" alt="object not found"/>
                       
                    </div>
                     <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067895/Frame_139_bi3qtx.png" alt="object not found"/>
                        
                    </div>
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067697/Frame_136_nw2bzl.png" alt="object not found"/>
                       
                    </div>

                </div>
                <div className="third_menu_sect">
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067697/Frame_138_lwnrqy.png" alt="object not found"/>
                        
                    </div>
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067698/Frame_51221_zn3uxm.png" alt="object not found"/>
                      
                    </div>
                </div>

            </div>

                )
            }
            
        </div>
    )
}