import React, {Component} from 'react';
import ListButton from "../shoplist/ListButton";
import Nav from "react-bootstrap/Nav";
import Cart from "../cart/Cart";
import SessionButton from "../auth/SessionButton";

/*
COMP
 */
class ControlButtons extends Component {
  render() {
    return (
      <Nav id="buttonNav" className="flex-row justify-content-between text-md-center">
        <ListButton />
        <div className="mx-1">
          <SessionButton />
        </div>
        <div className="mx-1">
          <Cart />
        </div>
      </Nav>
    );
  }
}

export default ControlButtons;