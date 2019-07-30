import React, { useState } from "react";
import { Link } from "react-router-dom";
const Counter = props => {
    const { count } = props.match.params;

    const [counter, setCounter] = useState(count ? +count : 0);

    const counterClickHandler = () => {
        setCounter(counter + 1);
    };

    return (
        <div>
            <Link to="/">Home Page</Link>
            <h1>{counter}</h1>
            <button className="button" onClick={counterClickHandler}>
                Increment Counter
            </button>
        </div>
    );
};

export default Counter;
