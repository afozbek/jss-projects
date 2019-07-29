import React from "react";

import TransportTypes from "./TransportTypes";

const TransportContainer = props => {
    const prices = [
        {
            type: "CARS",
            prices: [
                { model: "A", price: 32000, year: 2013 },
                { model: "B", price: 4400, year: 2011 },
                { model: "C", price: 15500, year: 2016 }
            ]
        },
        {
            type: "TRUCKS",
            prices: [
                { model: "D", price: 18000, year: 2014 },
                { model: "E", price: 5200, year: 2014 }
            ]
        },
        {
            type: "MOTOR",
            prices: [{ model: "D", price: 18000, year: 2014 }]
        }
    ];

    const mappedTransports = prices.map(transportObj => {
        return (
            <TransportTypes
                key={Math.random()}
                type={transportObj.type}
                prices={transportObj.prices}
            />
        );
    });

    return <div>{mappedTransports}</div>;
};

export default TransportContainer;
