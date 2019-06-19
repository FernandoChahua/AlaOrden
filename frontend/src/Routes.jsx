import React from 'react';
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import PlaceOrder from "./components/order/PlaceOrder";
import Home from "./components/home/Home";

const Routes = () => (
    <Router>
        <Switch>
            <Route exact path="/" component={Home}/>
            <Route path="/order" component={PlaceOrder}/>
        </Switch>
    </Router>
);

export default Routes;