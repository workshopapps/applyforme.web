import React from "react";
import { useState } from "react";
import BarLoader from "react-spinners/BarLoader";
import classes from "./Spinner.module.css";
const Spinner = () => {
    let [color] = useState("#2E3192");

    return (
        <div className={classes.spinner_container}>
            <BarLoader
                color={color}
                size={25}
                aria-label="Loading Spinner"
                data-testid="loader"
            />
        </div>
    );
};

export default Spinner;
