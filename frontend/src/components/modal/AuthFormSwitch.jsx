import React, {Component} from 'react';
import {Route, Switch} from "react-router-dom";
import LoginForm from "../auth/LoginForm";
import RegisterForm from "../auth/RegisterForm";

function AuthFormSwitch(props) {
  return props.login? <LoginForm /> : <RegisterForm />
}

export default AuthFormSwitch;