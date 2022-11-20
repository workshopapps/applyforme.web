import { useState } from "react";
import "../styles/CareerForm.css";

const CareerForm = () => {
    const [inputValue, setInputValue] = useState("");
    return (
        <div className="career-form-wrapper">
            <div className="career-form">
                <div className="career-form-text">
                    <h3>Excited to join the team?</h3>
                    <p>
                        We are always looking for amazing talents like you.
                        Leave your email and we'll notify of available roles.
                    </p>
                </div>
                <div className="career-input-section">
                    <input
                        type="text"
                        placeholder="Input a valid email"
                        value={inputValue}
                        onChange={event => setInputValue(event.target.value)}
                    />
                    <button>Submit Email</button>
                </div>
            </div>
        </div>
    );
};

export default CareerForm;
