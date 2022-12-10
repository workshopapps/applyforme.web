import React from 'react';
import { useDispatch} from "react-redux";
import { userInfo } from "store/slice/UserSlice";
import { Link } from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import axios from "axios";
import jwt_decode from "jwt-decode";
// Toaster
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
const BaseUrl = "https://api.applyforme.hng.tech/api/v1/auth/sign-in";




const Sign_In_Modal = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleSignup = async event => {
    event.preventDefault();
    const formData = {
        "email_address": event.target.email.value,
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
        toast("Welcome back!");
        setTimeout(() => {
            navigate("/rr_admin");
        }, 3000);
    } else {
        toast("Incorrect password or email");
    }
  };

  let field1 = 'example@gmail.com';
  let field2= '**********';


  return (
    <div className='rr-sign-in-modal'>
      <ToastContainer />
      <div className='rr-sign-in-modal-container'>
        <div className='rr-sign-in-modal-header'>
          <h1>Welcome Back</h1>
          <p>Don't have an Account? <Link to='/rr_sign_up'>Sign up</Link></p>
        </div>

        <form onSubmit={e => handleSignup(e)}>
          <div className='rr-sign-in-modal-form'>
            <span>
              <label htmlFor="name">Email Address </label>
              <input 
                type="text" 
                placeholder={field1}
                name="email" 
                />
            </span>
            <span>
              <label htmlFor="name">Enter Password</label>
              <input 
                type="password" 
                placeholder={field2} 
                name='pass'
                />
            </span>
          </div>
          <div className='rr-sign-in-modal-submit'>
            <button value='submit'>Sign In</button>
            <div className='modal-vector'>
              <span></span>  
              <p>Or</p>
              <span></span>  
            </div>
            <button id='google'>Sign in with Google</button>
          </div>
        </form>
      </div>
    </div>
  )
}

export default Sign_In_Modal