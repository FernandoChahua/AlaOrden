import React, {Component} from 'react';
import Button from "react-bootstrap/Button";
import AuthModal from "../modal/AuthModal";
import ButtonToolbar from "react-bootstrap/ButtonToolbar";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import Dropdown from "react-bootstrap/Dropdown";
import {connect} from "react-redux";
import {logOut, showModal} from "../../actions/authActions";

/*
local:
state: authenticated, user, displayAuthModal
dispatch:
 */
class SessionButton extends Component {
  render() {
    return this.props.authenticated ?
      //UserButton
      (<Dropdown>
        <DropdownToggle variant="outline-danger" id="account-dropdown">
          <i className="far fa-user"> </i>
          <span className="btn-desc"> {this.props.user.username}</span>
        </DropdownToggle>

        <DropdownMenu alignRight>
          <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
          <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
          <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
          <Dropdown.Divider/>
          <Dropdown.Item onClick={this.props.logOut}>Cerrar Sesión</Dropdown.Item>
        </DropdownMenu>
      </Dropdown>) :

      //AuthenticationButton
      (<ButtonToolbar>
        <Button variant="danger"
                onClick={this.props.showModal}>
          <i className="far fa-user"> </i>
          <span className="btn-desc">Iniciar Sesion</span>
        </Button>
        <AuthModal/>
      </ButtonToolbar>);
  }
}

const mapState = state => {
  return {
    authenticated: state.auth.authenticated,
    user : state.auth.user,
    displayAuthModal: state.auth.displayAuthModal
  }
};

const mapDispatch = {
  logout: logOut,
  showModal: showModal
};

export default connect(mapState,mapDispatch)(SessionButton);