import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import privacyCss from "./Privacy.module.css";
import polygon from "../../assets/images/polygon.png";

const Privacy = () => {
    return (
        <div>
            <Nav />
            <div className={privacyCss.top_view}>
                <div className={privacyCss.bg_overlay}>
                    <div className={privacyCss.paragraph_group}>
                        <div className={privacyCss.header}>
                            <h1 style={{ color: "white" }}>Privacy Policy</h1>
                            <h2>Last updated: November 15, 2022</h2>
                        </div>
                        <br />
                        <div>
                            <p>
                                This Privacy Policy describes Our policies and
                                procedures on the collection, use and disclosure
                                of Your information when You use the Service and
                                tells You about Your privacy rights and how the
                                law protects You.
                            </p>
                            <br />
                            <p>
                                We use Your Personal data to provide and improve
                                the Service. By using the Service, You agree to
                                the collection and use of information in
                                accordance with this Privacy Policy. This
                                Privacy Policy has been created with the help of
                                the Free Privacy Policy Generator.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div id={privacyCss.privacy_policy}>
                <div id={privacyCss.table_of_content}>
                    <h2>Table of Content</h2>
                    <ol>
                        <li>
                            1. Interpretation and Definitions
                            <ol>
                                <li>Interpretation</li>
                                <li>Definition</li>
                            </ol>
                        </li>
                        <li>
                            2. Collecting and Using Your Personal Data
                            <ol>
                                <li>Types of Data Collected</li>
                                <li>Use of Your Personal Data</li>
                                <li>Retention of Your Personal Data</li>
                                <li>Transfer of Your Personal Data</li>
                                <li>Delete Your Personal Data</li>
                                <li>Disclosure of Your Personal Data</li>
                                <li>Security of Your Personal Data</li>
                            </ol>
                        </li>
                        <li>3. Children's Privacy</li>
                        <li>4. Links to Other Websites</li>
                        <li>5. Changes to this Privacy Policy</li>
                        <li>6. Contact Us</li>
                    </ol>
                </div>
                <div className={privacyCss.left}>
                    <h3 className={privacyCss.title}>
                        Interpretation and Definitions
                    </h3>
                    <p className={privacyCss.title}>
                        <strong>Interpretation</strong>
                    </p>
                    <p>
                        The words of which the initial letter is capitalized
                        have meanings defined under the following conditions.
                        The following definitions shall have the same meaning
                        regardless of whether they appear in singular or in
                        plural.
                    </p>
                    <p className={privacyCss.title}>
                        <strong>Definitions</strong>
                    </p>
                    <p className={privacyCss.child_content}>
                        <p>For the purposes of this Privacy Policy:</p>{" "}
                        <p>
                            <strong>Account</strong> means a unique account
                            created for You to access our Service or parts of
                            our Service.
                        </p>{" "}
                        <p>
                            <strong>Company</strong> (referred to as either "the
                            Company", "We", "Us" or "Our" in this Agreement)
                            refers to ApplyForMe.
                        </p>
                        <p>
                            <strong>Cookies</strong> are small files that are
                            placed on Your computer, mobile device or any other
                            device by a website, containing the details of Your
                            browsing history on that website among its many
                            uses.
                        </p>{" "}
                        <p>
                            <strong>Country</strong> refers to: Nigeria
                        </p>{" "}
                        <p>
                            <strong>Device</strong> means any device that can
                            access the Service such as a computer, a cellphone
                            or a digital tablet.
                        </p>{" "}
                        <p>
                            <strong>Personal Data</strong> is any information
                            that relates to an identified or identifiable
                            individual.
                        </p>{" "}
                        <p>
                            <strong>Service</strong> refers to the Website.
                        </p>{" "}
                        <p>
                            <strong>Service Provider</strong> means any natural
                            or legal person who processes the data on behalf of
                            the Company. It refers to third-party companies or
                            individuals employed by the Company to facilitate
                            the Service, to provide the Service on behalf of the
                            Company, to perform services related to the Service
                            or to assist the Company in analyzing how the
                            Service is used.
                        </p>{" "}
                        <p>
                            <strong>Usage Data</strong> refers to data collected
                            automatically, either generated by the use of the
                            Service or from the Service infrastructure itself
                            (for example, the duration of a page visit).
                        </p>{" "}
                        <p>
                            <strong>Website</strong> refers to ApplyForMe,
                            accessible from applyforme.com
                        </p>{" "}
                        <p>
                            <strong>You</strong> means the individual accessing
                            or using the Service, or the company, or other legal
                            entity on behalf of which such individual is
                            accessing or using the Service, as applicable.
                        </p>
                    </p>
                    <div>
                        <h3 className={privacyCss.title}>
                            Collecting and Using Your Personal Data
                        </h3>
                        <div className={privacyCss.child_content}>
                            <p>
                                {" "}
                                <img src={polygon} alt="" /> Types of Data
                                Collected
                            </p>
                            <p>
                                {" "}
                                <img src={polygon} alt="" /> Use of Your
                                Personal Data
                            </p>
                            <p>
                                {" "}
                                <img src={polygon} alt="" /> Retention of Your
                                Personal Data
                            </p>
                            <p>
                                {" "}
                                <img src={polygon} alt="" /> Transfer of Your
                                Personal Data
                            </p>
                            <p>
                                {" "}
                                <img src={polygon} alt="" /> Delete Your
                                Personal Data
                            </p>
                            <p>
                                {" "}
                                <img src={polygon} alt="" /> Disclosure of Your
                                Personal Data
                            </p>
                            <p>
                                {" "}
                                <img src={polygon} alt="" /> Security of Your
                                Personal Data
                            </p>
                        </div>
                    </div>

                    <div className="childrens_privacy">
                        <h3 className={privacyCss.title}>Children's Privacy</h3>
                        <div className={privacyCss.child_content}>
                            <p>
                                Our Service does not address anyone under the
                                age of 13. We do not knowingly collect
                                personally identifiable information from anyone
                                under the age of 13. If You are a parent or
                                guardian and You are aware that Your child has
                                provided Us with Personal Data, please contact
                                Us. If We become aware that We have collected
                                Personal Data from anyone under the age of 13
                                without verification of parental consent, We
                                take steps to remove that information from Our
                                servers.
                            </p>{" "}
                            <p>
                                If We need to rely on consent as a legal basis
                                for processing Your information and Your country
                                requires consent from a parent, We may require
                                Your parent's consent before We collect and use
                                that information.
                            </p>
                        </div>
                    </div>

                    <div className="link_to_other_websites">
                        <h3 className={privacyCss.title}>
                            Links to Other Websites
                        </h3>
                        <div className={privacyCss.child_content}>
                            <p>
                                Our Service may contain links to other websites
                                that are not operated by Us. If You click on a
                                third party link, You will be directed to that
                                third party's site. We strongly advise You to
                                review the Privacy Policy of every site You
                                visit.
                            </p>{" "}
                            <p>
                                We have no control over and assume no
                                responsibility for the content, privacy policies
                                or practices of any third party sites or
                                services.
                            </p>
                        </div>
                    </div>

                    <div className="changes_to_privacy_policy">
                        <h3 className={privacyCss.title}>
                            Changes to Privacy Policy
                        </h3>
                        <div>
                            <div className={privacyCss.child_content}>
                                <p>
                                    We may update Our Privacy Policy from time
                                    to time. We will notify You of any changes
                                    by posting the new Privacy Policy on this
                                    page.
                                </p>

                                <p>
                                    We will let You know via email and/or a
                                    prominent notice on Our Service, prior to
                                    the change becoming effective and update the
                                    "Last updated" date at the top of this
                                    Privacy Policy.
                                </p>

                                <p>
                                    You are advised to review this Privacy
                                    Policy periodically for any changes. Changes
                                    to this Privacy Policy are effective when
                                    they are posted on this page.
                                </p>
                            </div>
                        </div>
                    </div>

                    <div className="contact_us">
                        <h3 className={privacyCss.title}>Contact Us</h3>
                        <div className={privacyCss.child_content}>
                            <p>
                                If you have any questions about this Privacy
                                Policy, You can contact us:
                            </p>
                            <p>· By email: hello@applyforme.com</p>
                        </div>
                    </div>
                </div>
            </div>
            <Footer />
        </div>
    );
};

export default Privacy;
