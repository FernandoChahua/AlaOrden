import React, {Component} from 'react';
import Container from "react-bootstrap/Container";
import {Col, Row, Form, FormGroup, FormCheck, InputGroup} from "react-bootstrap";
import Button from "react-bootstrap/Button";


//FIXME: Nested forms
/*
local: [...forms]
state: creditCards, cardToken, coupons
dispatch:
*/
class Payment extends Component {
  render() {
    return (
      <Container className="text-left">
        <Row>
          <Col className="col-md-8">
            <br/>
            <div>
              <h4>Información de Pago</h4>
            </div>
            <hr className="mb-2"/>
            <Form>
              <Row>
                <Col className="col-md-6">
                  <h6 className="mb-3">Usar Tarjeta Guardada</h6>
                  <FormGroup>
                    <Form.Label htmlFor="selTarjeta">Número de Cuenta</Form.Label>
                    <select className="form-control" id="selTarjeta">
                      <option>XXXX-XXXX-XXXX-XXXX</option>
                      <option>YYYY-YYYY-YYYY-YYYY</option>
                    </select>
                  </FormGroup>
                </Col>
              </Row>
            </Form>
            <hr className="mb-2"/>
            <div className="d-flex justify-content-between mb-4">
              <h6>Metodo de Pago</h6>
              <Form inline>
                <FormGroup>
                  <FormCheck type="checkbox" label="Recordar"/>
                </FormGroup>
              </Form>
            </div>
            <Form>
              <Row>
                <Col className="col-md-6">
                  <FormGroup>
                    <Form.Label htmlFor="txtCuenta">Numero de Cuenta</Form.Label>
                    <Form.Control type="text" className="form-control" id="txtCuenta"
                                  placeholder="Numero de Cuenta"/>
                  </FormGroup>
                </Col>

                <Col className="col-md-4">
                  <Row>
                    <Col>
                      <FormGroup>
                        <Form.Label htmlFor="txtExpM">Mes</Form.Label>
                        <Form.Control type="text" id="txtExpM"
                                      placeholder="MM"/>
                      </FormGroup>
                    </Col>
                    <Col>
                      <FormGroup>
                        <Form.Label htmlFor="txtExpY">Año</Form.Label>
                        <Form.Control type="text" id="txtExpY"
                                      placeholder="YYYY"/>
                      </FormGroup>
                    </Col>
                  </Row>
                </Col>
                <Col/>
              </Row>
              <Row>
                <Col className="col-md-6">
                  <FormGroup>
                    <Form.Label htmlFor="txtTitular">Titular</Form.Label>
                    <Form.Control type="text" id="txtTitular" placeholder="Titular"/>
                  </FormGroup>
                </Col>
                <Col className="col-md-2">
                  <FormGroup>
                    <Form.Label htmlFor="txtCuenta">CCV</Form.Label>
                    <Form.Control type="text" id="txtCCV" placeholder="CCV"/>
                  </FormGroup>
                </Col>
              </Row>

            </Form>
          </Col>
          <Col className="col-md-4">
            <br/>
            <h4 className="d-flex justify-content-between">
              <span>Resumen</span>
              <span>#</span>
            </h4>
            <hr className="mb-3"/>
            <ul className="list-group mb-3">
              <li className="list-group-item d-flex justify-content-between">
                <div>
                  <h5 className="my-0">Subtotal</h5>
                  <a href="#">
                    <small className="text-muted">Detalles</small>
                  </a>
                </div>
                <span>$</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <div>
                  <h5 className="my-0">Precio de Envio</h5>
                  <a href="#">
                    <small className="text-muted">Detalles</small>
                  </a>
                </div>
                <span>$</span>
              </li>
              <li className="list-group-item d-flex justify-content-between text-success">
                <div>
                  <h5 className="my-0">Descuento</h5>
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
            <InputGroup>
              <Form.Control type="text" placeholder="Cupón"/>
              <InputGroup.Append>
                <Button type="submit" variant="secondary">Canjear</Button>
              </InputGroup.Append>
            </InputGroup>
          </Col>

        </Row>
        <br/>
        <hr className="mb-2"/>
        <br/>
        <Row>
          <Col>
            <Button variant="outline-primary" block onClick={this.register}>Anterior</Button>
          </Col>
          <Col>
            <Button block onClick={this.register}>Siguiente</Button>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default Payment;