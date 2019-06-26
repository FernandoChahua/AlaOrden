import {LOGIN, LOGOUT, REGISTER_ACC} from "./actions";

export function logIn(user) {
    return {
        type: LOGIN,
        user: user
    }
}

export function logOut() {
    return {
        type: LOGOUT,
    }
}
