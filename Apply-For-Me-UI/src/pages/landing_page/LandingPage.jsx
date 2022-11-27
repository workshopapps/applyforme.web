import React from "react";
import Nav from "../../components/nav/Nav";
import Hero from "./Hero";
import classes from "./Hero.module.css";
import Service from "./Service";
import Footer from "../../components/footer/Footer";
import LearnMore from "./LearnMore";
import Pricing from "./Pricing";
import Reviews from "./Reviews";
import FAQ from "./FAQ";
import Cookies from "../../components/modals/cookieModal/CookieModal";

const LandingPage = () => {
    return (
        <div className={classes.general_container}>
            <Nav />
            <Hero />
            <Service />
            <LearnMore />
            <Pricing />
            <Reviews />
            <FAQ />
            <Footer />
            <Cookies />
        </div>
    );
};

export default LandingPage;
