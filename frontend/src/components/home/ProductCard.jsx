import React, { Component } from 'react'
import Card from "react-bootstrap/Card";
import {Button, Col, FormControl, InputGroup, Row} from "react-bootstrap";
import Container from "react-bootstrap/Container";

class ProductCard extends Component {
    constructor(props) {
        super(props);
        let quantity = 0;
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
        this.props.updateMethod(detail.idProducto, cantidad);
    }

    decreaseQuantity(){
        let detail = this.props.details;
        this.props.updateMethod(detail.idProducto, detail.cantidad === 0? 0 : detail.cantidad - 1);
    }

    increaseQuantity() {
        let detail = this.props.details;
        this.props.updateMethod(detail.idProducto, detail.cantidad > 99 ? 99 : detail.cantidad + 1);
    }

    deleteItem(){
        this.props.deleteMethod(this.props.details.idProducto);
    }


    render() {
        //FIXME: hard-coded
        let producto = {
            "idProducto": 1,
                "idCategoria": 2,
                "categoria": null,
                "idMarca": 1,
                "marca": {
                "nombre": "Gloria"
            },
            "nombre": "Leche Evaporada",
                "presentacion": "paquete",
                "cantidad": 4,
                "magnitud": 500,
                "unidad": "g",
                "descripcion": "Leche evaporada",
                "imagen": "2.jpg",
                "productoFranquicias": null
        };
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
                                    <Button variant="outline-warning">-</Button>
                                </InputGroup.Prepend>
                                <FormControl className="text-center"/>
                                <InputGroup.Append>
                                    <Button variant="outline-success">+</Button>
                                </InputGroup.Append>
                            </InputGroup>
                        </Col>
                        <Col>
                            <Button size="sm" variant="link" className="text-secondary" onClick={this.deleteItem}>Agregar</Button>
                        </Col>
                    </Row>
                </Card.Footer>
            </Card>
        );
    }
}

export default ProductCard;