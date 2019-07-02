import React, {Component} from 'react';
import {Button, Col, Modal} from "react-bootstrap"
import Form from "react-bootstrap/Form";

const initialState = {
  nickError: '',
  emailError: '',
  passError: '',
};

class UserDialog extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: this.props.user,
      ...initialState
    };
    this.handleChange = this.handleChange.bind(this);
  }

  componentWillReceiveProps(nextProps, nextContext) {
    this.setState({...this.state,user:nextProps.user});
  }

  handleChange(event) {
    let value = event.target.value;
    let state = this.state;
    switch (event.target.name) {
      case "nick":
        state.user.nickname = value; break;
      case "email":
        state.user.email = value; break;
      case "pass":
        state.user.hashPassword = value; break;
      default:
    }
    this.setState(state);
  }

  async submit() {
    await this.setState(initialState);
    if (this.validate()){
      this.props.save(this.state.user,this.props.editing);
      this.props.onHide();
    }
  }

  validate() {
    let {nickError, emailError, passError} = this.state;
    let user = this.props.user;
    let rpta = true;
    if (user.nickname === 0) {
      nickError = 'nickname no puede estar vacio';
      rpta = false;
    }
    if (user.email === 0) {
      emailError = 'email no puede estar vacio';
      rpta = false;
    } else if (!user.email.includes("@")) {
      emailError = 'email no valido';
      rpta = false;
    }
    if (user.hashPassword < 5) {
      passError = 'la contraseña debe tener al menos 5 caracteres';
      rpta = false;
    }
    this.setState({...this.state,nickError,emailError,passError});
    return rpta;
  }

  render() {
    console.log(this.props);

    let user = this.state.user;
    let saveType = this.props.editing ? "Editar" : "Nuevo";
    return (
      <Modal
        show={this.props.show}
        onHide={this.props.onHide}
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter">
            {saveType} Usuario
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group controlId="formGroupEmail">
              <Form.Label>Nombre de usuario</Form.Label>
              <Form.Control type="text" placeholder="Ingrese Apodo" autoComplete="off"
                            name="nick" value={user.nickname} onChange={this.handleChange}/>
              <small className="text-danger">{}</small>
            </Form.Group>
            <Form.Group controlId="formGroupEmail">
              <Form.Label>Dirección de Email</Form.Label>
              <Form.Control type="email" placeholder="Ingrese Email" autoComplete="off"
                            name="email" value={user.email} onChange={this.handleChange}/>
            </Form.Group>
            <Form.Group controlId="formGroupPassword">
              <Form.Label>Contraseña</Form.Label>
              <Form.Control type="password" placeholder="Ingrese Contraseña" autoComplete="off"
                            name="pass" value={user.hashPassword} onChange={this.handleChange}/>
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={this.props.onHide}>Cerrar</Button>
          <Button variant="primary" onClick={this.submit.bind(this)}>Guardar</Button>
        </Modal.Footer>
      </Modal>
    );
  }
}

export default UserDialog;