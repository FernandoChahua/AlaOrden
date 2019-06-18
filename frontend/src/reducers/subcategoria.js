import {VIEW_SUBCATEGORIA_LIST, SAVE_SUBCATEGORIA, DELETE_SUBCATEGORIA} from "../actions/actionTypes";

export default function subcategoria(state = {}, action) {
    switch (action.type) {
        case VIEW_SUBCATEGORIA_LIST:
            return Object.assign({}, state, {
                actionType: action.type,
                subcategoriaList: action.subcategoriaList,
            });

        case SAVE_SUBCATEGORIA:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });

        case DELETE_SUBCATEGORIA:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });


        default:
            return state;
    }
}