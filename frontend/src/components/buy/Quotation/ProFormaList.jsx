import React, {Component} from 'react';
import Card from "react-bootstrap/Card";
import Accordion from "react-bootstrap/Accordion";
import ProForma from "./ProForma";
import Image from "react-bootstrap/Image";
import Badge from "react-bootstrap/Badge";
import ListGroup from "react-bootstrap/ListGroup";
import ListGroupItem from "react-bootstrap/ListGroupItem";

class ProFormaList extends Component {
    render() {
        return (
            <Accordion defaultActiveKey="0">
                <ProForma eventKey="1"/>
                <ProForma eventKey="2"/>
                <ProForma eventKey="3"/>
                <ProForma eventKey="4"/>
            </Accordion>
        );
    }
}

export default ProFormaList;