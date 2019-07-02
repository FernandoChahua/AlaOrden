import {combineReducers} from "redux";
import auth from "./authReducer";
import cart from "./cartReducer";
import catalog from "./catalogReducer";
import delivery from "./deliveryReducer";
import payment from "./paymentReducer";
import quotation from "./quotationReducer";
import order from "./orderReducer";
import admin from "./adminReducer";

const reducers = {
  auth,
  cart,
  catalog,
  delivery,
  payment,
  quotation,
  order,
  admin
};

export default combineReducers(reducers);
