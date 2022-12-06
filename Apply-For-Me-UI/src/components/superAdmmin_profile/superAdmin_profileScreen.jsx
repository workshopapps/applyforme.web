
import { MainContainer } from "./profile_main_conatiner/main_container"
import { NotificationHead } from "./profile_page_notification/notification_head"

export const ProfileScreen =()=>{
    return(
        <>
            <NotificationHead userName="John" notificationCount="0" userImage="https://res.cloudinary.com/hamskid/image/upload/v1668865249/Frame_51202_uoy0ee.png"/>
            <MainContainer img="https://res.cloudinary.com/hamskid/image/upload/v1668864953/Frame_51202_fn1t9x.png" address="2715 Ash Dr. San Jose, South Dakota 83475" dob="October 31, 1990"/>
        </>
    )
}