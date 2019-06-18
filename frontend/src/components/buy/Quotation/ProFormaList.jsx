import React, {Component} from 'react';
import Card from "react-bootstrap/Card";
import Accordion from "react-bootstrap/Accordion";
import ProFormaDetails from "./ProFormaDetails";
import Image from "react-bootstrap/Image";
import Badge from "react-bootstrap/Badge";
import ListGroup from "react-bootstrap/ListGroup";
import ListGroupItem from "react-bootstrap/ListGroupItem";

class ProFormaList extends Component {
    render() {
        return (
            <Accordion defaultActiveKey="0">
                <ProFormaDetails eventKey="1"/>
                <ProFormaDetails eventKey="2"/>
                <ProFormaDetails eventKey="3"/>
                <ProFormaDetails eventKey="4"/>
            </Accordion>
        );
    }
}

export default ProFormaList;