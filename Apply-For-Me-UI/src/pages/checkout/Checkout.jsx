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
  backwards
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
    firstName: false,
    lastName: false,
    email: false,
    message: false
  });

  const handleChange = e => {
    const name = e.target.name;
    const value = e.target.value;
    setUser({ ...user, [name]: value });
  };

  //A lot of refactoring to be done. Hng rushed the hell out of me. Couldnt even do form validation

  return (
    <main className={styles.mainCheckout}>
      <div className={styles.checkout}>
        <div className={styles.goback} onClick={() => navigate("/pricing")}>
          <img src={backwards} alt="go back" />
          <p>{goBack}</p>
        </div>
        <h1 className={styles.subheading}>{heading}</h1>
        <div className={styles.Inputwrapper}>
          <label className={styles.label}>{pinDetails.label}</label>
          <input
            type={pinDetails.type}
            name={pinDetails.naming}
            id={pinDetails.naming}
            placeholder={pinDetails.placeholder}
            className={`${
              touched.pin && !user.pin ? "inputEmpty" : `${styles.input__text}`
            }`}
            onChange={handleChange}
            onBlur={() => setTouched({ ...touched, pin: true })}
            value={user.pin}
            required
          />
          {touched.pin && !user.pin ? (
            <p className={styles.hint}>{cred}</p>
          ) : null}
        </div>

        <div className={styles.Inputwrapper}>
          <label className={styles.label}>{userCred.label}</label>

          <input
            type={userCred.type}
            name={userCred.naming}
            id={userCred.naming}
            placeholder={userCred.placeholder}
            className={`${
              touched.userCred && !user.userCred
                ? "inputEmpty"
                : `${styles.input__text}`
            }`}
            onChange={handleChange}
            onBlur={() => setTouched({ ...touched, userCred: true })}
            value={user.userCred}
            required
          />
          {touched.userCred && !user.userCred ? (
            <p className={styles.hint}>{cred}</p>
          ) : null}
        </div>

        <div className={styles.secure}>
          <div className={styles.secureDate}>
            <label className={styles.expirationlabel}>{validity.label}</label>
            <img src={warning} alt="warning" className={styles.warning} />
            <div className={styles.expirationWrapper}>
              <input
                type="number"
                name="year"
                id="year"
                placeholder={validity.yearPlaceholder}
                className={styles.validity}
              />

              <input
                type="number"
                name="month"
                id="month"
                placeholder={validity.monthPlaceholder}
                className={styles.validity}
              />
            </div>
            <div className={styles.expirationWrapper}></div>
          </div>
          <div className={styles.cvv}>
            <label className={styles.labelcvv}>{cvv.label}</label>
            <input
              type="number"
              name="cvv"
              id="cvv"
              placeholder={cvv.placeholder}
              className={styles.validity}
            />
          </div>
        </div>
        <button className={styles.submit}>{btnText}</button>
        <div className={styles.checked}>
          <input type="checkbox" name="checkbox" id="checkbox" />
          <label htmlFor="checkbox">{terms}</label>
        </div>
      </div>
    </main>
  );
};

export default Checkout;
