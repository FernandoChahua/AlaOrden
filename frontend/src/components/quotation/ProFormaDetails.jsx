 import React, {Component} from 'react';
import Badge from "react-bootstrap/Badge";

/*
COMP
 */
class ProFormaDetails extends Component {
  render() {

    const details = this.props.details;
    const product = details.product;
    const name = [product.brand.name.toUpperCase()+",", product.name,"-", product.packaging,"x"+product.quantity+":", product.measure,product.unit];

    return (
      <tr>
        <td>{name.join(" ")}</td>
        <td>{details.price}</td>
        <td>{details.quantity}</td>
        <td><b>S/{Math.round(details.price * details.quantity*100)/100}</b></td>
      </tr>
    );
  }
}

export default ProFormaDetails;