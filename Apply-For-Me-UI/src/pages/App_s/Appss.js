import React, { useState } from "react";
import Afm from "./img/Logo.svg";
import Bell from "./img/filled/social/notifications.svg";
import Profile from "./img/profile.svg";
import "./Reverse.css";
import Chat from "./img/chat.svg";
import Help from "./img/help.svg";
import Logout from "./img/logout.svg";
import Dash from "./img/Nav item 1/Vector.svg";
import Job from "./img/Nav item 2/Vector.svg";
import Apps from "./img/Nav item 3/Vector.svg";
import Search from "./img/filled/action/Vector.svg";
import PropF from "./img/Mensagem/Avatar.svg";
import propP from "./img/Mensagem/wBadge.svg";
import Call from "./img/filled/communication/Vector.svg";
import Video from "./img/filled/av/Vector.svg";
import Inc from "./img/filled/action/info.svg";
import Op from "./img/opop.svg";
import Sender from "./img/sender.svg";
import Navi from "./img/filled/navigation/Vector.svg";
import Edit from "./img/filled/editor/Vector.svg";

const Appss = () => {
  return (
    <div className="Reverse">
        {/* NAVBAR */}
    <div className="Nav-App">
      <div>
        <img src={Afm} alt="" />
      </div>
      <div className="BellP">
        <img src={Bell} alt="" />
        <img src={Profile} alt="" />
      </div>
    </div>
     {/* SIDE NAVBAR */}
    <div className="leftBar">
        <div className="lefT">
          <img src={Dash} alt="" />
          <h2>Dashboard</h2>
        </div>
        <div className="lefT">
          <img src={Job} alt="" />
          <h2>My Job Profile</h2>
        </div>
        <div className="lefT">
          <img src={Apps} alt="" />
          <h2>Applications</h2>
        </div>
        <div className="chatS" onClick={Handle}>
          <img src={Chat} alt="" />
          <h2>Chat</h2>
        </div>
        <div className="lefT" id="left">
          <img src={Help} alt="" />
          <h2>Help</h2>
        </div>
        <div className="lefT" id="left1">
          <img src={Logout} alt="" />
          <h2>Signout</h2>
        </div>
      </div>
    </div>
  )
}

export default Appss