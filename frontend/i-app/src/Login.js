import React, { useState } from 'react';
import { Container, Typography, TextField, Button } from '@mui/material';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        const loginData = { username: email, password: password };

        try {
            const response = await fetch('http://localhost:8080/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams(loginData),
            });

            if (response.ok) {
                console.log("Login successful");
                // Redirect or manage login state as needed
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
            <div style={{ marginTop: 8, display: 'flex', flexDirection: 'column', alignItems: 'center', }}>
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
