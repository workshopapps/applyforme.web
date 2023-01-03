import React from "react";
import Footer from "../../components/footer/Footer";
import Header from "./Header";
import MidContent from "./MidContent";
import What from "./What";
import Who from "./Who";
import Nav from "../../components/nav/Nav";

const AboutUs = () => {
    return (
        <>
            <Nav />
            <Header />
            <Who />
            <MidContent />
            <What />
            <Footer/>
        </>
    );
};

export default AboutUs;
