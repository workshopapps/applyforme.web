import React from "react";
import styles from "./InputFile.module.css";

const InputField = ({
    width,
    value,
    label,
    name,
    placeholder,
    type,
    onChange
}) => (
    <div className={styles.form_group}>
        {label && <label htmlFor="input-field">{label}</label>}
        <input
            required
            style={{ width: `${width}%` }}
            type={type}
            value={value}
            name={name}
            placeholder={placeholder}
            onChange={onChange}
        />
    </div>
);

export default InputField;
