import React from 'react'
import "./Password.css"
import Navbar from './Navbar'
import Text from './components/Text/Text'
import Text2 from './components/Text/Text2'
import Inputbox from './components/Elements/Inputbox'
import Button from './components/Elements/Button'
import "./components/Elements/Button.css"
import "./Welcome1.css"
import { Link } from "react-router-dom";



const Password = () => {
  return (
    <div className='Password'>
        <Navbar/>
        <div className='pbdy'>
            <Text child="Forgot Password ?"/>
            <Text2 child="Please enter your email address"/>
            <div className='form'>
                <Inputbox type="email" name="e-ml" id="e-ml" place="Email Address"/>
                <span className='liltxt'>A code will be sent to this email address</span>
            </div>
            <Link to='/veri' className='lg'><Button child="Continue"/></Link>
        </div>
    </div>
  )
}

export default Password