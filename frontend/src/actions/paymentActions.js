import {APPLY_COUPON, REMOVE_COUPON, REMOVE_ITEM, SEND_PAY} from "./actions";


export function applyCoupon(coupon) {
    return function (dispatch, getState) {
        fetch('http://localhost:8080/api/operations/applyRequests', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(coupon)
        })
            .then(async response => {
                return Object.assign({}, {error: !response.ok}, await response.json());
            })
            .then(jsonData => {
                dispatch(setapplyCoupon(jsonData))
            })
    };
}

export function setapplyCoupon(couponResult) {
    return {
        type: APPLY_COUPON,
        couponResult
    }
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