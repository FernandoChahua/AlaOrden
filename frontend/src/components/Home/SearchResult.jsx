import React, { Component } from 'react'
import Container from "react-bootstrap/Container";
import CardDeck from 'react-bootstrap/CardDeck'
import ProductCard from "./ProductCard";

class SearchResult extends Component {
    constructor(props) {
        super(props);

    }

    render() {
        return(
            <Container>
                <CardDeck>
                    <ProductCard />
                    <ProductCard />
                    <ProductCard />
                    <ProductCard />
                </CardDeck>
            </Container>
        );
    }
}

export default SearchResult;