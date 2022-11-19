import React from "react";
import settings from "../../Assets/Notification/settings.svg";
import cancel from "../../Assets/Notification/cancel.svg";
import message from "../../Assets/Notification/message.svg";
import time from "../../Assets/Notification/time.svg";

import chevronRight from "../../Assets/Notification/chevronRight.svg";

const Notification = () => {
  return (
    <>
      <section className="notifications">
        <div className="header">
          <h2>Notifications</h2>
          <img className="settings" src={settings} alt="" />
        </div>

        <div className="manage">
          <h3>Manage your notification</h3>
          <p className="seeSettings">See settings</p>
        </div>

        <div className="alert">
          <p className="unread">unread</p>
          <img className="cancel" src={cancel} alt="" />
          <div className="message">
            <img src={message} alt="" />
            <p>Message</p>
          </div>
          <div className="line"></div>
          <div className="mainMessage">
            <p>You have a new message from a potential employer</p>
            <p>14 hours ago</p>
          </div>
          <p className="backEng">Backend Engineer</p>
          <p className="xytech">Xytech systems.</p>
          <div className="goToMessage">
            <p>Lagos, NG</p>
            <button>
              <p>Go to message</p>
              <img src={chevronRight} alt="" />
            </button>
          </div>
        </div>
      </section>

      <section className="notifications">
        <div className="alert" id="read">
          <img className="cancel" src={cancel} alt="" />
          <div className="message">
            <img src={time} alt="" />
            <p>Interview Alert </p>
          </div>
          <div className="line"></div>
          <div className="mainMessage">
            <p>You have an upcoming interview with this company</p>
            <p>3 days ago</p>
          </div>
          <p className="backEng">Senior Software Engineer</p>
          <p className="xytech">Digified Inc.</p>
          <div className="goToMessage">
            <p>Abuja, NG</p>
            <button>
              <p>Go to message</p>
              <img src={chevronRight} alt="" />
            </button>
          </div>
        </div>
      </section>
    </>
  );
};

export default Notification;
