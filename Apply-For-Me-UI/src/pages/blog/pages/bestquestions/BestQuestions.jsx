import React, { useEffect } from "react";
import Details from "./components/details/Details";

import "./BestQuestions.css";
import Main from "./components/main/Main";
import Nav from "../../../../components/nav/Nav";
import Footer from "../../../../components/footer/Footer";

const BestQuestions = () => {
    useEffect(() => {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }, []);
    return (
        <div className="best-questions">
            <Nav />
            <Main />
            <Details />
            <Footer />
        </div>
    );
};

export default BestQuestions;
