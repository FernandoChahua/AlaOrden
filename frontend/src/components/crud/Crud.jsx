import React, {Component} from 'react';
import {Route} from "react-router-dom"
import UserTable from "./users/UserTable";
import Forbidden from "../user/Forbidden";
import {connect} from "react-redux";

class Crud extends Component {
  render() {
    if (!this.props.authenticated){
      return (<Forbidden />)
    }

    return (
      <div>
        <Route path={"/admin/user"} component={UserTable}/>
      </div>
    );
  }
}

const mapState = (state) => {
  return {
    authenticated: state.auth.authenticated
  }
};

export default connect(mapState,null)(Crud);