import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Container, Typography, TextField, Button } from '@mui/material';

const Register = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const navigate = useNavigate();

    const handleRegisterSubmit = async (e) => {
        e.preventDefault();
        const registerData = { username, password };

        try {
            const response = await fetch('http://localhost:8080/api/v1/auth/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(registerData),
            });

            if (response.ok) {
                console.log("Registration successful");
                navigate('/login'); // Redirect to login page after successful registration
            } else {
                const responseData = await response.json();
                if (response.status === 400 && responseData.error === "User with given username already exists!") {
                    setErrorMessage(responseData.error);
                } else {
                    console.log("Registration failed");
                    // Handle other registration failures
                }
            }
        } catch (error) {
            console.error("Registration error:", error);
        }
    };

    return (
        <Container component="main" maxWidth="xs">
            <div style={{ marginTop: 8, display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
                <Typography component="h1" variant="h5">
                    Register
                </Typography>
                <form style={{ width: '100%', marginTop: 1 }} onSubmit={handleRegisterSubmit}>
                    <TextField
                        variant="outlined"
                        margin="normal"
                        required
                        fullWidth
                        id="username"
                        label="Username"
                        name="username"
                        autoComplete="username"
                        autoFocus
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
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
                        autoComplete="new-password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    {errorMessage && (
                        <Typography variant="body2" color="error" style={{ marginTop: 8 }}>
                            {errorMessage}
                        </Typography>
                    )}
                    <Button
                        type="submit"
                        fullWidth
                        variant="contained"
                        color="primary"
                        style={{ marginTop: 3, marginBottom: 2 }}
                    >
                        Register
                    </Button>
                </form>
            </div>
        </Container>
    );
};

export default Register;
