import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { userInfo } from "store/slice/UserSlice";
import  "./mobileNav.css";
export const MobileNav =({setShowMenu})=>{
    const navigate = useNavigate()
    const dispatch = useDispatch();
    const handleLogout = () => {
        localStorage.removeItem("tokenHngKey");
        dispatch(userInfo(""));
        navigate("/");
    };
    return(
        
            <div className="profile_mobile_nav">
                <div className="menu-Header">
                    <h2  style={{color:"grey"}}>Menu</h2>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670603040/close-svgrepo-com_1_ie1sje.svg" alt="object not found" onClick={()=> setShowMenu(false)}/>
                </div>
                <div className="second_menu_sect">
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1670603076/Frame_51220_nvc5zs.svg" alt="object not found"/>
                    
                    </div>
                </div>
                <div className="third_menu_sect">
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1670603160/Frame_138_uomsbb.svg" alt="object not found"
                        onClick={()=>navigate("/help")}/>
                        
                    </div>
                    <div>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1670603240/Frame_51221_d3x4pb.svg" alt="object not found"
                        onClick={handleLogout}/>
                    
                    </div>
                </div>

        </div>
    )
}