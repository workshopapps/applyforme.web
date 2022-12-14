import styles from "./Dropdown.module.css";

const Dropdown = ({
    id,
    value,
    onChange,
    onFocus,
    name,
    options,
    width,
    placeholderText
}) => {
    return (
        <div className={styles.dropdown}>
            <select
                id={id}
                value={value}
                onChange={onChange}
                onFocus={onFocus}
                style={{ width: `${width}%` }}
                name={name}
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
