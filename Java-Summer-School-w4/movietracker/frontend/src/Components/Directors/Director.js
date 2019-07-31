import React from "react";

const Director = props => {

    const { directorId, name, surname, birthPlace } = props.directorData;

    return < tr >
        <td>{directorId}</td>
        <td>{name}</td>
        <td>{surname}</td>
        <td>{birthPlace}</td>
        <td><button className="button">UPDATE</button></td>
    </tr >
};

export default Director;
