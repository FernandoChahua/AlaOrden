import {HIDE_AUTH_MODAL, LOGIN, LOGOUT, SHOW_AUTH_MODAL} from "./actions";
import axios from "axios";

export function logIn(input, pass) {
  return (dispatch) => {
    axios.get(`api/usuario/login/${input}/${pass}`)
      .then(response => {dispatch(_logIn(response.data))})
      .catch(error => { /*TODO: handle error*/ });
  }
}

export function logOut() {
  return (dispatch) => {
    dispatch(_logOut());
  }
}

export function showModal() {
  return (dispatch) => {
    dispatch(_showAuthModal());
  }
}

export function hideModal() {
  return (dispatch) => {
    dispatch(_hideAuthModal());
    //TODO: review
  }
}

const _logIn = (user) => {
  return {
    type: LOGIN,
    user: user
  }
};

const _logOut = () => {
  return {
    type: LOGOUT,
  }
};

const _showAuthModal = () => {
  return {
    type: SHOW_AUTH_MODAL,
  }
};

const _hideAuthModal = () => {
  return {
    type: HIDE_AUTH_MODAL,
  }
};