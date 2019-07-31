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
                <Link to="/login">Login</Link>
            </li>
            <li>
                <Link to="/users">Users</Link>
            </li>
            <li>
                <Link to="/movies">Movies</Link>
            </li>
            <li>
                <Link to="/directors">Directors</Link>
            </li>
        </ul>
    );
};

export default Home;
