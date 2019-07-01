import {LOAD_ADDRESS_LIST, SET_ADDRESS} from "./actions";
import axios from "axios";
import {askForOptions} from "./quotationActions";


export function pickAddress(address, save, history) {
  return (dispatch, getState) => {
    address.user = getState().auth.user;

    console.log(address);
    if (save) {
      axios.post("api/direccion", address)
        .then(response => {

        }).catch(error => {

      });
    }
    dispatch(_setAddress(address));
    askForOptions(dispatch, getState(), history);
  }
}

export function loadAddress() {
  return (dispatch, getState) => {
    let user = getState().auth.user;

    axios.get(`api/direccion/${user.idUser}`)
      .then(response => dispatch(_loadAddressList(response.data)))
      .catch(error => {
      })
  }
}

const _setAddress = (address) => {
  return {
    type: SET_ADDRESS,
    address
  }
};

const _loadAddressList = (addressList) => {
  return {
    type: LOAD_ADDRESS_LIST,
    addressList
  }
};