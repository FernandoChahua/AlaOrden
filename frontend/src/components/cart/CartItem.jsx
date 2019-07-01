import React, {Component} from 'react';
import {Col, Image, Row, InputGroup, FormControl, Button, Container} from "react-bootstrap";
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
    this.commitChange = this.commitChange.bind(this);

    this.state = {
      quantity: this.props.cartItem.quantity,
      updateTimer: () => {}
    }
  }

  componentWillReceiveProps(nextProps, nextContext) {
    if (this.state.quantity !== nextProps.cartItem.quantity){
      this.setState({...this.state, quantity: nextProps.cartItem.quantity});
    }
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
    this.commitChange(cartItem.product, quantity);
  }

  commitChange(product,quantity) {
    clearTimeout(this.state.updateTimer);
    this.setState({quantity, updateTimer: setTimeout(() => {this.props.updateItem(product, quantity)},1000) });
  }

  decreaseQuantity() {


    let cartItem = this.props.cartItem;
    let newQuantity = this.state.quantity - 1;
    if (newQuantity > 0 ){
      this.commitChange(cartItem.product, newQuantity);
    }
  }

  increaseQuantity() {
    let cartItem = this.props.cartItem;
    let newQuantity =  this.state.quantity + 1;
    if (newQuantity < 100) {
      this.commitChange(cartItem.product, newQuantity);
    }
  }

  deleteItem() {
    this.props.removeItem(this.props.cartItem.product.idProduct);
  }


  render() {
    let product = this.props.cartItem.product;
    let quantity = this.state.quantity;

    let name = [product.brand.name.toUpperCase(),product.name].join(' ');
    let details = product.packaging + " x" + product.quantity + ": " + product.measure + product.unit;

    return (
      <Row>
        <Col xs={3}>
          <Image src={process.env.PUBLIC_URL + "/img/products/"+product.image} height="70px" width="70px" alt={product.name} className="noselect p-1"/>
        </Col>
        <Col>
          <Container>
            <Row>
              <p className="m-0">{name}</p>
            </Row>
            <Row>
              <p className="text-muted mb-1">{details}</p>
            </Row>
            <Row noGutters>
              <Col xs={6}>
                <InputGroup size="sm">
                  <InputGroup.Prepend>
                    <Button variant="outline-warning" onClick={this.decreaseQuantity}>-</Button>
                  </InputGroup.Prepend>
                  <FormControl className="text-center" value={quantity}
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
          </Container>
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