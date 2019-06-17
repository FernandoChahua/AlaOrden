import React, {Component} from 'react'
import {Dropdown} from "react-bootstrap";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import DropdownMenu from "react-bootstrap/DropdownMenu";

class UserLoggedButton extends Component {
    constructor(props){
        super(props);

        this.logOut = this.logOut.bind(this);
    }

    logOut(){
        let user = this.props.user;
        user.idUsuario = null;
        user.apodo = "";
        user.email = "";

        this.props.manageUser(user);
    }

    render() {
        return(
            <Dropdown>
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
            </Dropdown>
        );
    }
}

export default UserLoggedButton;