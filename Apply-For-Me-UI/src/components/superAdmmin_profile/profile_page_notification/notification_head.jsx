import  "./notification_head.css";
export const NotificationHead =({userName, notificationCount, userImage})=>{
    return(
        <div className="notification_icon">
            <div>
                <h3>Hello {userName}</h3>
            </div>
            <div>
                <img  src="https://res.cloudinary.com/hamskid/image/upload/v1668864953/Vector_jfm392.png" alt="object not found"/>
                <span style={{width:'30%'}}><img style={{width:'30%'}}  src={userImage} alt="object not found"/></span>
                
               {notificationCount >0? <h6 className="notification_count">{notificationCount}</h6>:null}
            </div>
        </div>
    )
}