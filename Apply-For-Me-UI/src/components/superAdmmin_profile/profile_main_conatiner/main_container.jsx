import { useState } from "react";
import { PasswordContent } from "../../modals/editpersonalinfo/editPassword/editPassword";
import { EditInfoContainer } from "../../modals/editpersonalinfo/editpersonalInfo";
import { EditInfoContent } from "../../modals/editpersonalinfo/editProfileInformation/editProfileInformation";
import  "./main_container.css";
export const MainContainer=({name, email,img,phoneNumber,address,dob})=>{
    const [showEditModal, setEditModal] = useState(false);
    const [showPasswordModal, setPasswordModal] = useState(false);

    
    return(
        <>
            <div  className="ProfileMainContainer">
                <div className="profile_header">
                    <h1>Profile</h1>
                    <button className="profile_content_btn" onClick={()=>setEditModal(true)}>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/pencil-edit_g9boq4.png" alt="object not found"/>
                        <h4>Edit</h4> 
                    </button>
                </div>
                <div className="proileInfoContainer">
                    <div className="mobile_info_top_view">
                        <div className="mobile_img_top">
                            <img style={{width:'100%'}} src={img} alt="object not found"/>
                        </div>
                        <div className="mobile_info_top">
                            <div className="proileInfo">
                                <h2 className="proileInfolabel">Name</h2>
                                <h2 className="proileInfovalue">{name}</h2>
                            </div>
                            <div className="proileInfo">
                                <h2 className="proileInfolabel">Email Address</h2>
                                <h2 className="proileInfovalue"> {email}</h2>
                            </div>
                        </div>                          
                    </div>
                    <div className="desktop_info_top">
                        <div className="proileInfo">
                            <h2 className="proileInfolabel">Name</h2>
                            <h2 className="proileInfovalue">{name}</h2>
                        </div>
                        <div className="proileInfo">
                            <h2 className="proileInfolabel">Email Address</h2>
                            <h2 className="proileInfovalue"> {email}</h2>
                        </div>
                    </div>
                    
                    <div className="proileInfo">
                        <h2 className="proileInfolabel">Phone Number</h2>
                        <h2 className="proileInfovalue">{phoneNumber}</h2>
                    </div>
                    <div className="proileInfo">
                        <h2 className="proileInfolabel">Address</h2>
                        <h2 className="proileInfovalue">{address}</h2>
                    </div>
                    <div className="proileInfo">
                        <h2 className="proileInfolabel">Dob</h2>
                        <h2 className="proileInfovalue">{dob}</h2>
                    </div>
                </div>
                <div className="changePassword">
                    <h1>Password</h1>
                    <button className="profile_content_btn" onClick={()=>setPasswordModal(true)}>
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/pencil-edit_g9boq4.png" alt="object not found"/>
                        <h4>Change</h4> 
                    </button>
                </div>
            </div>
           {showEditModal ? <EditInfoContainer content={<EditInfoContent/>}/>:null}
           {showPasswordModal ? <EditInfoContainer content={<PasswordContent/>}/>:null}
        </>
    )
}