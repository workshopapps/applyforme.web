/* eslint-disable no-unused-vars */
import "./RR_admin_List.css";
import { useNavigate } from "react-router-dom";
import { Delete_RR_Admin } from "store/slice/RR_AdminSlice";
import { useDispatch } from "react-redux";
export const Mobile_view_list =({firstName,currentJobTitle,id} )=>{
    const navigate = useNavigate();
    const dispatch = useDispatch();
    return (
        <>
            <div className="img_rapper">
                <img
                    style={{ width: "100%" }}
                    src="https://res.cloudinary.com/hamskid/image/upload/v1668865249/Frame_51202_uoy0ee.png"
                    alt="object not found"
                />
            </div>
            <div style={{ width: "50%" }}>
                <h3>{firstName}</h3>
                <h3>{currentJobTitle}</h3>
            </div>
            <div className="view_mobile_Container">
                <h5
                        onClick={() => navigate(`/user-page/reverseRecruiterAdmin/${id}`)}
                        style={{color:"#2E3192",marginBottom:"0",marginRight:"0.3rem"}}
                    >
                        View profile
                    </h5>
            </div>
        </>
    );
};
