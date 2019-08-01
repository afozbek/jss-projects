import React from "react";

import { Link } from "react-router-dom";

const User = props => {
    const { userId, username, firstName } = props.userData;

    return (
        <tr>
            <td>{userId}</td>
            <td>{username}</td>
            <td>{firstName}</td>
            <td>
                <Link to={`/update-user/${username}`}>UPDATE</Link>
            </td>
        </tr>
    );
};

export default User;
