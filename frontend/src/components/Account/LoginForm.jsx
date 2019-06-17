import React, {Component} from 'react'
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import {Row} from "react-bootstrap";
import Col from "react-bootstrap/Col";

class LoginForm extends Component {
    constructor(props){
        super(props);

        this.login = this.login.bind(this);
    }

    login(){
        let user = {
            "idUsuario": 11,
            "apodo": "Welcome Back"
        };
        this.props.manageUser(user);
    }

    render() {
        //TODO: validate form
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

export default LoginForm;