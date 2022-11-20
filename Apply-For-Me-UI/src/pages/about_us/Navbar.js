import React, { useState } from 'react'
import { Link } from 'react-router-dom'

function Navbar() {
    const [sidebar, setSidebar] = useState(false)
    return (
        <div className="navbar">
            <img src="../img/Frame.svg" alt="page logo" className="logo"/>
            <ul className="list" style={sidebar !== false ? {height: '100vh', left: 0} : {left: '-100%', overflow: 'hidden'}}>
                <li>
                    <Link to="/about" className="us">About us</Link>
                </li>
                <li>
                    <Link to="/pricing">Pricing plan</Link>
                </li>
                <li>
                    <Link to="/blog">Blog</Link>
                </li>
                <li>
                    <Link to="/faqs">FAQs</Link>
                </li>
                <li>
                    <Link to="/contact">Contact us</Link>
                </li>
                <div className="btns">
                <a href="" className="signin">Sign in</a>
                <a href="" className="started">Get started</a>
            </div>
            </ul>
            <div className="buttons">
                <a href="" className="sign-in">Sign in</a>
                <a href="" className="start">Get started</a>
            </div>
            <div className="openers">
            <img onClick={() => setSidebar(false)} style={sidebar !== true ? {display: 'none'} : {display: 'block'}} src="./img/Vector (1).svg" alt="close menu image" className="close"/>
            <img onClick={() => setSidebar(true)} style={sidebar !== false ? {display: 'none'} : {display: 'block'}} src="./img/sandwich (1).svg" alt="hamburger opener image" className="menu"/>
            </div>
        </div>
    )
}

export default Navbar
