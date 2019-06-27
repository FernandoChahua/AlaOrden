import React, {Component} from 'react';
import Header from "../header/Header";
import Brand from "../header/Brand";
import SearchBar from "../search/SearchBar";
import Categories from "../category/Categories";
import ControlButtons from "../header/ControlButtons";
import Body from "../body/Body";

class Layout extends Component {
  render() {
    return (
      <div id="page">
        <Header>
          <Brand/>
          <SearchBar/>
          <ControlButtons/>
        </Header>
        <Categories/>
        <Body>
          {this.props.children}
        </Body>
      </div>
    );
  }
}

export default Layout;