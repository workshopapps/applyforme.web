import "./notification_head.css";
import { useState } from "react";
import { MobileNav } from "components/dashboard/mobileNav";
import { useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";
import LetteredAvatar from "react-lettered-avatar";

export const NotificationHead = ({ notificationCount }) => {
    const [showMobileNav, setShowMobileNav] = useState(false);
    const navigate = useNavigate();
    const { user } = useSelector(state => state.user);
    const userName = user.fullName;
    return (
        <div className="notification_icon" style={{ position: "relative" }}>
            <div className="head_barge">
                <img
                    className="not_burger"
                    style={{ width: "26%", height: "26%" }}
                    src="https://res.cloudinary.com/hamskid/image/upload/v1669063349/Vector_bj9ixf.png"
                    alt="object not found"
                    onClick={() => setShowMobileNav(true)}
                />
                <span>
                    <img
                        className="notification_icon_amf"
                        src="https://res.cloudinary.com/hamskid/image/upload/v1669063349/Frame_yqkxnb.png"
                        alt="object not found"
                        onClick={() => navigate("/")}
                    />
                </span>
            </div>
            <div>
                <span>
                    <LetteredAvatar
                        name={userName}
                        backgroundColor={"#78909c"}
                    />
                </span>
                {notificationCount > 0 ? (
                    <h6 className="notification_count">{notificationCount}</h6>
                ) : null}
            </div>
            {showMobileNav && <MobileNav setShowMenu={setShowMobileNav} />}
        </div>
    );
};
