/* eslint-disable no-unused-vars */
import React from "react";
import { useState } from "react";
// import PuffLoader from "react-spinners/PuffLoader";
import classes from "./Spinner.module.css";
const Spinner = () => {
    let [color] = useState("#2E3192");

    return (
        <div className={classes.spinner_container}>
            <PuffLoader
                color={color}
                size={100}
                aria-label="Loading Spinner"
                data-testid="loader"
            />
        </div>
    );
};

export default Spinner;
