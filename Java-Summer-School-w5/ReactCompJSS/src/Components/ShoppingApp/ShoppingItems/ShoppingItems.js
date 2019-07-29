import React from "react";

const ShoppingItems = props => {
    return (
        <ul>
            {props.list.map(listItem => (
                <li>{listItem}</li>
            ))}
        </ul>
    );
};

export default ShoppingItems;
