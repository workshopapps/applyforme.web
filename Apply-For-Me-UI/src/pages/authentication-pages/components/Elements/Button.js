import React from "react";
import "./Button.css";

const Button = props => {
    return (
        <label className="button_label">
            <input
                type="submit"
                name="submit"
                value={props.child}
                className="btn"
            />
        </label>
    );
};

export default Button;
