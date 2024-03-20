import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate for redirection
import { Container, Typography, Button } from '@mui/material';

const Dashboard = () => {
    const [data, setData] = useState('');
    const navigate = useNavigate(); // For redirecting to login after logout

    // Function to fetch data from the secured endpoint
    const fetchData = async () => {
        const token = localStorage.getItem('jwtToken'); // Retrieve the JWT token
        console.log("token" + token)
        try {
            const response = await fetch('http://localhost:8080/api/v1/demo-controller', {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${token}`, // Include the JWT token in the Authorization header
                },
            });

            if (response.ok) {
                const result = await response.text(); // Assuming the response is plain text
                setData(result);
            } else {
                console.log("Failed to fetch data");
                // Handle failure, e.g., by redirecting to login if unauthorized
                if (response.status === 401) { // Unauthorized
                    navigate('/login');
                }
            }
        } catch (error) {
            console.error("Error fetching data:", error);
        }
    };

    useEffect(() => {
        fetchData();
    }, []); // Empty dependency array means this effect runs once on mount

    const handleLogout = () => {
        localStorage.removeItem('jwtToken'); // Remove the JWT token
        navigate('/login'); // Redirect to login page
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
            <Typography paragraph>
                {data ? data : 'Loading data...'}
            </Typography>
            <Button variant="outlined" color="secondary" onClick={handleLogout}>
                Log Out
            </Button>
        </Container>
    );
};

export default Dashboard;
