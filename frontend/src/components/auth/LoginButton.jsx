import React, {Component} from 'react';
import ButtonToolbar from "react-bootstrap/ButtonToolbar";
import Button from "react-bootstrap/Button";
import AuthModal from "../modal/AuthModal";

class LoginButton extends Component {
    //displayModal [local]

    render() {
        return (
            <ButtonToolbar>
                <Button variant="danger"
                        onClick={() => this.setState({displayModal: true})}>
                    <i className="far fa-user"> </i>
                    <span className="btn-desc">Iniciar Sesion</span>
                </Button>
                <AuthModal />
            </ButtonToolbar>
        );
    }
}

export default LoginButton;