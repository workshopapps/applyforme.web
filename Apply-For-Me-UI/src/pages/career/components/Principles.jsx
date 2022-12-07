import "../styles/Principles.css";

const Principles = () => {
    return (
        <section>
            <div className="principles-wrapper">
                <div className="principles-heading">
                    <h2>Our Principles</h2>
                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_9_ejupno.svg" alt="object not found" />
                </div>

                <div className="principles-container">
                    <div className="border-container">
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_3_qoskae.svg" alt="object not found" />
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_1_yq5ros.svg" alt="object not found" />
                    </div>
                    <div className="principles">
                        <div className="principles-row principles-row-one">
                            <div className="principle principle-one">
                                <div className="principle-tick">
                                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_jnjkg9.svg" alt="object not found" />
                                </div>
                                <div className="principle-content">
                                    <h2>Trust</h2>
                                    <p>
                                        Our users trust us to help them find
                                        their dream roles
                                    </p>
                                </div>
                            </div>

                            <div className="principle principle-two">
                                <div className="principle-tick">
                                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_jnjkg9.svg" alt="object not found" />
                                </div>
                                <div className="principle-content">
                                    <h2>Security</h2>
                                    <p>
                                        We ensure all user data are kept secured
                                    </p>
                                </div>
                            </div>
                        </div>

                        <div className="principles-row principles-row-two">
                            <div className="principle principle-three">
                                <div className="principle-tick">
                                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_jnjkg9.svg" alt="object not found" />
                                </div>
                                <div className="principle-content">
                                    <h2>Excellence</h2>
                                    <p>
                                        We work above and beyond for our users
                                    </p>
                                </div>
                            </div>

                            <div className="principle principle-final">
                                <div className="principle-tick">
                                    <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_jnjkg9.svg" alt="object not found" />
                                </div>
                                <div className="principle-content">
                                    <h2>Satisfaction</h2>
                                    <p>
                                        Everything we do is targeted at ensuring
                                        we offer the best to our customers
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="border-container">
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_4_b6tp0r.svg" alt="object not found" />
                        <img src="https://res.cloudinary.com/hamskid/image/upload/v1670406759/Vector_2_v92zzb.svg" alt="object not found" />
                    </div>
                </div>
            </div>
        </section>
    );
};

export default Principles;
