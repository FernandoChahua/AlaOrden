import {APPLY_COUPON, REMOVE_COUPON, SEND_PAY} from "../actions/actions";


export default function paymentReducer(state = { coupons: [], discount: 0 } ,action) {
    let couponList = [];
    let discount = 0;
    switch (action.type) {
        case APPLY_COUPON:
            couponList = [...state.coupons].concat([action.coupon]);
            couponList.forEach(x => {discount += x.discount});
            return Object.assign({}, state,
                { coupons: couponList, discount: discount});
        case REMOVE_COUPON:
            couponList =  state.coupons.splice(0,action.index);
            couponList.forEach(x => {discount += x.discount});
            return Object.assign({}, state,
                { coupons: couponList, discount: discount });
        case SEND_PAY:
            return Object.assign({},state,
                { currentStep: '3' });
        default:
            return state;
    }
}