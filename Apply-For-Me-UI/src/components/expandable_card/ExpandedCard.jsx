/* eslint-disable no-unused-vars */
import hsclasses from "../../pages/help_support_page/HelpSupport.module.css";

const ExpandedCard = ({ cardInfo, close }) => {
    return (
        <div className={hsclasses.expanded_card}>
            <div className={hsclasses.greeting}>
                <span onClick={close} className={hsclasses.close_button}>X</span>
                <h1>{cardInfo.title}</h1>
                <p>{cardInfo.details}</p>
            </div>
        </div>
    );
};

export default ExpandedCard;
