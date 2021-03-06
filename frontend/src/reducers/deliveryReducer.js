import {LOAD_ADDRESS_LIST, SET_ADDRESS} from "../actions/actions";

const initial = {
    addressList: [],
    address: {}
};

export default function deliveryReducer(state = initial, action) {
    switch (action.type) {
        case LOAD_ADDRESS_LIST:
            return Object.assign({},state,
                {addressList :action.addressList, address:null});
        case SET_ADDRESS:
            return Object.assign({},state,
                {address: action.address});
        default:
            return state;
    }
}