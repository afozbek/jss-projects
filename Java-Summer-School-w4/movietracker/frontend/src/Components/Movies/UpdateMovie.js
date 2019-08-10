import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";
import Logout from "../Auth/Logout/Logout";
import Loading from "../../Util/Loading";

export default class UpdateMovie extends Component {
    state = {
        movieData: {},
        directorData: [],
        loading: true,
        message: "",
        genreTypes: [
            { id: 1, value: "COMEDY" },
            { id: 2, value: "ACTION" },
            { id: 3, value: "DRAMA" }
        ],
        input: {
            name: "",
            genreType: "",
            directorId: ""
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
                const movieData = res.data;
                const directorId = res.data.director.directorId;

                console.log(movieData);

                axios
                    .get(`/admin/director`, {
                        headers: {
                            Authorization: `Bearer ${jwttoken}`
                        }
                    })
                    .then(res => {
                        const directors = res.data;

                        this.setState(prevState => ({
                            ...prevState,
                            movieData: movieData,
                            directorId: directorId,
                            loading: false,
                            directorData: directors,
                            input: {
                                ...prevState.input,
                                directorId: res.data[0].directorId,
                                genreType: movieData.genreType
                            }
                        }));
                    })
                    .catch(err => {
                        console.log(err);
                        this.setState({
                            loading: false
                        });
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

        const movieId = this.props.match.params.movieId;

        const { name, genreType, directorId } = this.state.input;

        axios
            .put(
                `/admin/movie/${movieId}`,
                {
                    name,
                    genreType,
                    director: { directorId }
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

                alert("Successfully updated 😊");

                this.props.history.push("/movies");
            })
            .catch(err => {
                console.log(err);
                this.setState({ loading: false });
            });
    };

    render() {
        const directors = this.state.loading ? (
            <Loading />
        ) : this.state.directorData ? (
            this.state.directorData.map(director => (
                <option key={director.directorId} value={director.directorId}>
                    {director.name}
                </option>
            ))
        ) : null;

        const genreTypes = this.state.genreTypes.map(genre => (
            <option key={genre.id} value={genre.value}>
                {genre.value}
            </option>
        ));

        const form = (
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
                            <span className="form-label-text">Director:</span>
                            <select
                                onChange={this.dropDownChangeHandler}
                                name="directorId"
                            >
                                {directors}
                            </select>
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
                <Link to="/movies">To Movies</Link>
                <Link to="/">Home Page</Link>
                {content}
            </Fragment>
        );
    }
}
