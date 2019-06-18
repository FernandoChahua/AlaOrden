import React, {Component} from 'react';

import Badge from "react-bootstrap/Badge";

class ProFormaDetails extends Component {
    render() {
        return (
            <tr>
                <td >Marca, nombre presentacion x cantidad: magnitud unidad</td>
                <td>cantidad (en carrito)</td>
                <td>1</td>
                <td><Badge>$ 111</Badge></td>
            </tr>
        );
    }
}

export default ProFormaDetails;