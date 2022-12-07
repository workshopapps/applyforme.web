import React from "react";
import CareerForm from "./components/CareerForm";
import HeroSection from "./components/HeroSection";
import JobOpenings from "./components/JobOpenings";
import Footer from "./components/Footer";
import Nav from "components/nav/Nav";

// import Nav from "./components/Nav";
import Principles from "./components/Principles";
import Testimonials from "./components/Testimonials";

const CareerPage = () => {
    return (
        <React.Fragment>
            <Nav />
            <HeroSection />
            <Principles />
            <JobOpenings />
            <Testimonials />
            <CareerForm />
            <Footer />
        </React.Fragment>
    );
};

export default CareerPage;
