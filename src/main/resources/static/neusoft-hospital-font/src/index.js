import React from 'react';
import { createRoot } from 'react-dom/client';
import App from './App'; // Import your main App component

document.addEventListener('DOMContentLoaded', () => {
    createRoot(document.getElementById('root')).render(<App />);
});
