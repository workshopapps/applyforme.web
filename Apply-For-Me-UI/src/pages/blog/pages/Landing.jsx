import React, { useEffect } from "react";
import "./Landing.css";
import Home from "./home/Home";
import Faqs from "../components/faqs/Blogs";
import Nav from "../../../components/nav/Nav";
import Footer from "../../../components/footer/Footer";

const Landing = () => {
    useEffect(() => {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }, []);
    return (
        <div>
            <div className="">
                <Nav />
            </div>
            <div className="wrapper">
                <Home />
                <Faqs />
                <Footer />
            </div>
        </div>
    );
};

export default Landing;
