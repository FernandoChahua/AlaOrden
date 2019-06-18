import {VIEW_PRODUCTO_LIST, SAVE_PRODUCTO, DELETE_PRODUCTO} from './actionTypes';

export function fetchProductoList() {
    return function (dispatch, getState) {

        fetch("http://localhost:9090/api/producto")
            .then(response => response.json())
            .then(jsonData => {
                dispatch(setProductos(jsonData))
            })
    };
}

function setProductos(productoList) {
    return {
        type: VIEW_PRODUCTO_LIST,
        productoList
    }
}

export function fetchProductoSave(producto) {
    return function (dispatch, getState) {
        fetch('http://localhost:9090/api/producto', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(producto)
        })
            .then(async response => {
                return Object.assign({}, await response.json());
            })
            .then(jsonData => {
                dispatch(setProductoSave(jsonData))
            })
    };
}

export function setProductoSave(result) {
    return {
        type: SAVE_PRODUCTO,
        result
    }
}


export function fetchProductoDelete(idproducto) {
    return function (dispatch, getState) {
        fetch(`http://localhost:9090/api/producto/delete/${idproducto}`,{
            method:'delete',
            headers:{
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(idproducto)
        })
            .then(response => response.json())
            .then(jsonData => {
                dispatch(setProductoDelete(jsonData))
            })
    };
}

export function setProductoDelete(result) {
    return {
        type: DELETE_PRODUCTO,
        result
    }
}