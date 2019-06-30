import {LOAD_OPTIONS} from "../actions/actions";

const initial = {
    proformaList: [],
};

export default function quotationReducer(state = initial, action) {
    switch (action.type) {
        case LOAD_OPTIONS:
            return Object.assign({}, state,
                { proformaList: action.proformaList });
        default:
            return state;
    }
}