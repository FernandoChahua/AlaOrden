import React, {Component} from 'react';
import {Form, Row, Col} from "react-bootstrap";
import Button from "react-bootstrap/Button";
import {connect} from "react-redux";
import {logIn} from "../../actions/authActions";
import {compose} from "redux";
import {withRouter} from "react-router-dom"
/*
local: [...form]
state: (response)
dispatch:
 */
class LoginForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      user: '',
      pass: '',
    };
    this.handleChange = this.handleChange.bind(this);
    this.login = this.login.bind(this);
  }


  handleChange(event) {
    let state = this.state;
    switch (event.target.name) {
      case "user":
        state.user = event.target.value;
        break;
      case "pass":
        state.pass = event.target.value;
        break;
      default:
        return;
    }
    this.setState(state);
  }

  login(event) {
    event.preventDefault();

    this.props.logIn(this.state.user,this.state.pass,this.props.history);

    this.setState({
      user: '',
      pass: '',
    });
  }

  render() {
    return (
      <Form onSubmit={e => this.login(e)}>
        <h3 className="text-center">Iniciar Sesión</h3>
        <Row className="flex-column flex-md-row">
          <Col>
            <Form.Group id="formLogUser">
              <Form.Label>Email o username</Form.Label>
              <Form.Control type="text" placeholder="Email o username" name="user" value={this.state.user}
                            onChange={this.handleChange}/>
            </Form.Group>
          </Col>
          <Col>
            <Form.Group controlId="formLogPassword">
              <Form.Label>Password</Form.Label>
              <Form.Control type="password" placeholder="Password" name="pass" value={this.state.pass}
                            onChange={this.handleChange}/>
            </Form.Group>
          </Col>
        </Row>
        <hr></hr>
        <Button block type="submit">
          Iniciar Sesion
        </Button>
      </Form>
    );
  }
}

const mapState = state => {
  return {}
};

const mapDispatch = {
  logIn: logIn,
};

export default compose(withRouter,connect(mapState, mapDispatch))(LoginForm);