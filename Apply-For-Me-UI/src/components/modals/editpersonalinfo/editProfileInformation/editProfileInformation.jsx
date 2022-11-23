import './editProfileInformation.css';
export const EditInfoContent=()=>{
    return(
        <div>
            <form className="edit_passwordContent">
                <label htmlFor='profilePics'>ProfilePics</label>
                <input type="file" name="profilePics"/>
                <input type="text" name="FirstName" placeholder="First Name" required/>
                <input type="text" name="LastName" placeholder="Last Name"  required/>
                <input type="date" name="date" placeholder="DD/MM/YYYY"  required/>
                <input type="text" name="emailAddress" placeholder="Email Address"  required/>
                <input type="number" name="phoneNumber" placeholder="Phone Number"  required/>
                <input type="text" name="address" placeholder=" Address"  required/>
                <div className='editButtonDiv'>
                    <button type="button" style={{color:'#2E3192', background:'white', border:"1px solid #2E3192"}}>Cancel</button>
                    <button type="submit" style={{color:'white', background:'#2E3192', border:"1px solid white"}}>Save</button>
                </div>
            </form>
        </div>
    )
}