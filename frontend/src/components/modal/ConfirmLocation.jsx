import React, {Component} from 'react';
import {Button, Modal} from "react-bootstrap";

class ConfirmLocation extends Component {
  render() {
    let order = this.props.object;

    return (
      <Modal
        centered
        show={this.props.show}
        onHide={this.props.toggle}
      >
        <Modal.Header closeButton>
          <Modal.Title id="example-modal-sizes-title-sm">
            Confirmar Lugar de Compra
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <h5>Desea realizar su compra en</h5>
          <div>{order.location.franchise.name}</div>
          <div>{order.location.address}</div>
          <ul>
            <li>Subtotal: {order.subTotal}</li>
            <li>Envio: {order.priceDelivery}</li>
          </ul>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={this.props.toggle}>Volver</Button>
          <Button variant="primary" onClick={this.props.confirm}>Continuar</Button>
        </Modal.Footer>
      </Modal>
    );
  }
}

export default ConfirmLocation;