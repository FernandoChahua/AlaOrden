//auth
export const LOGIN = 'LOGIN';
export const LOGOUT = 'LOGOUT';
export const SHOW_AUTH_MODAL = 'SHOW_AUTH_MODAL';
export const HIDE_AUTH_MODAL = 'HIDE_AUTH_MODAL';

//catalog(search/list/category)
export const SET_QUERY = 'SET_QUERY';
export const LOAD_CATEGORY_LIST = 'LOAD_CATEGORY_LIST';
export const SET_RESULTS = 'SET_RESULTS';
//list
export const UPDATE_LIST_QUERY = 'UPDATE_LIST_QUERY';
export const TOGGLE_LIST = 'TOGGLE_LIST';

//cart
export const UPDATE_CART = 'UPDATE_CART';
export const CLEAR_CART = 'CLEAR_CART';

//order
export const SET_STEP = 'SET_STEP';
export const SET_ORDER = 'SET_ORDER';

//delivery
export const PICK_ADDRESS = 'PICK_ADDRESS';
export const LOAD_ADDRESS_LIST = 'LOAD_ADDRESS_LIST';

//quotation
export const PICK_OPTION = 'PICK_OPTION';
export const LOAD_OPTIONS = 'VIEW_OPTIONS';

//payment
export const APPLY_COUPON = 'APPLY_COUPON';
export const REMOVE_COUPON = 'REMOVE_COUPON';
export const SET_TOKEN = 'SET_TOKEN';

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