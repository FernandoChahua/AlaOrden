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
        return(
            <Container>
                <Row className="py-3">
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                </Row>
                <Row className="py-3">
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                    <Col xs={3}>
                        <ProductCard />
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default SearchResult;