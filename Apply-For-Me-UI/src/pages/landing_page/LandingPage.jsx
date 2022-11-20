import React from "react";
import "./landing.css";
import Nav from "../../components/nav/Nav";
import Footer from "../../components/footer/Footer";
import upload from "../../assets/landing-page-imgs/upload.png";
import heroImg from "../../assets/landing-page-imgs/hero-img.png";
import check from "../../assets/landing-page-imgs/check-icon.png";
import arrow from "../../assets/landing-page-imgs/arrow.png";
import starfull from "../../assets/landing-page-imgs/star-full.png";
import starhalf from "../../assets/landing-page-imgs/star-half.png";
import starnull from "../../assets/landing-page-imgs/star-null.png";
import user from "../../assets/landing-page-imgs/user.png";
import dropdown from "../../assets/landing-page-imgs/dropdown.png";

// const LandingPage = () => {
//     return (
//         <div className="">
//             <Nav />
//             <main>
//                 {/* =========================Hero==Section============================ */}

//                 <section className="hero-section">
//                     <div className="container">
//                         {/* =============Hero-left======== */}
//                         <div className="hero-left">
//                             <div className="text-box">
//                                 <h1>Take a single step to your dream job</h1>
//                                 <p>
//                                     We believe career is life, life is once, it
//                                     is therefore worth enjoying.Study, work,
//                                     travel, tour, worship, keep working and keep
//                                     exploring.... It begins with you. We believe
//                                     career is life, life is once, it is
//                                     therefore worth enjoying.
//                                 </p>
//                                 <div className="upload-box">
//                                     <div className="upload-box_img">
//                                         <img src={upload} alt="" />
//                                     </div>
//                                     <p>
//                                         Drop your CV here to get the best
//                                         matches or
//                                         <span className="span-text">
//                                             browse
//                                         </span>
//                                     </p>
//                                 </div>
//                             </div>
//                         </div>

//                         {/* ================Hero==right================= */}
//                         <div className="hero-img">
//                             <img src={heroImg} alt="" className="" />
//                         </div>
//                         <button className="upload-btn">Upload file</button>
//                     </div>
//                 </section>

//                 {/* ===================================Featrures===Section===================== */}
//                 <section className="features">
//                     <div className="container">
//                         <div className="grid-wrapper">
//                             {/* =======================Card==one========= */}
//                             <div className="card">
//                                 <div className="checkbox">
//                                     <img src={check} alt="" />
//                                 </div>
//                                 <h5>
//                                     Apply to over a hundred Jobs without lifting
//                                     a finger
//                                 </h5>
//                                 <p>
//                                     We believe career is life, life is once, it
//                                     is therefore worth enjoying.Study, work,
//                                     travel, tour, worship, keep working and keep
//                                     exploring.... It begins with you. We believe
//                                     career is life, life is once, it is
//                                     therefore worth enjoying.
//                                 </p>
//                             </div>
//                             {/* =======================Card==two========= */}
//                             <div className="card">
//                                 <div className="checkbox">
//                                     <img src={check} alt="" />
//                                 </div>
//                                 <h5>
//                                     Apply to over a hundred Jobs without lifting
//                                     a finger
//                                 </h5>
//                                 <p>
//                                     We believe career is life, life is once, it
//                                     is therefore worth enjoying.Study, work,
//                                     travel, tour, worship, keep working and keep
//                                     exploring.... It begins with you. We believe
//                                     career is life, life is once, it is
//                                     therefore worth enjoying.
//                                 </p>
//                             </div>
//                             {/* =======================Card==Three========= */}
//                             <div className="card">
//                                 <div className="checkbox">
//                                     <img src={check} alt="" />
//                                 </div>
//                                 <h5>
//                                     Apply to over a hundred Jobs without lifting
//                                     a finger
//                                 </h5>
//                                 <p>
//                                     We believe career is life, life is once, it
//                                     is therefore worth enjoying.Study, work,
//                                     travel, tour, worship, keep working and keep
//                                     exploring.... It begins with you. We believe
//                                     career is life, life is once, it is
//                                     therefore worth enjoying.
//                                 </p>
//                             </div>
//                         </div>
//                     </div>
//                 </section>

//                 {/* =============================================Price==Section======================= */}
//                 <section className="price-section">
//                     <div className="container">
//                         <div className="price-section_text-box">
//                             <p>Payment services </p>
//                             <h5>Our Price Plan</h5>
//                             <div className="view-all">
//                                 View All
//                                 <img src={arrow} alt="" />
//                             </div>
//                         </div>

//                         <div className="prices">
//                             <div className="plans-wrapper">
//                                 <div className="plans">
//                                     <div>
//                                         <img src={check} alt="" />
//                                     </div>
//                                     <div className="request">
//                                         <h6>Application</h6>
//                                         <p>
//                                             We believe career is life, life is
//                                             once, it is therefore worth
//                                             enjoying.Study, work, travel, tour,
//                                             worship, keep working and keep
//                                             exploring
//                                         </p>
//                                     </div>
//                                 </div>
//                                 <div className="plans">
//                                     <div>
//                                         <img src={check} alt="" />
//                                     </div>
//                                     <div className="request">
//                                         <h6>Application</h6>
//                                         <p>
//                                             We believe career is life, life is
//                                             once, it is therefore worth
//                                             enjoying.Study, work, travel, tour,
//                                             worship, keep working and keep
//                                             exploring
//                                         </p>
//                                     </div>
//                                 </div>
//                                 <div className="plans">
//                                     <div>
//                                         <img src={check} alt="" />
//                                     </div>
//                                     <div className="request">
//                                         <h6>Application</h6>
//                                         <p>
//                                             We believe career is life, life is
//                                             once, it is therefore worth
//                                             enjoying.Study, work, travel, tour,
//                                             worship, keep working and keep
//                                             exploring
//                                         </p>
//                                     </div>
//                                 </div>
//                             </div>
//                             <div className="price-card">
//                                 <div className="plans-price">
//                                     <p>Basic Plan</p>
//                                     <h5>$15.99</h5>
//                                     <p className="small">Per month</p>
//                                 </div>

