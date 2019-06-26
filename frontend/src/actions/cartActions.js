import {ADD_ITEM, LOAD_CART, REMOVE_ITEM, SUBMIT_CART, UPDATE_ITEM} from "./actions";

export function addItem() {
    return (dispatch) => {

        dispatch(_addItem())
    }
}

export function updateItem() {
    return (dispatch) => {

        dispatch(_updateItem())
    }
}

export function removeItem() {
    return (dispatch) => {

        dispatch(_removeItem())
    }
}

export function loadCart() {
    return (dispatch) => {

        dispatch(_loadCart())
    }
}

export function submitCart() {
    return (dispatch) => {

        dispatch(_submitCart())
    }
}


const _addItem = (productId, quantity) => {
    return {
        type: ADD_ITEM,
        id: productId,
        quantity: quantity
    }
}

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
}
const _loadCart = (cart) => {
    return {
        type: LOAD_CART,
        cart: cart
    }
}

const _submitCart = () => {
    return {
        type: SUBMIT_CART
    }
}