import React from "react";
import CareerForm from "./components/CareerForm";
import Nav from "../../components/nav/Nav";
import Footer from "../../components/footer/Footer";
import HeroSection from "./components/HeroSection";
import JobOpenings from "./components/JobOpenings";
import Principles from "./components/Principles";
import Testimonials from "./components/Testimonials";
import Cookies from "../../components/modals/cookieModal/CookieModal";

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
            <Cookies />
        </React.Fragment>
    );
};

export default CareerPage;
