/* eslint-disable no-unused-vars */
import "./RR_admin_List.css";
import { useNavigate } from "react-router-dom";

// import { useDispatch } from "react-redux";
// import { Delete_RR_Admin } from "store/slice/RR_AdminSlice";
export const DesktopList = ({ firstName, currentJobTitle, id, createdOn, avatar }) => {
    const navigate = useNavigate();
    // const dispatch= useDispatch();

    return (
        <>
             <td className="table-td">
                <div className="name_table_data">
                    <span style={{ width: "15%" }}>
                        <img
                            style={{ width: "100%" }}
                            src="https://res.cloudinary.com/hamskid/image/upload/v1670374366/Ellipse_4_h3itvt.svg"
                            alt="object not found"
                        />
                    </span>
                    <h6 style={{ marginLeft: "2rem" }}>{firstName}</h6>
                </div>
            </td>
             <td className="table-td">
                <h6 style={{ fontWeight: "400" }}>{currentJobTitle}</h6>
            </td>
             <td className="table-td">
                <h6 style={{ fontWeight: "400" }}>
                    {createdOn?.split("T").shift()}
                </h6>
            </td>
             <td className="table-td">
                <div className="viewContainer">
                    <h6
                        onClick={() =>
                            navigate(`/user-page/reverseRecruiterAdmin/${id}`)
                        }
                        style={{
                            color: "#2E3192",
                            marginBottom: "0",
                            marginRight: "0.3rem"
                        }}
                    >
                        View profile
                    </h6>
                </div>
            </td>
        </>
    );
};
