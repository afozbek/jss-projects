import React from "react";

import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";

const Movie = props => {
    const { movieId, name, genreType, rating, director } = props.movieData;

    return (
        <tr>
            <td>{movieId}</td>
            <td>{name}</td>
            <td>{genreType}</td>
            <td>{rating}</td>
            <td>{director.name}</td>
            <td>
                <Link to={`/update-movie/${movieId}`}>
                    <FontAwesomeIcon icon={faEdit} />
                </Link>
            </td>
            <td>
                <Link to={`/delete-movie-confirm/${movieId}`}>
                    <FontAwesomeIcon icon={faTrash} />
                </Link>
            </td>
        </tr>
    );
};

export default Movie;
