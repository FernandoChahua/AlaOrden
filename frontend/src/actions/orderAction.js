import {SET_MAX_STEP, SET_STEP} from "./actions";

export function setStep (step) {
  return (dispatch) => {
    dispatch(_setStep(step));
  }
}

export function setMaxStep(step) {
  return (dispatch) => {
    dispatch(_setMaxStep(step));
  }
}

const _setStep = (activeStep) => {
  return {
    type: SET_STEP,
    activeStep
  }
};

const _setMaxStep = (maxStep) => {
  return {
    type: SET_MAX_STEP,
    maxStep
  }
};