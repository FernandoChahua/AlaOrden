import React, {Component} from 'react';
import ListButton from "../shoplist/ListButton";
import Nav from "react-bootstrap/Nav";
import Cart from "../cart/Cart";
import AuthButton from "../auth/AuthButton";

class ControlButtons extends Component {
  render() {
    return (
      <Nav id="buttonNav" className="flex-row justify-content-between text-md-center">
        <ListButton />
        <div className="mx-1">
          <AuthButton user={this.state.user} manageUser={this.manageUser}/>
        </div>
        <div className="mx-1">
          <Cart cart={this.props.cart} changeBody={this.props.changeBody} updateCart={this.props.updateCart}/>

        </div>
      </Nav>
    );
  }
}

export default ControlButtons;