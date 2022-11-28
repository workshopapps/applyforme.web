import './editPassword.css';
export const PasswordContent=()=>{
    return(
        <div>
            <form className="edit_passwordContent">
                <input type="text" name="newPassword" placeholder="enter new password"  required/>
                <input type="text" name="oldPassword" placeholder="enter old password"  required/>
                <input type="text" name="confirm" placeholder="confirm password"  required/>
                <div className='editButtonDiv'>
                    <button style={{color:'#2E3192', background:'white', border:"1px solid #2E3192"}}>Cancel</button>
                    <button style={{color:'white', background:'#2E3192', border:"1px solid white"}}>Save</button>
                </div>
            </form>
        </div>
    )
}