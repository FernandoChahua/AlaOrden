import React, { Component } from 'react'
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import direccion from './direccion'

class Location extends Component {
    render() {
        return (
            <Container>
                <Row>
                    <Col>
                        <section className="container mt-3">
                            <input id="autocomplete" className="form-control " type="text"></input>
                        </section>
                    </Col>
                </Row>
                <Row>
                    <Col>
                        <section id="map" className="container mt-3 mb-3">
                        </section>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default Location;