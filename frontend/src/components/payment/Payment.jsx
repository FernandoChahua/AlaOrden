import React, {Component} from 'react';
import Container from "react-bootstrap/Container";
import {Col, Row, Form, FormGroup, FormCheck, InputGroup} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import {connect} from "react-redux";
import {applyCoupon, finish, sendPay} from "../../actions/paymentActions";
import {compose} from "redux";
import {withRouter} from "react-router-dom";


//FIXME: Nested forms
/*
local: [...forms]
state: creditCards, cardToken, coupons
dispatch:
*/

const initialState = {
  card: '',
  holder: '',
  month: '',
  year: '',
  ccv: '',
  couponInput: '',
  cardError: '',
  holderError: '',
  monthError: '',
  yearError: '',
  ccvError: '',
  couponInputError: '',
  remember: false,
  usingNew: false,
  showDetails: false,
  showShipping: false
};

const cleanErrors = {
  cardError: '',
  holderError: '',
  monthError: '',
  yearError: '',
  ccvError: '',
  couponInputError: ''
};

class Payment extends Component {
  constructor(props) {
    super(props);

    this.state = initialState;

    this.checkout = this.checkout.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.toggleCheck = this.toggleCheck.bind(this);
    this.addCoupon = this.addCoupon.bind(this);
    this.validateForm = this.validateForm.bind(this);
    this.getResponse = this.getResponse.bind(this);

    this.toggleDetails = this.toggleDetails.bind(this);
  }

  componentDidUpdate(prevProps, prevState, snapshot) {
    if (prevProps.response !== this.props.response) {
      console.log("received response");
      this.getResponse();
    }
  }


  checkout() {

    if (this.validateForm()) {
      let card = {
        cardNumber: this.state.card,
        holder: this.state.holder,
      };
      console.log("validated");
      this.props.sendPay(card, this.state.remember)
    }
  }

  validateForm() {
    let state = this.state;
    let rpta = true;
    //CARD
    if (state.card.length === 0) {
      state.cardError = "por favor ingrese tarjeta";
      rpta = false;
    } else if (state.card.length < 16 || state.card.length > 19) {
      state.cardError = "longitud de tarjeta invalida";
      rpta = false;
    } else {
      state.cardError = "";
    }
    //MONTH
    if (state.month.toString().length === 0) {
      state.monthError = "ingrese mes";
      rpta = false;
    } else if (state.month < 1 || state.month > 12) {
      state.monthError = "mes invalido";
      rpta = false;
    } else {
      state.monthError = "";
    }
    //YEAR
    if (state.year.toString().length === 0) {
      state.yearError = "ingrese año"
      rpta = false;
    } else if (state.year < new Date().getFullYear() || state.year > 2030) {
      state.yearError = "año invalido"
      rpta = false;
    } else {
      state.yearError = "";
    }
    //HOLDER
    if (state.holder.length === 0) {
      state.holderError = "por favor ingrese titular";
      rpta = false;
    } else {
      state.holderError = "";
    }
    //CCV
    if (state.ccv.toString().length !== 3) {
      state.ccvError = "ccv invalido";
      rpta = false;
    } else {
      state.ccvError = ""
    }

    this.setState(state);
    return rpta;
  }

  getResponse() {
    console.log("here");
    console.log(this.props.response);
    let response = this.props.response;
    if (response.status === 200) {
      console.log("finishing");
      this.props.finish(this.props.history);
    }
    else {
    }
  }

  toggleDetails(event) {

    this.setState({...this.state, showDetails: !this.state.showDetails});
  }

  addCoupon() {
    this.props.applyCoupon(this.state.couponInput);
    this.setState({...this.state, couponInput: ''});
  }

  toggleCheck() {
    this.setState({...this.state, remember: !this.state.remember});
  }

  handleChange(event) {
    let state = this.state;
    let value = event.target.value;
    switch (event.target.name) {
      case 'card':
        state.card = value;
        break;
      case 'holder':
        state.holder = value;
        break;
      case 'month':
        state.month = value;
        break;
      case 'year':
        state.year = value;
        break;
      case 'ccv':
        state.ccv = value;
        break;
      case 'couponInput':
        state.couponInput = value;
        break;
      default:
        break;
    }
    this.setState(state);
  }

