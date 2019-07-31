import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import RegisterForm from "./Components/Auth/RegisterForm/RegisterForm";
import Home from "./Components/Home";
import LoginForm from "./Components/Auth/LoginForm/LoginForm";
import Users from "./Components/Users/Users";

const AppRouter = props => {
    return (
        <Router>
            <Switch>
                <Route path="/login" exact component={LoginForm} />
                <Route path="/register" exact component={RegisterForm} />
                <Route path="/users" exact component={Users} />
                <Route path="/" exact component={Home} />
            </Switch>
        </Router>
    );
};

export default AppRouter;
