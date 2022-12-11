import React from "react";
import "./Inputbox.css";

const Inputbox = props => {
    return (
        <label className="inputbox_label">
            <input
                type={props.type}
                name={props.name}
                id={props.id}
                placeholder={props.place}
                className="input"
            />
        </label>
    );
};

export default Inputbox;
