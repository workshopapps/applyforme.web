import styles from "./Dropdown.module.css";

const Dropdown = ({
    id,
    value,
    onChange,
    name,
    options,
    width,
    placeholderText,
    onBlur
}) => {
    return (
        <div className={styles.dropdown}>
            <select
                id={id}
                value={value}
                onChange={onChange}
                style={{ width: `${width}%` }}
                name={name}
                onBlur={onBlur}
            >
                <option value="" defaultValue={""}>
                    {placeholderText}
                </option>
                {options?.map(option => (
                    <option key={option.value} value={option.value}>
                        {option.label}
                    </option>
                ))}
            </select>
        </div>
    );
};

export default Dropdown;
