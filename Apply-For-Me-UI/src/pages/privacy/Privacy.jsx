import React from "react";
import Nav from "../../components/nav/Nav";
import Footer from "../../components/footer/Footer"
import heroPrivacy from "../../assets/images/privacy_policy.svg"
import heroPrivacyMobile from "../../assets/images/privacy_policy_mobile.svg"
import "./privacy.css"
const Privacy = () => {
    return (
        <>
            <Nav />

            <div className="privacy">
                <div className="hero" id="hero">
                    <div className="img-container">
                        <img className="hero-privacy-img" src={heroPrivacy} alt="two people looking at laptop screen" />
                        <img className="hero-privacy-img-mobile" src={heroPrivacyMobile} alt="two people looking at laptop screen" />
                    </div>
                    <div className="privacy__container hero-privacy-content">

                        <h1>Privacy Policy</h1>
                        <p>Last Updated: November 15, 2022</p>
                        <p>This Privacy Policy describes Our policies and procedures on the collection, use and disclosure of Your information when You use the Service and tells You about Your privacy rights and how the law protects You.
                            We use Your Personal data to provide and improve the Service. By using the Service, You agree to the collection and use of information in accordance with this Privacy Policy. This Privacy Policy has been created with the help of the Free Privacy Policy Generator.</p>
                    </div>
                </div>
                <div className="privacy__container content">
                    <div className="content-table">
                        <ul className="content-table-list">
                            <h3>Table of Content</h3>
                            <li>Interpretation and Definitions
                                <a href="#">Interpretation</a>
                                <a href="#">Definitions</a>
                            </li>
                            <li>
                                Collecting and Using Your Personal Data
                                <a href="#">Types of Data Collected</a>
                                <a href="#">Use of Your Personal Data</a>
                                <a href="#">Transfer of Your Personal Data</a>
                                <a href="#">Delete Your Personal Data</a>
                                <a href="#">Disclosure of Your Personal Data</a>
                                <a href="#">Security of Your Personal Data</a>
                            </li>
                            <li>
                                Children's Privacy
                            </li>
                            <li>
                                Links to other Websites
                            </li>
                            <li>Changes to this Privacy Policy</li>
                            <li>Contact Us</li>
                        </ul>
                        <button className="back-top"><a href="#hero">Go Back to Top</a></button>
                    </div>
                    <div className="interpretations-definitions">
                        <h2>Interpretations and Definitions</h2>


                        <div className="interpretations">

                            <h3>Interpretation</h3>
                            <p>The words of which the initial letter is capitalized have meanings defined under the following conditions. The following definitions shall have the same meaning regardless of whether they appear in singular or in plural.</p>
                        </div>
                        <div className="definitions">

                            <h3>Definitions</h3>
                            <p>
                                For the purposes of this Privacy Policy:
                                <br />
                                <strong>Account</strong> means a unique account created for You to access our Service or parts of our Service.
                                <br />
                                <strong>Company</strong> (referred to as either "the Company", "We", "Us" or "Our" in this Agreement) refers to ApplyForMe.
                                <br />
                                <strong>Cookies</strong> are small files that are placed on Your computer, mobile device or any other device by a website, containing the details of Your browsing history on that website among its many uses.
                                <br />
                                <strong>Country</strong> refers to: Nigeria
                                <br />
                                <strong>Device</strong> means any device that can access the Service such as a computer, a cellphone or a digital tablet.
                                <br />
                                <strong>Personal</strong> Data is any information that relates to an identified or identifiable individual.
                                <br />
                                <strong>Service</strong> refers to the Website.
                                <br />
                                <strong>Service Provider</strong> means any natural or legal person who processes the data on behalf of the Company. It refers to third-party companies or individuals employed by the Company to facilitate the Service, to provide the Service on behalf of the Company, to perform services related to the Service or to assist the Company in analyzing how the Service is used.
                                <br />
                                <strong>Usage Data</strong> refers to data collected automatically, either generated by the use of the Service or from the Service infrastructure itself (for example, the duration of a page visit).
                                <br />
                                <strong>Website</strong> refers to ApplyForMe, accessible from applyforme.com
                                <br />
                                <strong>You</strong> means the individual accessing or using the Service, or the company, or other legal entity on behalf of which such individual is accessing or using the Service, as applicable.</p>

                        </div>
                        <div className="privacy__container-collecting__data">
                            <h2>Collecting and Using Your personal Data</h2>
                            <ul>
                                <li>Types of Data Collected</li>
                                <li>Use of Your Personal Data</li>
                                <li>Retention of Your Personal Data</li>
                                <li>Transfer of Your Personal Data</li>
                                <li>Delete Your Personal Data</li>
                                <li>Disclosure of your Personal Data</li>
                                <li>Security of Your Personal Data</li>
                            </ul>
                        </div>
                        <div className="privacy__container-childrens-privacy">
                            <h2>Children's Privacy</h2>
                            <p>Our Service does not address anyone under the age of 13. We do not knowingly collect personally identifiable information from anyone under the age of 13. If You are a parent or guardian and You are aware that Your child has provided Us with Personal Data, please contact Us. If We become aware that We have collected Personal Data from anyone under the age of 13 without verification of parental consent, We take steps to remove that information from Our servers.
                                <br />
                                If We need to rely on consent as a legal basis for processing Your information and Your country requires consent from a parent, We may require Your parent's consent before We collect and use that information.</p>
                        </div>
                        <div className="privacy__container-links">
                            <h2>Links to other Websites</h2>
                            <p>
                                Our Service may contain links to other websites that are not operated by Us. If You click on a third party link, You will be directed to that third party's site. We strongly advise You to review the Privacy Policy of every site You visit.
                                We have no control over and assume no responsibility for the content, privacy policies or practices of any third party sites or services.
                            </p>
                        </div>
                        <div className="privacy__container-changes">
                            <h2>Changes to this Privacy Policy</h2>
                            <p>We may update Our Privacy Policy from time to time. We will notify You of any changes by posting the new Privacy Policy on this page.
                                We will let You know via email and/or a prominent notice on Our Service, prior to the change becoming effective and update the "Last updated" date at the top of this Privacy Policy.
                                You are advised to review this Privacy Policy periodically for any changes. Changes to this Privacy Policy are effective when they are posted on this page.</p>
                        </div>
                        <div className="privacy__container-contactus">
                            <h2>Contact Us</h2>
                            <p>If you have any questions about this Privacy Policy, You can contact us:
                                · By email: hello@applyforme.com</p>
                        </div>
                    </div>

                </div>
            </div>
            <Footer />
        </>
    )

};

export default Privacy;
