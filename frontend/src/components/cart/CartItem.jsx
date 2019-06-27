import React, {Component} from 'react';
import {Col, Image, Row, InputGroup, FormControl, Button} from "react-bootstrap";
import {connect} from "react-redux";
import {removeItem, updateItem} from "../../actions/cartActions";

/*
local:
state: cart[i]
dispatch:
 */
class CartItem extends Component {
  constructor(props) {
    super(props);

    this.changeQuantity = this.changeQuantity.bind(this);
    this.increaseQuantity = this.increaseQuantity.bind(this);
    this.decreaseQuantity = this.decreaseQuantity.bind(this);
    this.deleteItem = this.deleteItem.bind(this);
  }

  changeQuantity(event) {
    let cartItem = this.props.cartItem;
    let quantity = event.target.value;
    if (quantity < 0 || isNaN(quantity)) {
      quantity = 1;
    }
    if (quantity > 100) {
      quantity = 99;
    }
    this.props.updateItem(cartItem.productId, quantity);
  }

  decreaseQuantity() {
    let cartItem = this.props.cartItem;
    let newQuantity = cartItem.quantity === 0 ? 0 : cartItem.quantity - 1;

    this.props.updateItem(cartItem.productId, newQuantity);
  }

  increaseQuantity() {
    let cartItem = this.props.cartItem;
    let newQuantity = cartItem.quantity > 99 ? 99 : cartItem.quantity + 1;

    this.props.updateItem(cartItem.productId, newQuantity);
  }

  deleteItem() {
    this.props.removeItem(this.state.cartItem.productId);
  }


  render() {
    let product = this.props.cartItem.product;
    let prName = product.name;

    return (
      <Row>
        <Col xs={3}>
          <Image src={product.photo} height="70px" alt={product.name} className="noselect"/>
        </Col>
        <Col>
          <Row>
            <p className="m-0">{prName}</p>
          </Row>
          <Row>
            <p className="text-muted mb-1">{product.description}</p>
          </Row>
          <Row>
            <Col xs={6}>
              <InputGroup size="sm">
                <InputGroup.Prepend>
                  <Button variant="outline-warning" onClick={this.decreaseQuantity}>-</Button>
                </InputGroup.Prepend>
                <FormControl className="text-center" value={this.props.cartItem.quantity}
                             onChange={this.changeQuantity}/>
                <InputGroup.Append>
                  <Button variant="outline-success" onClick={this.increaseQuantity}>+</Button>
                </InputGroup.Append>
              </InputGroup>
            </Col>
            <Col>
              <Button size="sm" variant="link" className="text-danger" onClick={this.deleteItem}>Eliminar</Button>
            </Col>
          </Row>
        </Col>
      </Row>
    );
  }
}

const mapState = (state, ownProps) => {
  return {
    cartItem: state.cart.cart[ownProps.index]
  }
};

const mapDispatch = {
  updateItem: updateItem,
  removeItem: removeItem
};

export default connect(mapState, mapDispatch)(CartItem);