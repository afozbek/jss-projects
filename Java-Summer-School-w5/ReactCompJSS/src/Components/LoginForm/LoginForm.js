import React, { Component } from "react";

class LoginForm extends Component {
    state = {
        message: "",
        input: {
            username: "",
            password: ""
        }
    };

    inputChangeHandler = e => {
        let inputName = e.target.name;
        let value = e.target.value;

        this.setState(prevState => ({
            ...prevState,
            input: {
                ...prevState.input,
                [inputName]: value
            }
        }));
    };

    formSubmitHandler = e => {
        e.preventDefault();
        const { username, password } = this.state.input;

        if (username === "admin" && password === "admin") {
            this.setState(prevState => ({
                message: "WELCOME " + prevState.input.username + " 😊"
            }));
        } else {
            this.setState({ message: "Username or Password Wrong 😢" });
        }
    };
    render() {
        return (
            <form onSubmit={this.formSubmitHandler}>
                <div className="inner-container">
                    <h1 className="header">Login Form</h1>
                    <div className="form-input">
                        <label htmlFor="username" className="form-label">
                            <span className="form-label-text">Username: </span>
                            <input
                                onChange={this.inputChangeHandler}
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
                                onChange={this.inputChangeHandler}
                                placeholder="Enter your password"
                                className="form-text"
                                id="password"
                                type="password"
                                name="password"
                                required
                            />
                        </label>
                    </div>
                    <h3>{this.state.message}</h3>
                    <input className="button" type="submit" value="LOGIN" />
                </div>
            </form>
        );
    }
}

export default LoginForm;
