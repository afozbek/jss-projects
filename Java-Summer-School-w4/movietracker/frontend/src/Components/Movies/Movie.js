import React, { Component } from "react";

import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEdit, faTrash, faStar } from "@fortawesome/free-solid-svg-icons";
import axios from "../../axios-instance";

class Movie extends Component {
    state = {
        userId: "",
        movieId: "",
        name: "",
        genreType: "",
        rating: "",
        director: ""
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
                console.log(res.data);
                localStorage.setItem("favlist", res.data);

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
                        onClick={this.favButtonClickHandler}
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
