import {LOAD_ADDRESS_LIST, PICK_ADDRESS} from "./actions";

export function pickDirection(direction){
    return {
        type: PICK_ADDRESS,
        direction
    }
}

export function loadDirections(addressList) {
    return {
        type: LOAD_ADDRESS_LIST,
        directionList: addressList
    }
}