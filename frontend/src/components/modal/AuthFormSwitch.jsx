import React from 'react';
import LoginForm from "../auth/LoginForm";
import RegisterForm from "../auth/RegisterForm";

function AuthFormSwitch(props) {
  return props.login? <LoginForm /> : <RegisterForm />
}

export default AuthFormSwitch;