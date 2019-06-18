import {VIEW_ORDEN_LIST,SAVE_ORDEN} from "./actionTypes";

export function fetchOrdenList(){
    return function (dispatch,getState){

        fetch("http://localhost:9090/api/orden")
            .then(response=>response.json())
            .then(jsonData=>{
                dispatch(setOrdenList(jsonData))
            })
    }
}

function setOrdenList(ordenList) {
    return{
        type: VIEW_ORDEN_LIST,
        ordenList
    }
}

export  function fetchOrdenSave(orden){
    return function (dispatch,getState) {
        fetch("http://localhost:9090/api/orden", {
            method:'post',
            headers:{
                'Accept':'application/json, text/plain, */*',
                'Content-Type':'application/json'
            },
            body: JSON.stringify(orden)

                .then(async response=>{
                   return Object.assign({},await response.json());
                })
                .then(jsonData=>{
                    dispatch(setOrdenSave(jsonData))
                })
        })
    };
}

export function setOrdenSave(result) {
    return{
        type: SAVE_ORDEN,
        result
    }
}