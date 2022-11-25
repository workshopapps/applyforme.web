import React from 'react'
import logo from "./images/logo.svg"
import "./Navbar.css"

const Navbar = () => {
  return (
    <div className='Navbar'>
        <img src={logo} className="logo" alt="logo"/>
    </div>
  )
}

export default Navbar