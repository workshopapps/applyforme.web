import  "./mobileNav.css";
export const MobileNav =({setShowMenu})=>{
    return(
        
            <div className="profile_mobile_nav">
                <div className="menu-Header">
                    <h2  style={{color:"grey"}}>Menu</h2>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067698/Vector_rc9avy.png" alt="object not found" onClick={()=> setShowMenu(false)}/>
                </div>
                <div className="second_menu_sect">
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1669298055/Frame_131_bhfi0b.png" alt="object not found"/>
                    
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