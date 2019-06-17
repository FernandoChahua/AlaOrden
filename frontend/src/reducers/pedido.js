import {VIEW_PEDIDO_LIST, SAVE_PEDIDO} from "../actions/actionTypes";


export default function pedido(state = {}, action) {
    switch (action.type) {
        case VIEW_PEDIDO_LIST:
            return Object.assign({}, state, {
                actionType: action.type,
                ordenList: action.ordenList,
            });

        case SAVE_PEDIDO:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });


        default:
            return state;
    }
}