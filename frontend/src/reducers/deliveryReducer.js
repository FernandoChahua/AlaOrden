import {LOAD_ADDRESS_LIST, PICK_ADDRESS} from "../actions/actions";


export default function deliveryReducer(state = {}, action) {
    switch (action.type) {
        case LOAD_ADDRESS_LIST:
            return Object.assign({},state,
                {addressList :action.addressList, address:null});
        case PICK_ADDRESS:
            return Object.assign({},state,
                {address: action.address});
        default:
            return state;
    }
}