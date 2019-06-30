import {CLEAR_CART, UPDATE_CART} from "../actions/actions"

const initial = { cart: [] };

export default function cartReducer(state = initial, action) {
    switch (action.type) {
        case UPDATE_CART:
            return Object.assign({},state,
              {cart: action.cart});
        case CLEAR_CART:
            return Object.assign({},state,
              {cart: []});
        default:
            return state;
    }
}