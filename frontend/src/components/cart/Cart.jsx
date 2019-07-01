import React, {Component} from 'react';
import Dropdown from "react-bootstrap/Dropdown";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import Badge from "react-bootstrap/Badge";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import Button from "react-bootstrap/Button";
import CartItem from "./CartItem";
import {connect} from "react-redux";
import {checkOut, clearCart} from "../../actions/cartActions";
import Alert from "react-bootstrap/Alert";
import {compose} from "redux";
import {withRouter} from "react-router-dom"
import {showModal} from "../../actions/authActions";

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

    let cartButton = {
      text: "Procesar Pedido",
      action: this.goToCheckout,
      disabled: cart.length === 0,
      variant: "primary"
    };

    if(this.props.authenticated) {
      if (this.props.isOrdering){
        cartButton = {
          text: "Regresar ",
          action: this.props.showModal,
          disabled: true,
          variant: "warning"
        }
      }
    } else {
      cartButton = {
        text: "Iniciar Sesion",
        action: this.props.showModal,
        disabled: false,
        variant: "danger"
      }
    }

    return (
      <Dropdown>
        <DropdownToggle variant="outline-warning">
          <i className="fas fa-shopping-cart"> </i>
          <span className="btn-desc"> Carrito </span>
          {cart.length > 0 && <Badge variant="warning">{cart.length}</Badge>}
        </DropdownToggle>
        <DropdownMenu alignRight className="p-2" >
          <Dropdown.Header className="d-flex justify-content-between align-items-center">
            Resumen de compra
            <Button variant="link" size="sm" onClick={this.props.clearCart}>Vaciar Carrito</Button>
          </Dropdown.Header>
          <div className="cart-menu">
            {menu}
          </div>
          <Dropdown.Divider/>
          <Button block variant={cartButton.variant} onClick={cartButton.action} disabled={cartButton.disabled}>{cartButton.text}</Button>
        </DropdownMenu>
      </Dropdown>
    );
  }
}

const mapState = state => {
  return {
    cart: state.cart.cart,
    isOrdering: state.order.isOrdering,
    authenticated: state.auth.authenticated
  }
};

const mapDispatch = {
  showModal: showModal,
  clearCart: clearCart
};

export default compose(withRouter,connect(mapState, mapDispatch))  (Cart);