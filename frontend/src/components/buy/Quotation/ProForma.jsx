import React, {Component} from "react";
import Accordion from "react-bootstrap/Accordion";
import Card from "react-bootstrap/Card";
import Image from "react-bootstrap/Image";
import Badge from "react-bootstrap/Badge";
import ListGroup from 'react-bootstrap/ListGroup'
import ProFormaDetails from "./ProFormaDetails";
import Table from "react-bootstrap/Table";

class ProForma extends Component {
    render() {
        return (
            <Card>
                <Accordion.Toggle as={Card.Header} eventKey={this.props.eventKey} className="d-inline-flex justify-content-between text-light bg-secondary">
                    <span>Metro</span>
                    <Image src="logo" alt="logo" className=""/>
                    <div>
                        <span>TOTAL: </span>
                        <Badge variant="light">$666</Badge>
                    </div>
                </Accordion.Toggle>
                <Accordion.Collapse eventKey={this.props.eventKey}>
                    <ListGroup variant="flush">
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
                                <ProFormaDetails />
                                <ProFormaDetails />
                                <ProFormaDetails />
                                <ProFormaDetails />
                                <ProFormaDetails />
                            </tbody>
                        </Table>
                    </ListGroup>
                </Accordion.Collapse>
            </Card>
        );
    }
}

export default ProForma;