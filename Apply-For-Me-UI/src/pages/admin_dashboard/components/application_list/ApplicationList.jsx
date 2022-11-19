import style from './ApplicationList.module.css';

import {Link} from 'react-router-dom';

const ApplicationList = () => {
    return (
        <div className={style.list_list}>
            <ul>
                <li>Name</li>
                <li>Job title</li>
                <li>Plan</li>
                <li>Salary</li>
                <li>Type</li>
                <li>Details</li>
            </ul>
            <ul>
                <li>Sharon Sunday</li>
                <li>Product Design</li>
                <li>Premium</li>
                <li>$10,000 - $15,000</li>
                <li>Remote</li>
                <li><Link to="/dashboard/details">View</Link></li>
            </ul>

            <ul>
                <li>Sharon Sunday</li>
                <li>Product Design</li>
                <li>Basic</li>
                <li>$10,000 - $15,000</li>
                <li>Hybrid</li>
                <li><Link to="/dashboard/details">View</Link></li>
            </ul>
            <ul>
                <li>Sharon Sunday</li>
                <li>Product Design</li>
                <li>Standard</li>
                <li>$10,000 - $15,000</li>
                <li>Remote</li>
                <li><Link to="/dashboard/details">View</Link></li>
            </ul>
            <ul>
                <li>Michael Anu</li>
                <li>Product Design</li>
                <li>Premium</li>
                <li>$10,000 - $15,000</li>
                <li>On-site</li>
                <li><Link to="/dashboard/details">View</Link></li>
            </ul>
            <ul>
                <li>Michael Anu</li>
                <li>Product Design</li>
                <li>Basic</li>
                <li>$10,000 - $15,000</li>
                <li>Remote</li>
                <li><Link to="/dashboard/details">View</Link></li>
            </ul>
            <ul>
                <li>Michael Anu</li>
                <li>Product Design</li>
                <li>Standard</li>
                <li>$10,000 - $15,000</li>
                <li>Remote</li>
                <li><Link to="/dashboard/details">View</Link></li>
            </ul>
        </div>
    );
};
export default ApplicationList;
