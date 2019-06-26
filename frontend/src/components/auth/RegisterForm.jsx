import React, {Component} from 'react';
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import  {InputGroup} from "react-bootstrap"
import Button from "react-bootstrap/Button";

class RegisterForm extends Component {
  //TODO: validate

  render() {
    return (
      <Form>
        <h3 className="text-center">Registrarse</h3>
        <Row className="flex-column flex-md-row">
          <Col>

            <Form.Group id="formRegUsername">
              <Form.Label>Nombre de Usuario</Form.Label>
              <Form.Control type="text" placeholder="Usuario"/>
            </Form.Group>
          </Col>
          <Col>
            <Form.Group id="formRegEmail">
              <Form.Label>Email</Form.Label>
              <InputGroup>
                <Form.Control type="email" placeholder="Email"/>
                <InputGroup.Append>
                  <InputGroup.Text>@</InputGroup.Text>
                </InputGroup.Append>
              </InputGroup>
            </Form.Group>
          </Col>
        </Row>

        <Row className="flex-column flex-md-row">
          <Col>
            <Form.Group id="formRegPass1">
              <Form.Label>Contraseña</Form.Label>
              <Form.Control type="password" placeholder="Password"/>
            </Form.Group>
          </Col>
          <Col>
            <Form.Group id="formRegPass2">
              <Form.Label>Confirmar Contraseña</Form.Label>
              <Form.Control type="password" placeholder="Password"/>
            </Form.Group>
          </Col>
        </Row>
        <hr></hr>
        <Button type="submit" block onClick={this.register}>Registrarse</Button>
      </Form>
    );
  }
}

export default RegisterForm;