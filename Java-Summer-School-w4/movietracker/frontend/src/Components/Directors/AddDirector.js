import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";
import Logout from "../Auth/Logout/Logout";
import Loading from "../../Util/Loading";

export default class AddMovie extends Component {
    state = {
        directorData: [],
        loading: true,
        message: "",
        birthPlaces: [
            { id: 1, value: "ISTANBUL" },
            { id: 2, value: "ANKARA" },
            { id: 3, value: "IZMIR" },
            { id: 4, value: "KASTAMONU" }
        ],
        input: {
            name: "",
            surname: "",
            birthPlace: "ISTANBUL"
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
            directorId: "",
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

        axios
            .get(`/admin/director`, {
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

                this.setState({
                    loading: false
                });
            });
    }

    formSubmitHandler = e => {
        e.preventDefault();

        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        const { name, surname, birthPlace } = this.state.input;

        axios
            .post(
                `/admin/director`,
                {
                    name,
                    surname,
                    birthPlace
                },
                {
                    headers: {
                        Authorization: `Bearer ${jwttoken}`
                    }
                }
            )
            .then(res => {
                this.setState({
                    movieData: res.data,
                    loading: false
                });

                alert("Successfully created 😊");

                this.props.history.push("/directors");
            })
            .catch(err => {
                console.log(err);

                this.setState({
                    loading: false
                });
            });
    };

    render() {
        const birthPlaces = this.state.birthPlaces.map(place => (
            <option key={place.id} value={place.value}>
                {place.value}
            </option>
        ));

        const form = (
            <form onSubmit={this.formSubmitHandler}>
                <div className="inner-container">
                    <div className="form-input">
                        <label htmlFor="name" className="form-label">
                            <span className="form-label-text">Name:</span>
                            <input
                                onChange={this.inputChangeHandler}
                                className="form-text form-label-input"
                                placeholder="Enter Director's Name"
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
                                placeholder="Enter Director's Surname"
                                id="surname"
                                type="text"
                                name="surname"
                                required
                            />
                        </label>
                    </div>

                    <div className="form-input">
                        <label htmlFor="director" className="form-label">
                            <span className="form-label-text">BirthPlace:</span>
                            <select
                                onChange={this.dropDownChangeHandler}
                                name="birthPlace"
                            >
                                {birthPlaces}
                            </select>
                        </label>
                    </div>

                    <h3>{this.state.message}</h3>
                    <input
                        className="button"
                        type="submit"
                        value="ADD DIRECTOR"
                    />
                </div>
            </form>
        );

        const content = this.state.loading ? <Loading /> : form;

        return (
            <Fragment>
                <Logout {...this.props} />
                <Link to="/directors">To Directors</Link>
                <Link to="/">Home Page</Link>
                {content}
            </Fragment>
        );
    }
}
