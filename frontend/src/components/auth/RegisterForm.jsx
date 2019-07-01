import React, {Component} from 'react';
import Form from "react-bootstrap/Form";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import  {InputGroup} from "react-bootstrap"
import Button from "react-bootstrap/Button";
import {connect} from "react-redux";
import {withRouter} from "react-router-dom";
import {compose} from "redux";
import {register} from "../../actions/authActions";

/*
local: [...form]
state: (response)
dispatch: addUser
 */
class RegisterForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: '',
      email: '',
      pass1: '',
      pass2: ''
    };
    this.handleChange = this.handleChange.bind(this);
    this.register = this.register.bind(this);
  }
  register(event) {
    event.preventDefault();

    //TODO: validate inputs;
    if((pass1 == pass2)&&(pass1.length>5)&&(email.length>10)&&(user.length>6) ){

    this.setState({
      user: '',
      email: '',
      pass1: '',
      pass2: ''
    });
  }
  }

  handleChange(event) {
    let state = this.state;
    switch (event.target.name) {
      case 'user':
        state.user = event.target.value; break;
      case 'email':
        state.email = event.target.value; break;
      case 'pass1':
        state.pass1 = event.target.value; break;
      case 'pass2':
        state.pass2 = event.target.value; break;
      default:
        return;
    }
    this.setState(state);
  }

  render() {
    return (
      <Form onSubmit={e => this.register(e)}>
        <h3 className="text-center">Registrarse</h3>
        <Row className="flex-column flex-md-row">
          <Col>
            <Form.Group id="formRegUsername">
              <Form.Label>Nombre de Usuario</Form.Label>
              <Form.Control type="text" placeholder="Usuario" name="user" value={this.state.user} onChange={this.handleChange}/>
            </Form.Group>
          </Col>
          <Col>
            <Form.Group id="formRegEmail">
              <Form.Label>Email</Form.Label>
              <InputGroup>
                <Form.Control type="email" placeholder="Email" name="email" value={this.state.email} onChange={this.handleChange}/>
                <InputGroup.Append>
                  <InputGroup.Text>@</InputGroup.Text>
                </InputGroup.Append>
              </InputGroup>
            </Form.Group>
          </Col>
        </Row>

        <Row className="flex-column flex-md-row">
          <Col>
            <Form.Group id="formRegPass1">
              <Form.Label>Contraseña</Form.Label>
              <Form.Control type="password" placeholder="Password" name="pass1" value={this.state.pass1} onChange={this.handleChange}/>
            </Form.Group>
          </Col>
          <Col>
            <Form.Group id="formRegPass2">
              <Form.Label>Confirmar Contraseña</Form.Label>
              <Form.Control type="password" placeholder="Password" name="pass2" value={this.state.pass2} onChange={this.handleChange}/>
            </Form.Group>
          </Col>
        </Row>
        <hr></hr>
        <Button type="submit" block>Registrarse</Button>
      </Form>
    );
  }
}

const mapState = state => {
  return {

  }
};

const mapDispatch = {
  register: register
};

export default compose(withRouter,connect(mapState,mapDispatch))(RegisterForm);