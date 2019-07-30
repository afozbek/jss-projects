import { Link } from "react-router-dom";
import React from "react";

const Home = props => {
    return (
        <ul>
            <li>
                <Link to="/">Home</Link>
            </li>
            <li>
                <Link to="/register">Register</Link>
            </li>
            <li>
                <Link to="/counter">Count with Counter: default</Link>
            </li>
            <li>
                <Link to="/counter/5">Count with Counter: 5</Link>
            </li>
        </ul>
    );
};

export default Home;
