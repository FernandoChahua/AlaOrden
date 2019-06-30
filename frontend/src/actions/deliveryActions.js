import {LOAD_ADDRESS_LIST, SET_ADDRESS} from "./actions";
import axios from "axios";
import {askForOptions} from "./quotationActions";


export function pickAddress(address,save) {
    return (dispatch, getState) => {
        dispatch(_setAddress(address));

        if (save) {
            //TODO: save address;
        }
        askForOptions(address);
    }
}

export function loadAddress() {
    return (dispatch, getState) => {
        let user = getState().auth.user;

        axios.get(`api/direccion/${user.idUser}`)
          .then(response =>  dispatch(_loadAddressList(response.data)))
          .catch(error => {  })
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