import React from "react";
import classes from "./BlueBorderButton.module.css";
import mainStyle from "../Button.module.css";

const BlueBorderButton = ({ width, text, func }) => {
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

export default BlueBorderButton;
