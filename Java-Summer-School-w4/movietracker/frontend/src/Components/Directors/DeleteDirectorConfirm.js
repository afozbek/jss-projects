import React, { Component } from "react";

import axios from "../../axios-instance";
import Loading from "../../Util/Loading";

export default class DeleteMovieConfirm extends Component {
    state = { directorData: {} };

    confirmButtonHandler = e => {
        const directorId = this.props.match.params.directorId;
        this.props.history.push(`/delete-director/${directorId}`);
    };

    cancelButtonHandler = e => {
        this.props.history.goBack();
    };

    componentDidMount() {
        const jwtToken = localStorage.getItem("jwttoken");
        if (!jwtToken) {
            this.props.history.push("/login");
        }

        const directorId = this.props.match.params.directorId;
        axios
            .get("/admin/director/" + directorId, {
                headers: { Authorization: "Bearer " + jwtToken }
            })
            .then(res => {
                console.log(res.data);
                this.setState({
                    directorData: res.data
                });
            })
            .catch(err => {
                console.log(err);
            });
    }

    render() {
        const content = this.state.loading ? (
            <Loading />
        ) : (
            <span>{this.state.directorData.name}</span>
        );
        return (
            <React.Fragment>
                <h1>
                    Are you sure you want to delete director:
                    {content}
                </h1>
                <button className="button" onClick={this.confirmButtonHandler}>
                    HELL YEAH!
                </button>
                <button className="button" onClick={this.cancelButtonHandler}>
                    NEVER MIND
                </button>
            </React.Fragment>
        );
    }
}
