/* eslint-disable no-unused-vars */
import React from "react";
import { useState } from "react";
import PacmanLoader from "react-spinners/PacmanLoader";
import classes from "./Spinner.module.css";
const Spinner = () => {
    let [color] = useState("#2E3192");

    return (
        <div className={classes.spinner_container}>
            <PacmanLoader
                color={color}
                size={50}
                aria-label="Loading Spinner"
                data-testid="loader"
            />
        </div>
    );
};

export default Spinner;
