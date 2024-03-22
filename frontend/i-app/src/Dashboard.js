import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import { Container, Typography, Tabs, Tab, Button } from '@mui/material';

const Dashboard = () => {
    const handleLogout = () => {
        localStorage.removeItem('jwtToken'); // Remove the JWT token
        console.log("User logged out");
    };

    return (
        <Container component="main" maxWidth="md">
            <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
                <Typography variant="h4" component="h1" gutterBottom>
                    Welcome to the Dashboard
                </Typography>
                <Button variant="outlined" color="secondary" onClick={handleLogout}>
                    Log Out
                </Button>
            </div>
            <div style={{ display: 'flex' }}>
                <div style={{ marginRight: '20px' }}>
                    <Typography variant="h5" component="h2" gutterBottom>
                        Menu
                    </Typography>
                    <Tabs orientation="vertical">
                        <Tab label="My Weight" component={Link} to="/dashboard/myweight" />
                        {/* Add other tabs here */}
                    </Tabs>
                </div>
                <div>
                    <Outlet />
                </div>
            </div>
        </Container>
    );
};

export default Dashboard;
