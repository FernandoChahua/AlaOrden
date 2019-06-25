import React, {Component} from 'react';
import MainBody from "./MainBody";

class Content extends Component {
  render() {
    return (
      <div id="body" className="flex-grow-1">
        <div id="content">
          <MainBody body={this.state.body} changeBody={this.changeBody} updateCart={this.updateCart}/>
        </div>
      </div>
    );
  }
}

export default Content;