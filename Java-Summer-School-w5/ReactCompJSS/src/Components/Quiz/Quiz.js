import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import Answer from "./Answer";

export default class Quiz extends Component {
    state = {
        message: "",
        answer: Math.floor(1 + Math.random() * 3),
        answered: false
    };

    radioButtonChangeHandler = e => {
        let checked = e.target.checked;
        let element = e.target;

        console.log(checked, element.value);

        if (this.state.answer === +element.value) {
            console.log("DOGRU");
            this.setState({ message: "DOGRU", answered: true });
        } else {
            console.log("YANLIS");
            this.setState({ message: "YANLIS", answered: true });
        }
    };

    render() {
        return (
            <Fragment>
                <div className="inner-container">
                    <h1 className="header">Quiz Page</h1>
                    <h2>{this.state.message}</h2>
                    <h3>Guess the answer: </h3>

                    <label className="form-label">
                        <label htmlFor="A" className="inline-label">
                            <Answer
                                answer="A"
                                value={1}
                                changeHandler={this.radioButtonChangeHandler}
                                answered={this.state.answered}
                            />
                        </label>
                        <label htmlFor="B" className="inline-label">
                            <Answer
                                answer="B"
                                value={2}
                                changeHandler={this.radioButtonChangeHandler}
                                answered={this.state.answered}
                            />
                        </label>
                        <label htmlFor="C" className="inline-label">
                            <Answer
                                answer="C"
                                value={3}
                                changeHandler={this.radioButtonChangeHandler}
                                answered={this.state.answered}
                            />
                        </label>
                        <label htmlFor="D" className="inline-label">
                            <Answer
                                answer="D"
                                value={4}
                                changeHandler={this.radioButtonChangeHandler}
                                answered={this.state.answered}
                            />
                        </label>
                    </label>
                </div>
            </Fragment>
        );
    }
}
