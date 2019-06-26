import {LOAD_ADDRESS_LIST, PICK_ADDRESS} from "./actions";

const _pickDirection = (direction) => {
    return {
        type: PICK_ADDRESS,
        direction
    }
};

const _loadDirections = (addressList) => {
    return {
        type: LOAD_ADDRESS_LIST,
        directionList: addressList
    }
};