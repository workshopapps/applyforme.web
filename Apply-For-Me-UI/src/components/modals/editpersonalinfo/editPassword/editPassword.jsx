import "./editPassword.css";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { SuperAdmin_changePassword } from "store/slice/RR_AdminSlice";
import { ToastContainer } from "react-toastify";

export const PasswordContent = () => {
    const [formField, setFormField] = useState({
        newpassword: "",
        oldpassword: "",
        confirmpassword: ""
    });

    const [errors, setErrors] = useState({});

    const validateInput = () => {
        let errors = {};
        if (formField.newpassword.length < 8) {
            errors.newpassword = "new password must be at least 8 characters";
        }
        if (formField.confirmpassword != formField.newpassword) {
            errors.confirmpassword = "password doesn't match";
        }
        return errors;
    };
    const dispatch = useDispatch();
    const handleSubmit = e => {
        e.preventDefault();

        console.log(formField);
        const errors = validateInput();
        if (Object.keys(errors).length) {
            setErrors(errors);
            return;
        }
        setErrors({});
        dispatch(
            SuperAdmin_changePassword({
                newpassword: formField.newpassword,
                oldpassword: formField.oldpassword,
                confirmpassword: formField.confirmpassword
            })
        );
        setFormEmpty();
    };
    const setFormEmpty = () => {
        setFormField({ newpassword: "", oldpassword: "", confirmpassword: "" });
    };

    return (
        <div className="edit_password">
            <ToastContainer />
            <form className="edit_passwordContent" onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="">Old password</label>
                    <input
                        id="oldPassword"
                        type="password"
                        name="oldPassword"
                        placeholder="enter old password"
                        required
                        value={formField.oldpassword}
                        onChange={e =>
                            setFormField({
                                ...formField,
                                oldpassword: e.target.value
                            })
                        }
                    />
                </div>

                <div>
                    <label htmlFor="">New Password</label>
                    <input
                        id="newPassword"
                        type="password"
                        name="newPassword"
                        placeholder="enter new password"
                        required
                        value={formField.newpassword}
                        onChange={e =>
                            setFormField({
                                ...formField,
                                newpassword: e.target.value
                            })
                        }
                    />
                    <span>{errors.newpassword}</span>
                </div>

                <div>
                    <label htmlFor="confirm">Confirm password</label>
                    <input
                        id="confirm"
                        type="password"
                        name="confirm"
                        placeholder="confirm password"
                        required
                        value={formField.confirmpassword}
                        onChange={e =>
                            setFormField({
                                ...formField,
                                confirmpassword: e.target.value
                            })
                        }
                    />
                    <span>{errors.confirmpassword}</span>
                </div>
                <div className="editButtonDiv">
                    <button
                        style={{
                            color: "#2E3192",
                            background: "white",
                            border: "1px solid #2E3192"
                        }}
                        onClick={setFormEmpty}
                    >
                        Cancel
                    </button>
                    <button
                        style={{
                            color: "white",
                            background: "#2E3192",
                            border: "1px solid white"
                        }}
                    >
                        Save
                    </button>
                </div>
            </form>
        </div>
    );
};
