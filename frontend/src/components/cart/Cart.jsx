import React, {Component} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import Badge from "react-bootstrap/Badge";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import Button from "react-bootstrap/Button";
import CartItem from "./CartItem";
import {connect} from "react-redux";
import {checkOut} from "../../actions/cartActions";
import Alert from "react-bootstrap/Alert";
import {Redirect} from "react-router-dom"

/*
local:
state: user, cart
dispatch: checkOut
*/
class Cart extends Component {
  constructor(props) {
    super(props);

    this.state = {
      cartMessage: ''
    };
  }

  goToCheckout() {
    if (this.prop.cart.length === 0) {
      return null;
    }
    return <Redirect to="/order" />
  }

  render() {
    const cart = this.props.cart ;

    let menu = cart.length === 0 ?
      (<Alert variant="secondary">Su carrito de compras está vacio</Alert>) :
      cart.map((item, i) =>
        [<Dropdown.Divider key={'dvd' + i}/>,
          <CartItem key={'item' + i} index={i}/>
        ]);

    return (
      <Dropdown>
        <DropdownToggle variant="outline-warning">
          <i className="fas fa-shopping-cart"> </i>
          <span className="btn-desc"> Carrito </span>
          {cart.lenght > 0 && <Badge variant="warning">{cart.length}</Badge>}
        </DropdownToggle>
        <DropdownMenu alignRight className="p-2" >
          <Dropdown.Header>Resumen de compra</Dropdown.Header>
          <div className="cart-menu">
            {menu}
          </div>
          <Dropdown.Divider/>
          <Button block onClick={this.props.checkOut} disabled={cart.length===0}>Procesar Pedido</Button>
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
  checkOut: checkOut
};

export default connect(mapState, mapDispatch)(Cart);