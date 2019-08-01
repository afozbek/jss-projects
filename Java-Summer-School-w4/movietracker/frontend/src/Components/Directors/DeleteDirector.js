import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";

export default class DeleteMovie extends Component {
    state = {
        message: ""
    };

    componentDidMount() {
        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        const movieId = this.props.match.params.movieId;

        axios
            .delete(`/admin/movie/${movieId}`, {
                headers: {
                    Authorization: `Bearer ${jwttoken}`
                }
            })
            .then(res => {
                console.log(res.data);
                this.setState({ message: res.data });

                this.props.history.push("/movies");
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <Fragment>
                <Link to="/movies">To Movies</Link>
                <Link to="/">Home Page</Link>

                <h1>Successfully deleted</h1>
            </Fragment>
        );
    }
}
