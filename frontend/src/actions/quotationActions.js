import {LOAD_OPTIONS} from "./actions";
import {_setOrder, _setStep} from "./orderAction";
import axios from "axios";


export function askForOptions(dispatch, state, history) {
    let address = state.delivery.address;
    let user = state.auth.user;
    axios.post(`api/cotizacion/${user.idUser}`, address)
      .then(response => {
        dispatch(_loadOptions(response.data));
        dispatch(_setStep(2));
        history.push("/order/quotation");
      }).catch(error => {
      console.log(error)
    });
}

export function pickOption(order) {
  return (dispatch) => {
    //TODO: implement
    dispatch(_setOrder(order))
  }
}


const _loadOptions = (proformaList) => {
  return {
    type: LOAD_OPTIONS,
    proformaList
  }
};