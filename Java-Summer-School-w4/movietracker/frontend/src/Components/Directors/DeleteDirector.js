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

        const directorId = this.props.match.params.directorId;

        axios
            .delete(`/admin/director/${directorId}`, {
                headers: {
                    Authorization: `Bearer ${jwttoken}`
                }
            })
            .then(res => {
                console.log(res.data);
                this.setState({ message: res.data });

                this.props.history.push("/directors");
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <Fragment>
                <Link to="/directors">To Directors</Link>
                <Link to="/">Home Page</Link>

                <h1>Successfully deleted</h1>
            </Fragment>
        );
    }
}
