import React, {Component} from 'react';
import {BrowserRouter,Switch,Route} from "react-router-dom";
import Order from "../order/Order";
import Catalog from "../catalog/Catalog";

class MainBody extends Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route path={"/catalog"} component={Catalog}/>
          <Route path={"/order"} component={Order} />
        </Switch>
      </BrowserRouter>
    );
  }
}

export default MainBody;