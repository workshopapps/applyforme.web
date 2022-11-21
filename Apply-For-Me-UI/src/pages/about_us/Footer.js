import React from 'react'

function Footer() {
    return (
        <div className="footer">
        <div className="ads">
            <div className="typo">
        <img src="./img/Frame (1).svg" alt="footer app logo" />
        <p>Job hunting has never been easier. We got you covered.</p>
        <img src="./img/image 1.svg" alt="google play logo" className="google"/>
        </div>
        
        <div className="social">
            <img src="./img/Vector.svg" alt="facebook-icon" />
            <img src="./img/teenyicons_instagram-solid.svg" alt="instagram-icon" />
            <img src="./img/brandico_twitter-bird.svg" alt="twitter-icon" />
            <img src="./img/bi_youtube.svg" alt="youtube-icon" />
        </div>
        </div>
        <div className="foot-details">
        <div className="company">
            <p>Company</p>
            <p>About Us</p>
            <p>Blog</p>
            <p>Privacy Policies</p>
            <p>Terms and conditions</p>
        </div>
        <div className="help">
            <p>Help</p>
            <p>Contact Us</p>
            <p>FAQs</p>
            <p>Pricing</p>
            <p>Careers</p>
        </div>
        </div>
        </div>
    )
}

export default Footer
