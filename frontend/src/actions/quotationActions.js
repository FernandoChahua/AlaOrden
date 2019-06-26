import {LOAD_OPTIONS, PICK_OPTION} from "./actions";


export function loadOptions(proformaList) {
    return {
        type: LOAD_OPTIONS,
        proformaList
    }
}

export function pickOption(order) {
    return {
        type: PICK_OPTION,
        order
    }
}
