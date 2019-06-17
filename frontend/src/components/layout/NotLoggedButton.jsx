import React, {Component} from 'react'
import {Button, ButtonToolbar} from "react-bootstrap";
import AccountModal from "../Account/AccountModal";

class NotLoggedButton extends Component {
    constructor(props){
        super(props);
        this.state = {
            displayModal: false
        }
    }

    render() {
        return (
            <ButtonToolbar>
                <Button variant="danger"
                        onClick={() => this.setState({displayModal: true})}>
                    <i className="far fa-user"> </i>
                    <span className="btn-desc"> Iniciar Sesion</span>
                </Button>
                <AccountModal
                    manageUser={this.props.manageUser}
                    show={this.state.displayModal}
                    onHide={() => this.setState({ displayModal: false })}
                />
            </ButtonToolbar>
        );
    }
}

export default NotLoggedButton;