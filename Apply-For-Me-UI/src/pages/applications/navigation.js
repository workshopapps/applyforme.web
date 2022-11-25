import {
    MdOutlineWorkOutline,
    MdOutlineDashboard,
    MdPersonOutline
} from "react-icons/md";

export const navigations = [
    { name: "Dashboard", icon: <MdOutlineDashboard />, link: "/dashboard" },
    {
        name: "My Job Profile",
        icon: <MdPersonOutline />,
        link: "/dashboard/profile"
    },
    {
        name: "Applications",
        icon: <MdOutlineWorkOutline />,
        link: "/dashboard/applications"
    }
];
