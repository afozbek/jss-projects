import React, { Component, Fragment } from "react";
import { Link } from "react-router-dom";
import axios from "../../axios-instance";

import Movie from "./Movie";
import Loading from "../../Util/Loading";
import Logout from "../Auth/Logout/Logout";

export default class Movies extends Component {
    state = {
        movies: [],
        loading: true
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
                console.log(res.data);

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
            return <Movie key={movie.movieId} movieData={movie} />;
        });

        const movieTable = (
            <table>
                <thead>
                    <tr>
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

        const content = this.state.loading ? <Loading /> : movieTable;

        const body =
            this.state.movies.length < 1 ? (
                <h1>You don't have any directors</h1>
            ) : (
                content
            );

        return (
            <Fragment>
                <Logout {...this.props} />
                <Link to="/add-movie">ADD A MOVIE</Link>
                <div>
                    <h1>Your Movies</h1>
                    <div>{body}</div>
                    <Link to="/" style={{ marginTop: 30 }}>
                        Home Page
                    </Link>
                </div>
            </Fragment>
        );
    }
}
