import React from "react";

import "./App.css";
import AppRouter from "../AppRouter";

const App = props => {
    return (
        <div className="table-app">
            <AppRouter />
        </div>
    );
};

export default App;
