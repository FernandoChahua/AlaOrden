import {APPLY_COUPON, REMOVE_COUPON, REMOVE_ITEM, SEND_PAY} from "./actions";


export function applyCoupon(code,discount){
    return {
        type: APPLY_COUPON,
        coupon: { code, discount }
    }
}

export function removeCoupon(index) {
    return {
        type: REMOVE_COUPON,
        index
    }
}

export function sendPay(response) {
    return {
        type: SEND_PAY,
        response
    }
}