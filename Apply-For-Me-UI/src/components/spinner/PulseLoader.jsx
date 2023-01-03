import React from "react";
import { useState } from "react";
import PulseLoader from "react-spinners/PulseLoader";
import classes from "./Spinner.module.css";
const Spinner = () => {
    let [color] = useState("#2E3192");

    return (
        <div className={classes.spinner_container}>
            <PulseLoader
                color={color}
                size={25}
                aria-label="Loading Spinner"
                data-testid="loader"
            />
        </div>
    );
};

export default Spinner;
