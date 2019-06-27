import {SET_MAX_STEP, SET_STEP} from "../actions/actions";


const initial = {
  activeStep: 0
};

export default function orderReducer(state = initial, action) {
  switch (action.type) {
    case SET_STEP:
      return Object.assign({}, state,
        {activeStep: action.activeStep});
    case SET_MAX_STEP:
      return Object.assign({},state,
        {maxStep: action.maxStep});
    default:
      return state;
  }
}