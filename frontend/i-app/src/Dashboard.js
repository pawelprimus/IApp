import React from 'react';
import { Container, Typography, Button } from '@mui/material';

const Dashboard = () => {
    // Placeholder function for logout or navigation
    const handleLogout = () => {
        // Implement logout functionality here
        console.log("User logged out");
    };

    return (
        <Container component="main" maxWidth="md">
            <Typography variant="h4" component="h1" gutterBottom>
                Welcome to the Dashboard
            </Typography>
            <Typography paragraph>
                This is your dashboard. Here you can view your fitness progress, manage your data, and explore insights.
            </Typography>
            {/* Example button for logout - adjust according to your auth flow */}
            <Button variant="outlined" color="secondary" onClick={handleLogout}>
                Log Out
            </Button>
        </Container>
    );
};

export default Dashboard;
