import React, {Component} from 'react';
import Button from "react-bootstrap/Button";
import {toggleList} from "../../actions/catalogActions";
import {connect} from "react-redux";

/*
local:
state: displayShopList
dispatch:
 */
class ListButton extends Component {
  //TODO: toggleList() -state-, list (state)

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

const mapDispatch = {
  toggleList: toggleList
};

export default connect(null,mapDispatch)(ListButton);