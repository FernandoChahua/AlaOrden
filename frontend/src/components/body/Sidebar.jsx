import React, {Component} from 'react';
import ShoppingList from "../shoplist/ShoppingList";

/*
COMP
 */
class Sidebar extends Component {
  render() {
    return (
      <div id="sidebar">
        <ShoppingList />
      </div>
    );
  }
}

export default Sidebar;