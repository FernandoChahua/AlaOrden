import React from 'react';
import {Router, Route, Switch,Redirect} from "react-router-dom";
import {createBrowserHistory} from "history";
import Home from "./views/Home";
import PlaceOrder from "./views/PlaceOrder";

const history = createBrowserHistory();

const Paths = () => (
    <Router history={history}>
        <Switch>
            <Route exact path="/home" component={Home}/>
            <Route path="/order" component={PlaceOrder}/>
        </Switch>
    </Router>
);

export default Paths;