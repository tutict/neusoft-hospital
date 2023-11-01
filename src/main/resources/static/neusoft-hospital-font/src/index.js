import React from 'react';
import { createRoot } from 'react-dom/client';
import App from './App'; // Import your main App component

// Ensure you have a div with id 'root' in your index.html
const container = document.getElementById('root');
const root = createRoot(container); // Create a root for the container

root.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>
);
