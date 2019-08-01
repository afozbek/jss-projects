import React, { Component, Fragment } from "react";
import { Link } from "react-router-dom";
import axios from "../../axios-instance";

import Movie from "./Movie";
import Loading from "../../Util/Loading";
import Logout from "../Auth/Logout/Logout";

export default class Movies extends Component {
    state = {
        movies: [],
        loading: true,
        input: {
            search: ""
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

    searchButtonHandler = e => {
        const jwttoken = localStorage.getItem("jwttoken");

        axios
            .get("/movies", {
                params: { movie: this.state.input.search },
                headers: { Authorization: "Bearer " + jwttoken }
            })
            .then(res => {
                console.log(res.data);
                this.setState({
                    movies: res.data
                });
            })
            .catch(err => {
                console.log(err);
            });
    };

    componentDidMount() {
        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        axios
            .get("/movies", {
                headers: { Authorization: "Bearer " + jwttoken }
            })
            .then(res => {
                this.setState({ movies: res.data, loading: false });
            })
            .catch(err => {
                console.log(err);
                this.setState({
                    err,
                    loading: false
                });
            });
    }

    render() {
        const movies = this.state.movies.map(movie => {
            return (
                <Movie {...this.props} key={movie.movieId} movieData={movie} />
            );
        });

        const movieTable = (
            <table>
                <thead>
                    <tr>
                        <th style={{ textAlign: "center" }}>ADD TO FAV LIST</th>
                        <th style={{ textAlign: "center" }}>ID</th>
                        <th style={{ textAlign: "center" }}>Movie Name</th>
                        <th style={{ textAlign: "center" }}>Genre</th>
                        <th style={{ textAlign: "center" }}>IMDB Rating</th>
                        <th style={{ textAlign: "center" }}>Director</th>
                        <th style={{ textAlign: "center" }}>Update</th>
                        <th style={{ textAlign: "center" }}>Delete</th>
                    </tr>
                </thead>

                <tbody>{movies}</tbody>
            </table>
        );

        const content = this.state.loading ? (
            <Loading />
        ) : (
            <div>
                <h1>Your Movies</h1>
                <div>{movieTable}</div>
                <Link to="/" style={{ marginTop: 30 }}>
                    Home Page
                </Link>
            </div>
        );

        // MOVIE YOKSA MESAJ VER

        return (
            <Fragment>
                <Logout {...this.props} />
                <div className="search">
                    <div className="form-input">
                        <label htmlFor="search" className="form-label">
                            <input
                                onChange={this.inputChangeHandler}
                                placeholder="Search..."
                                className="form-text"
                                id="search"
                                type="text"
                                name="search"
                            />
                        </label>
                    </div>
                    <button
                        className="button"
                        onClick={this.searchButtonHandler}
                    >
                        SEARCH
                    </button>
                </div>
                <Link to="/add-movie">ADD A MOVIE</Link>
                {content}
            </Fragment>
        );
    }
}
