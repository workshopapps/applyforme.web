import React from 'react'
import "./Verification.css"
import Navbar from './Navbar'
import Text from './components/Text/Text'
import Text2 from './components/Text/Text2'
import Button from './components/Elements/Button'
import "./components/Elements/Button.css"
import { Link } from "react-router-dom";

const Verification = () => {
  return (
    <div className='Verification'>
        <Navbar/>
        <div className='vbdy'>
            <Text child="Verification Code"/>
            <Text2 child=">Enter the verification code sent to your email address"/>
            <div className='verify'>
                <input type="text" className="vrfy"/>
                <input type="text" className="vrfy"/>
                <input type="text" className="vrfy"/>
                <input type="text" className="vrfy"/>
            </div>
            <div className='resend'>Resend verification code</div>
            <Link to='/nwpass' className='lg'><Button child="Continue"/></Link>
        </div>
    </div>
  )
}

export default Verification