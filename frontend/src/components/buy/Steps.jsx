import React, { Component } from 'react'
import Tab from 'react-bootstrap/Tab'
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Nav from "react-bootstrap/Nav";

class Steps extends Component {
    constructor(props) {
        super(props);

    }

    render() {
        return (
            <Tab.Container id="steps" defaultActiveKey="first">
                <Row>
                    <Col>
                        <Nav fill variant="pills" className="flex-row">
                            <Nav.Item>
                                <Nav.Link eventKey="1">Direccion</Nav.Link>
                            </Nav.Item>
                            <Nav.Item>
                                <Nav.Link eventKey="2">Cotizacion</Nav.Link>
                            </Nav.Item>
                            <Nav.Item>
                                <Nav.Link eventKey="3">Pago</Nav.Link>
                            </Nav.Item>
                            <Nav.Item>
                                <Nav.Link eventKey="4">Recibo</Nav.Link>
                            </Nav.Item>
                        </Nav>
                    </Col>
                </Row>
                <Row>
                    <Col sm={9}>
                        <Tab.Content>
                            <Tab.Pane eventKey="first">
                            </Tab.Pane>
                            <Tab.Pane eventKey="second">
                            </Tab.Pane>
                        </Tab.Content>
                    </Col>
                </Row>
            </Tab.Container>
        );
    }
}

export default Steps;