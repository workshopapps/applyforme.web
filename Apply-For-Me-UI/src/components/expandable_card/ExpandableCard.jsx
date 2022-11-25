import eCard from "./ExpandableCard.module.css";
import bluearrow from "../../assets/images/bluearrow.svg";

const ExpandableCard = ({ title, content, expand }) => {
    return (
        <div className={eCard.help_card}>
            <div className={eCard.help_card_subsection}>
                <h2>{title}</h2>
                <p>{content}</p>
            </div>
            <div onClick={expand} className={eCard.learn_more}>
                Learn more <img src={bluearrow} alt="" />
            </div>
        </div>
    );
};

export default ExpandableCard;
