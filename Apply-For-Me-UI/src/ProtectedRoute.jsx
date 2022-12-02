import React from "react";
import { Navigate, Outlet } from "react-router-dom";

const ProtectedRoute = ({ user, children }) => {
    // const navigate = useNavigate();
    if (!user) {
        return <Navigate to="/" replace />;
    }
    return children ? children : <Outlet />;
};

export default ProtectedRoute;
