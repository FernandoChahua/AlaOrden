import React, {Component} from 'react';
import Container from "react-bootstrap/Container";
import {Col,Row,Form} from "react-bootstrap";


//FIXME: Nested forms
class Payment extends Component {
  render() {
    return (
        <Container className="text-left">
          <Row>
            <Col className="md-8">
              <br></br>
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
                    <input type="text" className="form-control" id="txtCuenta"
                           placeholder="Numero de Cuenta"/>
                  </Col>

                  <Col className="md-6">
                    <Form className="group">
                      <Form.Label for="txtExpM">Expiracion</Form.Label>
                      <Row className="m-0 p-0">
                        <Col className="md-4 pl-0">
                          <input type="text" className="form-control" id="txtExpM"
                                 placeholder="MM"/>
                        </Col>
                        <Col className="md-4 pl-0">
                          <input type="text" className="form-control" id="txtExpY"
                                 placeholder="YY"/>
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

              </Form>
            </Col>
            <Col className="md-4">
              <br></br>
              <h4 className="d-flex justify-content-between">

                <span>Resumen</span>
                <span>#</span>
              </h4>
              <hr className="mb-3"/>
              <ul className="list-group mb-3">
                <li className="list-group-item d-flex justify-content-between">
                  <div>
                    <h5 class="my-0">Subtotal</h5>
                    <a href="#">
                      <small className="text-muted">Detalles</small>
                    </a>
                  </div>
                  <span>$</span>
                </li>
                <li class="list-group-item d-flex justify-content-between">
                  <div>
                    <h5 class="my-0">Precio de Envio</h5>
                    <a href="#">
                      <small className="text-muted">Detalles</small>
                    </a>
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
          <br></br>
          <hr className="mb-2"></hr>
          <br></br>
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