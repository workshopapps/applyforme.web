/* eslint-disable no-unused-vars */
import React from "react";
import { useSelector } from "react-redux";
import { Navigate, Outlet, useLocation } from "react-router-dom";
import jwt_decode from "jwt-decode";

const ProtectedRoute = ({ children, allowedRoles }) => {
    const location = useLocation();

    if (!localStorage.getItem("tokenHngKey")) {
        return <Navigate to="/" state={{ from: location }} replace />;
    } else {
        let user = jwt_decode(localStorage?.getItem("tokenHngKey"));
        if (user?.roles[0]?.includes(allowedRoles)) {
            return <Outlet />;
        }
    }
    return <Navigate to="/" state={{ from: location }} replace />;

    // return user?.roles?.find(role => allowedRoles?.includes(role)) ? (
    //     <Outlet />
    // ) : user ? (
    //     <Navigate to="/" state={{ from: location }} replace />
    // ) : (
    //     <Outlet />
    // );
};

export default ProtectedRoute;
// if (!localStorage.getItem("tokenHngKey"))
// return <Navigate to="/" state={{ from: location }} replace />;
