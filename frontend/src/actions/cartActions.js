import {CLEAR_CART, UPDATE_CART} from "./actions";
import axios from "axios";

export function addItem(product, quantity) {
  return (dispatch, getState) => {
    let user = getState().auth.user;

    axios.post(`api/cart`, {
      pk: {idUser: user.idUser, idProduct: product.idProduct },
      user: user,
      product: product,
      quantity: quantity
    }).then(response => {
      loadCart(dispatch,user.idUser);
    }).catch(error => {

    });
  }
}

export function updateItem(product, quantity) {
  return (dispatch, getState) => {
    let user = getState().auth.user;

    axios.put(`api/cart`, {
      pk: {idUser: user.idUser, idProduct: product.idProduct },
      user: user,
      product: product,
      quantity: quantity
    }).then(response => {
      loadCart(dispatch ,user.idUser);
    }).catch(error => {

    });
  }
}

export function removeItem(productId) {
  return (dispatch, getState) => {
    let user = getState().auth.user;
    axios.delete(`api/cart/${user.idUser}/${productId}`)
      .then(response => { loadCart(dispatch, user.idUser); })
      .catch(error => {  });
  }
}


export function loadCart(dispatch, idUser) {
    axios.get(`api/cart/${idUser}`)
      .then(response => { dispatch(_updateCart(response.data)) })
      .catch(error => { /*TODO: handle error*/ });
}

export function emptyCart(dispatch, idUser) {
    axios.delete(`api/cart/${idUser}`)
      .then(response => { dispatch(_clearCart()) })
      .catch(error => { /*TODO: handle error*/ });
}

const _updateCart = (cart) => {
  return {
    type: UPDATE_CART,
    cart: cart
  }
};

export const _clearCart = () => {
  return {
    type: CLEAR_CART,
  }
};