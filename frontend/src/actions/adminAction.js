import {VIEW_COUPON_LIST, VIEW_USER_ADDRESS, VIEW_USER_LIST} from "./actions";
import axios from "axios";

export function loadUsers() {
  return (dispatch, getState) => {
    listUsers(dispatch);
  }
}

function listUsers(dispatch) {
  axios.get("api/usuario")
    .then(response => {
      dispatch(_listUSers(response.data));
    }).catch(error => {

  });
}

export function saveUser(user, edited) {
  return (dispatch) => {
    if (!edited) {
      axios.post("api/usuario", {
        "nickname": user.nickname,
        "hashPassword": user.hashPassword,
        "salt": null,
        "email": user.email,
        "emailValidated": false,
        "state": 1,
      }).then(response => {
        listUsers(dispatch);
      }).catch(error => {

      });
    } else {
      axios.put("api/usuario", {
        "idUser": user.idUser,
        "nickname": user.nickname,
        "hashPassword": user.hashPassword,
        "salt": user.salt,
        "email": user.email,
        "emailValidated": user.emailValidated,
        "state": user.state,
      }).then(response => {
        listUsers(dispatch);
      }).catch(error => {

      });
    }
  }
}

export function deleteUser(id) {
  return (dispatch) => {
    axios.delete("api/usuario/" + id)
      .then(response => {
        listUsers(dispatch);
      })
      .catch(error => {
      });
  }
}

export function loadCoupons() {
  return (dispatch, getState) => {
    axios.get("api/coupon")
      .then(response => {
        dispatch(_listCoupons(response.data));
      })
      .catch(error => {

      })
  }
}


const _listUSers = (userList) => {
  return {
    type: VIEW_USER_LIST,
    userList
  }
};

const _listUserAddress = (user, addressList) => {
  return {
    type: VIEW_USER_ADDRESS,
    userAddress: {user, addressList}
  }
};

const _listCoupons = (couponList) => {
  return {
    type: VIEW_COUPON_LIST,
    couponList
  }
};