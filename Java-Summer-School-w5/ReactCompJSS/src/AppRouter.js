import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Counter from "./Components/CounterApp/Counter";
import RegisterForm from "./Components/RegisterForm/RegisterForm";
import Home from "./Components/Home";

const AppRouter = props => {
    return (
        <Router>
            <Switch>
                <Route path="/counter/:count" exact component={Counter} />
                <Route path="/counter" exact component={Counter} />
                <Route path="/register" exact component={RegisterForm} />
                <Route path="/" exact component={Home} />
            </Switch>
        </Router>
    );
};

export default AppRouter;
