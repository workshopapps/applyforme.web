import React from 'react'
import classes from "./AccountSettings.module.css"
import person from "../../assets/images/Friendly Ones Avatar.png"
import bell from "../../assets/images/bell.png"


const SettingsTopNav = () => {
  return (
    <div className={classes.top_nav}>
      <div className={classes.nav_content}>
        <h2>Account Settings</h2>

        <div>
          <div className={classes.nav_image}>
            <img src={person} alt="" className={classes.person}/>
          </div>
          <img src={bell} alt="" />
        </div>
      </div>
    </div>
  )
}

export default SettingsTopNav