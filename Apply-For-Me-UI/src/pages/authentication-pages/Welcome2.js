import React from 'react'
import "./Welcome2.css"
import Navbar from './Navbar'
import Text from './components/Text/Text'
import Text2 from './components/Text/Text2'
import Inputbox from './components/Elements/Inputbox'
import Button from './components/Elements/Button'
import './components/Elements/Button.css'
import Footer from './Footer'
import { Link } from "react-router-dom";

const Welcome2 = () => {
  return (
    <div className='Welcome2'>
        <Navbar/>
        <div className='w2bdy'>
            <Text child="Welcome Back !!"/>
            <Text2 child="Login to ApplyForMe "/>
            <div className='form'>
                <Inputbox type="email" name="email" id="eml" place="Email Address"/>
                <Inputbox type="password" name="pass" id="pass" place="Password"/>
                <Link to='/pass' className='forgot'>Forgot Password</Link>
            </div>
            <Link to='/wel1' className='lg'> <Button child="Sign In"/></Link>
            <span className='ques'>Don't have an account? <Link to='/' className='special'> Sign Up</Link></span>
            <Footer/>
        </div>
    </div>
  )
}

export default Welcome2
