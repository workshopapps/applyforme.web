/* eslint-disable no-unused-vars */
import "./RR_admin_List.css";
import { useNavigate } from "react-router-dom";
import { useDispatch } from "react-redux";
import { Delete_RR_Admin } from "store/slice/RR_AdminSlice";
export const Desktop_List = ({ firstName, currentJobTitle, id, createdOn }) => {
    const navigate = useNavigate();
    const dispatch = useDispatch();

    return (
        <>
            <td>
                <div className="name_table_data">
                    <span style={{ width: "15%" }}>
                        <img
                            style={{ width: "100%" }}
                            src="https://res.cloudinary.com/hamskid/image/upload/v1670374366/Ellipse_4_h3itvt.svg"
                            alt="object not found"
                        />
                    </span>
                    <h5 style={{ marginLeft: "2rem" }}>{firstName}</h5>
                </div>
            </td>
            <td>
                <h5 style={{ fontWeight: "400" }}>{currentJobTitle}</h5>
            </td>
            <td>
                <h5 style={{ fontWeight: "400" }}>
                    {createdOn?.split("T").shift()}
                </h5>
            </td>
            <td>
                <div className="viewContainer">
                    <h5
                        onClick={() =>
                            navigate(`/user-page/reverseRecruiterAdmin/${id}`)
                        }
                        style={{
                            color: "#2E3192",
                            marginBottom: "0",
                            marginRight: "0.3rem"
                        }}
                    >
                        view Profile
                    </h5>
                </div>
            </td>
        </>
    );
};
