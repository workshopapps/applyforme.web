import React from "react";
import classes from "./BlueButton.module.css";
import mainStyle from "../Button.module.css";

const BlueButton = ({ text, width, func, type = "button" }) => {
    return (
        <button
            style={{ width: `${width}px` }}
            className={[classes.btn, mainStyle.main_btn].join(" ")}
            onClick={() => (func ? func() : {})}
            type={type}
        >
            {text}
        </button>
    );
};

export default BlueButton;
