import {VIEW_DETALLEPEDIDO_LIST, SAVE_DETALLEPEDIDO} from "../actions/actionTypes";


export default function detallePedido(state = {}, action) {
    switch (action.type) {
        case VIEW_DETALLEPEDIDO_LIST:
            return Object.assign({}, state, {
                actionType: action.type,
                detalleOrdenList: action.detalleOrdenList,
            });

        case SAVE_DETALLEPEDIDO:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });


        default:
            return state;
    }
}