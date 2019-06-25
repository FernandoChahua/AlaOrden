import React, {Component} from 'react';
import {Button, Col, Container, Row} from "react-bootstrap";

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