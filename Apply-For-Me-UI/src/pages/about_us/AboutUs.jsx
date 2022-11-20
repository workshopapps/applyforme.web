import React from "react";
<<<<<<< HEAD

const AboutUs = () => {
    return <div>AboutUs</div>;
=======
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
>>>>>>> f47aafc17494e8e145a85e3c9cacc1abe1133f43
};

export default AboutUs;
