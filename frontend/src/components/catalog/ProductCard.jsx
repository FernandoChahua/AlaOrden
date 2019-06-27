import React, {Component} from 'react';
import Card from "react-bootstrap/Card";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {FormControl, InputGroup} from 'react-bootstrap'
import Button from "react-bootstrap/Button";
import {connect} from "react-redux";
import {addItem} from "../../actions/cartActions";

/*
local: quantity
state:
dispatch:
 */
class ProductCard extends Component {
  constructor(props) {
    super(props);
    this.state = {
      quantity: 0
    };
    this.changeQuantity = this.changeQuantity.bind(this);
    this.decreaseQuantity = this.decreaseQuantity.bind(this);
    this.increaseQuantity = this.increaseQuantity.bind(this);
    this.addToCart = this.addToCart.bind(this);
  }

  changeQuantity(event){
    let quantity = event.target.value;
    if (quantity < 0 || isNaN(quantity)){
      quantity = 1;
    }
    if (quantity > 100){
      quantity = 99;
    }
    this.setState({ quantity: quantity });
  }

  decreaseQuantity(){
    let quantity = this.state.quantity;
    this.setState({ quantity: quantity === 0? 0: quantity - 1 });
  }

  increaseQuantity() {
    let quantity = this.state.quantity;
    this.setState({ quantity: quantity > 99? 99: quantity + 1 });
  }

  addToCart() {
    this.props.addItem(this.props.product,this.state.quantity);
    this.setState({quantity: 0});
  }

  render() {
    //TODO: validate
    const product = this.props.product;
    let details = product.packaging + " x" + product.quantity + ": " + product.measure + product.unit;

    return (
      <Card className="product-card">
        <Card.Img src={"img/products/" + product.image} alt="imagen"/>
        <Card.Body>
          <Container>
            <Row>
              <Col>
                <h6 className="my-0 text-center">{product.brand.name.toUpperCase()}</h6>
              </Col>
            </Row>
            <Row>
              <Col>
                <p className="m-0">{product.name}</p>
              </Col>
            </Row>
            <Row>
              <Col>
                <p className="text-muted mb-0">{details}</p>
              </Col>
            </Row>
          </Container>
        </Card.Body>
        <Card.Footer>
          <Row noGutters>
            <Col xs={6}>
              <InputGroup size="sm">
                <InputGroup.Prepend>
                  <Button variant="outline-warning" onClick={this.decreaseQuantity}>-</Button>
                </InputGroup.Prepend>
                <FormControl className="text-center" value={this.state.quantity} onChange={this.changeQuantity}/>
                <InputGroup.Append>
                  <Button variant="outline-success" onClick={this.increaseQuantity}>+</Button>
                </InputGroup.Append>
              </InputGroup>
            </Col>
            <Col>
              <Button size="sm" variant="link" className="text-secondary" onClick={this.addToCart}>Agregar</Button>
            </Col>
          </Row>
        </Card.Footer>
      </Card>
    );
  }
}

const mapState = (state,ownProps) => {
  return {
    product: state.catalog.results[ownProps.index]
  }
};

const mapDispatch = {
  addItem: addItem
};

export default connect(mapState,mapDispatch)(ProductCard);