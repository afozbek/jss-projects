import React, { Component } from "react";

export default class RegisterForm extends Component {
    state = {
        message: "",
        input: {
            firstname: "",
            lastname: "",
            username: "",
            password: "",
            passwordAgain: "",
            sehir: "istanbul",
            sex: "male",
            confirm: false
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

    confirmChangeHandler = e => {
        let checked = e.target.checked;
        let name = e.target.name;

        this.setState(prevState => ({
            ...prevState,
            input: {
                ...prevState.input,
                [name]: checked
            }
        }));
    };

    radioButtonChangeHandler = e => {
        let checked = e.target.checked;
        let element = e.target;

        console.log(checked, element.value);

        if (checked) {
            this.setState(prevState => ({
                ...prevState,
                input: {
                    ...prevState.input,
                    sex: element.value
                }
            }));
        }
    };

    formSubmitHandler = e => {
        e.preventDefault();
        const { password, passwordAgain, confirm } = this.state.input;

        if (!confirm) {
            this.setState({ message: "You must confirm the form 😢" });
        } else if (password.length < 4) {
            this.setState({ message: "Please enter longer password" });
        } else if (password !== passwordAgain) {
            this.setState({ message: "Your passwords must match" });
        } else {
            this.setState({
                message: "Successfully registered to the system 😊"
            });
        }
    };

    dropDownChangeHandler = e => {
        let value = e.target.value;
        let name = e.target.name;

        this.setState(prevState => ({
            ...prevState,
            input: {
                ...prevState.input,
                [name]: value
            }
        }));
    };

    render() {
        return (
            <form className="form" onSubmit={this.formSubmitHandler}>
                <div className="inner-container">
                    <h1 className="header">Register Page</h1>
                    <div className="form-input">
                        <label htmlFor="username" className="form-label">
                            <span className="form-label-text">Firstname :</span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text form-label-input"
                                id="firstname"
                                type="text"
                                name="username"
                                required
                            />
                        </label>
                    </div>
                    <div className="form-input">
                        <label htmlFor="username" className="form-label">
                            <span className="form-label-text">Lastname:</span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text form-label-input"
                                id="lastname"
                                type="text"
                                name="username"
                                required
                            />
                        </label>
                    </div>
                    <div className="form-input">
                        <label htmlFor="username" className="form-label">
                            <span className="form-label-text">Username:</span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text form-label-input"
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
                                className="form-text"
                                id="password"
                                type="password"
                                name="password"
                                required
                            />
                        </label>
                    </div>
                    <div className="form-input">
                        <label htmlFor="passwordAgain" className="form-label">
                            <span className="form-label-text">
                                Password-Ag:
                            </span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text"
                                id="passwordAgain"
                                type="password"
                                name="passwordAgain"
                                required
                            />
                        </label>
                    </div>
                    <div className="form-input">
                        <label htmlFor="city" className="form-label">
                            <span className="form-label-text">City: </span>
                            <select
                                onChange={this.dropDownChangeHandler}
                                name="sehir"
                            >
                                <option value="istanbul">Istanbul</option>
                                <option value="ankara">Ankara</option>
                                <option value="izmir">Izmir</option>
                            </select>
                        </label>
                    </div>

                    <div className="form-input sex-util">
                        <label className="form-label">
                            <span className="form-label-text">Sex: </span>
                            <span className="sex-wrapper">
                                <label htmlFor="male" className="inline-label">
                                    <span className="form-label-radio">
                                        Male:{" "}
                                    </span>
                                    <input
                                        onChange={this.radioButtonChangeHandler}
                                        className="form-radio"
                                        id="male"
                                        type="radio"
                                        name="sex"
                                        value="male"
                                    />
                                </label>
                                <label
                                    htmlFor="female"
                                    className="inline-label"
                                >
                                    <span className="form-label-radio">
                                        Female:
                                    </span>
                                    <input
                                        onChange={this.radioButtonChangeHandler}
                                        className="form-radio"
                                        id="female"
                                        type="radio"
                                        value="female"
                                        name="sex"
                                    />
                                </label>
                            </span>
                        </label>
                    </div>
                    <div className="form-input">
                        <label htmlFor="confirm" className="form-label">
                            <span className="form-label-text">Confirm: </span>
                            <input
                                onChange={this.confirmChangeHandler}
                                className="form-text"
                                id="confirm"
                                type="checkbox"
                                name="confirm"
                            />
                        </label>
                    </div>

                    <h2>{this.state.message}</h2>
                    <input className="button" type="submit" value="REGISTER" />
                </div>
            </form>
        );
    }
}
