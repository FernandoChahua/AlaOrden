import {APPLY_COUPON, REMOVE_COUPON, SET_RESPONSE} from "../actions/actions";

const initial = {
  coupons: [],
  discount: 0,
  response: ''
};

export default function paymentReducer(state = initial, action) {
  let couponList = [];
  let discount = 0;
  switch (action.type) {
    case APPLY_COUPON:
      couponList = [...state.coupons].concat([action.coupon]);
      couponList.forEach(x => {
        discount += x.discount
      });
      return Object.assign({}, state,
        {coupons: couponList, discount: discount});
    case REMOVE_COUPON:
      couponList = state.coupons.splice(0, action.index);
      couponList.forEach(x => {
        discount += x.discount
      });
      return Object.assign({}, state,
        {coupons: couponList, discount: discount});
    case SET_RESPONSE:
      return Object.assign({}, state,
        {response: action.response});
    default:
      return state;
  }
}