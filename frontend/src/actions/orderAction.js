import {CHANGE_STATUS, SET_ORDER, SET_STEP} from "./actions";


export const _setStep = (activeStep) => {
  return {
    type: SET_STEP,
    activeStep
  }
};

export const _setOrder = (order) => {
  return {
    type: SET_ORDER,
    order
  }
};

export const _isOrdering = (status) => {
  return {
    type: CHANGE_STATUS,
    status
  }
}