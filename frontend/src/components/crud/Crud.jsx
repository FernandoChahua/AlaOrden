import React, {Component} from 'react';
import {Route} from "react-router-dom"
import UserTable from "./users/UserTable";

class Crud extends Component {
  render() {
    return (
      <div>
        <Route path={"/admin/user"} component={UserTable}/>
      </div>
    );
  }
}

export default Crud;