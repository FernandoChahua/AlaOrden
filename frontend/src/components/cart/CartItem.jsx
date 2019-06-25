import React, {Component} from 'react';
import {Col, Image, Row, InputGroup, FormControl, Button} from "react-bootstrap";

class CartItem extends Component {
  //TODO: cartitem -state-

  render() {
    return (
      <Row>
        <Col xs={3}>
          <Image src={imagen} height="70px" alt={producto.nombre} className="noselect"/>
        </Col>
        <Col>
          <Row>
            <p className="m-0">{nombre.join(' ')}</p>
          </Row>
          <Row>
            <p className="text-muted mb-1">{desc}</p>
          </Row>
          <Row>
            <Col xs={6}>
              <InputGroup size="sm">
                <InputGroup.Prepend>
                  <Button variant="outline-warning" onClick={this.decreaseQuantity}>-</Button>
                </InputGroup.Prepend>
                <FormControl className="text-center" value={detail.cantidad} onChange={this.changeQuantity}/>
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

export default CartItem;