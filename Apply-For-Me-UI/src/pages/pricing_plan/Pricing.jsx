import React from "react";
import styles from "pages/pricing_plan/pricing.module.css";

//Importing bluebutton component
import BlueBorderButton from "components/buttons/blue_border_button/BlueBorderButton";

//The question component
import Question from "pages/pricing_plan/question/Question";

import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import BlueButton from "components/buttons/blue_background/BlueButton";

const Pricing = ({
  primaryHeading,
  primaryText,
  plans,
  toggleInfo,
  faqSection,
  secondaryHeading,
  secondaryText,
  faqSection: { faqHeading, faqText, faqBtnText }
}) => {
  return (
    <>
      <Nav />
      <main className={styles.container}>
        <section className={styles.section__head}>
          <div className={styles.headingWrapper}>
            <h1 className={styles.mainheading}>{primaryHeading}</h1>
            <p className={styles.primaryText}>{primaryText}</p>
          </div>
        </section>
        <section className={styles.section__plans}>
          <div className={styles.planWrapper}>
            <div className={styles.toggle}>
              <p>{toggleInfo.text1}</p>
              <p>{toggleInfo.text2}</p>
            </div>

            <div className={styles.majorPlan}>
              {plans.map(
                ({ basic, price, duration, model, btnText, stamp }, index) => {
                  return (
                    <div className={styles.card} key={index}>
                      <span className={styles.choice}>
                        <p className={styles.choice}>{stamp}</p>
                      </span>

                      <h3 className={styles.card__heading}>{basic}</h3>
                      <p className={styles.card__price}>{price}</p>
                      <p className={styles.card__duration}>{duration}</p>

                      <div className={styles.statusWrapper}>
                        {model.map(({ icon, text, alt }, index) => {
                          return (
                            <div className={styles.status} key={index}>
                              <img
                                src={icon}
                                alt={alt}
                                className={styles.status__img}
                              />
                              <p className={styles.status__text}>{text}</p>
                            </div>
                          );
                        })}
                      </div>

                      <BlueButton width={200} text={btnText} />
                    </div>
                  );
                }
              )}
            </div>
          </div>
        </section>
        <section className={styles.subHead}>
          <div className={styles.secondaryHeadWrapper}>
            <h2 className={styles.secondaryHeading}>{secondaryHeading}</h2>
            <p className={styles.secondaryText}>{secondaryText}</p>
          </div>
        </section>
        <section className={styles.faq}>
          <div className={styles.faqWrapper}>
            <div className={styles.faqmain}>
              <h2 className={styles.faqheading}>{faqHeading}</h2>
              <p className={styles.faqText}>{faqText}</p>

              <BlueBorderButton text={faqBtnText} />
            </div>

            <div className={styles.questionWrapper}>
              {faqSection.questions.map((question, index) => {
                return (
                  <Question
                    key={index}
                    subIcon={question.subIcon}
                    subQuestion={question.mainQuestion}
                    answer={question.answer}
                  />
                );
              })}
            </div>
          </div>
        </section>
      </main>
      <Footer />
    </>
  );
};

export default Pricing;
