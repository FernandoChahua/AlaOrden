import React, {Component} from 'react';
import Container from "react-bootstrap/Container";
import {Col, Row, Form, FormGroup, FormCheck, InputGroup} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import {connect} from "react-redux";
import {applyCoupon} from "../../actions/paymentActions";


//FIXME: Nested forms
/*
local: [...forms]
state: creditCards, cardToken, coupons
dispatch:
*/
class Payment extends Component {
  constructor(props) {
    super(props);

    this.state = {
      storedCard: '',
      card: '',
      person: '',
      month: '',
      year: '',
      ccv: '',
      couponInput: '',
      remember: false
    };

    this.checkout = this.checkout.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.toggleCheck = this.toggleCheck.bind(this);
    this.addCoupon = this.addCoupon.bind(this);
  }

  addCoupon() {
    this.props.applyCoupon(this.state.couponInput);
    this.setState({...this.state,couponInput:''});
  }

  toggleCheck() {
    this.setState({ ...this.state, remember: !this.state.remember});
  }

  handleChange(event) {
    let state = this.state;
    let value = event.target.value;
    switch (event.target.name) {
      case 'card':
        state.card = value; break;
      case 'person':
        state.person = value; break;
      case 'month':
        state.month = value; break;
      case 'year':
        state.year = value; break;
      case 'ccv':
        state.ccv = value; break;
      case 'couponInput':
        state.couponInput = value; break;
      default:
        break;
    }
    this.setState(state);
  }

  checkout() {

  }

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
            <Form onSubmit={this.checkout}>
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
                  <FormCheck type="checkbox" label="Recordar" checked={this.state.remember} onChange={this.toggleCheck} />
                </FormGroup>
              </Form>
            </div>
            <Form>
              <Row>
                <Col className="col-md-6">
                  <FormGroup>
                    <Form.Label htmlFor="txtCuenta">Numero de Cuenta</Form.Label>
                    <Form.Control type="text" className="form-control" id="txtCuenta"
                                  placeholder="Numero de Cuenta"
                                  name="card" value={this.state.card} onChange={this.handleChange}/>
                  </FormGroup>
                </Col>

                <Col className="col-md-4">
                  <Row>
                    <Col>
                      <FormGroup>
                        <Form.Label htmlFor="txtExpM">Mes</Form.Label>
                        <Form.Control type="text" id="txtExpM"
                                      placeholder="MM"
                                      name="month" value={this.state.month} onChange={this.handleChange}/>
                      </FormGroup>
                    </Col>
                    <Col>
                      <FormGroup>
                        <Form.Label htmlFor="txtExpY">Año</Form.Label>
                        <Form.Control type="text" id="txtExpY"
                                      placeholder="YYYY"
                                      name="year" value={this.state.year} onChange={this.handleChange}/>
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
                    <Form.Control type="text" id="txtTitular" placeholder="Titular"
                                  name="person" value={this.state.person} onChange={this.handleChange}/>
                  </FormGroup>
                </Col>
                <Col className="col-md-2">
                  <FormGroup>
                    <Form.Label htmlFor="txtCuenta">CCV</Form.Label>
                    <Form.Control type="text" id="txtCCV" placeholder="CCV"
                                  name="ccv" value={this.state.ccv} onChange={this.handleChange}/>
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
                  <ul>
                    {this.props.coupons.map((x,i) => <li key={i}>{x.code}</li>)}
                  </ul>
                </div>
                <span>-${this.props.discount}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <div>
                  <h5 className="my-0">TOTAL</h5>
                </div>
                <strong>$</strong>
              </li>
            </ul>
            <InputGroup>
              <Form.Control type="text" placeholder="Cupón"
                            name="couponInput" value={this.state.couponInput} onChange={this.handleChange}/>
              <InputGroup.Append>
                <Button variant="secondary" onClick={this.addCoupon}>Canjear</Button>
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

const mapState = state => {
  return {
    coupons: state.payment.coupons,
    order: state.quotation.order,
    discount: state.payment.discount
  }
};

const mapDispatch = {
  applyCoupon: applyCoupon
};

export default connect(mapState,mapDispatch)(Payment);