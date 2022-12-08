import React from 'react';
import LogoModal from './components/LogoModal';
import Sign_In_Modal from './Sign_In_Modal';
import './recruiters.css';

const Sign_In = () => {
  return (
    <div className='rr_signin'>
      <LogoModal />
      <Sign_In_Modal />
    </div>
  )
}

export default Sign_In