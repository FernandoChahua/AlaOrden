import {VIEW_CUPON_LIST, SAVE_CUPON, DELETE_CUPON} from "../actions/actionTypes";

export default function cupon(state = {}, action) {
    switch (action.type) {
        case VIEW_CUPON_LIST:
            return Object.assign({}, state, {
                actionType: action.type,
                cuponList: action.cuponList,
            });

        case SAVE_CUPON:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });

        case DELETE_CUPON:
            return Object.assign({}, state, {
                actionType: action.type,
                result: action.result,
            });



        default:
            return state;
    }
}