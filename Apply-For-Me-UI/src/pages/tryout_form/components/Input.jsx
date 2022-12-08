import formStyle from "../TryoutForm.module.css";

const Input = ({ placeholder }) => {
    return (
        <div>
            <input
                className={formStyle.input}
                type="text"
                placeholder={placeholder}
            />
        </div>
    );
};

export default Input;
