import React from "react";

import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";

const User = props => {
    const { userId, username, firstName } = props.userData;

    return (
        <tr>
            <td>{userId}</td>
            <td>{username}</td>
            <td>{firstName}</td>
            <td>
                <Link to={`/update-user/${userId}`}>
                    <FontAwesomeIcon icon={faEdit} />
                </Link>
            </td>
            <td>
                <Link to={`/delete-user-confirm/${username}`}>
                    <FontAwesomeIcon icon={faTrash} />
                </Link>
            </td>
        </tr>
    );
};

export default User;
