import React, { useState } from 'react';
import { Modal, Typography, TextField, Button, Container } from '@mui/material';

const AddWeightModal = ({ open, onClose, onAddWeight }) => {
    const [measure, setMeasure] = useState('');
    const [localDate, setLocalDate] = useState('');

    const handleSubmit = () => {
        // Create weight object
        const weightData = {
            measure: measure,
            localDate: localDate,
        };
        // Call onAddWeight with weight data
        onAddWeight(weightData);
        // Close the modal
        onClose();
    };

    return (
        <Modal open={open} onClose={onClose}>
            <Container maxWidth="sm" style={{ backgroundColor: 'white', padding: '20px', borderRadius: '5px' }}>
                <Typography variant="h6" gutterBottom>
                    Add Weight
                </Typography>
                <TextField
                    fullWidth
                    label="Weight"
                    variant="outlined"
                    value={measure}
                    onChange={(e) => setMeasure(e.target.value)}
                    style={{ marginBottom: '10px' }}
                />
                <TextField
                    fullWidth
                    label="Date"
                    type="date"
                    variant="outlined"
                    value={localDate}
                    onChange={(e) => setLocalDate(e.target.value)}
                    style={{ marginBottom: '10px' }}
                />
                <Button variant="contained" color="primary" onClick={handleSubmit}>
                    Add
                </Button>
            </Container>
        </Modal>
    );
};

export default AddWeightModal;
