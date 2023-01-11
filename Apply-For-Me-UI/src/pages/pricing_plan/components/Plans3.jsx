import { useLocation, useNavigate } from "react-router-dom";
import BlueButton from "components/buttons/blue_background/BlueButton";
import { toast } from "react-toastify";
import { useSelector } from "react-redux";
import styles from "pages/pricing_plan/pricing.module.css";
import { useState } from "react";

const Plans3 = ({ paymentInterval, plans }) => {
    const location = useLocation();
    const navigate = useNavigate();
    const { user } = useSelector(state => state.user);
    const [activeSubScription] = useState("Free")
    return (
        <div className={styles.majorPlan}>
            {plans.map(
                (
                    { planName, price, duration, model, btnText, stamp },
                    index
                ) => {
                    return (
                        <div className={styles.card} key={index}>
                            <div className={styles.choices}>
                                <p className={styles.choice_text}>{stamp}</p>
                            </div>

                            <h3 className={styles.card__heading}>{planName} plan</h3>
                            <p className={styles.card__price}>$ {price}</p>
                            <p className={styles.card__duration}>{duration}</p>

                            <div className={styles.statusWrapper}>
                                {model.map(({ icon, text, alt }, index) => {
                                    return (
                                        <div
                                            className={styles.status}
                                            key={index}
                                        >
                                            <img
                                                src={icon}
                                                alt={alt}
                                                className={styles.status__img}
                                            />
                                            <p className={styles.status__text}>
                                                {text}
                                            </p>
                                        </div>
                                    );
                                })}
                            </div>
                            {
                                user && (user?.roles?.includes("Professional"))? (
                                    activeSubScription !== planName ?
                                    <BlueButton
                                        text="Upgrade"
                                        width={200}
                                        func={() => {
                                            if (price !== "0") {
                                                navigate(
                                                    `/checkout/${planName}/${paymentInterval}/${price}`
                                                );
                                            } else {
                                                return;
                                            }
                                        }}
                                    />
                                    :
                                    <BlueButton
                                        text="SubScribed"
                                        width={200}
                                    />
                                ) : user && (!user?.roles?.includes("Professional"))? (
                                    <BlueButton
                                        text="Get Plan"
                                        width={200}
                                        func={()=>toast("SubScriptions are meant for users alone")}
                                    />
                                ):(
                                    <>
                                        <BlueButton
                                            width={200}
                                            text={btnText}
                                            func={() =>
                                                navigate("/wel2", {
                                                    state: {
                                                        from: location
                                                    }
                                                })
                                            }
                                        />{" "}
                                    </>
                            )}
                        </div>
                    );
                }
            )}
        </div>
    );
};

export default Plans3;
