<<<<<<< HEAD
import React, { Component } from 'react'

class Payment extends Component {
    render() {
        return (
            <div>

            </div>
        );
    }
}

export default Payment;
=======
import React from 'react'
import {Button} from 'react-bootstrap';
import {Container} from 'react-bootstrap';
import {Row} from 'react-bootstrap';
import {Col} from 'react-bootstrap';
import {Form} from 'react-bootstrap';

class Payment extends Component {
    constructor(props) {
        super(props);

    }

    render() {
        return (
    <Container>
    <Row>
        <Col className="md-8">
            <div>
                <h4>Información de Pago</h4>
            </div>
            <hr className="mb-2"/>
            <Form>
                <Row>
                    <Col className="md-6">
                        <h6 className="mb-3">Usar Tarjeta Guardada</h6>
                        <Form>
                            <Form.Label for="selTarjeta">Número de Cuenta</Form.Label>
                            <select className="form-control" id="selTarjeta">
                                <option>XXXX-XXXX-XXXX-XXXX</option>
                                <option>YYYY-YYYY-YYYY-YYYY</option>
                            </select>
                        </Form>
                    </Col>
                </Row>
            </Form>
            <hr className="mb-2"/>
            <div className="d-flex justify-content-between mb-4">
                <h6>Metodo de Pago</h6>
                <div className="form-check">
                    <input className="form-check-input" type="checkbox" id="chkRecordar"/>
                    <Form.Label className="form-check-label" for="chkRecordar">Recordar</Form.Label>
                </div>
            </div>
            <Form>
                <Row>
                    <Col className="md-6">
                        <Form.Label for="txtCuenta">Numero de Cuenta</Form.Label>
                        <input type="text" className="form-control" id="txtCuenta" placeholder="Numero de Cuenta"/>
                    </Col>

                    <Col className="md-6">
                        <Form className="group">
                            <Form.Label for="txtExpM">Expiracion</Form.Label>
                            <Row className="m-0 p-0">
                                <Col className="md-4 pl-0">
                                    <input type="text" className="form-control" id="txtExpM" placeholder="MM"/>
                                </Col>
                                <Col className="md-4 pl-0">
                                    <input type="text" className="form-control" id="txtExpY" placeholder="YY"/>
                                </Col>
                            </Row>
                        </Form>
                    </Col>
                </Row>
                <div className="row">
                    <div className="col-md-6">
                        <label for="txtTitular">Titular</label>
                        <input type="text" className="form-control" id="txtTitular" placeholder="Titular"/>
                    </div>
                    <div className="col-md-2">
                        <label for="txtCuenta">CCV</label>
                        <input type="text" className="form-control" id="txtCCV" placeholder="CCV"/>
                    </div>
                </div>
                <hr class="mb-4"/>
                <Button className="btn btn-primary btn-block btn-lg" type="submit">Proceder (?)</Button>
            </Form>
        </Col>
        <Col className="md-4">
            <h4 className="d-flex justify-content-between">
                <span>Resumen</span>
                <span>#</span>
            </h4>
            <hr className="mb-3"/>
            <ul className="list-group mb-3">
                <li className="list-group-item d-flex justify-content-between">
                    <div>
                        <h5 class="my-0">Subtotal</h5>
                        <a href="#"><small className="text-muted">Detalles</small></a>
                    </div>
                    <span>$</span>
                </li>
                <li class="list-group-item d-flex justify-content-between">
                    <div>
                        <h5 class="my-0">Precio de Envio</h5>
                        <a href="#"><small className="text-muted">Detalles</small></a>
                    </div>
                    <span>$</span>
                </li>
                <li className="list-group-item d-flex justify-content-between text-success">
                    <div>
                        <h5 class="my-0">Descuento</h5>
                        <small>CODIGO</small>
                    </div>
                    <span>-$</span>
                </li>
                <li className="list-group-item d-flex justify-content-between">
                    <div>
                        <h5 className="my-0">TOTAL</h5>
                    </div>
                    <strong>$</strong>
                </li>
            </ul>
            <div className="input-group">
                <input type="text" class="form-control" placeholder="Cupón"/>
                <div className="input-group-append">
                    <Button type="submit" className="btn btn-secondary">Canjear</Button>
                </div>
            </div>
        </Col>
    </Row>
</Container>
)
        }
    }
>>>>>>> 1e6e3e16b822a4bca627ad56577163ee139df3b5
