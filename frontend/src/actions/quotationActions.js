import {LOAD_OPTIONS, PICK_OPTION} from "./actions";


export function loadOptions(cart, direction) {
    return (dispatch) => {
        //

        dispatch(_loadOptions([]))
    }
}

export function pickOption() {
    return (dispatch) => {
        //TODO: implement
        dispatch(_pickOption())
    }
}


const _loadOptions = (proformaList) => {
    return {
        type: LOAD_OPTIONS,
        proformaList
    }
};

const _pickOption = (order) => {
    return {
        type: PICK_OPTION,
        order
    }
};
