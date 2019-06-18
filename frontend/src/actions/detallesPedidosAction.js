import {VIEW_DETALLEORDEN_LIST, SAVE_DETALLEORDEN} from "./actionTypes";

export function fetchDetalleOrdenList(){

    return function (dispatch,getState) {

        fetch("http://localhost:9090/api/detalleOrden")
            .then(response=>response.json())
            .then(jsonData=>{
                dispatch(setDetalleOrdenList(jsonData))
            })
    }
}

function setDetalleOrdenList(detalleOrdenList) {
    return{
        type:VIEW_DETALLEORDEN_LIST,
        detalleOrdenList
    }
}

export function fetchDetalleOrdenSave(detalleOrden) {

    return function (dispatch,getState) {
        fetch("http://localhost:9090/api/detalleOrden", {
            method:'post',
            headers:{
                'Accept':'application/json, text/plain, */*',
                'Content-Type':'application/json'
            },
            body: JSON.stringify(detalleOrden)

                .then(async response=>{
                    return Object.assign({},await response.json());
                })
                .then(jsonData=>{
                    dispatch(setDetalleOrdenSave(jsonData))
                })
        })
    };
}

export function setDetalleOrdenSave(result) {
    return{
        type:SAVE_DETALLEORDEN,
        result
    }
}