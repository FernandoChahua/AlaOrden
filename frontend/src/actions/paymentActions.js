import {APPLY_COUPON, REMOVE_COUPON, REMOVE_ITEM } from "./actions";
import axios from "axios";


export function applyCoupon(code) {
    return function (dispatch) {
        //validate Coupon (returns discount amount)
        axios.get(`api/payment/coupon/${code}`)
          .then(response => {
              //FIXME: hard-coded
              let discount = 10;
              dispatch(_applyCoupon(code,discount));
          })
          .catch(error => { });
    };
}

export function removeCoupon(index) {
    return (dispatch) => {

        dispatch(_removeCoupon(index));
    }
}


export function sendPay() {
    return (dispatch) => {


    }
}


const _applyCoupon = (code,discount) => {
    return {
        type: APPLY_COUPON,
        coupon: { code, discount }
    }
};

const _removeCoupon = (index) => {
    return {
        type: REMOVE_COUPON,
        index
    }
};