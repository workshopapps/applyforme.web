import React from "react";
//import Navbar from "./Navbar";
import Copy from "./Copy";
import Footer from "./Footer";
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
            <Footer />
            <Copy />
        </>
    );
};

export default AboutUs;
