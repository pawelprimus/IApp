import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; // Use useNavigate instead of useHistory
import { Container, Typography, TextField, Button } from '@mui/material';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate(); // Use navigate for redirection

    const handleSubmit = async (e) => {
        e.preventDefault();
        const loginData = { username: email, password: password };

        try {
            const response = await fetch('http://localhost:8080/api/v1/auth/authenticate', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(loginData),
            });

            if (response.ok) {
                const data = await response.json(); // Assuming the token is in the JSON response
                console.log("Login successful");
                console.log(data)
                console.log("set to local storage token -> " + data.access_token);
                localStorage.setItem('jwtToken', data.access_token); // Adjust 'data.token' based on your actual response structure
                //navigate('/api/v1/demo-controller'); // Change to your desired path
                navigate('/dashboard');
            } else {
                console.log("Login failed");
                // Handle login failure
            }
        } catch (error) {
            console.error("Login error:", error);
        }
    };

    return (
        <Container component="main" maxWidth="xs">
            <div style={{ marginTop: 8, display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                <Typography component="h1" variant="h5">
                    Sign in
                </Typography>
                <form style={{ width: '100%', marginTop: 1 }} onSubmit={handleSubmit}>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="email"
                        label="Email Address"
                        name="email"
                        autoComplete="email"
                        autoFocus
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        name="password"
                        label="Password"
                        type="password"
                        id="password"
                        autoComplete="current-password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        style={{ marginTop: 3, marginBottom: 2 }}
                    >
                        Sign In
                    </Button>
                </form>
            </div>
        </Container>
    );
};

export default Login;
