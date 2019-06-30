import {CHANGE_STATUS, SET_ORDER, SET_STEP} from "../actions/actions";


const initial = {
  activeStep: 0,
  order: {},
  isOrdering: false
};

export default function orderReducer(state = initial, action) {
  switch (action.type) {
    case SET_STEP:
      return Object.assign({}, state,
        {activeStep: action.activeStep});
    case SET_ORDER:
      return Object.assign({},state,
        {order: action.order});
    case CHANGE_STATUS:
      return Object.assign({},state,
        {isOrdering: action.status});
    default:
      return state;
  }
}