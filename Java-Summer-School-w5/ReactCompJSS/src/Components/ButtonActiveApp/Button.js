import React from "react";

const Button = props => {
    const buttonId = props.id;
    return (
        <button
            className="button"
            style={{ color: props.active[buttonId] ? "green" : "red" }}
            onClick={() => props.buttonClickHandler(buttonId, props.details)}
        >
            {props.name}
        </button>
    );
};

export default Button;
