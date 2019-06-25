import React, {Component} from 'react';
import {BrowserRouter,Switch,Route} from "react-router-dom";
import Location from "../location/Location";
import Payment from "../payment/Payment";

class MainBody extends Component {
  render() {
    return (
      <BrowserRouter>
        <Switch>
          <Route path={"/location"} component={Location}/>
          <Route path={"/payment"} component={Payment} />
          <Route path={"/quotation"} component={Quotattion}/>
        </Switch>
      </BrowserRouter>
    );
  }
}

export default MainBody;