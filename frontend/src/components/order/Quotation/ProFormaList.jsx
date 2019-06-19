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
        let franquicias = [
            {
                "nombre": "Metro",
                "style": "c-metro",
                "logo": "Logo_Metro_Cencosud.png"
            },
            {
                "nombre": "Wong",
                "style" : "c-wong",
                "logo": "Logo_Wong_Cencosud.png"
            },
            {
                "nombre": "Plaza Vea",
                "style": "c-vea",
                "logo": "Plaza_Vea_nuevo_logo.svg"
            },
            {
                "nombre": "Tottus",
                "style": "c-tottus",
                "logo": "Logotipo_Tottus.svg"
            },
        ];

        return (
            <Accordion defaultActiveKey="0">
                <ProForma franquicia={franquicias[0]} eventKey="1"/>
                <ProForma franquicia={franquicias[1]} eventKey="2"/>
                <ProForma franquicia={franquicias[2]} eventKey="3"/>
                <ProForma franquicia={franquicias[3]} eventKey="4"/>
            </Accordion>
        );
    }
}

export default ProFormaList;