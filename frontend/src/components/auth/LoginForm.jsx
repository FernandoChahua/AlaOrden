import React, {Component} from 'react';
import {Form,Row,Col} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import {connect} from "react-redux";

/*
local: [...form]
state: (response)
dispatch:
 */
class LoginForm extends Component {

  validateForm(){
    //TODO: validate form
  }

  render() {
    return (
      <Form>
        <h3 className="text-center">Iniciar Sesión</h3>
        <Row className="flex-column flex-md-row">
          <Col>
            <Form.Group id="formLogUser">
              <Form.Label>Email o username</Form.Label>
              <Form.Control type="text" placeholder="Email o username" />
            </Form.Group>
          </Col>
          <Col>
            <Form.Group controlId="formLogPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" placeholder="Password" />
            </Form.Group>
          </Col>
        </Row>
        <hr></hr>
        <Button block type="submit" onClick={this.login}>
          Iniciar Sesion
        </Button>
      </Form>
    );
  }
}

const mapState = state => {
  return {

  }
};

const mapDispatch = {

};

export default connect(mapState,mapDispatch)(LoginForm);