import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";

export default class UpdateMovie extends Component {
    state = {
        movieData: {},
        message: "",
        directorId: "",
        input: {
            name: "",
            genreType: "",
            director: ""
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

        const movieId = this.props.match.params.movieId;

        axios
            .get(`/admin/movie/${movieId}`, {
                headers: {
                    Authorization: `Bearer ${jwttoken}`
                }
            })
            .then(res => {
                console.table(res.data);
                this.setState({
                    movieData: res.data,
                    directorId: res.data.director.directorId
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

        const movieId = this.props.match.params.movieId;

        const { directorId } = this.state;
        const { name, genreType, director } = this.state.input;

        axios
            .put(
                `/admin/movie/${movieId}`,
                {
                    name,
                    genreType,
                    director: { directorId: directorId, name: director }
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
        return (
            <Fragment>
                <Link to="/movies">To Movies</Link>
                <Link to="/">Home Page</Link>

                <form onSubmit={this.formSubmitHandler}>
                    <div className="inner-container">
                        <h1 className="header">
                            Update Movie: {this.state.movieData.name}
                        </h1>
                        <div className="form-input">
                            <label htmlFor="name" className="form-label">
                                <span className="form-label-text">Name:</span>
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
                                <span className="form-label-text">Genre:</span>
                                <input
                                    onChange={this.inputChangeHandler}
                                    className="form-text form-label-input"
                                    placeholder="Enter Movie Genre Type"
                                    id="genreType"
                                    type="text"
                                    name="genreType"
                                />
                            </label>
                        </div>
                        <div className="form-input">
                            <label htmlFor="director" className="form-label">
                                <span className="form-label-text">
                                    Director:
                                </span>
                                <input
                                    onChange={this.inputChangeHandler}
                                    placeholder="Enter your director name"
                                    className="form-text"
                                    id="director"
                                    type="text"
                                    name="director"
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
