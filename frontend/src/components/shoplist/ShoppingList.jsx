import React, {Component} from 'react';
import Collapse from "react-bootstrap/Collapse";
import Card from "react-bootstrap/Card";

class ShoppingList extends Component {
  //TODO: showList -state-, list -state-, toggleList -state-

  toggleList() {
    //TODO: implement
  }

  render() {
    return (
      <Collapse in={this.props.showList}>
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