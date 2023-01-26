import React, { useState } from "react";
import { motion } from "framer-motion";

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
      {/* {text && <p>{answer}</p>} */}
      { 
        text ? (
            <motion.p
                    initial={{display:"none", opacity: 0, height: 0, scaleY:0 }}
                    animate={{display:"block", opacity: 1, height: "auto",scaleY:1}}
                    transition={{ duration: 0.3 }}>
                    {answer}
            </motion.p>
        ):
        (
            <motion.p
                    initial={{display:"block", opacity: 1, height: "auto",scaleY:1 }}
                    animate={{height: 0, opacity: 0, scaleY:0}}
                    transition={{ duration: 0.3 }}
                    >
                    {answer}
            </motion.p>
        )
     }
    </div>
  );
};

export default Question;
