import React, { Component } from 'react';
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import Collapse from "react-bootstrap/Collapse";

class ShoppingList extends Component{
    constructor(props) {
        super(props);

    }

    render() {
        return(
            <Collapse in={this.props.openlist}>
                <Card id="shopping-list">
                    <Card.Header>
                        <i className="fas fa-pen-alt noselect"> </i>
                        <span className="noselect"> Lista de compras</span>
                        <button type="button" className="close" aria-label="Close" onClick={this.props.toggleList}>
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </Card.Header>
                    <Card.Body>

                    </Card.Body>
                </Card>
            </Collapse>
        );
    }
}

export default ShoppingList;