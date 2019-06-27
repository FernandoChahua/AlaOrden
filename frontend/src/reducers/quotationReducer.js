import {LOAD_OPTIONS, PICK_OPTION} from "../actions/actions";

const initial = {
    proformaList: []
};

export default function quotationReducer(state = initial, action) {
    switch (action.type) {
        case LOAD_OPTIONS:
            return Object.assign({}, state,
                { proformaList: action.proformaList });
        case PICK_OPTION:
            return Object.assign({},state,
                {order:action.order});
        default:
            return state;
    }
}