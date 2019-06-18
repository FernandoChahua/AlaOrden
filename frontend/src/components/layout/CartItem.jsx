import React, { Component } from 'react'
import {Col, Image, Row, InputGroup, FormControl, Button} from "react-bootstrap";
import CartManager from "../../util/CartManager";

class CartItem extends Component {
    constructor(props){
        super(props);

        this.changeQuantity = this.changeQuantity.bind(this);
        this.increaseQuantity = this.increaseQuantity.bind(this);
        this.decreaseQuantity = this.decreaseQuantity.bind(this);
        this.deleteItem = this.deleteItem.bind(this);
    }

    changeQuantity(event){
        let detail = this.props.details;
        let cantidad = event.target.value;
        if (cantidad < 0 || isNaN(cantidad)){
            cantidad = 1;
        }
        if (cantidad > 100){
            cantidad = 99;
        }
        CartManager.updateCart(detail.idProducto,cantidad);
        this.props.updateCart();
    }

    decreaseQuantity(){
        let detail = this.props.details;
        CartManager.updateCart(detail.idProducto, detail.cantidad === 0? 0 : detail.cantidad - 1);
        this.props.updateCart();
    }

    increaseQuantity() {
        let detail = this.props.details;
        CartManager.updateCart(detail.idProducto, detail.cantidad > 99 ? 99 : detail.cantidad + 1);
        this.props.updateCart();
    }

    deleteItem(){
        CartManager.removeFromCart(this.props.details.idProducto);
        this.props.updateCart();
    }

    render() {
        let detail = this.props.details;
        let producto = detail.producto;

        let imagen = 'assets/img/' + producto.imagen;
        //Genera el nombre a mostrar
        let nombre = [ producto.marca.nombre.toUpperCase() + ",", producto.nombre ];
        let desc = [ producto.presentacion + ": ", producto.magnitud, producto.unidad ]

        return(
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