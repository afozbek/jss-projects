import React, { Component } from "react";

export default class Counter extends Component {
    state = {
        value: 0,
        message: "INITIAL MESSAGE"
    };

    componentDidMount() {
        this.setState((prevState, props) => {
            return { message: prevState.message + "!" };
        });
        this.setState((prevState, props) => {
            return { message: prevState.message + "!" };
        });
        this.setState((prevState, props) => {
            return { message: prevState.message + "!" };
        });
    }

    render() {
        return (
            <div style={{ fontSize: 16 }}>
                <div>message: {this.state.message}</div>
            </div>
        );
    }
}
