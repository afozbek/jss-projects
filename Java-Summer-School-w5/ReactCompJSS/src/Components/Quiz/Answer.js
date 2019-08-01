import React, { Fragment } from "react";

const Answer = props => {
    return (
        <Fragment>
            <span className="form-label-radio">{props.value}:</span>
            <input
                onChange={props.changeHandler}
                className="form-radio"
                id={props.answer}
                type="radio"
                name="answer"
                value={props.value}
                disabled={props.answered}
            />
        </Fragment>
    );
};

export default Answer;
