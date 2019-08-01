import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";

export default class UpdateUser extends Component {
    state = {
        userData: {},
        message: "",
        input: {
            username: "",
            name: "",
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

    componentDidMount() {
        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        const username = this.props.match.params.username;

        axios
            .get(`/admin/user/${username}`, {
                headers: {
                    Authorization: `Bearer ${jwttoken}`
                }
            })
            .then(res => {
                this.setState({
                    userData: res.data
                });
            })
            .catch(err => {
                console.log(err);
            });
    }

    formSubmitHandler = e => {
        e.preventDefault();

        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        const paramUsername = this.props.match.params.username;

        const { username, password, firstName } = this.state.input;

        axios
            .put(
                `/admin/user/${paramUsername}`,
                { username, password, firstName },
                {
                    headers: {
                        Authorization: `Bearer ${jwttoken}`
                    }
                }
            )
            .then(res => {
                console.log(res.data);
            })
            .catch(err => {
                console.log(err);
            });
    };

    render() {
        return (
            <Fragment>
                <Link to="/register">To Register</Link>
                <Link to="/users">See Users</Link>

                <form onSubmit={this.formSubmitHandler}>
                    <div className="inner-container">
                        <h1 className="header">
                            Update User: {this.state.userData.username}
                        </h1>
                        <div className="form-input">
                            <label htmlFor="username" className="form-label">
                                <span className="form-label-text">
                                    Username:
                                </span>
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
                            <label htmlFor="name" className="form-label">
                                <span className="form-label-text">Name:</span>
                                <input
                                    onChange={this.inputChangeHandler}
                                    className="form-text form-label-input"
                                    placeholder="Enter Your Name"
                                    id="name"
                                    type="text"
                                    name="name"
                                />
                            </label>
                        </div>
                        <div className="form-input">
                            <label htmlFor="password" className="form-label">
                                <span className="form-label-text">
                                    Password:
                                </span>
                                <input
                                    onChange={this.inputChangeHandler}
                                    placeholder="Enter your Password"
                                    className="form-text"
                                    id="password"
                                    type="text"
                                    name="password"
                                    required
                                />
                            </label>
                        </div>
                        <h3>{this.state.message}</h3>
                        <input
                            className="button"
                            type="submit"
                            value="UPDATE"
                        />
                    </div>
                </form>
            </Fragment>
        );
    }
}
