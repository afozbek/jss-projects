import React, { Component } from "react";

import axios from "axios";

import "./Spinner.css";

export default class RenderPostApp extends Component {
    state = {
        data: [],
        loading: true
    };

    componentDidMount() {
        axios
            .get("https://jsonplaceholder.typicode.com/posts")
            .then(res => {
                console.log(res.data);
                this.setState({ data: res.data, loading: false });
            })
            .catch(err => {
                this.setState({
                    loading: false
                });
            });
    }

    render() {
        const titles = this.state.data.map(post => (
            <li key={post.id}>{post.title}</li>
        ));
        if (this.state.loading) {
            return <div class="lds-hourglass" />;
        } else return <ul>{titles}</ul>;
    }
}
