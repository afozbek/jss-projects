import React from "react";

const User = props => {

    const { userId, username, firstName } = props.userData;

    return < tr >
        <td>{userId}</td>
        <td>{username}</td>
        <td>{firstName}</td>
        <td><button className="button">UPDATE</button></td>
    </tr >
};

export default User;
