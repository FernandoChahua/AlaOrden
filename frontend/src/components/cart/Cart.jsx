import React, {Component} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import Badge from "react-bootstrap/Badge";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import Button from "react-bootstrap/Button";
import CartItem from "./CartItem";
import {connect} from "react-redux";

/*
local:
state: user, cart
dispatch: submitCart
*/
class Cart extends Component {

  render() {
    const cart = this.props.cart || [];

    return (
      <Dropdown>
        <DropdownToggle variant="outline-warning">
          <i className="fas fa-shopping-cart"> </i>
          <span className="btn-desc"> Carrito </span>
          {cart.lenght > 0 && <Badge variant="warning">{cart.length}</Badge>}
        </DropdownToggle>
        <DropdownMenu alignRight className="p-2" >
          <Dropdown.Header>CARRITO</Dropdown.Header>
          <div className="cart-menu">
            {cart.map((item, i) =>
              [<Dropdown.Divider key={'dvd' + i}/>,
                <CartItem key={'item' + i} index={i}/>
              ])}
          </div>
          <Dropdown.Divider/>
          <Button type="submit" block onClick={this.props.submitCart}>Procesar Pedido</Button>
        </DropdownMenu>
      </Dropdown>
    );
  }
}

const mapState = state => {
  return {
    cart: state.cart.cart
  }
};

const mapDispatch = {
  //submitCart
};

export default connect(mapState, mapDispatch)(Cart);