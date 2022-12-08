import style from "./Applications.module.css";

import ApplicationList from "../application_list/ApplicationList";

import arrowDown from "../../../../assets/images/arrow-down.svg";
import filterIcon from "../../../../assets/images/filter-icon.svg";
import RRD_Nav from "pages/RR_Dashboard/components/RRD_Nav";

const Applications = () => {
    return (
        <article className={style.container}>
            <RRD_Nav/>
            <div>
                <input type="text" placeholder="&#x1F50E;&#xFE0E;   Search"/>
                <div>
                    <img src={filterIcon} alt="filter"/>
                    
                    <img src={arrowDown} alt="arrow facing down" />
                </div>
            </div>
            <ApplicationList />
        </article>
    );
};

export default Applications;
