/* eslint-disable no-unused-vars */
import React from "react";
import { useSelector } from "react-redux";
import { Navigate, Outlet, useLocation } from "react-router-dom";

const ProtectedRoute = ({ children, allowedRoles }) => {
    const location = useLocation();
    const { user } = useSelector(state => state.user);
    console.log(allowedRoles);
    return user?.roles?.find(role => allowedRoles?.includes(role)) ? (
        <Outlet />
    ) : !user ? (
        <Navigate to="*" state={{ from: location }} replace />
    ) : (
        <Outlet />
    );
};

export default ProtectedRoute;
