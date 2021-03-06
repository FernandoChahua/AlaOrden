import React, {Component} from 'react';
import Button from "react-bootstrap/Button";
import AuthModal from "../modal/AuthModal";
import ButtonToolbar from "react-bootstrap/ButtonToolbar";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import Dropdown from "react-bootstrap/Dropdown";
import {connect} from "react-redux";
import {logOut, showModal} from "../../actions/authActions";
import {Link} from "react-router-dom";

/*
local:
state: authenticated, user, displayAuthModal
dispatch:
 */
class SessionButton extends Component {
  componentWillUpdate(nextProps, nextState, nextContext) {
  }

  render() {
    return this.props.authenticated ?
      //UserButton
      (<Dropdown>
        <DropdownToggle variant="outline-danger" id="account-dropdown">
          <i className="far fa-user"> </i>
          <span className="btn-desc"> {this.props.user.nickname }</span>
        </DropdownToggle>

        <DropdownMenu alignRight>
          <Dropdown.Item as={Link} to={"/admin/user"}>CRUD: usuarios</Dropdown.Item>
          <Dropdown.Divider/>
          <Dropdown.Item onClick={this.props.logOut} as={Link} to={"/"}>Cerrar Sesión</Dropdown.Item>
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
  logOut: logOut,
  showModal: showModal
};

export default connect(mapState,mapDispatch)(SessionButton);