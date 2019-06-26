import {APPLY_COUPON, REMOVE_COUPON, REMOVE_ITEM, SEND_PAY} from "./actions";


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