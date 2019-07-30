import React, { useState, useEffect } from "react";

const Input = props => {
    const [input, setInput] = useState("Please Type something below");
    const [width, setWidth] = useState(window.innerWidth);

    useEffect(() => {
        const handleResize = () => setWidth(window.innerWidth);
        window.addEventListener("resize", handleResize);
        return () => window.removeEventListener("resize", handleResize);
    }, [width]);

    const inputChangeHandler = e => {
        let value = e.target.value;

        if (value === "") {
            setInput("Please Type something below");
        } else {
            setInput(value);
        }
    };

    return (
        <div>
            <h1>Window inner width: {width}</h1>
            <p style={{ marginTop: 25 }}>{input}</p>
            <input
                className="form-text"
                type="text"
                onChange={inputChangeHandler}
            />
        </div>
    );
};

export default Input;
