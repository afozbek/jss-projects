import React from "react";

import "./App.css";
import TransportContainer from "./TransportApp/TransportContainer";
import TransportWelcome from "./TransportApp/TransportWelcome";

const App = props => {
    return (
        <div className="table-app">
            <TransportWelcome />
            <TransportContainer />
        </div>
    );
};

export default App;
