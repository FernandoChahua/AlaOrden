import React, {Component} from 'react';
import {Button, Col, Container, Row} from "react-bootstrap";
import Alert from "react-bootstrap/Alert";
import ProForma from "./ProForma";
import {withRouter} from "react-router-dom";
import {connect} from "react-redux";
import {compose} from "redux";

/*
local:
state: proformaList, order
dispatch:
 */
class Quotation extends Component {
  constructor(props) {
    super(props);
  }


  componentDidMount() {

  }

  render() {
    let shoppingOptions = this.props.proformaList.length === 0 ?
      (<Alert variant="danger">Los sentimos, no hemos encontrado nada</Alert>) :
      (this.props.proformaList.map((x,i) => <ProForma key={i} index={i} history={this.props.history}/>));

    return (
      <Container className="text-left">
        <Row>
          <Col className="md-8">
            <br/>
            <div className="mt-4">
              <h4>Elija su lugar de compra</h4>
            </div>
            <hr className="mb-2"/>
            <div className="pr-5 m-4">

              {shoppingOptions}

              <br/>
              <hr className="mb-2"/>
              <br/>
              <Row>
                <Col>
                  <Button variant="outline-primary" block onClick={() => {}}>Anterior</Button>
                </Col>
              </Row>
            </div>
          </Col>
        </Row>
      </Container>
    );
  }
}

const mapState = state => {
  return {
    proformaList: state.quotation.proformaList,
    cart: state.cart.cart,
    address: state.delivery.address
  }
};

const mapDispatch = {

};

export default compose(withRouter,connect(mapState,mapDispatch))(Quotation);