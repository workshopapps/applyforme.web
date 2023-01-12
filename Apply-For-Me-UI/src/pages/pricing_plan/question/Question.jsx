import React, { useState } from "react";

import styles from "pages/pricing_plan/pricing.module.css";

//Component that manages it's own state onclick
const Question = ({ subQuestion, answer, subIcon }) => {
  const [text, setText] = useState(false);
  return (
    <div className={styles.content__box} onClick={() => setText(!text)}>
      <div className={styles.contentbox__question}>
        <h3 className={styles.minheading}>{subQuestion}</h3>
        <img
          src={subIcon}
          className={`${
            text
              ? `${styles.faqicon} ${styles.faqicon__active}`
              : `${styles.faqicon}`
          }`}
          alt="object not found"
        />
      </div>
      {text && <p>{answer}</p>}
    </div>
  );
};

export default Question;
