import {combineReducers} from "redux";
import authReducer from "./authReducer";
import cartReducer from "./cartReducer";
import catalogReducer from "./catalogReducer";
import deliveryReducer from "./deliveryReducer";
import paymentReducer from "./paymentReducer"
import quotationReducer from "./quotationReducer"

const reducers = { authReducer,cartReducer,catalogReducer,deliveryReducer, paymentReducer, quotationReducer };

export default combineReducers(reducers);