//                                 <div className="plans">
//                                     <div>
//                                         <img src={check} alt="" />
//                                     </div>
//                                     <div>
//                                         <p>up to 15 applications per</p>
//                                     </div>
//                                 </div>
//                                 <div className="plans">
//                                     <div>
//                                         <img src={check} alt="" />
//                                     </div>
//                                     <div>
//                                         <p>up to 15 applications per</p>
//                                     </div>
//                                 </div>
//                                 <div className="plans">
//                                     <div>
//                                         <img src={check} alt="" />
//                                     </div>
//                                     <div>
//                                         <p>up to 15 applications per</p>
//                                     </div>
//                                 </div>

//                                 <div className="start-btn">Get Started</div>
//                             </div>
//                         </div>
//                     </div>
//                 </section>

//                 {/* ===============================Testimonial==Section======================== */}

//                 <section className="testimonial">
//                     <div className="container">
//                         <div className="testimonial-leading-box">
//                             <p>Testimonial</p>
//                             <h5>What they have to say about us</h5>
//                         </div>

//                         <div className="testimonial-card-box">
//                             <div className="card">
//                                 <div className="rating-box">
//                                     <img src={starfull} alt="" />
//                                     <img src={starfull} alt="" />
//                                     <img src={starfull} alt="" />
//                                     <img src={starhalf} alt="" />
//                                     <img src={starnull} alt="" />
//                                 </div>
//                                 <p>
//                                     "We believe career is life, life is once, it
//                                     is therefore worth enjoying.Study, work,
//                                     travel, tour, worship, keep working and keep
//                                     exploring.... It begins with you. We believe
//                                     career is life, life is once, it is
//                                     therefore worth
//                                 </p>
//                                 <div className="user-box">
//                                     <div className="user-img-box">
//                                         <img src={user} alt="" />
//                                     </div>
//                                     <div className="user-info">
//                                         <small>Joa Juan</small>
//                                         <p>Company name, position</p>
//                                     </div>
//                                 </div>
//                             </div>
//                             <div className="card">
//                                 <div className="rating-box">
//                                     <img src={starfull} alt="" />
//                                     <img src={starfull} alt="" />
//                                     <img src={starfull} alt="" />
//                                     <img src={starhalf} alt="" />
//                                     <img src={starnull} alt="" />
//                                 </div>
//                                 <p>
//                                     "We believe career is life, life is once, it
//                                     is therefore worth enjoying.Study, work,
//                                     travel, tour, worship, keep working and keep
//                                     exploring.... It begins with you. We believe
//                                     career is life, life is once, it is
//                                     therefore worth
//                                 </p>
//                                 <div className="user-box">
//                                     <div className="user-img-box">
//                                         <img src={user} alt="" />
//                                     </div>
//                                     <div className="user-info">
//                                         <small>Joa Juan</small>
//                                         <p>Company name, position</p>
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 </section>

//                 {/* -------------------------------------FAQ---Section------------------------ */}
//                 <section className="faq">
//                     <div className="container">
//                         <div className="faq-flex">
//                             <div className="faq-leading-box">
//                                 <h2>Frequently asked questions</h2>
//                                 <p>
//                                     We believe career is life, life is once, it
//                                     is therefore worth enjoying.Study, work,
//                                     travel, tour, worship, keep working and keep
//                                 </p>
//                                 <button className="contact-btn">
//                                     Contact Us
//                                 </button>
//                             </div>
//                             <div className="answers-box">
//                                 <div className="answer answer-one">
//                                     <div>
//                                         <p>What do I have to do now</p>
//                                     </div>
//                                     <div>
//                                         <img src={dropdown} alt="" />
//                                     </div>
//                                 </div>
//                                 <div className="answer">
//                                     <div>
//                                         <p>What do I have to do now</p>
//                                     </div>
//                                     <div>
//                                         <img src={dropdown} alt="" />
//                                     </div>
//                                 </div>
//                                 <div className="answer ">
//                                     <div>
//                                         <p>What do I have to do now</p>
//                                     </div>
//                                     <div>
//                                         <img src={dropdown} alt="" />
//                                     </div>
//                                 </div>
//                                 <div className="answer ">
//                                     <div>
//                                         <p>What do I have to do now</p>
//                                     </div>
//                                     <div>
//                                         <img src={dropdown} alt="" />
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                 </section>
//             </main>

//             <Footer />
//         </div>
//     );
import Nav from "../../components/nav/Nav"
import Hero from "./Hero";
import classes from "./Hero.module.css"
import Service from "./Service";
import Footer from "../../components/footer/Footer"
import LearnMore from "./LearnMore";
import Pricing from "./Pricing";
import Reviews from "./Reviews";
import FAQ from "./FAQ";

const LandingPage = () => {
    return <div className={classes.general_container}>
        <Nav/>
        <Hero/>
        <Service/>
        <LearnMore/>
        <Pricing/>
        <Reviews/>
        <FAQ/>
        <Footer/>
    </div>;
};

export default LandingPage;
