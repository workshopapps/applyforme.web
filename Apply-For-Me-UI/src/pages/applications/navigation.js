import { CiUser } from "react-icons/ci";
import { MdOutlineWorkOutline, MdOutlineDashboard } from "react-icons/md";

export const navigations = [
    { name: "Dashboard", icon: <MdOutlineDashboard />, link: "/dashboard" },
    {
        name: "Job Profile",
        icon: <CiUser />,
        link: "/dashboard/profile"
    },
    {
        name: "Applications",
        icon: <MdOutlineWorkOutline />,
        link: "/dashboard/applications"
    }
];
