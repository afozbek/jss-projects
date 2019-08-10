import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";
import Logout from "../Auth/Logout/Logout";
import Loading from "../../Util/Loading";
import { birthPlaces } from "./BirthPlaces";

export default class UpdateDirector extends Component {
    state = {
        directorData: {},
        birthPlaces,
        loading: true,
        message: "",
        input: {
            name: "",
            surname: "",
            birthPlace: birthPlaces[0].place,
            birthDate: ""
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

        const { name, surname, birthPlace, birthDate } = this.state.input;

        axios
            .put(
                `/admin/director/${directorId}`,
                { name, surname, birthPlace, birthDate },
                {
                    headers: {
                        Authorization: `Bearer ${jwttoken}`
                    }
                }
            )
            .then(res => {
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
        const birthPlaces = this.state.loading ? (
            <Loading />
        ) : this.state.birthPlaces ? (
            this.state.birthPlaces.map(birthPlace => (
                <option key={birthPlace.birthPlaceId} value={birthPlace.place}>
                    {birthPlace.place}
                </option>
            ))
        ) : null;

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
                            <select
                                onChange={this.dropDownChangeHandler}
                                name="birthPlace"
                            >
                                {birthPlaces}
                            </select>
                        </label>
                    </div>

                    <div className="form-input">
                        <label htmlFor="birthDate" className="form-label">
                            <span className="form-label-text">Birth Date:</span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text"
                                id="birthDate"
                                type="date"
                                name="birthDate"
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
