import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

import User from "./User";

export default class Users extends Component {
    state = {
        users: []
    };

    componentDidMount() {
        axios
            .get("http://localhost:8080/admin/user")
            .then(res => {
                console.log(res.data);
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        return (
            <div>
                <h1>Your Users</h1>
                <div>
                    <table>
                        <thead>
                            <th style={{ textAlign: "center" }}>ID</th>
                            <th style={{ textAlign: "center" }}>Name</th>
                            <th style={{ textAlign: "center" }}>Email</th>
                            <th style={{ textAlign: "center" }}>Phone</th>
                            <th style={{ textAlign: "center" }}>Operation</th>
                        </thead>

                        <tbody>
                            <User />
                        </tbody>
                    </table>
                </div>
                <Link to="/register" style={{ marginTop: 30 }}>
                    To add user
                </Link>
            </div>
        );
    }
}
