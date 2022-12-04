import React from 'react'
import { Link } from 'react-router-dom';
import { useDispatch} from "react-redux";
import { userInfo } from "store/slice/UserSlice";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import jwt_decode from "jwt-decode";
// Toaster
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
const BaseUrl = "https://official-volunux.uc.r.appspot.com/api/v1/auth/sign-up";

const Sign_Up_Modal = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleSignup = async event => {
    event.preventDefault();
    const formData = {
        "first_name": event.target.fname.value,
        "last_name": event.target.lname.value,
        "email_address": event.target.email.value,
        "phone_number": event.target.num.value,
        "password": event.target.pass.value
    };

    let result = await axios
        .post(`${BaseUrl}`, formData)
        .then(res => res.data)
        .catch(err => {
            console.log(err);
        });

    if (result?.token) {
        let decoded = jwt_decode(result.token);
        let tokenKey = "tokenHngKey";
        localStorage.setItem(tokenKey, result.token);
        dispatch(userInfo(decoded));
        toast("Signup Successfully");
        setTimeout(() => {
            navigate("/dashboard");
        }, 3000);
    } else {
        toast("Error signin up, try again");
    }
  };

  let field1 = 'First Name';
  let field2= 'Last Name';
  let field3= 'Phone number';
  let field4 = 'example@gmail.com';
  let field5 = 'min. 8 characters';





  return (
    <div className='rr-sign-in-modal'>
      <ToastContainer />
      <div className='rr-sign-in-modal-container'>
        <div className='rr-sign-in-modal-header'>
          <h1>Create an Account</h1>
          <p>Already have an Account? <span><Link to='/rr_sign_in'>Sign in</Link></span></p>
        </div>
        <form onSubmit={e => handleSignup(e)}>
          <div className='rr-sign-in-modal-form'>
            <div className='rr-sign-in-modal-inner-form'>
              <span>
                <label htmlFor="name">First Name</label>
                <input 
                  type="text" 
                  placeholder={field1}
                  name="fname" 
                  />
              </span>
              <span>
                <label htmlFor="name">Last Name</label>
                <input 
                  placeholder={field2} 
                  type="text" 
                  name="lname"
                  />
              </span>
            </div>
            <div className='rr-sign-in-modal-inner-form'>
              <span>
                <label htmlFor="name">Email Address</label>
                <input type="email" 
                  placeholder={field4}
                  name="email" 
                  />
              </span>
              <span>
                <label htmlFor="tel">Phone number</label>
                <input 
                  type="tel" 
                  placeholder={field3}
                  name="num"
                   />
              </span>
            </div>
            <div style={{gap: '24px'}} className='rr-sign-in-modal-inner-forms'>
              <span>
                <label htmlFor="name">Create Password</label>
                <input type="password" 
                  placeholder={field5}
                  name="pass" 
                   />
              </span>
              {/* <span>
                <label htmlFor="name">Confirm Password</label>
                <input 
                  type="pass" 
                  placeholder={field5}
                  name="password2" 
                  />
              </span> */}
            </div>
            <div className='rr-sign-span'>
              <input type="checkbox" />
              <label id='rr-agree' htmlFor="check">I here by agree to ApplyForMe 
                <Link to='/'>Terms of Service </Link> and
                <Link to='/'>Privacy Policy</Link>
              </label>
            </div>
          </div>
          <div className='rr-sign-in-modal-submit'>
            <button value='submit'>Sign Up</button>
            <div className='modal-vector'>
              <span></span>  
              <p>Or</p>
              <span></span>  
            </div>
            <button id='google'>Sign up with Google</button>
          </div>
        </form>
      </div>
    </div>
  )
}

export default Sign_Up_Modal