import React from "react";

const ShoppingHeader = props => {
    return (
        <React.Fragment>
            <h1>{props.title}</h1>
            <h2>Total Numbers of Items: {props.count}</h2>
        </React.Fragment>
    );
};

export default ShoppingHeader;
