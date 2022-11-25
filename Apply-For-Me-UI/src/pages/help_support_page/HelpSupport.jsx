/* eslint-disable no-unused-vars */
import hsclasses from "./HelpSupport.module.css";
import Nav from "components/nav/Nav";
import Footer from "components/footer/Footer";
import ExpandableCard from "components/expandable_card/ExpandableCard";
import BlueButton from "components/buttons/blue_background/BlueButton";
import { HelpSupportInfo } from "./HelpSupportInfo";
import { useState } from "react";
import ExpandedCard from "components/expandable_card/ExpandedCard";

const HelpSupport = () => {
    const [expanded, setExpanded] = useState(false);
    const [selectedCardInfo, setselectedCardInfo] = useState(null);

    const toggleExpand = cardInfo => {
        const temp = !expanded;
        setExpanded(temp);
        setselectedCardInfo(temp ? cardInfo : null);
        document.scrollingElement.scroll({ top: 0})
    };

    return (
        <div>
            <Nav />
            <div className={hsclasses.hsmain}>
                {/* greeting message */}
                {!expanded ? (
                    <>
                        <div className={hsclasses.greeting}>
                            <h1>Hello, We Are Here To Help</h1>
                            <p>Welcome to our Help and Support Center</p>
                        </div>
                        {/* help cards */}
                        <div className={hsclasses.card_wrapper}>
                            {HelpSupportInfo.map(hsinfo => {
                                return (
                                    <ExpandableCard
                                        key={hsinfo.id}
                                        title={hsinfo.title}
                                        content={hsinfo.content}
                                        expand={() => toggleExpand(hsinfo)}
                                    />
                                );
                            })}
                        </div>
                    </>
                ) : (
                    <ExpandedCard cardInfo={selectedCardInfo} close={() => toggleExpand(null)} />
                )}
                {/*  */}
                <div className={hsclasses.contact_afm}>
                    <div>
                        <h3>Haven’t found an answer? We can help..</h3>
                        <p>
                            Contact us and we’ll get back to you as soon as
                            possible.
                        </p>
                    </div>
                    <BlueButton text={"Contact Us"} />
                </div>
            </div>
            <Footer />
        </div>
    );
};

export default HelpSupport;
