import {HIDE_AUTH_MODAL, LOGIN, LOGOUT, SET_LOGIN_RESPONSE, SHOW_AUTH_MODAL} from "../actions/actions";

const initial = {
    authenticated:false,
    displayAuthModal: false,
    user: {},
};


export default function authReducer(state = initial, action){
    switch (action.type) {
        case LOGIN:
            return Object.assign({},state,
                {user:action.user,authenticated:true,displayAuthModal: false});
        case LOGOUT:
            return Object.assign({},state,
                {user:null,authenticated:false});
        case SHOW_AUTH_MODAL:
            return Object.assign({},state,
              {displayAuthModal: true});
        case HIDE_AUTH_MODAL:
            return Object.assign({},state,
              {displayAuthModal: false});
        case SET_LOGIN_RESPONSE:
            return Object.assign({},state,
              {response: action.response});
        default:
            return state;
    }
}