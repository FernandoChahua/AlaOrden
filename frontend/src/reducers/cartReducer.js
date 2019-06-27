import {ADD_ITEM, UPDATE_ITEM, REMOVE_ITEM, LOAD_CART, SUBMIT_CART} from "../actions/actions"
import CartManager from "../util/CartManager";

export default function cartReducer(state = { cart: [] }, action) {
    switch (action.type) {
        case ADD_ITEM:
            return Object.assign({},state,
                {cart: CartManager.addToCart(state.cart,action.id,action.quantity)});
        case UPDATE_ITEM:
            return Object.assign({},state,
                {cart: CartManager.updateCart(state.cart,action.id,action.quantity)});
        case REMOVE_ITEM:
            return Object.assign({},state,
                {cart: CartManager.removeFromCart(state.cart,action.id)});
        case LOAD_CART:
            return Object.assign({},state, {cart:action.cart});
        case SUBMIT_CART:
            return Object.assign({}, state,
              {})
        default:
            return state;
    }
}