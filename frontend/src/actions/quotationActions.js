import {LOAD_OPTIONS, PICK_OPTION} from "./actions";


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
