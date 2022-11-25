import React from 'react'
import { useParams } from 'react-router-dom'

function Header() {
  const params = useParams()
  return (
    <div className='header'>
      <div>
        <h1>Good evening Bukola, </h1>
        <p>{params?.newuser === 'newuser' ? 'Let’s get started ' : 'Here’s an overview for you'}</p>
      </div>
      <div className='header-profile'>
        <img src="../images/bell-icon.svg" alt="" />
        <img src="../images/profile.svg" alt="" />
      </div>
    </div>
  )
}

export default Header
