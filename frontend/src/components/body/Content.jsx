import React, {Component} from 'react';

/*
COMP
 */
class Content extends Component {
  render() {
    return (
        <div id="content" className="flex-grow-1">
            {this.props.children}
        </div>
    );
  }
}

export default Content;