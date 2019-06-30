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
import {compose} from "redux";
import {withRouter} from "react-router-dom"

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

    this.goToCheckout = this.goToCheckout.bind(this);
  }

  goToCheckout() {
    this.props.history.push("/order/delivery");
  }

  render() {
    let cart = this.props.cart ;

    let menu = cart.length === 0 ?
      (<Alert variant="secondary" className="m-2">Su carrito de compras está vacio</Alert>) :
      cart.map((item, i) =>
        [<Dropdown.Divider key={'dvd' + i}/>,
          <CartItem key={'item' + i} index={i}/>
        ]);

    return (
      <Dropdown>
        <DropdownToggle variant="outline-warning">
          <i className="fas fa-shopping-cart"> </i>
          <span className="btn-desc"> Carrito </span>
          {cart.length > 0 && <Badge variant="warning">{cart.length}</Badge>}
        </DropdownToggle>
        <DropdownMenu alignRight className="p-2" >
          <Dropdown.Header>Resumen de compra</Dropdown.Header>
          <div className="cart-menu">
            {menu}
          </div>
          <Dropdown.Divider/>
          <Button block onClick={this.goToCheckout} disabled={!this.props.allowCheckout}>Procesar Pedido</Button>
        </DropdownMenu>
      </Dropdown>
    );
  }
}

const mapState = state => {
  return {
    cart: state.cart.cart,
    allowCheckout: state.cart.allowCheckout
  }
};

const mapDispatch = {

};

export default compose(withRouter,connect(mapState, mapDispatch))  (Cart);