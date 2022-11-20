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
    const [click, setClick] = useState(false);

    function Handle() {
        setClick(!click);
    }
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

            {/* DISPLAY CHAT AND CONVO */}
            <div className="boaRD">
                {/* DISPLAY CHAT */}
                <div className={!click ? "boa" : "boa boa-NX"}>
                    <h1 className="Mess">Messages</h1>
                    <div className="SearchChat">
                        <div className="Search">
                            <img src={Search} alt="" />
                            <input type="text" placeholder="Pesquisar chat" />
                        </div>
                        <div className="CHAT">
                            <h3>CHAT</h3>
                            <p>+</p>
                        </div>
                    </div>

                    <div className="Supports" onClick={Handle}>
                        <img src={propP} alt="" />
                        <div className="suPP">
                            <h2>Suporte ADMIN</h2>
                            <p>
                                Lorem Ipsum has been the industry's standard
                                dummy text ever since the{" "}
                            </p>
                        </div>
                        <h5 className="one">1</h5>
                    </div>
                    <div className="Support">
                        <img src={PropF} alt="" />
                        <div className="suPP">
                            <h2>Suporte ADMIN</h2>
                            <p>
                                Lorem Ipsum has been the industry's standard
                                dummy text ever since the{" "}
                            </p>
                        </div>
                        <h5 className="one">1</h5>
                    </div>
                    <div className="Supportt">
                        <img src={PropF} alt="" />
                        <div className="suPPP">
                            <h2>Suporte ADMIN</h2>
                            <p>Opened </p>
                        </div>
                    </div>
                    <div className="Supportt">
                        <img src={PropF} alt="" />
                        <div className="suPPP">
                            <h2>Suporte ADMIN</h2>
                            <p>Opened </p>
                        </div>
                    </div>
                    <div className="Supportt">
                        <img src={PropF} alt="" />
                        <div className="suPPP">
                            <h2>Suporte ADMIN</h2>
                            <p>Opened </p>
                        </div>
                    </div>
                    <div className="Supportt">
                        <img src={PropF} alt="" />
                        <div className="suPPP">
                            <h2>Suporte ADMIN</h2>
                            <p>Opened </p>
                        </div>
                    </div>
                    <div className="Supportt">
                        <img src={PropF} alt="" />
                        <div className="suPPP">
                            <h2>Suporte ADMIN</h2>
                            <p>Opened </p>
                        </div>
                    </div>
                </div>
                {/* DISPLAY CONVO */}
                <div className={click ? "bOA" : "bOA bOA-NX"}>
                    <div className="sNav">
                        <img src={PropF} alt="" />
                        <div>
                            <img src={Call} alt="" />
                            <img src={Video} alt="" />
                            <img src={Inc} alt="" />
                        </div>
                    </div>
                    <hr className="lines" />
                    <div className="opContain">
                        <div className="opOp">
                            <img src={Op} alt="" />
                            <div className="opOp1">
                                <p>
                                    Lorem Ipsum has been the industry's standard
                                    dummy text ever since the 1500s,
                                </p>
                                <h6>8:00 PM</h6>
                            </div>
                        </div>
                        <div className="opop">
                            <img src={Op} alt="" />
                            <div className="opop1">
                                <p>
                                    Lorem Ipsum has been the industry's standard
                                    dummy text ever since the 1500s,
                                </p>
                                <h6>8:00 PM</h6>
                            </div>
                        </div>
                        <div className="opOp">
                            <img src={Op} alt="" />
                            <div className="opOp1">
                                <p>
                                    Lorem Ipsum has been the industry's standard
                                    dummy text ever since the 1500s,
                                </p>
                                <h6>8:00 PM</h6>
                            </div>
                        </div>
                        <div className="opop">
                            <img src={Op} alt="" />
                            <div className="opop1">
                                <p>
                                    Lorem Ipsum has been the industry's standard
                                    dummy text ever since the 1500s,
                                </p>
                                <h6>8:00 PM</h6>
                            </div>
                        </div>
                        <div className="Dot">
                            <h1>...</h1>
                            <img src={Op} alt="" />
                        </div>
                        <div className="IconS">
                            <div className="IconS1">
                                <img src={Edit} alt="" className="imgg1" />
                                <img src={Navi} alt="" className="imgg2" />
                                <img src={Sender} alt="" className="imgg3" />
                            </div>
                            <input
                                type="text"
                                placeholder="Digite a mensagem"
                            />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Appss;
