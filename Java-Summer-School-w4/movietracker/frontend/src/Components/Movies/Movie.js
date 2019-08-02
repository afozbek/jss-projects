import React, { Component } from "react";

import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEdit, faTrash, faStar } from "@fortawesome/free-solid-svg-icons";
import axios from "../../axios-instance";

class Movie extends Component {
    state = {
        userId: "",
        movieId: "",
        favList: {},
        watchList: {},
        name: "",
        genreType: "",
        rating: "",
        director: ""
    };
    watchButtonClickHandler = e => {
        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        axios
            .post(
                `/${this.state.userId}/watchList/${this.state.movieId}`,
                null,
                {
                    headers: { Authorization: "Bearer " + jwttoken }
                }
            )
            .then(res => {
                this.setState({
                    watchList: res.data
                });

                this.props.history.push("/watchlist");
            })
            .catch(err => {
                console.log(err);
            });
    };

    favButtonClickHandler = e => {
        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        axios
            .post(`/${this.state.userId}/favList/${this.state.movieId}`, null, {
                headers: { Authorization: "Bearer " + jwttoken }
            })
            .then(res => {
                this.setState({
                    favList: res.data
                });

                this.props.history.push("/favlist");
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

        const {
            movieId,
            name,
            genreType,
            rating,
            director
        } = this.props.movieData;

        const username = localStorage.getItem("username");

        axios
            .get("/admin/user/" + username, {
                headers: { Authorization: "Bearer " + jwttoken }
            })
            .then(res => {
                console.log(res.data);

                this.setState({
                    movieId,
                    name,
                    genreType,
                    rating,
                    director,
                    userId: res.data.userId
                });
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        const {
            movieId,
            name,
            genreType,
            rating,
            director
        } = this.props.movieData;

        return (
            <tr>
                <td>
                    <span
                        style={{ cursor: "pointer" }}
                        onClick={
                            this.props.isFav
                                ? () =>
                                      this.props.favRemoveButtonHandler(
                                          this.state.movieId
                                      )
                                : this.favButtonClickHandler
                        }
                    >
                        <FontAwesomeIcon icon={faStar} />
                    </span>
                </td>
                <td>
                    <span
                        style={{ cursor: "pointer" }}
                        onClick={
                            this.props.isWatch
                                ? () =>
                                      this.props.watchRemoveButtonHandler(
                                          this.state.movieId
                                      )
                                : this.watchButtonClickHandler
                        }
                    >
                        <FontAwesomeIcon icon={faStar} />
                    </span>
                </td>
                <td>{movieId}</td>
                <td>{name}</td>
                <td>{genreType}</td>
                <td>{rating}</td>
                <td>{director.name}</td>
                <td>
                    <Link to={`/update-movie/${movieId}`}>
                        <FontAwesomeIcon icon={faEdit} />
                    </Link>
                </td>
                <td>
                    <Link to={`/delete-movie-confirm/${movieId}`}>
                        <FontAwesomeIcon icon={faTrash} />
                    </Link>
                </td>
            </tr>
        );
    }
}

export default Movie;
