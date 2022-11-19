import React from "react";
import "./Faqs.css";

const Faqs = () => {
    return (
        <div className="faqs">
            <div className="content">
                <p>
                    Get the latest career resource tips delivered to your email!{" "}
                    <br />
                    Subscribe to our Newsletter below
                </p>
                <div className="input-container">
                    <input type="text" placeholder="Email address" />
                    <button>Subscribe</button>
                </div>
            </div>
        </div>
    );
};

export default Faqs;
