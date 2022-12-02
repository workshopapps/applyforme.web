import React from "react";
import classes from "./BlueBorderButton.module.css";
import mainStyle from "../Button.module.css";
import { useNavigate } from "react-router-dom";

const BlueBorderButton = ({ width, text, func }) => {
    const navigate = useNavigate();
    return (
            <button
                style={{ width: `${width}px` }}
                className={[classes.btn, mainStyle.main_btn].join(" ")}
                onClick={() => func(navigate("/contact"), window.scroll(0, 0)) ?? {}}
            >
                {text}
            </button>
    );
};

export default BlueBorderButton;
