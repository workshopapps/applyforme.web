import './editProfileInformation.css';
import { useState } from 'react';
export const EditInfoContent=()=>{
    const[formField, setFormField] = useState({profilePics:'',FirstName:'',LastName:'',date:'',emailAddress:'',phoneNumber:'',address:''})
    const handleSubmit=(e)=>{
        e.preventDefault();
    }
    const setFormEmpty=()=>{
        setFormField({profilePics:'',FirstName:'',LastName:'',date:'',emailAddress:'',phoneNumber:'',address:''})
    }
    return(
        <div>
            <form className="edit_passwordContent" onSubmit={handleSubmit}>
                <label htmlFor='profilePics'>
                    Profile:<input type="file" name="profilePics" value={formField.profilePics} onChange={(e)=>setFormField({...formField, profilePics:e.target.value})}/>
                </label>
                
                <input type="text" name="FirstName" value={formField.FirstName} onChange={(e)=>setFormField({...formField, FirstName:e.target.value})} placeholder="First Name" required />
                <input type="text" name="LastName" value={formField.LastName} onChange={(e)=>setFormField({...formField, LastName:e.target.value})} placeholder="Last Name"  required/>
                <input type="date" name="date" value={formField.date} onChange={(e)=>setFormField({...formField, date:e.target.value})} placeholder="DD/MM/YYYY"  required/>
                <input type="text" name="emailAddress" value={formField.emailAddress} onChange={(e)=>setFormField({...formField, emailAddress:e.target.value})} placeholder="Email Address"  required/>
                <input type="number" name="phoneNumber" value={formField.phoneNumber} onChange={(e)=>setFormField({...formField, phoneNumber:e.target.value})} placeholder="Phone Number"  required/>
                <input type="text" name="address" value={formField.address} onChange={(e)=>setFormField({...formField, address:e.target.value})} placeholder=" Address"  required/>
                <div className='editButtonDiv'>
                    <button type="button" style={{color:'#2E3192', background:'white', border:"1px solid #2E3192"}} onClick={setFormEmpty}>Cancel</button>
                    <button type="submit" style={{color:'white', background:'#2E3192', border:"1px solid white"}}>Save</button>
                </div>
            </form>
        </div>
    )
}