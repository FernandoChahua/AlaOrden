import React, {Component} from 'react';
import {BrowserRouter,Route,Switch} from "react-router-dom";

function AuthForm(props) {
  return (
    <BrowserRouter>
      <Switch>
        <Route path={"/login"} component={}/>
        <Route path={"/register"} component={}/>
      </Switch>
    </BrowserRouter>
  );
}



export default AuthForm;