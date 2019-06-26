import React from 'react';
import {Router, Route, Switch} from "react-router-dom";
import {createBrowserHistory} from "history";
import Home from "./views/Home";

const history = createBrowserHistory();

const Paths = () => (
    <Router history={history}>
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route path="/order" component={"FIXME"}/>
        </Switch>
    </Router>
);

export default Paths;