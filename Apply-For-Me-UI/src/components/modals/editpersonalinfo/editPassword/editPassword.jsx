import './editPassword.css';
import {useState} from 'react';
export const PasswordContent=()=>{
    const[formField, setFormField] = useState({newpassword:'',oldpassword:'',confirmpassword:''})
    const handleSubmit=(e)=>{
        e.preventDefault();
    }
    const setFormEmpty=()=>{
        setFormField({newpassword:'',oldpassword:'',confirmpassword:''})
    }

    return(
        <div>
            <form className="edit_passwordContent" onSubmit={handleSubmit}>
                <input type="text" name="newPassword" placeholder="enter new password"  required value={formField.newpassword} onChange={(e)=>setFormField({...formField, newpassword:e.target.value})}/>
                <input type="text" name="oldPassword" placeholder="enter old password"  required value={formField.oldpassword} onChange={(e)=>setFormField({...formField, oldpassword:e.target.value})}/>
                <input type="text" name="confirm" placeholder="confirm password"  required value={formField.confirmpassword} onChange={(e)=>setFormField({...formField, confirmpassword:e.target.value})}/>
                <div className='editButtonDiv'>
                    <button style={{color:'#2E3192', background:'white', border:"1px solid #2E3192"}} onClick={setFormEmpty}>Cancel</button>
                    <button style={{color:'white', background:'#2E3192', border:"1px solid white"}}>Save</button>
                </div>
            </form>
        </div>
    )
}