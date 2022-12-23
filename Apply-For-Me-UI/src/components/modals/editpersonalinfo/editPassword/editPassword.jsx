import "./editPassword.css";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { SuperAdmin_changePassword } from "store/slice/RR_AdminSlice";

export const PasswordContent = () => {
    const [oldPassword, setOldPassword] = useState("password");
    const [newPassword, setNewPassword] = useState("password");
    const [confirmPassword, setConfirmPassword] = useState("password");
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
        if (formField.confirmpassword !== formField.newpassword) {
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
    const handletoggle1 = () => {
        oldPassword === "password"
            ? setOldPassword("text")
            : setOldPassword("password");
    };
    const handletoggle2 = () => {
        newPassword === "password"
            ? setNewPassword("text")
            : setNewPassword("password");
    };
    const handletoggle3 = () => {
        confirmPassword === "password"
            ? setConfirmPassword("text")
            : setConfirmPassword("password");
    };

    return (
        <div className="edit_password">
            <form className="edit_passwordContent" onSubmit={handleSubmit}>
                <div className="password-label">
                    <label htmlFor="">Old password</label>
                    <input
                        id="oldPassword"
                        type={oldPassword}
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
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1670631906/Vector_1_qntpu2.svg"
                        alt="object not found"
                        onClick={handletoggle1}
                    />
                </div>

                <div className="password-label">
                    <label htmlFor="">New Password</label>
                    <input
                        id="newPassword"
                        type={newPassword}
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
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1670631906/Vector_1_qntpu2.svg"
                        alt="object not found"
                        onClick={handletoggle2}
                    />
                    <span>{errors.newpassword}</span>
                </div>

                <div className="password-label">
                    <label htmlFor="confirm">Confirm password</label>
                    <input
                        id="confirm"
                        type={confirmPassword}
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
                    <img
                        src="https://res.cloudinary.com/hamskid/image/upload/v1670631906/Vector_1_qntpu2.svg"
                        alt="object not found"
                        onClick={handletoggle3}
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
