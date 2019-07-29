import React from "react";

const TransportTypes = props => {
    const mappedTable = props.prices.map((priceObj, index) => {
        return (
            <tr key={priceObj.mode}>
                <td>
                    <span className="table-ops-item">{priceObj.year}</span>
                </td>
                <td>
                    <span className="table-ops-item">{priceObj.model}</span>
                </td>
                <td>
                    <span className="table-ops-item">{priceObj.price}</span>
                </td>
                <td>
                    <button className="button">BUY NOW</button>
                </td>
            </tr>
        );
    });

    return (
        <div style={{ marginBottom: 30 }}>
            <h1>{props.type}</h1>
            <table>
                <tr style={{ backgroundColor: "beige" }}>
                    <th>Year</th>
                    <th>Model</th>
                    <th>Price</th>
                    <th>Buy</th>
                </tr>
                <tbody>{mappedTable}</tbody>
            </table>
        </div>
    );
};

export default TransportTypes;
