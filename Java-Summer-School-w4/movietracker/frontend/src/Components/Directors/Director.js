import React from "react";

import { Link } from "react-router-dom";

const Director = props => {
    const { directorId, name, surname, birthPlace } = props.directorData;

    return (
        <tr>
            <td>{directorId}</td>
            <td>{name}</td>
            <td>{surname}</td>
            <td>{birthPlace}</td>
            <td>
                <Link to={`/update-director/${directorId}`}>UPDATE</Link>
            </td>
        </tr>
    );
};

export default Director;
