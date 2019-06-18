import {DELETE_CATEGORIA, SAVE_CATEGORIA, VIEW_CATEGORIA_LIST} from "../actions/actionTypes";

export default function categoria(state = {}, action) {
    switch (action.type) {
        case VIEW_CATEGORIA_LIST:
            return Object.assign({}, state, {
                actionType: action.type,
                categoriaList: action.categoriaList,
            });
        case SAVE_CATEGORIA:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });

        case DELETE_CATEGORIA:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });
        default:
            return state;
    }
}