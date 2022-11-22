import './editpersonalinfo.css';
import { useState } from 'react';
import { PasswordContent } from './editPassword/editPassword';
export const EditInfoContainer=({content})=>{
    const [hideModal, setHideModal] = useState(false);
    return(
       !hideModal && (<div className="editContainer">
                            <div className="editContent">
                                <div className='modal_closal' style={{marginBottom:"2rem"}}>
                                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1669067698/Vector_rc9avy.png" alt="object not found" onClick={()=>setHideModal(true)}/>
                                </div>
                            {content}
                            </div>
                        </div>
                    )
        
    )
    
    
}