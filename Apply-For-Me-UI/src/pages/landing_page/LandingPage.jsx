import React from "react";
import "./landing.css";
import Nav from "../../components/nav/Nav";
import Footer from "../../components/footer/Footer";
import upload from "../../assets/landing-page-imgs/upload.png";
import HeroImg from "../../assets/landing-page-imgs/hero-img.png";
import check from "../../assets/landing-page-imgs/check-icon.png";

const LandingPage = () => {
    return (
        <div className="">
            <Nav />
            <main>
                {/* =========================Hero==Section============================ */}
                <div className="hero_container_wrapper">
                    {/* ===========Letf==wrapper=============== */}
                    <div className="hero_left_wrapper">
                        <div className="text-box">
                            <h1 className="hero_heading_text">
                                Take a single step to your dream job
                            </h1>
                            <p className="hero_parag_text">
                                We believe career is life, life is once, it is
                                therefore worth enjoying.Study, work, travel,
                                tour, worship, keep working and keep
                                exploring.... It begins with you. We believe
                                career is life, life is once, it is therefore
                                worth enjoying.
                            </p>
                            <div className="upload-box">
                                <div className="upload-box_img">
                                    <img src={upload} alt="" />
                                </div>
                                <p>
                                    Drop your CV here to get the best matches or
                                    <span className="text-[#2A73D5] ml-2 cursor-pointer">
                                        browse
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div>

                    {/* ===============Hero right======================= */}
                    <div className="hero-img-wrapper">
                        <img src={HeroImg} alt="/" className="hero-img" />
                    </div>
                </div>
            </main>

            {/* ==================Feature==Section=============================== */}
            <div className="features">
                <div className="feature-section-container">
                    <div className="card-container">
                        <div className="card-one">
                            <div className="check-wrapper">
                                <img src={check} alt="" className="check-img" />
                            </div>

                            <h5 className="">
                                Apply to over a hundred Jobs without lifting a
                                finger
                            </h5>
                            <p>
                                We believe career is life, life is once, it is
                                therefore worth enjoying.Study, work, travel,
                                tour, worship, keep working and keep
                                exploring.... It begins with you. We believe
                                career is life, life is once, it is therefore
                                worth enjoying.
                            </p>
                        </div>
                        <div className="card-one">
                            <div className="check-wrapper">
                                <img src={check} alt="" className="check-img" />
                            </div>

                            <h5 className="">
                                Apply to over a hundred Jobs without lifting a
                                finger
                            </h5>
                            <p>
                                We believe career is life, life is once, it is
                                therefore worth enjoying.Study, work, travel,
                                tour, worship, keep working and keep
                                exploring.... It begins with you. We believe
                                career is life, life is once, it is therefore
                                worth enjoying.
                            </p>
                        </div>
                        <div className="card-one">
                            <div className="check-wrapper">
                                <img src={check} alt="" className="check-img" />
                            </div>

                            <h5 className="">
                                Apply to over a hundred Jobs without lifting a
                                finger
                            </h5>
                            <p>
                                We believe career is life, life is once, it is
                                therefore worth enjoying.Study, work, travel,
                                tour, worship, keep working and keep
                                exploring.... It begins with you. We believe
                                career is life, life is once, it is therefore
                                worth enjoying.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
};

export default LandingPage;
