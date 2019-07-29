import React from "react";

import ShoppingHeader from "./ShoppingHeader";

import ShoppingContainer from "./ShoppingContainer";

const ShoppingApp = props => {
    const foodList = ["Apple", "Bread", "Cheese"];
    const clothesList = ["Shirt", "Pants", "Hat"];
    const suppliesList = ["Pen", "Paper", "Glue"];

    return (
        <div>
            <h1>Welcome to {props.project}</h1>
            <ShoppingHeader
                title="My Shopping List"
                count={
                    foodList.length + clothesList.length + suppliesList.length
                }
            />
            <ShoppingContainer title="Food" items={foodList} />
            <ShoppingContainer title="Clothes" items={clothesList} />
            <ShoppingContainer title="Supplies" items={suppliesList} />
        </div>
    );
};

export default ShoppingApp;
