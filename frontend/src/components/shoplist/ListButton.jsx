import React, {Component} from 'react';
import Button from "react-bootstrap/Button";

/*
local:
state: displayShopList
dispatch:
 */
class ListButton extends Component {
  //TODO: toggleList() -state-, list (state)

  toggleList() {
    //TODO: implement
  }

  render() {
    return (
      <div id="list-button" className="mx-1">
        <Button variant="outline-success" onClick={this.props.toggleList}>
          <i className="fas fa-pen-alt"> </i>
          <span className="btn-desc"> Lista</span>
        </Button>
      </div>
    );
  }
}

export default ListButton;