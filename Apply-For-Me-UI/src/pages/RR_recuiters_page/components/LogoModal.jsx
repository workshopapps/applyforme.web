import React from 'react';
import './logoModal.css';
import logo from '../../../assets/landing-page-imgs/logo-white.png';
// import hero from '../../../assets/landing-page-imgs/hero-img.png';
import { Link } from 'react-router-dom';

const LogoModal = () => {
  return (
    <div className='logomodal'>
      <div className='logomodal-container'>
        <div className='logomodal-head'>
            <Link to="/rr_sign_up" style={{fontSize: '30px', color: '#fff'}}> &#60; </Link>
            <p> Back</p>
          </div>
        <div className='logomodal-content'>
          <img className='modal-logo' src={logo} alt="logo" />
          <div className='hero'>
               <img
                  src="https://res.cloudinary.com/hamskid/image/upload/v1669936036/Mask_group_afrsbg.png"
                  alt=""
                />
          </div>
          <p>Take a single step to your dream job</p>
        </div>
      </div>
    </div>
  )
}

export default LogoModal