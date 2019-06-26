import React, {Component} from 'react';
import Container from "react-bootstrap/Container";
import { Navbar } from "react-bootstrap"

/*
COMP
 */
class Header extends Component {
  render() {
    return (
      <div id="header">
        <Container fluid>
          <Navbar expand={false} className="flex-column flex-sm-row">
            {this.props.children}
          </Navbar>
        </Container>
      </div>
    );
  }
}

export default Header;