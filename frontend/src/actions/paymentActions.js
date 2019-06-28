import {APPLY_COUPON, REMOVE_COUPON, REMOVE_ITEM, SEND_PAY} from "./actions";


export function applyCoupon(code) {
    return function (dispatch,getState) {
        //getDiscount

        let discount = 10;
        dispatch(_applyCoupon(code,discount));
    };
}

export function removeCoupon() {
    return (dispatch) => {

        dispatch(_removeCoupon());
    }
}


export function sendPay() {
    return (dispatch) => {

        dispatch(_sendPay());
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

const _sendPay = (response) => {
    return {
        type: SEND_PAY,
        response
    }
};