import React, {Component} from 'react';
import Header from "../header/Header";
import Brand from "../header/Brand";
import SearchBar from "../SearchBar/SearchBar";

class Layout extends Component {
  render() {
    return (
      <Header>
        <Brand />
        <SearchBar />
      </Header>
    );
  }
}

export default Layout;