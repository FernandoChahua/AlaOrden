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
        let productos = [
            {
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
            },
            {
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
            },
            {
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
            },
            {
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
            },
            {
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
            },
            {
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
            },
            {
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
            },
            {
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
            },{
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
            },

        ];

        return(
            <div className="grid-contatiner">
                <ProductCard producto = {productos[0]} updateCart={this.props.updateCart}/>
                <ProductCard producto = {productos[1]} updateCart={this.props.updateCart}/>
                <ProductCard producto = {productos[2]} updateCart={this.props.updateCart}/>
                <ProductCard producto = {productos[3]} updateCart={this.props.updateCart}/>
                <ProductCard producto = {productos[4]} updateCart={this.props.updateCart}/>
                <ProductCard producto = {productos[5]} updateCart={this.props.updateCart}/>
                <ProductCard producto = {productos[6]} updateCart={this.props.updateCart}/>
                <ProductCard producto = {productos[7]} updateCart={this.props.updateCart}/>
            </div>
        );
    }
}

export default SearchResult;