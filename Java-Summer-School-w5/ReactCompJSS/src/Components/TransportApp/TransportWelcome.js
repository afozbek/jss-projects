import React from "react";

const TransportWelcome = props => {
    return (
        <div className="transportWelcome">
            <h1 className="message-item">Welcome to React Transportation</h1>
            <h3 className="message-item">
                The best place to buy vehicles online
            </h3>
            <h1 className="message-item">Choose Options</h1>
            <div className="message-item">
                New Only <input type="checkbox" />
            </div>
            <div className="message-item">
                <span>Select Type: </span>
                <select style={{ margin: 20 }}>
                    <option value="volvo">Volvo</option>
                    <option value="saab">Saab</option>
                    <option value="opel">Opel</option>
                    <option value="audi">Audi</option>
                </select>
            </div>
        </div>
    );
};

export default TransportWelcome;
