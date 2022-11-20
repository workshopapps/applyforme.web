import React from "react";
import HeroSection from "./components/HeroSection";

import Nav from "./components/Nav";
import Principles from "./components/Principles";

const CareerPage = () => {
    return (
        <React.Fragment>
            <Nav />
            <HeroSection />
            <Principles />
        </React.Fragment>
    );
};

export default CareerPage;
