import {VIEW_COUPON_LIST, VIEW_USER_ADDRESS, VIEW_USER_LIST} from "../actions/actions";


const initial = {
  userList: [],
  couponList: [],
  response: {}
};

export default function adminReducer(state = initial, action) {
  switch (action.type) {
    case VIEW_USER_LIST:
      return Object.assign({}, state,
        {userList: action.userList});
    case VIEW_USER_ADDRESS:
      return Object.assign({}, state,
        {userAddress: action.userAddress});
    case VIEW_COUPON_LIST:
      return Object.assign({}, state,
        {couponList: action.couponList});
    default:
      return state;
  }
}