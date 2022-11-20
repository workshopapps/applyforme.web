import React from "react";
import CareerForm from "./components/CareerForm";
import HeroSection from "./components/HeroSection";
import JobOpenings from "./components/JobOpenings";

import Nav from "./components/Nav";
import Principles from "./components/Principles";
import Testimonials from "./styles/Testimonials";

const CareerPage = () => {
    return (
        <React.Fragment>
            <Nav />
            <HeroSection />
            <Principles />
            <JobOpenings />
            <Testimonials />
            <CareerForm />
        </React.Fragment>
    );
};

export default CareerPage;
