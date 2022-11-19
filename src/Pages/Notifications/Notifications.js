import React from "react";
import Notification from "../../Components/Notification/Notification";
import SideNav from "../../Components/SideNav/SideNav";
import TopNav from "../../Components/TopNav/TopNav";
import "../../Components/Notification/Notification.css";
import "../../Components/SideNav/SideNav.css";
import "../../Components/TopNav/TopNav.css";

const Notifications = () => {
  return (
    <section id="notifications">
      <SideNav />
      <TopNav />
      <Notification />
    </section>
  );
};

export default Notifications;
