import React, { useEffect } from "react";
import Footer from "../../../../components/footer/Footer";
import Nav from "../../../../components/nav/Nav";
import Details from "./components/details/Details";
import Main from "./components/main/Main";

const Endorsment = () => {
    useEffect(() => {
        document.body.scrollTop = 0;
        document.documentElement.scrollTop = 0;
    }, []);
    return (
        <div>
            <Nav />
            <Main />
            <Details />
            <Footer />
        </div>
    );
};

export default Endorsment;
