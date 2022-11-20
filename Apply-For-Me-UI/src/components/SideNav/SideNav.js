import React from "react";
import whiteLogo from "../../Assets/Notification/whiteLogo.svg";
import jobprofileLarge from "../../Assets/Notification/jobprofileLarge.svg";
import dashboardLarge from "../../Assets/Notification/dashboardLarge.png";
import applicationsLarge from "../../Assets/Notification/applicationsLarge.png";
import helpLarge from "../../Assets/Notification/helpLarge.png";
import signoutLarge from "../../Assets/Notification/signoutLarge.png";

const SideNav = () => {
  return (
    <aside className="sideNav">
      <div>
        <img className="whiteLogo" src={whiteLogo} alt="" />
      </div>

      <div className="middle">
        <div>
          <img src={dashboardLarge} alt="" />
          <p>Dashboard</p>
        </div>
        <div>
          <img src={jobprofileLarge} alt="" />
          <p>My Job Profile</p>
        </div>
        <div>
          <img src={applicationsLarge} alt="" />
          <p>Applications</p>
        </div>
      </div>

      <div className="bottom">
        <div>
          <img src={helpLarge} alt="" />
          <p>Help</p>
        </div>
        <div>
          <img src={signoutLarge} alt="" />
          <p className="signout">Signout</p>
        </div>
      </div>
    </aside>
  );
};

export default SideNav;
