import styles from "./Dropdown.module.css";

const Dropdown = ({ id, value, onChange, name, options, width }) => {
    return (
        <div className={styles.dropdown}>
            <select
                id={id}
                value={value}
                onChange={onChange}
                style={{ width: `${width}%` }}
                name={name}
                // options={options}
            >
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
