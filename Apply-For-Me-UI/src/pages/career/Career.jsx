import React from "react";
import HeroSection from "./components/HeroSection";
import JobOpenings from "./components/JobOpenings";

import Nav from "./components/Nav";
import Principles from "./components/Principles";

const CareerPage = () => {
    return (
        <React.Fragment>
            <Nav />
            <HeroSection />
            <Principles />
            <JobOpenings />
        </React.Fragment>
    );
};

export default CareerPage;
