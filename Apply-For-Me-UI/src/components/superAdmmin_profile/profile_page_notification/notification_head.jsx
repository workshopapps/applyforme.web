import "./notification_head.css";
import { useState } from "react";
import { MobileNav } from "components/dashboard/mobileNav";
import { useNavigate } from "react-router-dom";
export const NotificationHead = ({ notificationCount }) => {
    const [showMobileNav, setShowMobileNav] = useState(false);
    const navigate = useNavigate();
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
                        onClick={()=>navigate("/")}
                    />
                </span>
            </div>
            <div>
                <img
                    className="notification_icon_img"
                    src="https://res.cloudinary.com/hamskid/image/upload/v1670375727/Vector_nqypjo.svg"
                    alt="object not found"
                />
                <span style={{ width: "30%", marginLeft: "1rem" }}>
                    <img
                        style={{ width: "30%" }}
                        src='https://res.cloudinary.com/hamskid/image/upload/v1670374366/Frame_51202_dbdtxv.svg'
                        alt="object not found"
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
