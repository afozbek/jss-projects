import React from "react";

import { Link } from "react-router-dom";

const Movie = props => {
    console.log(props);

    const { movieId, name, genreType, rating, director } = props.movieData;

    return (
        <tr>
            <td>{movieId}</td>
            <td>{name}</td>
            <td>{genreType}</td>
            <td>{rating}</td>
            <td>{director.name}</td>
            <td>
                <Link to={`/update-movie/${movieId}`}>UPDATE</Link>
            </td>
            <td>
                <Link to={`/delete-movie-confirm/${movieId}`}>DELETE</Link>
            </td>
        </tr>
    );
};

export default Movie;
