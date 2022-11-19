import "./Cookies.css";
import Nav from '../../components/nav/Nav.jsx';
import Footer from '../../components/footer/Footer.jsx';
import React from "react";

const Cookies = () => {
    return (
        <div>
            <Nav />
            <div>
            <div>
                <h2 className="heading">
                    Cookies and Similar Technologies Policy
                </h2>
                <p className='headSub'>This Cookie Policy takes effect on Dec 3, 2022. Last updated on Dec 3, 2022</p>
            </div>
            <div>
                <h3 className='informationH'>
                    Information About Our Use of Cookies and Similar Technologies
                </h3>
                <p className="information">
                    Applyforme (the “Applyforme Group,” “we,” “our,” or “us”) wants to make sure you understand how cookies and other similar technologies are used by us on our websites applyforme.com and any subdomains thereof (which we may refer to as the “Sites”) and by our partners. These technologies have several purposes (including third-party advertising). Our Sites use cookies and similar technologies to distinguish you from other users of our Sites. This helps us to provide you with a good experience when you browse our Sites and also allows us to improve our Sites. By continuing to browse any of our Sites, you are agreeing to our use of cookies and similar technologies as described in this Policy.
                </p>
            </div>
            <div>
                <h3 className="technologiesH">
                    Types of Technologies That We Use
                </h3>
                <p className="technologies">
                    Cookies: A cookie is a small piece of data (text file) that a website – when visited by a user – asks your browser to store on your device in order to remember information about you, such as your language preference or login information. Those cookies are set by us and called “first-party cookies”. We also use “third-party cookies” – which are cookies originating from a domain different from the domain of the website you are visiting (e.g., one of our Sites) – generally for our advertising and marketing efforts. More specifically, we use cookies and other tracking technologies for the following purposes: to enable our Sites to function and mainta in security (for example, shopping cart functionality, security, customer support); to track, measure, and improve performance of our Sites; allow personalization of our Sites; and to target our own ads to prior visitors of our Sites on third party websites (see below on “Why We Use Cookies and Similar Technologies”).




                </p>
            </div>
            </div>

            <Footer />
        </div>
    );

};

export default Cookies;
