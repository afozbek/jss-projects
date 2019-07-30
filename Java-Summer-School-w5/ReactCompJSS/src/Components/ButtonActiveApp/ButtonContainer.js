import React, { useState } from "react";

import Button from "./Button";

const ButtonContainer = props => {
    const [active, setActive] = useState([false, false]);

    const buttonClickHandler = (index, details) => {
        let activeArr = [false, false];
        activeArr[index] = 1;
        setActive(activeArr);
    };

    return (
        <div>
            <Button
                id={0}
                buttonClickHandler={buttonClickHandler}
                active={active}
                name="Button 1"
            />
            <Button
                id={1}
                buttonClickHandler={buttonClickHandler}
                active={active}
                name="Button 2"
            />
        </div>
    );
};

export default ButtonContainer;
