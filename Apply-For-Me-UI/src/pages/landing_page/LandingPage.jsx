import React from "react";
import Nav from "../../components/nav/Nav"
import Hero from "./Hero";
import classes from "./Hero.module.css"
import Service from "./Service";
import Footer from "../../components/footer/Footer"
import LearnMore from "./LearnMore";

const LandingPage = () => {
    return <div className={classes.general_container}>
        <Nav/>
        <Hero/>
        <Service/>
        <LearnMore/>
        <Footer/>
    </div>;
};

export default LandingPage;
