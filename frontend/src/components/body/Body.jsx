import React, {Component} from 'react';
import Sidebar from "./Sidebar";
import Content from "./Content";

class Body extends Component {
  render() {
    return (
      <div id="body" className="d-flex">
        <Sidebar />
        <Content>
          {this.props.children}
        </Content>
      </div>
    );
  }
}

export default Body;