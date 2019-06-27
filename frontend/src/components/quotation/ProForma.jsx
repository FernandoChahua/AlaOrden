import React, {Component} from 'react';
import Card from "react-bootstrap/Card";
import Image from "react-bootstrap/Image";
import Badge from "react-bootstrap/Badge";
import Collapse from "react-bootstrap/Collapse";
import ProFormaDetails from "./ProFormaDetails";
import ListGroupItem from "react-bootstrap/ListGroupItem";
import Table from "react-bootstrap/Table";

/*
local:
state: proformaList[i]
dispatch:
 */
class ProForma extends Component {
  render() {
    const franchise = this.props.franchise

    return (
      <Card>
        <Card.Header eventKey={this.props.eventKey}
                     className={"d-inline-flex justify-content-between text-light " + franchise.style}>
          <span>{franchise.nombre}</span>
          <Image src={"/assets/img/" + franchise.logo} alt="logo" className="" height="40px"/>
          <div>
            <span>TOTAL: </span>
            <Badge variant="light">$666</Badge>
          </div>
        </Card.Header>
        <Collapse>
          <ListGroupItem variant="flush">
            <Table responsive className="proforma-table" size="sm">
              <thead>
              <tr>
                <th>producto</th>
                <th>cantidad</th>
                <th>precio</th>
                <th>subtotal</th>
              </tr>
              </thead>
              <tbody>
              <ProFormaDetails/>
              <ProFormaDetails/>
              <ProFormaDetails/>
              <ProFormaDetails/>
              <ProFormaDetails/>
              </tbody>
            </Table>
          </ListGroupItem>
        </Collapse>
      </Card>
    );
  }
}

export default ProForma;