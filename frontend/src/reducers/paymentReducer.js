import {APPLY_COUPON, REMOVE_COUPON, SEND_PAY} from "../actions/actions";


export default function paymentReducer(state = { coupons: [] } ,action) {
    switch (action.type) {
        case APPLY_COUPON:
            return Object.assign({}, state,
                { coupons: [...state.coupons, action.coupon] });
        case REMOVE_COUPON:
            return Object.assign({}, state,
                { coupons: state.coupons.splice(0,action.index) });
        case SEND_PAY:
            return Object.assign({},state,
                {currentStep: '3'});
        default:
            return state;
    }
}