import {VIEW_COUPON_LIST, VIEW_USER_ADDRESS, VIEW_USER_LIST} from "./actions";
import axios from "axios";

export function loadUsers() {
  return (dispatch,getState) => {

    axios.get()
  }
}

export function loadCoupons() {
  return(dispatch,getState) => {

  }
}




const _listUSers = (userList) => {
  return {
    type: VIEW_USER_LIST,
    userList
  }
};

const _listUserAddress = (user, addressList) => {
  return {
    type: VIEW_USER_ADDRESS,
    userAddress: { user, addressList }
  }
};

const _listCoupons = (couponList) => {
  return {
    type: VIEW_COUPON_LIST,
    couponList
  }
};