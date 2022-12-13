import formStyle from "../TryoutForm.module.css";

const Input = ({
    placeholder,
    value,
    onChange,
    id,
    onBlur,
    newClass,
    type = "text"
}) => {
    return (
        <div>
            <input
                className={[formStyle.input, newClass].join(" ")}
                type={type}
                placeholder={placeholder}
                value={value}
                onChange={onChange}
                id={id}
                onBlur={onBlur}
            />
        </div>
    );
};

export default Input;
