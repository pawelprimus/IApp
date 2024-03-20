import React from 'react';
import { Navigate } from 'react-router-dom';

const ProtectedRoute = ({ children }) => {
    // Check for JWT token in local storage
    const token = localStorage.getItem('jwtToken');

    if (!token) {
        // If no token, redirect to login page
        return <Navigate to="/login" replace />;
    }

    // If token exists, allow access to the component
    return children;
};

export default ProtectedRoute;
