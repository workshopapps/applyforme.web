import "./RR_admin_List.css";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { Delete_RR_Admin } from "store/slice/RR_AdminSlice";
export const Desktop_List =({firstName,currentJobTitle,id,createdOn} )=>{
    const navigate = useNavigate();
    const dispatch= useDispatch();
    
    
    return (
        <>
            <td>
                <div className="name_table_data">
                    <span style={{ width: "15%" }}>
                        <img
                            style={{ width: "100%" }}
                            src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/Frame_51202_uoy0ee.png"
                            alt="object not found"
                        />
                    </span>
                    <h3 style={{ marginLeft: "0.4rem" }}>{firstName}</h3>
                </div>
            </td>
            <td>
                <h3 style={{ fontWeight: "400" }}>{currentJobTitle}</h3>
            </td>
            <td>
                <h3 style={{ fontWeight: "400" }}>{createdOn}</h3>
            </td>
            <td>
                <div className="viewContainer">
                    <button
                        onClick={() => navigate(`/reverseRecruiterAdmin/${id}`)}
                    >
                        view Profile
                    </button>
                    <span className="dropdown">
                        <img
                            className="three_dot_icon"
                            src="https://res.cloudinary.com/hamskid/image/upload/v1668864951/Group_caynky.png"
                            alt="object not found"
                        />
                        <div className="dropdownContent">
                            <img
                                src="https://res.cloudinary.com/hamskid/image/upload/v1669300167/Frame_51367_phrq53.png"
                                style={{ marginBottom: "0.7rem" }}
                                onClick={()=> {
                                    dispatch(Delete_RR_Admin({id:id}))
                                }}
                            />
                            <img src="https://res.cloudinary.com/hamskid/image/upload/v1669300167/Frame_51368_oevqxr.png" />
                        </div>
                    </span>
                </div>
            </td>
        </>
    );
};
