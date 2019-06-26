//auth
export const LOGIN = 'LOGIN';
export const LOGOUT = 'LOGOUT';

//catalog(search/list/category)
export const LOAD_INIT_CATALOG = 'LOAD_INIT_CATALOG';
export const GET_SEARCH_RESULTS = 'GET_SEARCH_RESULTS';
export const ADD_LIST_QUERY = 'ADD_LIST_QUERY';
export const DELETE_LIST_QUERY = 'DELETE_LIST_QUERY';
export const GET_QUERY_RESULTS = 'GET_QUERY_RESULTS';
export const ADD_FILTER = 'ADD_FILTER';

//cart
export const ADD_ITEM = 'ADD_ITEM';
export const UPDATE_ITEM = 'UPDATE_ITEM';
export const REMOVE_ITEM = 'REMOVE_ITEM';
export const LOAD_CART = 'LOAD_CART';
export const SUBMIT_CART = 'SUBMIT_CART';

//delivery
export const PICK_ADDRESS = 'PICK_ADDRESS';
export const LOAD_ADDRESS_LIST = 'LOAD_ADDRESS_LIST';

//quotation
export const LOAD_OPTIONS = 'VIEW_OPTIONS';
export const PICK_OPTION = 'PICK_OPTION';

//payment
export const APPLY_COUPON = 'APPLY_COUPON';
export const REMOVE_COUPON = 'REMOVE_COUPON';
export const SEND_PAY = 'SEND_PAY';

/* CRUD */
//USER[lse] (direction[l])
export const VIEW_USER_LIST = 'VIEW_USER_LIST';
export const VIEW_USER_DIR = 'VIEW_USER_DIR';

//PRODUCT[lse] (brand[g],category[g], location[l])
export const VIEW_PRODUCT_LIST = 'VIEW_PRODUCT_LIST';

//ORDER[le] (detail[le])
export const VIEW_ORDER_LIST = 'VIEW_ORDER_LIST';
export const VIEW_ORDER_DETAILS = 'VIEW_ORDER_DETAILS';

//FRANCHISE[l] (store[lsed])
export const VIEW_FRANCHISES = 'VIEW_FRANCHISES' ;
export const DELETE_LOCATION = 'DELETE_LOCATION';