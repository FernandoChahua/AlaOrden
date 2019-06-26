import React, {Component} from 'react';
import Header from "../header/Header";
import Brand from "../header/Brand";
import SearchBar from "../SearchBar/SearchBar";
import SessionButton from "../auth/SessionButton";
import Sidebar from "./Sidebar";

class Layout extends Component {
  render() {
    return (
      <Header>
        <Brand/>
        <SearchBar/>
        <SessionButton/>
      </Header>
    );
  }
}

export default Layout;