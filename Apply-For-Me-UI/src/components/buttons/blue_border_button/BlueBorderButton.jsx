import React from "react";
import classes from "./BlueBorderButton.module.css";
import mainStyle from "../Button.module.css";
import { useNavigate } from "react-router-dom";

const BlueBorderButton = ({ width, text, func }) => {
    const navigate = useNavigate();
    return (
<<<<<<< HEAD
            <button
                style={{ width: `${width}px` }}
                className={[classes.btn, mainStyle.main_btn].join(" ")}
                onClick={() => func(navigate("/contact"), window.scroll(0, 0)) ?? {}}
            >
                {text}
            </button>
=======
        <button
            style={{ width: `${width}px` }}
            className={[classes.btn, mainStyle.main_btn].join(" ")}
            onClick={() => (func ? func() : {})}
        >
            {text}
        </button>
>>>>>>> ac402ad696b4a75c65d9a475a9a2c9c771f3163d
    );
};

export default BlueBorderButton;
