import React, { useState } from "react";
import styles from "pages/checkout/checkout.module.css";

import { useNavigate } from "react-router-dom";

const Checkout = ({
    goBack,
    heading,
    pinDetails,
    userCred,
    cred,
    validity,
    cvv,
    btnText,
    terms,
    warning,
    backwards,
    defaultImg,
    checkoutLogo
}) => {
    const navigate = useNavigate();

    const [user, setUser] = useState({
        userCred: "",
        pin: "",
        cvv: "",
        year: "",
        month: ""
    });

    const [touched, setTouched] = useState({
        //Handling touch events
        pin: false,
        userCred: false,
        year: false,
        month: false,
        cvv: false
    });

    const handleChange = e => {
        const name = e.target.name;
        const value = e.target.value;
        setUser({ ...user, [name]: value });
    };

    const [isChecked, setIsChecked] = useState(false); //Togglingstate of checbox for button disability

    const handleSubmit = e => {
        e.preventDefault();
        if (
            user.pin &&
            user.userCred &&
            user.cvv &&
            user.year &&
            user.month &&
            isChecked
        ) {
            setUser({
                pin: "",
                userCred: "",
                year: "",
                month: "",
                cvv: ""
            });
            setTouched({
                pin: false,
                userCred: false,
                year: false,
                month: false,
                cvv: false
            });
            setIsChecked(false);
        }
    };

    //A lot of refactoring to be done. Hng rushed the hell out of me. Couldnt even do form validation

    return (
        <>
            <header className={styles.checkoutheader}>
                <div className={styles.headerwrapper}>
                    <div
                        className={styles.imgwrapper}
                        onClick={() => navigate("/")}
                    >
                        <img
                            src={checkoutLogo}
                            alt="logo"
                            className={styles.logo}
                        />
                    </div>
                    <div className={styles.profilewrapper}>
                        <img
                            src={defaultImg}
                            alt="profile icon"
                            className={styles.profileImg}
                        />
                        <p className={styles.names}>{userCred.placeholder}</p>
                    </div>
                </div>
            </header>
            <main className={styles.mainCheckout}>
                <form onSubmit={handleSubmit}>
                    <div className={styles.checkout}>
                        <div
                            className={styles.goback}
                            onClick={() => navigate("/pricing")}
                        >
                            <img src={backwards} alt="go back" />
                            <p>{goBack}</p>
                        </div>
                        <h1 className={styles.subheading}>{heading}</h1>
                        <div className={styles.Inputwrapper}>
                            <label className={styles.label}>
                                {pinDetails.label}
                            </label>
                            <input
                                type={pinDetails.type}
                                name={pinDetails.naming}
                                id={pinDetails.naming}
                                placeholder={pinDetails.placeholder}
                                className={`${
                                    touched.pin && !user.pin
                                        ? `${styles.input__text} ${styles.inputEmpty}`
                                        : `${styles.input__text}`
                                }`}
                                onChange={handleChange}
                                onBlur={() =>
                                    setTouched({ ...touched, pin: true })
                                }
                                value={user.pin}
                                required
                            />
                            {touched.pin && !user.pin ? (
                                <p className={styles.hint}>{cred}</p>
                            ) : null}
                        </div>

                        <div className={styles.Inputwrapper}>
                            <label className={styles.label}>
                                {userCred.label}
                            </label>

                            <input
                                type={userCred.type}
                                name={userCred.naming}
                                id={userCred.naming}
                                placeholder={userCred.placeholder}
                                className={`${
                                    touched.userCred && !user.userCred
                                        ? `${styles.input__text} ${styles.inputEmpty}`
                                        : `${styles.input__text}`
                                }`}
                                onChange={handleChange}
                                onBlur={() =>
                                    setTouched({ ...touched, userCred: true })
                                }
                                value={user.userCred}
                                required
                            />
                            {touched.userCred && !user.userCred ? (
                                <p className={styles.hint}>{cred}</p>
                            ) : null}
                        </div>

                        <div className={styles.secure}>
                            <div className={styles.secureDate}>
                                <label className={styles.expirationlabel}>
                                    {validity.label}
                                </label>
                                <img
                                    src={warning}
                                    alt="warning"
                                    className={styles.warning}
                                />
                                <div className={styles.expirationWrapper}>
                                    <input
                                        type="number"
                                        name="year"
                                        id="year"
                                        placeholder={validity.yearPlaceholder}
                                        className={`${
                                            touched.year && !user.year
                                                ? `${styles.validity} ${styles.inputEmpty}`
                                                : `${styles.validity}`
                                        }`}
                                        value={user.year}
                                        onChange={handleChange}
                                        onBlur={() =>
                                            setTouched({
                                                ...touched,
                                                year: true
                                            })
                                        }
                                        required
                                    />

                                    <input
                                        type="number"
                                        name="month"
                                        id="month"
                                        placeholder={validity.monthPlaceholder}
                                        className={`${
                                            touched.month && !user.month
                                                ? `${styles.validity} ${styles.inputEmpty}`
                                                : `${styles.validity}`
                                        }`}
                                        value={user.month}
                                        onChange={handleChange}
                                        onBlur={() =>
                                            setTouched({
                                                ...touched,
                                                month: true
                                            })
                                        }
                                        required
                                    />
                                </div>
                                <div className={styles.expirationWrapper}></div>
                            </div>
                            <div className={styles.cvv}>
                                <div className={styles.cvvlabelwrapper}>
                                    <label className={styles.labelcvv}>
                                        {cvv.label}
                                    </label>
                                    <img
                                        src={warning}
                                        alt="warning"
                                        className={styles.warning}
                                    />
                                </div>
                                <input
                                    type="number"
                                    name="cvv"
                                    id="cvv"
                                    placeholder={cvv.placeholder}
                                    className={`${
                                        touched.cvv && !user.cvv
                                            ? `${styles.validity} ${styles.inputEmpty}`
                                            : `${styles.validity}`
                                    }`}
                                    value={user.cvv}
                                    onChange={handleChange}
                                    onBlur={() =>
                                        setTouched({ ...touched, cvv: true })
                                    }
                                    required
                                />
                            </div>
                        </div>
                        <button className={styles.submit} disabled={!isChecked}>
                            {btnText}
                        </button>
                        <div className={styles.checked}>
                            <input
                                type="checkbox"
                                name="checkbox"
                                id="checkbox"
                                required
                                checked={isChecked}
                                onChange={() => setIsChecked(!isChecked)}
                            />
                            <label
                                htmlFor="checkbox"
                                className={styles.checklabel}
                            >
                                {terms}
                            </label>
                        </div>
                    </div>
                </form>
            </main>
        </>
    );
};

export default Checkout;
