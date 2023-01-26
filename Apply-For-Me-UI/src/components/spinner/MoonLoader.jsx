import React from "react";
import { useState } from "react";
import MoonLoader from "react-spinners/MoonLoader";
import classes from "./Spinner.module.css";
const Spinner = () => {
    let [color] = useState("#2E3192");

    return (
        <div className={classes.spinner_container}>
            <div className={classes.spinner_inner}>
                <MoonLoader
                    color={color}
                    size={100}
                    aria-label="Loading Spinner"
                    data-testid="loader"
                />
                <br />
                <p>verifying payment...</p>
            </div>
        </div>
    );
};

export default Spinner;
