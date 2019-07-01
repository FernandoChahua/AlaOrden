import {HIDE_AUTH_MODAL, LOGIN, LOGOUT, SET_LOGIN_RESPONSE, SHOW_AUTH_MODAL} from "./actions";
import axios from "axios";
import {_clearCart, loadUserCart} from "./cartActions";

export function logIn(input, pass,history) {
  return (dispatch) => {
    axios.get(`api/usuario/login/${input}/${pass}`)
      .then(response => {
        dispatch(_logIn(response.data));
        loadUserCart(dispatch, response.data.idUser);
        history.push("/");
      })
      .catch(error => {

      });
  }
}

export function register(nickname,email,hashPassword) {
  return (dispatch) => {
    axios.post("api/usuario", {
      nickname,email,hashPassword
    }).then(response => {
      dispatch(_logIn(response.data));
    }).catch(error => {

    });
  }
}

export function logOut() {
  return (dispatch) => {
    dispatch(_logOut());
    dispatch(_clearCart())
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

const _setLoginResponse = (response) => {
  return {
    type: SET_LOGIN_RESPONSE,
    response
  }
};