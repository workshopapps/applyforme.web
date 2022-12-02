import React from "react";
import classes from "./DarkBlueButton.module.css";
import mainStyle from "../Button.module.css";

const DarkBlueButton = ({ text, width, func }) => {
    return (
        <button
            style={{ width: `${width}px` }}
            className={[classes.btn, mainStyle.main_btn].join(" ")}
            onClick={() => (func ? func() : {})}
        >
            {text}
        </button>
    );
};

export default DarkBlueButton;
