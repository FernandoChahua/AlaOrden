import {CLEAR_CART, UPDATE_CART} from "./actions";
import axios from "axios";

//TODO: merge existing items
export function addItem(product, quantity) {
  return (dispatch, getState) => {

    if (getState().auth.authenticated) {
      let user = getState().auth.user;

      axios.post(`api/cart`, {
        pk: {idUser: user.idUser, idProduct: product.idProduct},
        user: user,
        product: product,
        quantity: quantity
      }).then(response => {
        loadUserCart(dispatch, user.idUser);
      }).catch(error => {

      });
    } else {
      //OFFLINE CART
    }
  }
}

export function updateItem(product, quantity) {
  return (dispatch, getState) => {

    if (getState().auth.authenticated){
      let user = getState().auth.user;

      axios.put(`api/cart`, {
        pk: {idUser: user.idUser, idProduct: product.idProduct},
        user: user,
        product: product,
        quantity: quantity
      }).then(response => {
        loadUserCart(dispatch, user.idUser);
      }).catch(error => {

      });
    } else {
      //OFFLINE CART
    }

  }
}

export function removeItem(productId) {
  return (dispatch, getState) => {

    if (getState().auth.authenticated){
      let user = getState().auth.user;

      axios.delete(`api/cart/${user.idUser}/${productId}`)
        .then(response => {
          loadUserCart(dispatch, user.idUser);
        })
        .catch(error => {
        });
    } else {
      //OFFLINE CART
    }
  }
}

export function clearCart() {
  return (dispatch,getState) => {
    if (getState().auth.authenticated){
      let user = getState().auth.user;

      axios.delete(`api/cart/${user.idUser}`)
        .then(response => {
          dispatch(_clearCart());
        })
        .catch(error => { /*TODO: handle error*/
        });
    }
    else {
      dispatch(_clearCart());
    }

  }
}


export function loadUserCart(dispatch, idUser) {
  axios.get(`api/cart/${idUser}`)
    .then(response => {
      dispatch(_updateCart(response.data))
    })
    .catch(error => { /*TODO: handle error*/
    });
}

export function emptyUserCart(dispatch, idUser) {

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