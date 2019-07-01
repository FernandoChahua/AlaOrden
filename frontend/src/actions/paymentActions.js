import {APPLY_COUPON, REMOVE_COUPON, REMOVE_ITEM, SET_RESPONSE} from "./actions";
import axios from "axios";


export function applyCoupon(code) {
  return function (dispatch) {
    //validate Coupon (returns discount amount)
    axios.get(`api/payment/coupon/${code}`)
      .then(response => {
        //FIXME: hard-coded
        let discount = 10;
        dispatch(_applyCoupon(code, discount));
      })
      .catch(error => {
      });
  };
}

export function removeCoupon(index) {
  return (dispatch) => {

    dispatch(_removeCoupon(index));
  }
}


export function sendPay(card, save) {
  return (dispatch) => {
    //TODO: fake payment

    if (save) {

    }

    let response = {
      status: 200,
      card,
    };
      dispatch(_setResponse(response))
  }
}

export function finish() {
  return (dispatch, getState) => {
    let order = getState().order.order;
    let response = getState().payment.response;

    axios.post(`api/payment/${response.card}`, order)
      .then(response => {
      })
      .catch(error => {
      });
  }
}


const _applyCoupon = (code, discount) => {
  return {
    type: APPLY_COUPON,
    coupon: {code, discount}
  }
};

const _removeCoupon = (index) => {
  return {
    type: REMOVE_COUPON,
    index
  }
};

const _setResponse = (response) => {
  return {
    type: SET_RESPONSE,
    response
  }
};