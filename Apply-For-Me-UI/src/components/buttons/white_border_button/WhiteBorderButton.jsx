import React from "react";
import classes from "./WhiteBorderButton.module.css";
import mainStyle from "../Button.module.css";
const WhiteBorderButton = ({ text, width, func }) => {
    return (
        <button
            style={{ width: `${width}px` }}
            className={[classes.btn, mainStyle.main_btn].join(" ")}
            onClick={() => func() ?? {}}
        >
            {text}
        </button>
    );
};

export default WhiteBorderButton;
