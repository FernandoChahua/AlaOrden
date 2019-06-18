import React, {Component} from "react";
import Accordion from "react-bootstrap/Accordion";
import Card from "react-bootstrap/Card";
import Image from "react-bootstrap/Image";
import Badge from "react-bootstrap/Badge";
import ListGroup from 'react-bootstrap/ListGroup'
import ListGroupItem from "react-bootstrap/ListGroupItem";

class ProFormaDetails extends Component {
    render() {
        return (
            <Card bg="secondary" text="light">
                <Accordion.Toggle as={Card.Header} eventKey={this.props.eventKey} className="d-inline-flex justify-content-between">
                    <span>Metro</span>
                    <Image src="logo" alt="logo" className=""/>
                    <div>
                        <span>TOTAL: </span>
                        <Badge variant="light">$666</Badge>
                    </div>
                </Accordion.Toggle>
                <Accordion.Collapse eventKey={this.props.eventKey}>
                    <ListGroup variant="flush">
                        <ListGroupItem>
                            <div>Hola</div>
                        </ListGroupItem>
                        <ListGroupItem>
                            <div>Hola</div>
                        </ListGroupItem>
                        <ListGroupItem>
                            <div>Hola</div>
                        </ListGroupItem>
                        <ListGroupItem>
                            <div>Hola</div>
                        </ListGroupItem>
                        <ListGroupItem>
                            <div>Hola</div>
                        </ListGroupItem>
                    </ListGroup>
                </Accordion.Collapse>
            </Card>
        );
    }
}

export default ProFormaDetails;