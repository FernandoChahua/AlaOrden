import {HIDE_AUTH_MODAL, LOGIN, LOGOUT, SHOW_AUTH_MODAL} from "./actions";

export function logIn() {
    return (dispatch) => {
        
        dispatch(_logIn())
    }
}

export function logOut() {
    return (dispatch) => {
        //TODO: implement
    }
}

export function showModal() {
    return (dispatch) => {
        dispatch(_showAuthModal());
    }
}

export function hideModal() {
    return (dispatch) => {
        dispatch(_hideAuthModal());
    }
}

const _logIn = (user) => {
    return {
        type: LOGIN,
        user: user
    }
}

const _logOut = () => {
    return {
        type: LOGOUT,
    }
};

const _showAuthModal = () => {
    return {
        type: SHOW_AUTH_MODAL,
    }
};

const _hideAuthModal = () => {
    return {
        type: HIDE_AUTH_MODAL,
    }
};