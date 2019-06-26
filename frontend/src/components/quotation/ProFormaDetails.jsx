import React, {Component} from 'react';

/*
COMP
 */
class ProFormaDetails extends Component {
  render() {
    return (
      <tr>
        <td>Marca, nombre presentacion x 1: 500 mg</td>
        <td>cantidad (en carrito)</td>
        <td>1</td>
        <td><Badge>$ 111</Badge></td>
      </tr>
    );
  }
}

export default ProFormaDetails;