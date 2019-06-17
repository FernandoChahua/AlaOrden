import React, {Component} from 'react'
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";
import { Modal, Nav} from "react-bootstrap";

function AccountForm(props) {
    if (props.login) {
        return <LoginForm manageUser={props.manageUser}/>
    } else {
        return <RegisterForm manageUser={props.manageUser}/>
    }
}

class AccountModal extends Component {
    constructor(props) {
        super(props);

        this.state = {
            "login": true
        };

        this.handleEvent = this.handleEvent.bind(this)
    }

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
                    <AccountForm login={this.state.login} manageUser={this.props.manageUser}/>
                </Modal.Body>
            </Modal>
        );
    }
}

export default AccountModal;