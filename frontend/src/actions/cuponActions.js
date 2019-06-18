import {VIEW_CUPON_LIST, SAVE_CUPON, DELETE_CUPON} from './actionTypes';

export function fetchCuponList() {
    return function (dispatch, getState) {

        fetch("http://localhost:9090/api/cupon")
            .then(response => response.json())
            .then(jsonData => {
                dispatch(setCupones(jsonData))
            })
    };
}

function setCupones(cuponList) {
    return {
        type: VIEW_CUPON_LIST,
        cuponList
    }
}

export function fetchCuponSave(cupon) {
    return function (dispatch, getState) {
        fetch('http://localhost:9090/api/cupon', {
            method: 'post',
            headers: {
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(cupon)
        })
            .then(async response => {
                return Object.assign({}, await response.json());
            })
            .then(jsonData => {
                dispatch(setCuponSave(jsonData))
            })
    };
}

export function setCuponSave(result) {
    return {
        type: SAVE_CUPON,
        result
    }
}


export function fetchCuponDelete(idcupon) {
    return function (dispatch, getState) {
        fetch(`http://localhost:9090/api/cupon/delete/${idcupon}`,{
            method:'delete',
            headers:{
                'Accept': 'application/json, text/plain, */*',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(idcupon)
        })
            .then(response => response.json())
            .then(jsonData => {
                dispatch(setCuponDelete(jsonData))
            })
    };
}

export function setCuponDelete(result) {
    return {
        type: DELETE_CUPON,
        result
    }
}