import React, {Component} from 'react'
import {Container} from "react-bootstrap";
import Accordion from "react-bootstrap/Accordion";
import Card from "react-bootstrap/Card";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import ProFormaList from "./ProFormaList";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

class Quotation extends Component {
    render() {
        return (
            <Container className="text-left">
                <Row>
                    <Col md={8}>
                        <div className="mt-4">
                            <h4>Resultado de Búsqueda</h4>
                        </div>
                        <hr className="mb-2"></hr>
                        <div className="pr-5 m-4">
                            <ProFormaList/>

                            <hr className="mb-2"></hr>

                            <Form>
                                <h6>Seleccione sede</h6>
                                <div className="my-3">
                                    <Form.Check label="Metro" type="radio" id="r-1"/>
                                    <Form.Check label="Metro" type="radio" id="r-2"/>
                                    <Form.Check label="Metro" type="radio" id="r-3"/>
                                    <Form.Check label="Metro" type="radio" id="r-4"/>
                                </div>
                            </Form>

                            <hr className="mb-2"></hr>

                            <Row>
                                <Col>
                                    <Button variant="outline-primary" block onClick={this.register}>Anterior</Button>
                                </Col>
                                <Col>
                                    <Button block onClick={this.register}>Siguiente</Button>
                                </Col>
                            </Row>
                        </div>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default Quotation;