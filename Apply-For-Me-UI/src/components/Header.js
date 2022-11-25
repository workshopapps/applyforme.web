import React from 'react'

function Header() {
  return (
    <div className='dashboard-index-header'>
      <div>
        <h1>Good evening Enwono, </h1>
        <p>Here’s an overview for you</p>
      </div>
      <div className='dashboard-index-header__header-profile'>
        <img src="../images/bell-icon.svg" alt="" />
        <img src="../images/profile.svg" alt="" />
      </div>
    </div>
  )
}

export default Header
