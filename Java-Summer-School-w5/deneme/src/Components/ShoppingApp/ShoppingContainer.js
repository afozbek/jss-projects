import React from "react";

import ShoppingTitle from "./ShoppingTitle";
import ShoppingItems from "./ShoppingItems/ShoppingItems";

const ShoppingContainer = props => {
    return (
        <div>
            <ShoppingTitle title={props.title} />

            <ShoppingItems list={props.items} />
        </div>
    );
};

export default ShoppingContainer;
