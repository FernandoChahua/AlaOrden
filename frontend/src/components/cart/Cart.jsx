import React, {Component} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import Badge from "react-bootstrap/Badge";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import Button from "react-bootstrap/Button";
import CartItem from "./CartItem";

class Cart extends Component {
  //TODO: cart -state-, submitCart -local, orderStep -state-

  submitCart(){
    //TODO: implement
  }

  render() {
    const cart = this.props.cart;

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
              [<Dropdown.Divider key={i}/>,
                <CartItem key={i} index={i}/>
              ])}
          </div>
          <Dropdown.Divider/>
          <Button type="submit" block onClick={this.submitCart}>Procesar Pedido</Button>
        </DropdownMenu>
      </Dropdown>
    );
  }
}

export default Cart;