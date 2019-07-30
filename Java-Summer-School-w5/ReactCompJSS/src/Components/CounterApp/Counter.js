import React, { useState } from "react";

const Counter = props => {
    const [counter, setCounter] = useState(0);

    const counterClickHandler = () => {
        setCounter(counter + 1);
    };

    return (
        <div>
            <h1>{counter}</h1>
            <button className="button" onClick={counterClickHandler}>
                Increment Counter
            </button>
        </div>
    );
};

export default Counter;
