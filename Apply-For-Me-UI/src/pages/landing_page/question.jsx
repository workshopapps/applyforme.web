import React, { useState } from "react";
import { Link } from "react-router-dom";
import { motion } from "framer-motion";

import styles from "./question.module.css";

//Component that manages it's own state onclick
export const Question = ({ subQuestion, answer, subIcon,month }) => {
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
      { 
        text ? (
            <motion.div
                    initial={{display:"none", height: 0, opacity: 0, scaleY:0 }}
                    animate={{display:"block", height: "auto", opacity: 1,scaleY:1 }}
                    transition={{ duration: 0.3 }}
                     className={styles.innerText}>
                    <p>{answer}</p>
                    <h5 className={styles.faqlist}>{month}</h5>
                    <Link to="/faqs/faqspage">Learn more</Link>
            </motion.div>
        ):
        (
            <motion.div
                    initial={{display:"block", opacity: 1, height: "auto",scaleY:1 }}
                    animate={{height: 0, opacity: 0, scaleY:0}}
                    transition={{ duration: 0.3 }}
                     className={styles.innerText}>
                    <p>{answer}</p>
                    <h5 className={styles.faqlist}>{month}</h5>
                    <Link to="/faqs/faqspage">Learn more</Link>
            </motion.div>
        )
     }
    </div>
  );
};

