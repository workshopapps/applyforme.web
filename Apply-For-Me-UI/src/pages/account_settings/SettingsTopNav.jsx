import React from 'react'
import "./AccountSettings.css"
import person from "../../assets/images/Friendly Ones Avatar.png"
import bell from "../../assets/images/bell.png"


const SettingsTopNav = () => {
  return (
    <div className='top_nav'>
      <div className="nav_content">
        <h2>Account Settings</h2>

        <div>
          <div className='nav-image'>
            <img src={person} alt="" className='person' />
          </div>
          <img src={bell} alt="" />
        </div>
      </div>
    </div>
  )
}

export default SettingsTopNav