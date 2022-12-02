/* eslint-disable no-unused-vars */
import React from "react";
import { useSelector } from "react-redux";
import { Navigate, Outlet, useLocation } from "react-router-dom";

const ProtectedRoute = ({ user, children, allowedRoles }) => {
    const location = useLocation();

    return user?.roles?.find(role => allowedRoles?.includes(role)) ? (
        <Outlet />
    ) : user ? (
        <Navigate to="*" state={{ from: location }} replace />
    ) : (
        <Navigate to="/" state={{ from: location }} replace />
    );
};

export default ProtectedRoute;
