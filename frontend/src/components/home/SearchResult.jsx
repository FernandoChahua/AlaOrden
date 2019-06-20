import React, { Component } from 'react'
import Container from "react-bootstrap/Container";
import CardDeck from 'react-bootstrap/CardDeck'
import ProductCard from "./ProductCard";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

class SearchResult extends Component {
    constructor(props) {
        super(props);
    }

    render() {
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

        return(
            <Container>
                <Row className="py-3">
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                </Row>
                <Row className="py-3">
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                    <Col xs={3}>
                        <ProductCard producto = {producto} updateCart={this.props.updateCart}/>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default SearchResult;