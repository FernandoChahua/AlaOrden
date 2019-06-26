import {LOGIN, LOGOUT } from "../actions/actions";


export default function authReducer(state = {}, action){
    switch (action.type) {
        case LOGIN:
            return Object.assign({},state,
                {user:action.user,authenticated:true});
        case LOGOUT:
            return Object.assign({},state,
                {user:null,authenticated:false});
        default:
            return state;
    }
}