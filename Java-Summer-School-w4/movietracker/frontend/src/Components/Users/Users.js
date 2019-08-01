import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "../../axios-instance";

import User from "./User";
import Loading from "../../Util/Loading";

export default class Users extends Component {
    state = {
        users: [],
        loading: true
    };

    componentDidMount() {
        const jwttoken = localStorage.getItem("jwttoken");

        if (!jwttoken) {
            this.props.history.push("/login");
        }

        axios
            .get("/admin/user", {
                headers: { Authorization: "Bearer " + jwttoken }
            })
            .then(res => {
                console.log(res.data);

                this.setState({ users: res.data, loading: false });
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
        const users = this.state.users.map(user => {
            return <User key={user.userId} userData={user} />;
        });

        const usersTable = (
            <table>
                <thead>
                    <tr>
                        <th style={{ textAlign: "center" }}>ID</th>
                        <th style={{ textAlign: "center" }}>Username</th>
                        <th style={{ textAlign: "center" }}>Name</th>
                        <th style={{ textAlign: "center" }}>Operation</th>
                    </tr>
                </thead>

                <tbody>{users}</tbody>
            </table>
        );

        const content = this.state.loading ? <Loading /> : usersTable;

        return (
            <div>
                <h1>Your Users</h1>
                <div>{content}</div>
                <Link to="/" style={{ marginTop: 30 }}>
                    Home Page
                </Link>
            </div>
        );
    }
}
