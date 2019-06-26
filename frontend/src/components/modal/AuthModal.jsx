import React, {Component} from 'react';
import {Modal, Nav} from "react-bootstrap";
import AuthForm from "./AuthForm";



class AuthModal extends Component {


  handleEvent(eventKey) {
    if (eventKey !== "login") {
      this.setState({"login": false});
    } else {
      this.setState({"login": true});
    }
  }

  render() {
    return (
      <Modal
        show={this.props.show}
        onHide={this.props.onHide}
        centered>
        <Modal.Header closeButton>
          <Nav justify className="d-inline-flex flex-row w-100" defaultActiveKey="login"
               onSelect={k => this.handleEvent(k)}>
            <Nav.Item>
              <Nav.Link eventKey="login">Iniciar Sesion</Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link eventKey="register">Registrarse</Nav.Link>
            </Nav.Item>
          </Nav>
        </Modal.Header>
        <Modal.Body>
          <AuthForm />
        </Modal.Body>
      </Modal>
    );
  }
}

export default AuthModal;