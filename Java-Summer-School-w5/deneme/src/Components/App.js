import React, { useState, useEffect } from "react";

import ShoppingApp from "./ShoppingApp/ShoppingApp";
import "./App.css";

const App = props => {
    return (
        <div className="inner-container">
            <ShoppingApp project="ShoppingApp" />

            <button className="button" onClick={() => setLength(Math.random())}>
                CLICK ME
            </button>
        </div>
    );
};

export default App;
