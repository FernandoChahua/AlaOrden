import React from 'react';
import LoginForm from "./LoginForm";
import RegisterForm from "./RegisterForm";

function AuthFormSwitch(props) {
  return props.login? <LoginForm /> : <RegisterForm />
}

export default AuthFormSwitch;