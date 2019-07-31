import React, { Component, Fragment } from "react";

import { Link } from "react-router-dom";

import Answer from "./Answer";

export default class Quiz extends Component {
    state = {
        questions: [1, 2, 1, 3, 2, 3, 1, 4],
        message: "",
        answer: 0,
        isNewQuestion: true,
        answered: false,
        correctAnswerCount: 0
    };

    radioButtonChangeHandler = e => {
        let element = e.target;

        if (this.state.answer === +element.value) {
            console.log("DOGRU");
            this.setState(prevState => ({
                message: "DOGRU",
                answered: true,
                correctAnswerCount: prevState.correctAnswerCount + 1
            }));
        } else {
            console.log("YANLIS");
            this.setState({ message: "YANLIS", answered: true });
        }
    };

    handleLinkClick = () => {
        const page = this.props.match.params.page;

        if (+page === 8) {
            this.setState({
                message:
                    "YOU FINISHED THE QUIZ. Correct Answers: " +
                    this.state.correctAnswerCount
            });
        } else {
            this.setState(prevState => ({
                answer: this.state.questions[+page - 1],
                answered: false,
                message: ""
            }));
        }
    };

    componentDidMount() {
        console.log("CDD called");
        const page = this.props.match.params.page;

        this.setState(prevState => ({
            answer: this.state.questions[+page - 1]
        }));
    }

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
                {this.props.match.params.page < 9 ? (
                    <Link
                        onClick={this.handleLinkClick}
                        to={"/quiz/" + (+this.props.match.params.page + 1)}
                    >
                        Next Question
                    </Link>
                ) : (
                    <Link to="/quiz/1">To start over</Link>
                )}
            </Fragment>
        );
    }
}
