import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";
import Logout from "../Auth/Logout/Logout";

export default class AddMovie extends Component {
    state = {
        directorData: [],
        message: "",
        genreTypes: [
            { id: 1, value: "COMEDY" },
            { id: 2, value: "ACTION" },
            { id: 3, value: "DRAMA" }
        ],
        input: {
            name: "",
            genreType: "COMEDY",
            directorId: "1"
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
                    directorData: res.data
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

        const { name, genreType, directorId } = this.state.input;

        axios
            .post(
                `/admin/movie`,
                {
                    name,
                    genreType,
                    director: { directorId: directorId }
                },
                {
                    headers: {
                        Authorization: `Bearer ${jwttoken}`
                    }
                }
            )
            .then(res => {
                this.setState({
                    movieData: res.data
                });

                this.props.history.push("/movies");
            })
            .catch(err => {
                console.log(err);
            });
    };

    render() {
        if (this.state.directorData.length < 1) {
            this.props.history.push("/must-add-director");
        }

        const directors = this.state.directorData.map(director => (
            <option key={director.directorId} value={director.directorId}>
                {director.name}
            </option>
        ));

        const genreTypes = this.state.genreTypes.map(genre => (
            <option key={genre.id} value={genre.value}>
                {genre.value}
            </option>
        ));

        return (
            <Fragment>
                <Logout {...this.props} />
                <Link to="/movies">To Movies</Link>
                <Link to="/">Home Page</Link>

                <form onSubmit={this.formSubmitHandler}>
                    <div className="inner-container">
                        <div className="form-input">
                            <label htmlFor="name" className="form-label">
                                <span className="form-label-text">
                                    Movie Name:
                                </span>
                                <input
                                    onChange={this.inputChangeHandler}
                                    className="form-text form-label-input"
                                    placeholder="Enter Movie Name"
                                    id="name"
                                    type="text"
                                    name="name"
                                    required
                                />
                            </label>
                        </div>

                        <div className="form-input">
                            <label htmlFor="genreType" className="form-label">
                                <span className="form-label-text">
                                    Movie Genre:
                                </span>
                                <select
                                    onChange={this.dropDownChangeHandler}
                                    name="genreType"
                                >
                                    {genreTypes}
                                </select>
                            </label>
                        </div>

                        <div className="form-input">
                            <label htmlFor="director" className="form-label">
                                <span className="form-label-text">
                                    Director:
                                </span>
                                <select
                                    onChange={this.dropDownChangeHandler}
                                    name="directorId"
                                >
                                    {directors}
                                </select>
                            </label>
                        </div>

                        <h3>{this.state.message}</h3>
                        <input
                            className="button"
                            type="submit"
                            value="ADD MOVIE"
                        />
                    </div>
                </form>
            </Fragment>
        );
    }
}
