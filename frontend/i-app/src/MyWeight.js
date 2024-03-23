import React, { useState, useEffect } from 'react';
import { Container, Typography, Button } from '@mui/material';
import AddWeightModal from './AddWeightModal';
import { DataGrid } from '@mui/x-data-grid';
import { LineChart } from '@mui/x-charts/LineChart';

const MyWeight = () => {
    const [openModal, setOpenModal] = useState(false);
    const [weights, setWeights] = useState([]);
    const [chartData, setChartData] = useState({ xAxis: [{ data: [] }], series: [{ data: [] }] });

    useEffect(() => {
        fetchWeights();
    }, []);

    const fetchWeights = async () => {
        try {
            const token = localStorage.getItem('jwtToken');
            const response = await fetch('http://localhost:8080/weights', {
                method: 'GET',
                headers: {
                    'Authorization': `Bearer ${token}`,
                },
            });

            if (response.ok) {
                const data = await response.json();
                setWeights(data);

                // Transform weights data for chart
                const xAxisData = data.map(weight => formatDate(weight.localDate)); // Format date
                const seriesData = data.map(weight => weight.measure);
                console.log('xAxisData:', xAxisData);
                console.log('seriesData:', seriesData);
                setChartData({ xAxis: [{ data: xAxisData }], series: [{ data: seriesData }] });
            } else {
                console.error('Failed to fetch weights');
            }
        } catch (error) {
            console.error('Error fetching weights:', error);
        }
    };

    const formatDate = (dateString) => {
        console.log('date -> ' + dateString);
        const dateParts = dateString.split('-');
        console.log('date -> ' + dateParts[2]);
        return dateParts[2];
        //return `${dateParts[1]}/${dateParts[2]}/${dateParts[0]}`; // Assuming format mm/dd/yyyy
    };

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

                // Fetch weights again to update chart data
                fetchWeights();
            } else {
                console.error('Failed to add weight');
                // Handle failure
            }
        } catch (error) {
            console.error('Error adding weight:', error);
        }
        setOpenModal(false); // Close the modal after adding weight
    };

    const columns = [
        { field: 'id', headerName: 'ID', width: 100 },
        { field: 'measure', headerName: 'Measure', width: 150 },
        { field: 'localDate', headerName: 'Date', width: 200 },
    ];

    const rows = weights.map((weight, index) => ({
        id: index,
        measure: weight.measure,
        localDate: weight.localDate,
    }));

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
            <Typography variant="h6" component="h2" gutterBottom>
                Your Weights:
            </Typography>
            <div style={{ height: 400, width: '100%' }}>
                <DataGrid rows={rows} columns={columns} pageSize={5} />
            </div>
            <Typography variant="h6" component="h2" gutterBottom>
                Chart:
            </Typography>
            <LineChart {...chartData} width={500} height={300} />
        </Container>
    );
};

export default MyWeight;
