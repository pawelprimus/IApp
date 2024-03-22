import React, { useState } from 'react';
import { Container, Typography, Button } from '@mui/material';
import AddWeightModal from './AddWeightModal';

const MyWeight = () => {
    const [openModal, setOpenModal] = useState(false);

    const handleAddWeight = async (weightData) => {
        try {
            const token = localStorage.getItem('jwtToken');
            const response = await fetch('http://localhost:8080/weights', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`,
                },
                body: JSON.stringify(weightData),
            });

            if (response.ok) {
                const result = await response.json();
                console.log('Weight added successfully:', result);
                // You can add additional logic here, such as updating the UI with the new weight data
            } else {
                console.error('Failed to add weight');
                // Handle failure
            }
        } catch (error) {
            console.error('Error adding weight:', error);
        }
        setOpenModal(false); // Close the modal after adding weight
    };

    return (
        <Container component="main" maxWidth="md">
            <Typography variant="h4" component="h1" gutterBottom>
                My Weight Page
            </Typography>
            <Typography paragraph>
                This is the page where you can view and manage your weight data.
            </Typography>
            <Button variant="contained" color="primary" onClick={() => setOpenModal(true)}>
                Add Weight
            </Button>
            <AddWeightModal open={openModal} onClose={() => setOpenModal(false)} onAddWeight={handleAddWeight} />
        </Container>
    );
};

export default MyWeight;
