import { Link } from "react-router-dom";
import style from "./cookie.module.css";
import CookieConsent from "react-cookie-consent";
const CookieModal = () => {
    return (
        <CookieConsent
            location="bottom"
            buttonText="Accept All"
            enableDeclineButton
            hideOnAccept
            declineButtonText="Decline all"
            flipButtons
            style={{
                display: "block",
                backgroundColor: "#2E3192"
            }}
            buttonStyle={{
                backgroundColor: "#171646",
                color: "#FBFBFF",
                padding: "1rem 3rem",
                borderRadius: "5px"
            }}
            buttonWrapperClasses={style.wrapper}
            declineButtonStyle={{
                backgroundColor: "inherit",
                color: "#FBFBFF",
                border: "2px solid #BFBFBF",
                padding: "1rem 3rem",
                borderRadius: "5px"
            }}
            cookieName="applyforme_cookies"
        >
            <div className={style.pageContent}>
                <h2 className={style.heading}>Cookie Notification</h2>
                <p className={style.paragraph}>
                    This website uses cookies to optimize your experience and to
                    provide us insight on how to interact with the site. All
                    information shared with us through cookies are secured and
                    covered by our data privacy obligations. You can access our
                    Privacy Policy{" "}
                    <Link to="/privacy" className={style.link}>
                        here
                    </Link>
                </p>
            </div>
        </CookieConsent>
    );
};

export default CookieModal;
