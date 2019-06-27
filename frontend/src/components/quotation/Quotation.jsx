import React, {Component} from 'react';
import {Button, Col, Container, Row} from "react-bootstrap";
import Alert from "react-bootstrap/Alert";
import ProForma from "./ProForma";
import {connect} from "react-redux";
import {loadOptions} from "../../actions/quotationActions";

/*
local:
state: proformaList, order
dispatch:
 */
class Quotation extends Component {

  componentDidMount() {
    this.props.loadOptions();
    console.log(this.props.proformaList)
  }

  render() {
    let shoppingOptions = this.props.proformaList.length === 0 ?
      (<Alert variant="danger">Los sentimos, no hemos encontrado nada</Alert>) :
      (this.props.proformaList.map((x,i) => <ProForma key={i} index={i}/>));

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

const mapState = state => {
  return {
    proformaList: state.quotation.proformaList
  }
};

const mapDispatch = {
  loadOptions: loadOptions
};

export default connect(mapState,mapDispatch)(Quotation);