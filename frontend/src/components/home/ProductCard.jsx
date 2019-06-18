import React, { Component } from 'react'
import Card from "react-bootstrap/Card";
import {Button, Col, FormControl, InputGroup, Row} from "react-bootstrap";
import Container from "react-bootstrap/Container";
import CartManager from "../../util/CartManager";

class ProductCard extends Component {
    constructor(props) {
        super(props);
        this.state = {
            quantity: 0
        };
        this.setQuantity = this.setQuantity.bind(this);
        this.changeQuantity = this.changeQuantity.bind(this);
        this.decreaseQuantity = this.decreaseQuantity.bind(this);
        this.increaseQuantity = this.increaseQuantity.bind(this);
        this.addToCart = this.addToCart.bind(this);
    }

    setQuantity(cantidad){
        this.setState({ quantity: cantidad });
    }

    changeQuantity(event){
        let cantidad = event.target.value;
        if (cantidad < 0 || isNaN(cantidad)){
            cantidad = 1;
        }
        if (cantidad > 100){
            cantidad = 99;
        }
        this.setQuantity(cantidad)
    }

    decreaseQuantity(){
        let quantity = this.state.quantity;
        this.setQuantity(quantity === 0? 0: quantity - 1);
    }

    increaseQuantity() {
        let quantity = this.state.quantity;
        this.setQuantity(quantity > 99? 99: quantity + 1);
    }

    addToCart(){
        let producto = this.props.producto;
        CartManager.addToCart(producto, this.state.quantity);
        this.props.updateCart();
        this.setQuantity(0);
    }

    render() {
        //FIXME: hard-coded
        let producto = this.props.producto;
        let marca = producto.marca.nombre.toUpperCase();
        let nombre = [ producto.nombre ];
        let desc = [ producto.presentacion + ": ", producto.magnitud, producto.unidad ]

        return (
            <Card className="product-card">
                <Card.Img src={"assets/img/" + producto.imagen} alt="imagen"/>
                <Card.Body>
                    <Container>
                        <Row>
                            <Col>
                                <h6 className="my-0 text-center">{marca}</h6>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <p className="m-0">{nombre}</p>
                            </Col>
                        </Row>
                        <Row>
                            <Col>
                                <p className="text-muted mb-0">{desc}</p>
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

export default ProductCard;