  render() {
    let order = this.props.order;
    let total = order.subTotal + order.priceDelivery - order.discount;
    let details = this.state.showDetails ?
      (<ul className="pl-2">{order.orderDetails.map((x, i) =>
        <li key={i} className="d-flex justify-content-between">
          <small>{x.product.category.name + " " + x.product.name + " x" + x.quantity}</small>
          <small>{Math.round(x.quantity * x.price * 100) / 100}</small>
        </li>)}
      </ul>) :
      (null);


    return (
      <Container className="text-left">
        <Row>
          <Col id="payment-form" className="col-md-8">
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
                      <option>Seleccione Tarjeta</option>
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
                  <FormCheck type="checkbox" label="Recordar" checked={this.state.remember}
                             onChange={this.toggleCheck}/>
                </FormGroup>
              </Form>
            </div>
            <Form>
              <Row>
                <Col className="col-md-6">
                  <FormGroup>
                    <Form.Label htmlFor="txtCuenta">Numero de Cuenta</Form.Label>
                    <Form.Control type="text" className="form-control" id="txtCuenta"
                                  placeholder="Numero de Cuenta" required={this.state.usingNew}
                                  name="card" value={this.state.card} onChange={this.handleChange}/>
                    <small className="text-danger">{this.state.cardError}</small>
                  </FormGroup>
                </Col>

                <Col className="col-md-4">
                  <Row>
                    <Col>
                      <FormGroup>
                        <Form.Label htmlFor="txtExpM">Mes</Form.Label>
                        <Form.Control type="number" id="txtExpM"
                                      placeholder="MM" required={this.state.usingNew}
                                      name="month" value={this.state.month} onChange={this.handleChange}/>
                        <small className="text-danger">{this.state.monthError}</small>
                      </FormGroup>
                    </Col>
                    <Col>
                      <FormGroup>
                        <Form.Label htmlFor="txtExpY">Año</Form.Label>
                        <Form.Control type="number" id="txtExpY"
                                      placeholder="YYYY" required={this.state.usingNew}
                                      name="year" value={this.state.year} onChange={this.handleChange}/>
                        <small className="text-danger">{this.state.yearError}</small>
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
                    <Form.Control type="text" id="txtTitular" placeholder="Titular" required={this.state.usingNew}
                                  name="holder" value={this.state.holder} onChange={this.handleChange}/>
                    <small className="text-danger">{this.state.holderError}</small>
                  </FormGroup>
                </Col>
                <Col className="col-md-2">
                  <FormGroup>
                    <Form.Label htmlFor="txtCuenta">CCV</Form.Label>
                    <Form.Control type="number" id="txtCCV" placeholder="CCV" required={this.state.usingNew}
                                  name="ccv" value={this.state.ccv} onChange={this.handleChange}/>
                    <small className="text-danger">{this.state.ccvError}</small>
                  </FormGroup>
                </Col>
              </Row>

            </Form>
          </Col>
          <Col id="order-resume" className="col-md-4">
            <br/>
            <h4 className="d-flex justify-content-between">
              <span>Resumen</span>
              <span>#</span>
            </h4>
            <hr className="mb-3"/>
            <ul className="list-group mb-3">
              <li className="list-group-item">
                <div className="d-flex justify-content-between">
                  <div>
                    <h5 className="my-0">Subtotal</h5>
                    <a href="javascript:void(0)" onClick={this.toggleDetails}>
                      <small className="text-muted">Detalles</small>
                    </a>

                  </div>
                  <span>S/. {this.props.order.subTotal}</span>
                </div>
                {details}
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <div>
                  <h5 className="my-0">Precio de Envio</h5>
                  <a>
                    <small className="text-muted">Detalles</small>
                  </a>
                </div>
                <span>S/. {this.props.order.priceDelivery}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between text-success">
                <div>
                  <h5 className="my-0">Descuento</h5>
                  <ul>
                    {this.props.coupons.map((x, i) => <li key={i}>{x.code}</li>)}
                  </ul>
                </div>
                <span>-S/.{this.props.discount}</span>
              </li>
              <li className="list-group-item d-flex justify-content-between">
                <div>
                  <h5 className="my-0">TOTAL</h5>
                </div>
                <strong>S/. {Math.round(total * 100) / 100}</strong>
              </li>
            </ul>
            <InputGroup>
              <Form.Control type="text" placeholder="Cupón"
                            name="couponInput" value={this.state.couponInput} onChange={this.handleChange}/>
              <InputGroup.Append>
                <Button variant="secondary" onClick={this.addCoupon}>Canjear</Button>
              </InputGroup.Append>
              <small className="text-danger">{this.state.couponInputError}</small>
            </InputGroup>
          </Col>
        </Row>
        <br/>
        <hr className="mb-2"/>
        <br/>
        <Row>
          <Col>
            <Button variant="outline-primary" block onClick={() => {
              this.props.history.goBack()
            }}>Anterior</Button>
          </Col>
          <Col>
            <Button block onClick={this.checkout}>Siguiente</Button>
          </Col>
        </Row>
      </Container>
    );
  }
}

const mapState = state => {
  return {
    response: state.payment.response,
    coupons: state.payment.coupons,
    order: state.order.order,
    discount: state.payment.discount
  }
};

const mapDispatch = {
  applyCoupon: applyCoupon,
  sendPay: sendPay,
  finish: finish
};

export default compose(withRouter, connect(mapState, mapDispatch))(Payment);