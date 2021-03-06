import React, {Component} from 'react';
import {Modal, Nav} from "react-bootstrap";
import AuthFormSwitch from "../auth/AuthFormSwitch";
import {hideModal} from "../../actions/authActions"
import {connect} from "react-redux";

/*
local:
state: addressList, address
dispatch:
 */
class AuthModal extends Component {
  constructor(props) {
    super(props);
    this.state={ login: true};

    this.handleEvent = this.handleEvent.bind(this);
    this.onHide = this.onHide.bind(this);
  }

  handleEvent(eventKey) {
    if (eventKey !== "login") {
      this.setState({"login": false});
    } else {
      this.setState({"login": true});
    }
  }

  onHide(){
    this.setState({"login": true});
    this.props.hideModal();
  }

  render() {
    return (
      <Modal
        show={this.props.show}
        onHide={this.onHide}
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
          <AuthFormSwitch login={this.state.login} />
        </Modal.Body>
      </Modal>
    );
  }
}

const mapState = state => {
  return {
    show: state.auth.displayAuthModal
  }
};

const mapDispatch = {
  hideModal: hideModal
};

export default connect(mapState,mapDispatch)(AuthModal);