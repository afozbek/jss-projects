import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";
import Logout from "../Auth/Logout/Logout";
import Loading from "../../Util/Loading";

export default class UpdateDirector extends Component {
    state = {
        directorData: {},
        loading: true,
        message: "",
        input: {
            name: "",
            surname: "",
            birthPlace: ""
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

        const directorId = this.props.match.params.directorId;

        axios
            .get(`/admin/director/${directorId}`, {
                headers: {
                    Authorization: `Bearer ${jwttoken}`
                }
            })
            .then(res => {
                this.setState({
                    directorData: res.data,
                    loading: false
                });
            })
            .catch(err => {
                console.log(err);
                this.setState({ loading: false });
            });
    }

    formSubmitHandler = e => {
        e.preventDefault();

        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        const directorId = this.props.match.params.directorId;

        const { name, surname, birthPlace } = this.state.input;

        axios
            .put(
                `/admin/director/${directorId}`,
                { name, surname, birthPlace },
                {
                    headers: {
                        Authorization: `Bearer ${jwttoken}`
                    }
                }
            )
            .then(res => {
                console.log(res.data);
                this.setState({ directorData: res.data, loading: false });

                alert("Successfully updated 😊");

                this.props.history.push("/directors");
            })
            .catch(err => {
                console.log(err);
                this.setState({ loading: false });
            });
    };

    render() {
        const form = (
            <form onSubmit={this.formSubmitHandler}>
                <div className="inner-container">
                    <h1 className="header">
                        Update Director: {this.state.directorData.name}
                    </h1>
                    <div className="form-input">
                        <label htmlFor="name" className="form-label">
                            <span className="form-label-text">Name:</span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text form-label-input"
                                placeholder="Enter Director Name"
                                id="name"
                                type="text"
                                name="name"
                                required
                            />
                        </label>
                    </div>
                    <div className="form-input">
                        <label htmlFor="surname" className="form-label">
                            <span className="form-label-text">Surname:</span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text form-label-input"
                                placeholder="Enter Director Surname"
                                id="surname"
                                type="text"
                                name="surname"
                            />
                        </label>
                    </div>
                    <div className="form-input">
                        <label htmlFor="birthPlace" className="form-label">
                            <span className="form-label-text">
                                Birth Place:
                            </span>
                            <input
                                onChange={this.inputChangeHandler}
                                placeholder="Enter Director's Birth Place"
                                className="form-text"
                                id="birthPlace"
                                type="text"
                                name="birthPlace"
                                required
                            />
                        </label>
                    </div>
                    <h3>{this.state.message}</h3>
                    <input className="button" type="submit" value="UPDATE" />
                </div>
            </form>
        );

        const content = this.state.loading ? <Loading /> : form;
        return (
            <Fragment>
                <Logout {...this.props} />
                <Link to="/directors">See Directors</Link>
                <Link to="/">Home Page</Link>
                {content}
            </Fragment>
        );
    }
}
