import React from 'react';
import LogoModal from './components/LogoModal';
import SignInModal from './Sign_In_Modal';
import './recruiters.css';

const SignIn = () => {
  return (
    <div className='rr_signin'>
      <LogoModal />
      <SignInModal />
    </div>
  )
}

export default SignIn