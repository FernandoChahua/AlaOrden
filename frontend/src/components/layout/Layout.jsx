import React, {Component} from 'react';
import Header from "../header/Header";
import Brand from "../header/Brand";
import SearchBar from "../search/SearchBar";
import Sidebar from "../body/Sidebar";
import Categories from "../category/Categories";
import Content from "../body/Content";
import ControlButtons from "../header/ControlButtons";

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
        <div id="body" className="flex-grow-1">
          <Sidebar />
          <Content>
            {this.props.children}
          </Content>
        </div>
      </div>
    );
  }
}

export default Layout;