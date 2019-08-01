import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import axios from "../../axios-instance";

export default class DeleteUser extends Component {
    state = {
        message: ""
    };

    componentDidMount() {
        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        const userId = this.props.match.params.userId;

        axios
            .delete(`/admin/user/${userId}`, {
                headers: {
                    Authorization: `Bearer ${jwttoken}`
                }
            })
            .then(res => {
                console.log(res.data);

                this.setState({
                    message: res.data.message
                });

                this.props.history.push("/users");
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <Fragment>
                <Link to="/users">To Users</Link>
                <Link to="/">Home Page</Link>

                <h1>{this.state.message}</h1>
            </Fragment>
        );
    }
}
