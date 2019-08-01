import React, { useState } from "react";

const LoginFormHook = props => {
    const [message, setMessage] = useState("");
    const [input, setInput] = useState({ username: "", password: "" });

    const inputChangeHandler = e => {
        let inputName = e.target.name;
        let value = e.target.value;
    };

    const formSubmitHandler = e => {
        e.preventDefault();
        const { username, password } = input;

        if (username === "admin" && password === "admin") {
            setMessage("WELCOME " + input.username + " 😊");
        } else {
            this.setState({ message: "Username or Password Wrong 😢" });
        }
    };
    return (
        <form onSubmit={formSubmitHandler}>
            <div className="inner-container">
                <h1 className="header">Login Form</h1>
                <div className="form-input">
                    <label htmlFor="username" className="form-label">
                        <span className="form-label-text">Username: </span>
                        <input
                            onChange={inputChangeHandler}
                            className="form-text form-label-input"
                            placeholder="Enter Your username"
                            id="username"
                            type="text"
                            name="username"
                            required
                        />
                    </label>
                </div>
                <div className="form-input">
                    <label htmlFor="password" className="form-label">
                        <span className="form-label-text">Password: </span>
                        <input
                            onChange={inputChangeHandler}
                            placeholder="Enter your password"
                            className="form-text"
                            id="password"
                            type="password"
                            name="password"
                            required
                        />
                    </label>
                </div>
                <h3>{message}</h3>
                <input className="button" type="submit" value="LOGIN" />
            </div>
        </form>
    );
};

export default LoginFormHook;
