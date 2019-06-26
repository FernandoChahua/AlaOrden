import {ADD_ITEM, LOAD_CART, REMOVE_ITEM, SUBMIT_CART, UPDATE_ITEM} from "./actions";

export function addItem(productId, quantity){
    return {
        type: ADD_ITEM,
        id: productId,
        quantity: quantity
    }
}

export function updateItem(productId, quantity) {
    return {
        type: UPDATE_ITEM,
        id: productId,
        quantity: quantity
    }
}

export function removeItem(productId) {
    return {
        type: REMOVE_ITEM,
        id: productId
    }
}

export function loadCart(cart) {
    return {
        type: LOAD_CART,
        cart: cart
    }
}

export function submitCart() {
    return {
        type: SUBMIT_CART
    }
}