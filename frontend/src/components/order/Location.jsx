import React, { Component } from 'react'
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {Button, Dropdown, Form} from "react-bootstrap";
import Nav from "./PlaceOrder";
// import direccion from './direccion'
class Location extends Component {
    render() {
        return (
            <Container id="map">
                <Row>
                    <Col className="md-8">
                        <div>
                            <h4>Información de Entrega</h4>
                        </div>
                        <hr className="mb-2"/>
                        <Form>
                            <Row>
                                <Col className="md-6">
                                    <div className="input-group-append">
                                        <h6 className="mb-3">Usar Direccion Reciente</h6>
                                    </div>
                                    <Form>
                                        <Form.Label for="selDireccion">Direccion</Form.Label>
                                        <select className="form-control" id="selDireccion">
                                            <option>Calle xxx Nro ###</option>
                                            <option>Calle yyy Nro ###</option>
                                        </select>
                                    </Form>

                                    <br></br>
                                    <div className="row">
                                        <div className="col-md-6">
                                            <label htmlFor="txtTitular">Calle</label>
                                            <input type="text" className="form-control" id="txtCalle"
                                                   placeholder="Calle"/>
                                        </div>
                                        <div className="col-md-4">
                                            <label htmlFor="txtNumero">Numero</label>
                                            <input type="text" className="form-control" id="txtNumero" placeholder="Numero"/>
                                        </div>
                                    </div>

                                    <br></br>
                                    <div className="row">
                                        <div className="col-md-6">
                                            <label htmlFor="txtTitular">Urbanizacion</label>
                                            <input type="text" className="form-control" id="txtUrbanizacion"
                                                   placeholder="Urbanizacion"/>
                                        </div>
                                        <div className="col-md-6">
                                            <label htmlFor="txtCuenta">Distrito</label>
                                            <input type="text" className="form-control" id="txtDistrito" placeholder="Distrito"/>
                                        </div>
                                    </div>

                                    <br></br>
                                    <div className="row">
                                        <div className="col-md-12">
                                            <label htmlFor="txtReferencia">Referencia</label>
                                            <input type="text" className="form-control" id="txtReferencia"
                                                   placeholder="Referencia"/>
                                        </div>

                                    </div>


                                </Col>
                            </Row>
                        </Form>


                    </Col>
                    <Col className="md-4">
                        <br></br>
                        <hr className="mb-2"/>
                        <div className="d-flex justify-content-between mb-4">
                            <h6>Punto de Entrega</h6>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" id="chkRecordar"/>
                                <Form.Label className="form-check-label" for="chkRecordar">Recordar</Form.Label>
                            </div>
                        </div>
                        <Form>
                            <section className="container mt-3">
                                <input id="autocomplete" className="form-control " type="text"></input>
                            </section>

                        </Form>

                        <section id="map" className="container mt-3 mb-3">
                        </section>
                    </Col>


                </Row>
                <Dropdown.Divider/>
                <div>

                    <div className="mx-1">
                        <Button type="submit" className="btn btn-secondary">Cancelar</Button>
                    </div>
                    <br></br>
                    <div className="mx-1">
                        <Button type="submit" className="btn btn-secondary">Siguiente</Button>
                    </div>


                    </div>
            </Container>
        )
    }

}

export default Location;