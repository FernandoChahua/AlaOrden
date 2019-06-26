import {LOAD_ADDRESS_LIST, PICK_ADDRESS} from "./actions";

export function pickDirection() {
    return (dispatch) => {

        dispatch(_pickDirection())
    }
}

export function loadDirections() {
    return (dispatch) => {

        dispatch(_loadDirections())
    }
}



const _pickDirection = (direction) => {
    return {
        type: PICK_ADDRESS,
        direction
    }
};

const _loadDirections = (addressList) => {
    return {
        type: LOAD_ADDRESS_LIST,
        directionList: addressList
    }
};