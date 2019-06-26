import React, {Component} from 'react';
import UserButton from "../user/UserButton";
import LoginButton from "./LoginButton";
import Button from "react-bootstrap/Button";
import AuthModal from "../modal/AuthModal";
import ButtonToolbar from "react-bootstrap/ButtonToolbar";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import Dropdown from "react-bootstrap/Dropdown";

class SessionButton extends Component {
  render() {
    return this.props.authenticated ?
      (<Dropdown>
        <DropdownToggle variant="outline-danger" id="account-dropdown">
          <i className="far fa-user"> </i>
          <span className="btn-desc"> {this.props.user.apodo}</span>
        </DropdownToggle>

        <DropdownMenu alignRight>
          <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
          <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
          <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
          <Dropdown.Divider/>
          <Dropdown.Item onClick={this.logOut}>Cerrar Sesión</Dropdown.Item>
        </DropdownMenu>
      </Dropdown>) :
      (<ButtonToolbar>
        <Button variant="danger"
                onClick={() => this.setState({displayModal: true})}>
          <i className="far fa-user"> </i>
          <span className="btn-desc">Iniciar Sesion</span>
        </Button>
        <AuthModal/>
      </ButtonToolbar>);
  }
}

export default SessionButton;