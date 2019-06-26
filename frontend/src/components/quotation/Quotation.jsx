import React, {Component} from 'react';
import {Button, Col, Container, Row} from "react-bootstrap";

class Quotation extends Component {
  render() {
    return (
        <Container className="text-left">
          <Row>
            <Col className="md-8">
              <br></br>

              <div className="mt-4">
                <h4>Elija su lugar de compra</h4>
              </div>
              <hr className="mb-2"></hr>
              <div className="pr-5 m-4">

                <div className="d-flex justify-content-between mb-4">
                  <h6 className="mb-3">Metro</h6>
                  <div className="form-check">
                    <Button block onClick={this.register}>Comprar</Button>
                  </div>
                </div>
                <ProFormaList/>
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
              </div>
            </Col>
          </Row>
        </Container>
    );
  }
}

export default Quotation;