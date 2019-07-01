import React, {Component} from 'react';
import {Button, Modal} from "react-bootstrap";

class ConfirmAddress extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <Modal
        centered
        show={this.props.show}
        onHide={this.props.toggle}
      >
        <Modal.Header closeButton>
          <Modal.Title id="example-modal-sizes-title-sm">
            Confirmar Dirección de Entrega
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <h5>Desea realizar la entrega a esta direccion:</h5>
          <div>{this.props.object}</div>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={this.props.toggle}>Volver</Button>
          <Button variant="primary" onClick={this.props.confirm}>Continuar</Button>
        </Modal.Footer>
      </Modal>
    );
  }
}

export default ConfirmAddress;