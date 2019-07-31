import React from "react";

const Movie = props => {

    console.log(props)

    const { movieId, name, genreType, rating, director } = props.movieData;

    return < tr >
        <td>{movieId}</td>
        <td>{name}</td>
        <td>{genreType}</td>
        <td>{rating}</td>
        <td>{director.name}</td>
        <td><button className="button">UPDATE</button></td>
    </tr >
};

export default Movie;
