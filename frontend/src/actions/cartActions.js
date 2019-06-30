import {ADD_ITEM, LOAD_CART, REMOVE_ITEM, SUBMIT_CART, UPDATE_ITEM} from "./actions";

export function addItem(product, quantity) {
    return (dispatch) => {

        dispatch(_addItem(product, quantity))
    }
}

export function updateItem(productId,quantity) {
    return (dispatch) => {

        dispatch(_updateItem(productId,quantity))
    }
}

export function removeItem(productId) {
    return (dispatch) => {
        dispatch(_removeItem(productId))
    }
}

export function loadCart() {
    return (dispatch) => {

        let carrito = [];
        dispatch(_loadCart(carrito))
    }
}

export function checkOut() {
    return (dispatch) => {

        dispatch(_submitCart)
    }
}


const _addItem = (product, quantity) => {
    return {
        type: ADD_ITEM,
        product: product,
        quantity: quantity
    }
};

const _updateItem = (productId, quantity) => {
    return {
        type: UPDATE_ITEM,
        id: productId,
        quantity: quantity
    }
};

const _removeItem = (productId) => {
    return {
        type: REMOVE_ITEM,
        id: productId
    }
};
const _loadCart = (cart) => {
    return {
        type: LOAD_CART,
        cart: cart
    }
};

const _submitCart = () => {
    return {
        type: SUBMIT_CART
    }
};