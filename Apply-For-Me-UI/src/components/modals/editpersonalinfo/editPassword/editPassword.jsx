import "./editPassword.css";
import { useState } from "react";
import { useDispatch } from "react-redux";
import { SuperAdmin_changePassword } from "store/slice/RR_AdminSlice";

export const PasswordContent = () => {
    const [formField, setFormField] = useState({
        newpassword: "",
        oldpassword: "",
        confirmpassword: ""
    });
    const dispatch = useDispatch();
    const handleSubmit = e => {
        e.preventDefault();

        console.log(formField);
        dispatch(
            SuperAdmin_changePassword({
                newpassword: formField.newpassword,
                oldpassword: formField.oldpassword,
                confirmpassword: formField.confirmpassword
            })
        );
    };
    const setFormEmpty = () => {
        setFormField({ newpassword: "", oldpassword: "", confirmpassword: "" });
    };

    return (
        <div>
            <form className="edit_passwordContent" onSubmit={handleSubmit}>
                <input
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
                <input
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
                
                <input
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
