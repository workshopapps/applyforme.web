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

  const [isChecked, setIsChecked] = useState(false);

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
    <main className={styles.mainCheckout}>
      <form onSubmit={handleSubmit}>
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
                touched.pin && !user.pin
                  ? `${styles.input__text} ${styles.inputEmpty}`
                  : `${styles.input__text}`
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
                  ? `${styles.input__text} ${styles.inputEmpty}`
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
                  className={`${
                    touched.year && !user.year
                      ? `${styles.validity} ${styles.inputEmpty}`
                      : `${styles.validity}`
                  }`}
                  value={user.year}
                  onChange={handleChange}
                  onBlur={() => setTouched({ ...touched, year: true })}
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
                  onBlur={() => setTouched({ ...touched, month: true })}
                  required
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
                className={`${
                  touched.cvv && !user.cvv
                    ? `${styles.validity} ${styles.inputEmpty}`
                    : `${styles.validity}`
                }`}
                value={user.cvv}
                onChange={handleChange}
                onBlur={() => setTouched({ ...touched, cvv: true })}
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
            <label htmlFor="checkbox" className={styles.checklabel}>
              {terms}
            </label>
          </div>
        </div>
      </form>
    </main>
  );
};

export default Checkout;
