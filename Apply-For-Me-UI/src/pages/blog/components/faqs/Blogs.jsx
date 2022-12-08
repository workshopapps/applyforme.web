import React from "react";
import "./blogs.css";

const Blogs = () => {
    return (
        <div className="blogs">
            <div className="content">
                <p>
                    Get the latest career resource tips delivered to your email!
                </p>
                <p className="sub">Subscribe to our Newsletter below</p>
                <div className="input-container">
                    <input type="text" placeholder="Email address" />
                    <button>Subscribe</button>
                </div>
            </div>
        </div>
    );
};

export default Blogs;
